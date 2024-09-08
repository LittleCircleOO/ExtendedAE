package com.github.glodblock.extendedae.client.gui;

import appeng.client.gui.AEBaseScreen;
import appeng.client.gui.Icon;
import appeng.client.gui.style.PaletteColor;
import appeng.client.gui.style.ScreenStyle;
import appeng.core.AppEng;
import com.github.glodblock.extendedae.client.button.ActionEPPButton;
import com.github.glodblock.extendedae.client.button.EPPIcon;
import com.github.glodblock.extendedae.config.EPPConfig;
import com.github.glodblock.extendedae.container.ContainerPatternModifier;
import com.github.glodblock.extendedae.network.EAENetworkServer;
import com.github.glodblock.extendedae.network.packet.CGenericPacket;
import com.github.glodblock.extendedae.network.packet.CUpdatePage;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

import java.util.ArrayList;
import java.util.List;

public class GuiPatternModifier extends AEBaseScreen<ContainerPatternModifier> {

    private final ActionEPPButton clone;
    private final Button replace;
    private final List<Button> multiBtns = new ArrayList<>();

    public GuiPatternModifier(ContainerPatternModifier menu, Inventory playerInventory, Component title, ScreenStyle style) {
        super(menu, playerInventory, title, style);
        ActionEPPButton changeMode = new ActionEPPButton(b -> EAENetworkServer.INSTANCE.sendToServer(new CUpdatePage(() -> (this.menu.page + 1) % 3)), Icon.SCHEDULING_DEFAULT.getBlitter());
        this.clone = new ActionEPPButton(b -> EAENetworkServer.INSTANCE.sendToServer(new CGenericPacket("clone")), EPPIcon.RIGHT);
        changeMode.setMessage(Component.translatable("gui.extendedae.pattern_modifier.change"));
        this.clone.setMessage(Component.translatable("gui.extendedae.pattern_modifier.clone.desc"));
        addToLeftToolbar(changeMode);
        this.replace = Button.builder(Component.translatable("gui.extendedae.pattern_modifier.replace_button"), b -> EAENetworkServer.INSTANCE.sendToServer(new CGenericPacket("replace")))
                .size(46, 18)
                .build();
        this.multiBtns.add(
                Button.builder(getDisplayNumber(EPPConfig.INSTANCE.patternModifierMultipliers[0], true), b -> EAENetworkServer.INSTANCE.sendToServer(new CGenericPacket("modify", EPPConfig.INSTANCE.patternModifierMultipliers[0], false)))
                        .size(23, 18)
                        .tooltip(Tooltip.create(Component.translatable("gui.extendedae.pattern_modifier.multi.desc", EPPConfig.INSTANCE.patternModifierMultipliers[0])))
                        .build()
        );
        this.multiBtns.add(
                Button.builder(getDisplayNumber(EPPConfig.INSTANCE.patternModifierMultipliers[1], true), b -> EAENetworkServer.INSTANCE.sendToServer(new CGenericPacket("modify", EPPConfig.INSTANCE.patternModifierMultipliers[1], false)))
                        .size(23, 18)
                        .tooltip(Tooltip.create(Component.translatable("gui.extendedae.pattern_modifier.multi.desc", EPPConfig.INSTANCE.patternModifierMultipliers[1])))
                        .build()
        );
        this.multiBtns.add(
                Button.builder(getDisplayNumber(EPPConfig.INSTANCE.patternModifierMultipliers[2], true), b -> EAENetworkServer.INSTANCE.sendToServer(new CGenericPacket("modify", EPPConfig.INSTANCE.patternModifierMultipliers[2], false)))
                        .size(23, 18)
                        .tooltip(Tooltip.create(Component.translatable("gui.extendedae.pattern_modifier.multi.desc", EPPConfig.INSTANCE.patternModifierMultipliers[2])))
                        .build()
        );
        this.multiBtns.add(
                Button.builder(getDisplayNumber(EPPConfig.INSTANCE.patternModifierMultipliers[3], true), b -> EAENetworkServer.INSTANCE.sendToServer(new CGenericPacket("modify", EPPConfig.INSTANCE.patternModifierMultipliers[3], false)))
                        .size(23, 18)
                        .tooltip(Tooltip.create(Component.translatable("gui.extendedae.pattern_modifier.multi.desc", EPPConfig.INSTANCE.patternModifierMultipliers[3])))
                        .build()
        );
        this.multiBtns.add(
                Button.builder(getDisplayNumber(EPPConfig.INSTANCE.patternModifierMultipliers[0], false), b -> EAENetworkServer.INSTANCE.sendToServer(new CGenericPacket("modify", EPPConfig.INSTANCE.patternModifierMultipliers[0], true)))
                        .size(23, 18)
                        .tooltip(Tooltip.create(Component.translatable("gui.extendedae.pattern_modifier.div.desc", EPPConfig.INSTANCE.patternModifierMultipliers[0])))
                        .build()
        );
        this.multiBtns.add(
                Button.builder(getDisplayNumber(EPPConfig.INSTANCE.patternModifierMultipliers[1], false), b -> EAENetworkServer.INSTANCE.sendToServer(new CGenericPacket("modify", EPPConfig.INSTANCE.patternModifierMultipliers[1], true)))
                        .size(23, 18)
                        .tooltip(Tooltip.create(Component.translatable("gui.extendedae.pattern_modifier.div.desc", EPPConfig.INSTANCE.patternModifierMultipliers[1])))
                        .build()
        );
        this.multiBtns.add(
                Button.builder(getDisplayNumber(EPPConfig.INSTANCE.patternModifierMultipliers[2], false), b -> EAENetworkServer.INSTANCE.sendToServer(new CGenericPacket("modify", EPPConfig.INSTANCE.patternModifierMultipliers[2], true)))
                        .size(23, 18)
                        .tooltip(Tooltip.create(Component.translatable("gui.extendedae.pattern_modifier.div.desc", EPPConfig.INSTANCE.patternModifierMultipliers[2])))
                        .build()
        );
        this.multiBtns.add(
                Button.builder(getDisplayNumber(EPPConfig.INSTANCE.patternModifierMultipliers[3], false), b -> EAENetworkServer.INSTANCE.sendToServer(new CGenericPacket("modify", EPPConfig.INSTANCE.patternModifierMultipliers[3], true)))
                        .size(23, 18)
                        .tooltip(Tooltip.create(Component.translatable("gui.extendedae.pattern_modifier.div.desc", EPPConfig.INSTANCE.patternModifierMultipliers[3])))
                        .build()
        );
        this.multiBtns.add(
                Button.builder(Component.translatable("gui.extendedae.pattern_modifier.clear"), b -> EAENetworkServer.INSTANCE.sendToServer(new CGenericPacket("clear")))
                        .size(36, 18)
                        .tooltip(Tooltip.create(Component.translatable("gui.extendedae.pattern_modifier.clear.desc")))
                        .build()
        );
        this.imageHeight = 210;
    }

    private Component getDisplayNumber(int number, boolean isMulti) {
        return isMulti ? Component.literal("x" + number) :  Component.literal("÷" + number);
    }

    @Override
    public void drawFG(GuiGraphics guiGraphics, int offsetX, int offsetY, int mouseX, int mouseY) {
        guiGraphics.drawString(
                this.font,
                Component.translatable("gui.extendedae.pattern_modifier", this.getModeName()),
                8,
                6,
                style.getColor(PaletteColor.DEFAULT_TEXT_COLOR).toARGB(),
                false
        );
        if (this.menu.page == 2) {
            guiGraphics.drawString(
                    this.font,
                    Component.translatable("gui.extendedae.pattern_modifier.blank"),
                    52,
                    57,
                    style.getColor(PaletteColor.DEFAULT_TEXT_COLOR).toARGB(),
                    false
            );
            guiGraphics.drawString(
                    this.font,
                    Component.translatable("gui.extendedae.pattern_modifier.target"),
                    52,
                    25,
                    style.getColor(PaletteColor.DEFAULT_TEXT_COLOR).toARGB(),
                    false
            );
        }
    }

    @Override
    public void init() {
        super.init();
        this.multiBtns.get(0).setPosition(this.leftPos + 7, this.topPos + 16);
        this.multiBtns.get(1).setPosition(this.leftPos + 37, this.topPos + 16);
        this.multiBtns.get(2).setPosition(this.leftPos + 67, this.topPos + 16);
        this.multiBtns.get(3).setPosition(this.leftPos + 97, this.topPos + 16);
        this.multiBtns.get(4).setPosition(this.leftPos + 7, this.topPos + 36);
        this.multiBtns.get(5).setPosition(this.leftPos + 37, this.topPos + 36);
        this.multiBtns.get(6).setPosition(this.leftPos + 67, this.topPos + 36);
        this.multiBtns.get(7).setPosition(this.leftPos + 97, this.topPos + 36);
        this.multiBtns.get(8).setPosition(this.leftPos + 130, this.topPos + 25);
        this.multiBtns.forEach(this::addRenderableWidget);
        this.clone.setPosition(this.leftPos + 79, this.topPos + 38);
        this.addRenderableWidget(this.clone);
        this.replace.setPosition(this.leftPos + 120, this.topPos + 24);
        this.addRenderableWidget(this.replace);
    }

    @Override
    protected void updateBeforeRender() {
        super.updateBeforeRender();
        EAENetworkServer.INSTANCE.sendToServer(new CGenericPacket("show"));
        this.menu.showPage();
        if (this.menu.page == 0) {
            this.clone.setVisibility(false);
            this.multiBtns.forEach(b -> b.visible = true);
            this.replace.visible = false;
        } else if (this.menu.page == 1) {
            this.clone.setVisibility(false);
            this.multiBtns.forEach(b -> b.visible = false);
            this.replace.visible = true;
        } else if (this.menu.page == 2) {
            this.clone.setVisibility(true);
            this.multiBtns.forEach(b -> b.visible = false);
            this.replace.visible = false;
        }
    }

    @Override
    public void drawBG(GuiGraphics guiGraphics, int offsetX, int offsetY, int mouseX, int mouseY, float partialTicks) {
        if (this.menu.page == 0) {
            guiGraphics.blit(AppEng.makeId("textures/guis/pattern_editor_1.png"), offsetX, offsetY, 0, 0, 176, 210);
        } else if (this.menu.page == 1) {
            guiGraphics.blit(AppEng.makeId("textures/guis/pattern_editor_3.png"), offsetX, offsetY, 0, 0, 176, 210);
        } else if (this.menu.page == 2) {
            guiGraphics.blit(AppEng.makeId("textures/guis/pattern_editor_2.png"), offsetX, offsetY, 0, 0, 176, 210);
        }
        super.drawBG(guiGraphics, offsetX, offsetY, mouseX, mouseY, partialTicks);
    }

    private Component getModeName() {
        return switch (this.menu.page) {
            case 0 -> Component.translatable("gui.extendedae.pattern_modifier.multiply");
            case 1 -> Component.translatable("gui.extendedae.pattern_modifier.replace");
            case 2 -> Component.translatable("gui.extendedae.pattern_modifier.clone");
            default -> Component.empty();
        };
    }

}
