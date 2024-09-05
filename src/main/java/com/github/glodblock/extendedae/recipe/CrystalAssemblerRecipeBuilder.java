package com.github.glodblock.extendedae.recipe;

import com.google.gson.JsonObject;

import com.github.glodblock.extendedae.recipe.util.FluidIngredient;
import com.github.glodblock.extendedae.recipe.util.IngredientStack;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.Fluid;
import io.github.fabricators_of_create.porting_lib.fluids.FluidStack;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class CrystalAssemblerRecipeBuilder {

    protected List<IngredientStack.Item> inputs = new ArrayList<>();
    protected IngredientStack.Fluid fluid = null;
    public ItemStack output;

    public CrystalAssemblerRecipeBuilder(ItemStack output) {
        this.output = output.copy();
    }

    public static CrystalAssemblerRecipeBuilder assemble(ItemStack stack) {
        return new CrystalAssemblerRecipeBuilder(stack);
    }

    public static CrystalAssemblerRecipeBuilder assemble(ItemLike stack) {
        return new CrystalAssemblerRecipeBuilder(new ItemStack(stack));
    }

    public static CrystalAssemblerRecipeBuilder assemble(ItemLike stack, int count) {
        return new CrystalAssemblerRecipeBuilder(new ItemStack(stack, count));
    }

    public CrystalAssemblerRecipeBuilder fluid(FluidStack fluid) {
        this.fluid = IngredientStack.of(fluid);
        return this;
    }

    public CrystalAssemblerRecipeBuilder fluid(Fluid fluid, int amount) {
        this.fluid = IngredientStack.of(new FluidStack(fluid, amount));
        return this;
    }

    public CrystalAssemblerRecipeBuilder fluid(TagKey<Fluid> tag, int amount) {
        this.fluid = IngredientStack.of(new FluidIngredient(new FluidIngredient.TagValue(tag)), amount);
        return this;
    }

    public CrystalAssemblerRecipeBuilder input(ItemStack item) {
        this.inputs.add(IngredientStack.of(item));
        return this;
    }

    public CrystalAssemblerRecipeBuilder input(ItemLike item) {
        this.inputs.add(IngredientStack.of(new ItemStack(item)));
        return this;
    }

    public CrystalAssemblerRecipeBuilder input(ItemLike item, int count) {
        this.inputs.add(IngredientStack.of(new ItemStack(item, count)));
        return this;
    }

    public CrystalAssemblerRecipeBuilder input(TagKey<Item> tag) {
        this.inputs.add(IngredientStack.of(Ingredient.of(tag), 1));
        return this;
    }

    public CrystalAssemblerRecipeBuilder input(TagKey<Item> tag, int count) {
        this.inputs.add(IngredientStack.of(Ingredient.of(tag), count));
        return this;
    }

    public void save(Consumer<FinishedRecipe> consumer, ResourceLocation id) {
        //var recipe = new CrystalAssemblerRecipe(this.output, this.inputs, this.fluid);
        //consumer.accept(id, recipe, null);
        consumer.accept(new Result(id, this.inputs, this.fluid, this.output));
    }

    record Result(ResourceLocation id, List<IngredientStack.Item> input, IngredientStack.Fluid fluid, ItemStack output) implements FinishedRecipe {
        @Override
        public void serializeRecipeData(JsonObject json) {
            //TODO: 序列化器

        }

        @Override
        public ResourceLocation getId() {
            return id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return CrystalAssemblerRecipeSerializer.INSTANCE;
        }

        @Nullable
        @Override
        public JsonObject serializeAdvancement() {
            return null;
        }

        @Nullable
        @Override
        public ResourceLocation getAdvancementId() {
            return null;
        }
    }

}