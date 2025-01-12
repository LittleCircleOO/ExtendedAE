package com.github.glodblock.extendedae.container;

import appeng.menu.guisync.GuiSync;
import appeng.menu.implementations.MenuTypeBuilder;
import appeng.menu.implementations.UpgradeableMenu;
import com.github.glodblock.extendedae.common.parts.PartModExportBus;
import com.github.glodblock.extendedae.network.EAENetworkServer;
import com.github.glodblock.extendedae.network.packet.SGenericPacket;
import com.github.glodblock.extendedae.network.packet.sync.IActionHolder;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.function.Consumer;

public class ContainerModExportBus extends UpgradeableMenu<PartModExportBus> implements IActionHolder {
    private final Map<String, Consumer<Object[]>> actions = new Object2ObjectOpenHashMap<>();

    public static final MenuType<ContainerModExportBus> TYPE = MenuTypeBuilder
            .create(ContainerModExportBus::new, PartModExportBus.class)
            .build("mod_export_bus");

    @GuiSync(9)
    public String exp = "";

    public ContainerModExportBus(int id, Inventory ip, PartModExportBus host) {
        super(TYPE, id, ip, host);
        this.actions.put("set", o -> this.setExp((String) o[0]));
        this.actions.put("update", o -> {
            if (this.getPlayer() instanceof ServerPlayer sp) {
                EAENetworkServer.INSTANCE.sendTo(new SGenericPacket("init", this.exp), sp);
            }
        });
    }

    @Override
    protected void setupConfig() {
        // NO-OP
    }

    @Override
    public void broadcastChanges() {
        super.broadcastChanges();
        if (!this.exp.equals(getHost().getModNameFilter())) {
            this.exp = getHost().getModNameFilter();
        }
    }

    @Override
    public boolean isSlotEnabled(int idx) {
        return false;
    }

    public void setExp(String exp) {
        getHost().setModNameFilter(exp);
        this.broadcastChanges();
    }

    @NotNull
    @Override
    public Map<String, Consumer<Object[]>> getActionMap() {
        return this.actions;
    }


}
