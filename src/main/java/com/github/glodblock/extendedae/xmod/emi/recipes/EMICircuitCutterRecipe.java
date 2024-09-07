package com.github.glodblock.extendedae.xmod.emi.recipes;

import appeng.core.AppEng;
import com.github.glodblock.extendedae.common.EAEItemAndBlock;
import com.github.glodblock.extendedae.recipe.CircuitCutterRecipe;
import dev.emi.emi.api.recipe.BasicEmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class EMICircuitCutterRecipe extends BasicEmiRecipe {

    public static final EmiRecipeCategory CATEGORY = new EAERecipeCategory("cutter", EmiStack.of(EAEItemAndBlock.CIRCUIT_CUTTER), Component.translatable("emi.extendedae.category.cutter"));
    private final CircuitCutterRecipe recipe;

    public EMICircuitCutterRecipe(CircuitCutterRecipe recipe) {
        super(CATEGORY, recipe.getId(), 92, 26);
        this.recipe = recipe;
        this.inputs.add(EMIStackUtil.of(this.recipe.getInput()));
        this.outputs.add(EmiStack.of(this.recipe.output));
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        ResourceLocation background = AppEng.makeId("textures/guis/circuit_cutter.png");
        widgets.addTexture(background, 0, 0, 92, 26, 45, 32);
        widgets.addAnimatedTexture(background, 86, 4, 6, 18, 178, 36, 2000, false, true, false);
        widgets.addSlot(EMIStackUtil.of(this.recipe.getInput()), 0, 4);
        widgets.addSlot(EmiStack.of(recipe.output), 63, 4).drawBack(false);
    }

}
