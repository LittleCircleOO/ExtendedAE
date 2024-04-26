package com.glodblock.github.appflux.common.me.cell;

import appeng.api.storage.cells.ICellHandler;
import appeng.api.storage.cells.ISaveProvider;
import appeng.core.AEConfig;
import appeng.core.localization.Tooltips;
import appeng.items.storage.StorageCellTooltipComponent;
import com.glodblock.github.appflux.api.IFluxCell;
import com.glodblock.github.appflux.common.me.key.type.EnergyType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FECellHandler implements ICellHandler {

    public static final FECellHandler HANDLER = new FECellHandler();

    @Override
    public boolean isCell(ItemStack is) {
        return !is.isEmpty() && is.getItem() instanceof IFluxCell cell && cell.getEnergyType() == EnergyType.FE;
    }

    @Override
    public @Nullable FluxCellInventory getCellInventory(ItemStack is, @Nullable ISaveProvider host) {
        if (isCell(is)) {
            return new FECellInventory((IFluxCell) is.getItem(), is, host);
        }
        return null;
    }

    public void addCellInformationToTooltip(ItemStack is, List<Component> lines) {
        var handler = getCellInventory(is, null);
        if (handler == null) {
            return;
        }
        lines.add(Tooltips.bytesUsed(handler.getUsedBytes(), handler.getTotalBytes()));
        lines.add(Component.translatable("appflux.cell.storage", Tooltips.ofNumber(handler.storedEnergy), handler.getEnergyType().translate()));
    }

    public Optional<TooltipComponent> getTooltipImage(ItemStack is) {
        var handler = getCellInventory(is, null);
        if (handler == null) {
            return Optional.empty();
        }
        var upgradeStacks = new ArrayList<ItemStack>();
        if (AEConfig.instance().isTooltipShowCellUpgrades()) {
            for (var upgrade : handler.getUpgrades()) {
                upgradeStacks.add(upgrade);
            }
        }
        return Optional.of(new StorageCellTooltipComponent(upgradeStacks, List.of(), false, true));
    }

}