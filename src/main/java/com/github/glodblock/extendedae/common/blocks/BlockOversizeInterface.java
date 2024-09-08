package com.github.glodblock.extendedae.common.blocks;

import appeng.menu.locator.MenuLocators;
import com.github.glodblock.extendedae.common.tileentities.TileOversizeInterface;
import net.minecraft.world.entity.player.Player;

public class BlockOversizeInterface extends BlockBaseGui<TileOversizeInterface> {

    @Override
    public void openGui(TileOversizeInterface tile, Player p) {
        tile.openMenu(p, MenuLocators.forBlockEntity(tile));
    }

}
