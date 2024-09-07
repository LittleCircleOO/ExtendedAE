package com.github.glodblock.extendedae.recipe;

import com.github.glodblock.extendedae.recipe.util.IngredientStack;
import com.google.gson.JsonObject;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class CircuitCutterRecipeBuilder {

    protected IngredientStack.Item input;
    public ItemStack output;

    public CircuitCutterRecipeBuilder(ItemStack output) {
        this.output = output.copy();
    }

    public static CircuitCutterRecipeBuilder cut(ItemStack stack) {
        return new CircuitCutterRecipeBuilder(stack);
    }

    public static CircuitCutterRecipeBuilder cut(ItemLike stack) {
        return new CircuitCutterRecipeBuilder(new ItemStack(stack));
    }

    public static CircuitCutterRecipeBuilder cut(ItemLike stack, int count) {
        return new CircuitCutterRecipeBuilder(new ItemStack(stack, count));
    }

    public CircuitCutterRecipeBuilder input(ItemStack item) {
        this.input = IngredientStack.of(item);
        return this;
    }

    public CircuitCutterRecipeBuilder input(ItemLike item) {
        this.input = IngredientStack.of(new ItemStack(item));
        return this;
    }

    public CircuitCutterRecipeBuilder input(ItemLike item, int count) {
        this.input = IngredientStack.of(new ItemStack(item, count));
        return this;
    }

    public CircuitCutterRecipeBuilder input(TagKey<Item> tag) {
        this.input = IngredientStack.of(Ingredient.of(tag), 1);
        return this;
    }

    public CircuitCutterRecipeBuilder input(TagKey<Item> tag, int count) {
        this.input = IngredientStack.of(Ingredient.of(tag), count);
        return this;
    }

    public void save(Consumer<FinishedRecipe> consumer, ResourceLocation id) {
        consumer.accept(new Result(new CircuitCutterRecipe(id, this.output, this.input)));
    }

    record Result(CircuitCutterRecipe recipe) implements FinishedRecipe {
        @Override
        public void serializeRecipeData(JsonObject json) {
            CircuitCutterRecipeSerializer.INSTANCE.toJson(recipe, json);
        }

        @Override
        public ResourceLocation getId() {
            return recipe.getId();
        }

        @Override
        public RecipeSerializer<?> getType() {
            return CircuitCutterRecipeSerializer.INSTANCE;
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
