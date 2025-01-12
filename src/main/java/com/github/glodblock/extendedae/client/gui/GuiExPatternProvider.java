package com.github.glodblock.extendedae.client.gui;

import appeng.client.gui.implementations.PatternProviderScreen;
import appeng.client.gui.style.ScreenStyle;
import com.github.glodblock.extendedae.container.ContainerExPatternProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class GuiExPatternProvider extends PatternProviderScreen<ContainerExPatternProvider> {

    public GuiExPatternProvider(ContainerExPatternProvider menu, Inventory playerInventory, Component title, ScreenStyle style) {
        super(menu, playerInventory, title, style);
    }

}
