package com.github.glodblock.extendedae.xmod.emi.recipes;

import com.github.glodblock.extendedae.recipe.util.IngredientStack;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import net.minecraft.world.item.crafting.Ingredient;

public class EMIStackUtil {

    public static EmiIngredient of(IngredientStack.Item stack) {
        return !stack.isEmpty() ? EmiIngredient.of((Ingredient) stack.getIngredient(), stack.getAmount()) : EmiStack.EMPTY;
    }

}
