package com.github.glodblock.extendedae.datagen;

import appeng.api.stacks.AEFluidKey;
import appeng.api.stacks.AEItemKey;
import appeng.core.definitions.AEBlocks;
import appeng.core.definitions.AEItems;
import appeng.core.definitions.AEParts;
import appeng.datagen.providers.tags.ConventionTags;
import com.github.glodblock.extendedae.EAE;
import com.github.glodblock.extendedae.common.EAEItemAndBlock;
import com.github.glodblock.extendedae.recipe.CircuitCutterRecipeBuilder;
import com.github.glodblock.extendedae.util.EPPTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class EAERecipeProvider extends FabricRecipeProvider {

    static String C = "has_item";

    public EAERecipeProvider(FabricDataOutput p) {
        super(p);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> c) {
        // Extended Pattern Provider
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.EX_PATTERN_PROVIDER)
                .pattern("PC")
                .pattern("CZ")
                .define('P', ConventionTags.PATTERN_PROVIDER)
                .define('C', AEItems.CAPACITY_CARD)
                .define('Z', AEItems.ENGINEERING_PROCESSOR)
                .unlockedBy(C, has(EAEItemAndBlock.EX_PATTERN_PROVIDER))
                .save(c, EAE.id("epp"));
        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, EAEItemAndBlock.EX_PATTERN_PROVIDER_PART)
                .requires(EAEItemAndBlock.EX_PATTERN_PROVIDER)
                .unlockedBy(C, has(EAEItemAndBlock.EX_PATTERN_PROVIDER_PART))
                .save(c, EAE.id("epp_part"));
        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, EAEItemAndBlock.EX_PATTERN_PROVIDER)
                .requires(EAEItemAndBlock.EX_PATTERN_PROVIDER_PART)
                .unlockedBy(C, has(EAEItemAndBlock.EX_PATTERN_PROVIDER))
                .save(c, EAE.id("epp_alt"));
        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, EAEItemAndBlock.PATTERN_PROVIDER_UPGRADE)
                .requires(AEItems.CAPACITY_CARD, 2)
                .requires(AEItems.ENGINEERING_PROCESSOR)
                .unlockedBy(C, has(EAEItemAndBlock.PATTERN_PROVIDER_UPGRADE))
                .save(c, EAE.id("epp_upgrade"));

        // Extended Interface
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.EX_INTERFACE)
                .pattern("PC")
                .pattern("CZ")
                .define('P', ConventionTags.INTERFACE)
                .define('C', AEItems.CAPACITY_CARD)
                .define('Z', AEItems.LOGIC_PROCESSOR)
                .unlockedBy(C, has(EAEItemAndBlock.EX_INTERFACE))
                .save(c, EAE.id("ei"));
        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, EAEItemAndBlock.EX_INTERFACE_PART)
                .requires(EAEItemAndBlock.EX_INTERFACE)
                .unlockedBy(C, has(EAEItemAndBlock.EX_INTERFACE_PART))
                .save(c, EAE.id("ei_part"));
        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, EAEItemAndBlock.EX_INTERFACE)
                .requires(EAEItemAndBlock.EX_INTERFACE_PART)
                .unlockedBy(C, has(EAEItemAndBlock.EX_INTERFACE))
                .save(c, EAE.id("ei_alt"));
        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, EAEItemAndBlock.INTERFACE_UPGRADE)
                .requires(AEItems.CAPACITY_CARD, 2)
                .requires(AEItems.LOGIC_PROCESSOR)
                .unlockedBy(C, has(EAEItemAndBlock.INTERFACE_UPGRADE))
                .save(c, EAE.id("ei_upgrade"));

        // Infinity Cell
        NBTRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.INFINITY_CELL.getRecordCell(AEFluidKey.of(Fluids.WATER)))
                .pattern("CWC")
                .pattern("WXW")
                .pattern("III")
                .define('C', AEBlocks.QUARTZ_GLASS)
                .define('W', Items.WATER_BUCKET)
                .define('X', AEItems.CELL_COMPONENT_16K)
                .define('I', ConventionTags.DIAMOND)
                .unlockedBy(C, has(EAEItemAndBlock.INFINITY_CELL))
                .save(c, EAE.id("water_cell"));
        NBTRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.INFINITY_CELL.getRecordCell(AEItemKey.of(Blocks.COBBLESTONE)))
                .pattern("CLC")
                .pattern("WXW")
                .pattern("III")
                .define('C', AEBlocks.QUARTZ_GLASS)
                .define('L', Items.LAVA_BUCKET)
                .define('W', Items.WATER_BUCKET)
                .define('X', AEItems.CELL_COMPONENT_16K)
                .define('I', ConventionTags.DIAMOND)
                .unlockedBy(C, has(EAEItemAndBlock.INFINITY_CELL))
                .save(c, EAE.id("cobblestone_cell"));

        // Extended IO Bus
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.EX_EXPORT_BUS)
                .pattern("PS")
                .pattern("SZ")
                .define('P', AEParts.EXPORT_BUS)
                .define('S', AEItems.SPEED_CARD)
                .define('Z', AEItems.CALCULATION_PROCESSOR)
                .unlockedBy(C, has(EAEItemAndBlock.EX_EXPORT_BUS))
                .save(c, EAE.id("ebus_out"));
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.EX_IMPORT_BUS)
                .pattern("PS")
                .pattern("SZ")
                .define('P', AEParts.IMPORT_BUS)
                .define('S', AEItems.SPEED_CARD)
                .define('Z', AEItems.CALCULATION_PROCESSOR)
                .unlockedBy(C, has(EAEItemAndBlock.EX_IMPORT_BUS))
                .save(c, EAE.id("ebus_in"));
        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, EAEItemAndBlock.IO_BUS_UPGRADE)
                .requires(AEItems.SPEED_CARD, 2)
                .requires(AEItems.CALCULATION_PROCESSOR)
                .unlockedBy(C, has(EAEItemAndBlock.IO_BUS_UPGRADE))
                .save(c, EAE.id("ebus_upgrade"));

        // Extended Pattern Access Terminal
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.EX_PATTERN_TERMINAL)
                .pattern(" L ")
                .pattern("CPC")
                .pattern(" C ")
                .define('L', Blocks.REDSTONE_LAMP)
                .define('P', AEParts.PATTERN_ACCESS_TERMINAL)
                .define('C', AEItems.LOGIC_PROCESSOR)
                .unlockedBy(C, has(EAEItemAndBlock.EX_PATTERN_TERMINAL))
                .save(c, EAE.id("epa"));
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.PATTERN_UPGRADE)
                .pattern(" L ")
                .pattern("CCC")
                .define('L', Blocks.REDSTONE_LAMP)
                .define('C', AEItems.LOGIC_PROCESSOR)
                .unlockedBy(C, has(EAEItemAndBlock.PATTERN_UPGRADE))
                .save(c, EAE.id("epa_upgrade"));

        // ME Packing Tape
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.PACKING_TAPE)
                .pattern("FG ")
                .pattern("PIP")
                .pattern(" GF")
                .define('I', ConventionTags.IRON_INGOT)
                .define('P', Items.PAPER)
                .define('G', Items.SLIME_BALL)
                .define('F', ConventionTags.FLUIX_DUST)
                .unlockedBy(C, has(EAEItemAndBlock.PACKING_TAPE))
                .save(c, EAE.id("tape"));

        // Wireless Connector
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.WIRELESS_CONNECTOR, 2)
                .pattern("DWD")
                .pattern("CEC")
                .pattern("DWD")
                .define('D', AEItems.SKY_DUST)
                .define('W', AEItems.WIRELESS_RECEIVER)
                .define('C', ConventionTags.SMART_CABLE)
                .define('E', AEItems.ENGINEERING_PROCESSOR)
                .unlockedBy(C, has(EAEItemAndBlock.WIRELESS_CONNECTOR))
                .save(c, EAE.id("wireless_connector"));

        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.WIRELESS_TOOL)
                .pattern(" W ")
                .pattern("ICI")
                .pattern(" I ")
                .define('I', ConventionTags.IRON_INGOT)
                .define('W', AEItems.WIRELESS_RECEIVER)
                .define('C', AEItems.CALCULATION_PROCESSOR)
                .unlockedBy(C, has(EAEItemAndBlock.WIRELESS_TOOL))
                .save(c, EAE.id("wireless_tool"));

        // Ingredient Buffer
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.INGREDIENT_BUFFER)
                .pattern("IKI")
                .pattern("G G")
                .pattern("IKI")
                .define('I', ConventionTags.IRON_INGOT)
                .define('K', AEItems.CELL_COMPONENT_1K)
                .define('G', AEBlocks.QUARTZ_GLASS)
                .unlockedBy(C, has(EAEItemAndBlock.INGREDIENT_BUFFER))
                .save(c, EAE.id("ingredient_buffer"));

        // Extended ME Drive
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.EX_DRIVE)
                .pattern("CDC")
                .pattern("FEF")
                .define('C', ConventionTags.GLASS_CABLE)
                .define('D', AEBlocks.DRIVE)
                .define('F', ConventionTags.FLUIX_DUST)
                .define('E', AEItems.CAPACITY_CARD)
                .unlockedBy(C, has(EAEItemAndBlock.EX_DRIVE))
                .save(c, EAE.id("ex_drive"));

        // Drive Upgrade
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.DRIVE_UPGRADE)
                .pattern("C C")
                .pattern("FEF")
                .define('C', ConventionTags.GLASS_CABLE)
                .define('F', ConventionTags.FLUIX_DUST)
                .define('E', AEItems.CAPACITY_CARD)
                .unlockedBy(C, has(EAEItemAndBlock.DRIVE_UPGRADE))
                .save(c, EAE.id("ex_drive_upgrade"));

        // Pattern Modifier
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.PATTERN_MODIFIER)
                .pattern("GPG")
                .pattern(" L ")
                .define('G', ConventionTags.dye(DyeColor.GREEN))
                .define('P', AEItems.BLANK_PATTERN)
                .define('L', AEItems.LOGIC_PROCESSOR)
                .unlockedBy(C, has(EAEItemAndBlock.PATTERN_MODIFIER))
                .save(c, EAE.id("pattern_modifier"));

        // Extended Molecular Assembler
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.EX_ASSEMBLER)
                .pattern("FAF")
                .pattern("AEA")
                .pattern("FAF")
                .define('F', ConventionTags.FLUIX_CRYSTAL)
                .define('A', AEBlocks.MOLECULAR_ASSEMBLER)
                .define('E', AEItems.ENGINEERING_PROCESSOR)
                .unlockedBy(C, has(EAEItemAndBlock.EX_ASSEMBLER))
                .save(c, EAE.id("ex_molecular_assembler"));

        // Extended Inscriber
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.EX_INSCRIBER)
                .pattern("FAF")
                .pattern("AEA")
                .pattern("FAF")
                .define('F', AEBlocks.INSCRIBER)
                .define('A', AEParts.STORAGE_BUS)
                .define('E', ConventionTags.INTERFACE)
                .unlockedBy(C, has(EAEItemAndBlock.EX_INSCRIBER))
                .save(c, EAE.id("ex_inscriber"));

        // Extended Charger
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.EX_CHARGER)
                .pattern("FAF")
                .pattern("AEA")
                .pattern("FAF")
                .define('F', AEBlocks.CHARGER)
                .define('A', AEParts.STORAGE_BUS)
                .define('E', ConventionTags.INTERFACE)
                .unlockedBy(C, has(EAEItemAndBlock.EX_CHARGER))
                .save(c, EAE.id("ex_charger"));

        // Tag Storage Bus
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.TAG_STORAGE_BUS)
                .pattern(" L ")
                .pattern("RBR")
                .pattern(" K ")
                .define('L', AEItems.LOGIC_PROCESSOR)
                .define('R', ConventionTags.REDSTONE)
                .define('B', AEParts.STORAGE_BUS)
                .define('K', Items.BOOK)
                .unlockedBy(C, has(EAEItemAndBlock.TAG_STORAGE_BUS))
                .save(c, EAE.id("tag_storage_bus"));

        // Tag Export Bus
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.TAG_EXPORT_BUS)
                .pattern(" L ")
                .pattern("RBR")
                .pattern(" K ")
                .define('L', AEItems.LOGIC_PROCESSOR)
                .define('R', ConventionTags.REDSTONE)
                .define('B', AEParts.EXPORT_BUS)
                .define('K', Items.BOOK)
                .unlockedBy(C, has(EAEItemAndBlock.TAG_EXPORT_BUS))
                .save(c, EAE.id("tag_export_bus"));

        // Threshold Level Emitter
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.THRESHOLD_LEVEL_EMITTER)
                .pattern("RER")
                .pattern(" C ")
                .define('R', Items.REDSTONE_TORCH)
                .define('E', AEParts.LEVEL_EMITTER)
                .define('C', AEItems.CALCULATION_PROCESSOR)
                .unlockedBy(C, has(EAEItemAndBlock.THRESHOLD_LEVEL_EMITTER))
                .save(c, EAE.id("threshold_level_emitter"));

        // Mod Storage Bus
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.MOD_STORAGE_BUS)
                .pattern(" C ")
                .pattern("RBR")
                .pattern(" K ")
                .define('C', AEItems.CALCULATION_PROCESSOR)
                .define('R', ConventionTags.REDSTONE)
                .define('B', AEParts.STORAGE_BUS)
                .define('K', Items.BOOK)
                .unlockedBy(C, has(EAEItemAndBlock.MOD_STORAGE_BUS))
                .save(c, EAE.id("mod_storage_bus"));

        // Mod Export Bus
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.MOD_EXPORT_BUS)
                .pattern(" C ")
                .pattern("RBR")
                .pattern(" K ")
                .define('C', AEItems.CALCULATION_PROCESSOR)
                .define('R', ConventionTags.REDSTONE)
                .define('B', AEParts.EXPORT_BUS)
                .define('K', Items.BOOK)
                .unlockedBy(C, has(EAEItemAndBlock.MOD_EXPORT_BUS))
                .save(c, EAE.id("mod_export_bus"));

        // Active Formation Plane
        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, EAEItemAndBlock.ACTIVE_FORMATION_PLANE)
                .requires(AEParts.FORMATION_PLANE)
                .requires(AEParts.EXPORT_BUS)
                .requires(AEItems.ENGINEERING_PROCESSOR)
                .unlockedBy(C, has(EAEItemAndBlock.ACTIVE_FORMATION_PLANE))
                .save(c, EAE.id("active_formation_plane"));

        // ME Caner
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.CANER)
                .pattern("IBE")
                .pattern(" P ")
                .define('I', AEParts.IMPORT_BUS)
                .define('E', AEParts.EXPORT_BUS)
                .define('B', EAEItemAndBlock.INGREDIENT_BUFFER)
                .define('P', AEItems.CALCULATION_PROCESSOR)
                .unlockedBy(C, has(EAEItemAndBlock.INGREDIENT_BUFFER))
                .save(c, EAE.id("caner"));

        // ME Precise Export Bus
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.PRECISE_EXPORT_BUS)
                .pattern("PBP")
                .define('B', EAEItemAndBlock.EX_EXPORT_BUS)
                .define('P', AEItems.CALCULATION_PROCESSOR)
                .unlockedBy(C, has(EAEItemAndBlock.EX_EXPORT_BUS))
                .save(c, EAE.id("pre_bus"));

        // Wireless Ex PAT
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.WIRELESS_EX_PAT)
                .pattern("A")
                .pattern("B")
                .pattern("C")
                .define('A', AEItems.WIRELESS_RECEIVER)
                .define('B', EAEItemAndBlock.EX_PATTERN_TERMINAL)
                .define('C', AEBlocks.DENSE_ENERGY_CELL)
                .unlockedBy(C, has(EAEItemAndBlock.EX_PATTERN_TERMINAL))
                .save(c, EAE.id("wireless_ex_pat"));

        // Extended IO Port
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.EX_IO_PORT)
                .pattern("ACB")
                .pattern("CMC")
                .pattern("BCA")
                .define('A', AEItems.LOGIC_PROCESSOR)
                .define('B', AEItems.ENGINEERING_PROCESSOR)
                .define('C', AEItems.SPEED_CARD)
                .define('M', AEBlocks.IO_PORT)
                .unlockedBy(C, has(AEBlocks.IO_PORT))
                .save(c, EAE.id("ex_io_port"));

        // Crystal Fixer
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.CRYSTAL_FIXER)
                .pattern("C C")
                .pattern("I I")
                .pattern("IFI")
                .define('C', ConventionTags.CERTUS_QUARTZ)
                .define('I', ConventionTags.IRON_INGOT)
                .define('F', ConventionTags.FLUIX_CRYSTAL)
                .unlockedBy(C, has(AEItems.FLUIX_CRYSTAL))
                .save(c, EAE.id("crystal_fixer"));

        // Precise Storage Bus
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.PRECISE_STORAGE_BUS)
                .pattern("PBP")
                .define('B', AEParts.STORAGE_BUS)
                .define('P', AEItems.CALCULATION_PROCESSOR)
                .unlockedBy(C, has(AEParts.STORAGE_BUS))
                .save(c, EAE.id("precise_storage_bus"));

        // Threshold Export Bus
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.THRESHOLD_EXPORT_BUS)
                .pattern("LCE")
                .define('L', AEParts.LEVEL_EMITTER)
                .define('C', AEItems.LOGIC_PROCESSOR)
                .define('E', AEParts.EXPORT_BUS)
                .unlockedBy(C, has(AEParts.LEVEL_EMITTER))
                .save(c, EAE.id("threshold_export_bus"));

        // Fishbig
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.FISHBIG)
                .pattern("FFF")
                .pattern("F F")
                .pattern("FFF")
                .define('F', Items.PUFFERFISH)
                .unlockedBy(C, has(EAEItemAndBlock.FISHBIG))
                .save(c, EAE.id("fishbig"));

        // Silicon BLock
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.SILICON_BLOCK)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ConventionTags.SILICON)
                .unlockedBy(C, has(ConventionTags.SILICON))
                .save(c, EAE.id("silicon_block"));
        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, AEItems.SILICON, 9)
                .requires(EPPTags.SILICON_BLOCK)
                .unlockedBy(C, has(EPPTags.SILICON_BLOCK))
                .save(c, EAE.id("silicon_decompress"));

        // Circuit Cutter
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.CIRCUIT_CUTTER)
                .pattern("CEL")
                .pattern("PSP")
                .pattern("YUY")
                .define('C', AEItems.CALCULATION_PROCESSOR_PRESS)
                .define('E', AEItems.ENGINEERING_PROCESSOR_PRESS)
                .define('L', AEItems.LOGIC_PROCESSOR_PRESS)
                .define('P', AEItems.ENGINEERING_PROCESSOR)
                .define('S', AEItems.SILICON_PRESS)
                .define('Y', EAEItemAndBlock.EX_INSCRIBER)
                .define('U', Items.STONECUTTER)
                .unlockedBy(C, has(EAEItemAndBlock.EX_INSCRIBER))
                .save(c, EAE.id("circuit_cutter"));

        // Oversize Interface
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EAEItemAndBlock.OVERSIZE_INTERFACE)
                .pattern("BPB")
                .pattern("AIF")
                .pattern("ACF")
                .define('I', EAEItemAndBlock.EX_INTERFACE)
                .define('P', AEItems.CALCULATION_PROCESSOR)
                .define('A', AEItems.ANNIHILATION_CORE)
                .define('F', AEItems.FORMATION_CORE)
                .define('B', EAEItemAndBlock.INGREDIENT_BUFFER)
                .define('C', AEItems.CAPACITY_CARD)
                .unlockedBy(C, has(EAEItemAndBlock.OVERSIZE_INTERFACE))
                .save(c, EAE.id("oversize_interface"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, EAEItemAndBlock.OVERSIZE_INTERFACE_PART)
                .requires(EAEItemAndBlock.OVERSIZE_INTERFACE)
                .unlockedBy(C, has(EAEItemAndBlock.OVERSIZE_INTERFACE))
                .save(c, EAE.id("oversize_interface_part"));
        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, EAEItemAndBlock.OVERSIZE_INTERFACE)
                .requires(EAEItemAndBlock.OVERSIZE_INTERFACE_PART)
                .unlockedBy(C, has(EAEItemAndBlock.OVERSIZE_INTERFACE_PART))
                .save(c, EAE.id("oversize_interface_alt"));

        circuit(c);

    }

    private void circuit(@NotNull Consumer<FinishedRecipe> c){
        CircuitCutterRecipeBuilder
                .cut(AEItems.ENGINEERING_PROCESSOR_PRINT, 9)
                //.input(CommonTags.STORAGE_BLOCKS_DIAMOND)
                .input(Items.DIAMOND_BLOCK)
                .save(c, EAE.id("cutter/engineering_processor"));
        CircuitCutterRecipeBuilder
                .cut(AEItems.LOGIC_PROCESSOR_PRINT, 9)
                //.input(CommonTags.STORAGE_BLOCKS_GOLD)
                .input(Items.GOLD_BLOCK)
                .save(c, EAE.id("cutter/logic_processor"));
        CircuitCutterRecipeBuilder
                .cut(AEItems.CALCULATION_PROCESSOR_PRINT, 4)
                .input(AEBlocks.QUARTZ_BLOCK)
                .save(c, EAE.id("cutter/calculation_processor"));
        CircuitCutterRecipeBuilder
                .cut(AEItems.SILICON_PRINT, 9)
                .input(EPPTags.SILICON_BLOCK)
                .save(c, EAE.id("cutter/silicon_print"));
        // Troll
        CircuitCutterRecipeBuilder
                .cut(Items.PUFFERFISH, 8)
                .input(EAEItemAndBlock.FISHBIG)
                .save(c, EAE.id("cutter/fishbig_destroy"));

    }

}
