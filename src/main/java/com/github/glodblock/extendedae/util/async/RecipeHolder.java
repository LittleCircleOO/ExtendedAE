package com.github.glodblock.extendedae.util.async;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;

public record RecipeHolder<T extends Recipe<?>>(ResourceLocation id, T value) {

    public RecipeHolder(ResourceLocation id, T value) {
        this.id = id;
        this.value = value;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else {
            if (object instanceof RecipeHolder) {
                RecipeHolder<?> recipeHolder = (RecipeHolder)object;
                if (this.id.equals(recipeHolder.id)) {
                    return true;
                }
            }
            return false;
        }
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public String toString() {
        return this.id.toString();
    }

    public ResourceLocation id() {
        return this.id;
    }

    public T value() {
        return this.value;
    }

}
