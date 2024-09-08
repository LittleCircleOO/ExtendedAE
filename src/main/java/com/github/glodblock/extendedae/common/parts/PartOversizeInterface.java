package com.github.glodblock.extendedae.common.parts;

import appeng.api.parts.IPartItem;
import appeng.api.parts.IPartModel;
import appeng.api.stacks.AEKey;
import appeng.api.storage.AEKeyFilter;
import appeng.core.AppEngBase;
import appeng.helpers.externalstorage.GenericStackInv;
import appeng.menu.ISubMenu;
import appeng.menu.MenuOpener;
import appeng.menu.locator.MenuLocator;
import appeng.parts.PartModel;
import appeng.util.ConfigInventory;
import com.github.glodblock.extendedae.EAE;
import com.github.glodblock.extendedae.config.EPPConfig;
import com.github.glodblock.extendedae.container.ContainerExInterface;
import com.github.glodblock.extendedae.util.Ae2Reflect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class PartOversizeInterface extends PartExInterface {

    public static List<ResourceLocation> MODELS = Arrays.asList(
            new ResourceLocation(EAE.MODID, "part/oversize_interface"),
            new ResourceLocation(AppEngBase.MOD_ID, "part/interface_on"),
            new ResourceLocation(AppEngBase.MOD_ID, "part/interface_off"),
            new ResourceLocation(AppEngBase.MOD_ID, "part/interface_has_channel")
    );

    public static final PartModel MODELS_OFF = new PartModel(MODELS.get(0), MODELS.get(2));
    public static final PartModel MODELS_ON = new PartModel(MODELS.get(0), MODELS.get(1));
    public static final PartModel MODELS_HAS_CHANNEL = new PartModel(MODELS.get(0), MODELS.get(3));

    public PartOversizeInterface(IPartItem<?> partItem) {
        super(partItem);
        var logic = this.getInterfaceLogic();
        Ae2Reflect.setInterfaceConfig(logic, new OversizeConfigInv(null, GenericStackInv.Mode.CONFIG_STACKS, 36, () -> Ae2Reflect.onInterfaceConfigChange(logic), false));
        Ae2Reflect.setInterfaceStorage(logic, new OversizeConfigInv(null, GenericStackInv.Mode.STORAGE, 36, () -> Ae2Reflect.onInterfaceStorageChange(logic), false));
    }

    @Override
    public void openMenu(Player player, MenuLocator locator) {
        MenuOpener.open(ContainerExInterface.TYPE_OVERSIZE, player, locator);
    }

    @Override
    public void returnToMainMenu(Player player, ISubMenu subMenu) {
        MenuOpener.returnTo(ContainerExInterface.TYPE_OVERSIZE, player, subMenu.getLocator());
    }

    @Override
    public IPartModel getStaticModels() {
        if (this.isActive() && this.isPowered()) {
            return MODELS_HAS_CHANNEL;
        } else if (this.isPowered()) {
            return MODELS_ON;
        } else {
            return MODELS_OFF;
        }
    }

    private static class OversizeConfigInv extends ConfigInventory {

        protected OversizeConfigInv(@Nullable AEKeyFilter filter, Mode mode, int size, @Nullable Runnable listener, boolean allowOverstacking) {
            super(filter, mode, size, listener, allowOverstacking);
        }

        @Override
        public long getMaxAmount(AEKey key) {
            try {
                return Math.multiplyExact(super.getMaxAmount(key), EPPConfig.INSTANCE.oversizeMultiplier);
            } catch (Exception e) {
                return Long.MAX_VALUE;
            }
        }

    }

}
