package com.github.glodblock.extendedae.recipe;

import com.github.glodblock.extendedae.EAE;
import com.github.glodblock.extendedae.recipe.util.IngredientStack;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

@SuppressWarnings("ClassCanBeRecord")
public class CircuitCutterRecipe implements Recipe<Container> {

    public static final ResourceLocation TYPE_ID = EAE.id("circuit_cutter");
    public static final RecipeType<CircuitCutterRecipe> TYPE = RecipeType.register(TYPE_ID.toString());

    private final ResourceLocation id;
    protected final IngredientStack.Item input;
    public final ItemStack output;

    public CircuitCutterRecipe(ResourceLocation id, ItemStack output, IngredientStack.Item input) {
        this.id = id;
        this.output = output;
        this.input = input;
    }

    public IngredientStack.Item getInput() {
        return this.input;
    }

    public List<IngredientStack<?>> getSample() {
        return Collections.singletonList(this.input.sample());
    }

    @Override
    public boolean matches(@NotNull Container pContainer, @NotNull Level pLevel) {
        return false;
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull Container pContainer, @NotNull RegistryAccess pRegistryAccess) {
        return getResultItem(pRegistryAccess).copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public @NotNull ItemStack getResultItem(@NotNull RegistryAccess pRegistryAccess) {
        return this.output;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return CircuitCutterRecipeSerializer.INSTANCE;
    }

    @Override
    public @NotNull ResourceLocation getId() {
        return id;
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return TYPE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

}
