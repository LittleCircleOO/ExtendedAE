package com.github.glodblock.extendedae.container;

import appeng.blockentity.AEBaseBlockEntity;
import appeng.menu.AEBaseMenu;
import appeng.menu.guisync.GuiSync;
import appeng.menu.implementations.MenuTypeBuilder;
import appeng.parts.AEBasePart;
import com.github.glodblock.extendedae.network.EAENetworkServer;
import com.github.glodblock.extendedae.network.packet.SGenericPacket;
import com.github.glodblock.extendedae.network.packet.sync.IActionHolder;
import com.github.glodblock.extendedae.util.Ae2Reflect;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Nameable;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ContainerRenamer extends AEBaseMenu implements IActionHolder {

    public static final MenuType<ContainerRenamer> TYPE = MenuTypeBuilder
            .create(ContainerRenamer::new, Object.class)
            .build("renamer");
    private final Map<String, Consumer<Object[]>> actions = new Object2ObjectOpenHashMap<>();
    private final Consumer<String> setter;
    private final Supplier<Component> getter;
    @GuiSync(1)
    public String name = "";

    public ContainerRenamer(int id, Inventory playerInventory, Object host) {
        super(TYPE, id, playerInventory, host);
        this.getter = getter(host);
        this.setter = setter(host);
        if (this.setter == null || this.getter == null) {
            this.setValidMenu(false);
        }
        this.actions.put("set", o -> this.setName((String) o[0]));
        this.actions.put("update", o -> {
            if (this.getPlayer() instanceof ServerPlayer sp) {
                EAENetworkServer.INSTANCE.sendTo(new SGenericPacket("init", this.name), sp);
            }
        });
    }

    @Override
    public void broadcastChanges() {
        super.broadcastChanges();
        var newName = this.getter.get() == null ? "" : this.getter.get().getString();
        if (!this.name.equals(newName)) {
            this.name = newName;
        }
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.setter.accept(name);
        } else {
            this.setter.accept("");
        }
        broadcastChanges();
    }

    private static Supplier<Component> getter(Object o) {
        if (o instanceof Nameable n) {
            return n::getCustomName;
        }
        return null;
    }

    private static Consumer<String> setter(Object o) {
        if (o instanceof AEBaseBlockEntity || o instanceof AEBasePart) {
            return s -> {
                var c = s.isBlank() ? null : Component.literal(s);
                Ae2Reflect.setCustomName(o, c);
            };
        }
        return null;
    }

    @NotNull
    @Override
    public Map<String, Consumer<Object[]>> getActionMap() {
        return this.actions;
    }
}
