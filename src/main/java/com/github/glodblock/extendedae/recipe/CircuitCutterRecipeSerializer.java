package com.github.glodblock.extendedae.recipe;

import com.github.glodblock.extendedae.recipe.util.IngredientStack;
import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jetbrains.annotations.NotNull;

public class CircuitCutterRecipeSerializer implements RecipeSerializer<CircuitCutterRecipe> {

    public final static CircuitCutterRecipeSerializer INSTANCE = new CircuitCutterRecipeSerializer();

    /*public final static Codec<CircuitCutterRecipe> CODEC = RecordCodecBuilder.create(
            builder -> builder.group(
                    ItemStack.ITEM_WITH_COUNT_CODEC.fieldOf("output").forGetter(ir -> ir.output),
                    IngredientStack.ITEM_CODEC.fieldOf("input").forGetter(ir -> ir.input)
            ).apply(builder, CircuitCutterRecipe::new)
    );*/

    private CircuitCutterRecipeSerializer() {
        // NO-OP
    }


    @Override
    public CircuitCutterRecipe fromJson(ResourceLocation recipeId, JsonObject serializedRecipe) {
        //ID
        ResourceLocation id = recipeId;

        //INPUT
        IngredientStack.Item input;
        JsonObject jsonInput = GsonHelper.getAsJsonObject(serializedRecipe, "input");

        //INPUT -> INGREDIENT
        JsonObject jsonIngredient = GsonHelper.getAsJsonObject(jsonInput, "ingredient", new JsonObject());
        Ingredient ingredient = Ingredient.fromJson(jsonIngredient);
        int amount = GsonHelper.getAsInt(jsonInput, "amount", 1);
        input = IngredientStack.Item.of(ingredient, amount);

        //OUTPUT
        ItemStack output = null;
        JsonObject jsonOutput = GsonHelper.getAsJsonObject(serializedRecipe, "output");
        int count = GsonHelper.getAsInt(jsonOutput, "count", 1);
        String outItemId = GsonHelper.getAsString(jsonOutput, "item", null);
        if(outItemId != null){
            Item outItem = BuiltInRegistries.ITEM.getOptional(new ResourceLocation(outItemId)).orElse(null);
            if(outItem == null){
                throw new IllegalArgumentException("Unknown id" + outItemId + " for " + BuiltInRegistries.ITEM);
            }
            output = new ItemStack(outItem, count);
        }

        return new CircuitCutterRecipe(recipeId, output, input);

    }

    public void toJson(CircuitCutterRecipe recipe, JsonObject json) {
        json.add("input", serializeInput(recipe));
        json.add("output", serializeOutput(recipe));
    }

    private JsonObject serializeInput(CircuitCutterRecipe recipe){
        var jsonInput = new JsonObject();
        if (recipe.getInput() != null) {
            var jsonIngredient = ((Ingredient)recipe.getInput().getIngredient()).toJson();
            jsonInput.add("ingredient", jsonIngredient);
            var amount = recipe.getInput().getAmount();
            if(amount >= 2){
                jsonInput.addProperty("amount", amount);
            }
        }
        return jsonInput;
    }

    private JsonObject serializeOutput(CircuitCutterRecipe recipe){
        var jsonOutput = new JsonObject();
        if (recipe.output != null){
            var itemName = BuiltInRegistries.ITEM.getKey(recipe.output.getItem()).toString();
            var itemCount = recipe.output.getCount();
            jsonOutput.addProperty("count", itemCount);
            jsonOutput.addProperty("item", itemName);
        }
        return jsonOutput;
    }

    @Override
    public @NotNull CircuitCutterRecipe fromNetwork(ResourceLocation id, @NotNull FriendlyByteBuf buffer) {
        return new CircuitCutterRecipe(id, buffer.readItem(), IngredientStack.ofItem(buffer));
    }

    @Override
    public void toNetwork(@NotNull FriendlyByteBuf buffer, @NotNull CircuitCutterRecipe recipe) {
        buffer.writeItem(recipe.output);
        recipe.input.to(buffer);
    }

}
