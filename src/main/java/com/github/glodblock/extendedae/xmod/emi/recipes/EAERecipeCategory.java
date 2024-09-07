package com.github.glodblock.extendedae.xmod.emi.recipes;

import com.github.glodblock.extendedae.EAE;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiRenderable;
import net.minecraft.network.chat.Component;

public class EAERecipeCategory extends EmiRecipeCategory {
    private final Component name;

    public EAERecipeCategory(String id, EmiRenderable icon, Component name) {
        super(EAE.id(id), icon);
        this.name = name;
    }

    @Override
    public Component getName() {
        return name;
    }
}
