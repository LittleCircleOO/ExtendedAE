package com.github.glodblock.extendedae.xmod;

import appeng.api.stacks.AEKeyType;
import appeng.api.stacks.AEKeyTypes;
import net.minecraft.resources.ResourceLocation;

public class ExternalTypes {

    public static AEKeyType MANA;
    public static AEKeyType FLUX;

    static {
        try {
            MANA = AEKeyTypes.get(new ResourceLocation("appbot:mana"));
        } catch (Exception e) {
            MANA = null;
        }
        try {
            FLUX = AEKeyTypes.get(new ResourceLocation("appflux:flux"));
        } catch (Exception e) {
            FLUX = null;
        }
    }

}
