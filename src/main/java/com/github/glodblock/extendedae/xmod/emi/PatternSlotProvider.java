package com.github.glodblock.extendedae.xmod.emi;

import appeng.api.stacks.AEFluidKey;
import appeng.api.stacks.AEItemKey;
import appeng.api.stacks.GenericStack;
import appeng.items.misc.WrappedGenericStack;
import com.github.glodblock.extendedae.client.gui.pattern.GuiPattern;
import com.github.glodblock.extendedae.container.pattern.ContainerPattern;
import dev.emi.emi.api.EmiStackProvider;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.stack.EmiStackInteraction;
import net.minecraft.client.gui.screens.Screen;

public class PatternSlotProvider implements EmiStackProvider<Screen> {

    @Override
    public EmiStackInteraction getStackAt(Screen screen, int x, int y) {
        if (screen instanceof GuiPattern<?> patternScreen) {
            var slot = patternScreen.getSlotUnderMouse();
            if (slot instanceof ContainerPattern.DisplayOnlySlot dpSlot) {
                var stack = dpSlot.getItem();
                if (stack.getItem() instanceof WrappedGenericStack wgs) {
                    var key = wgs.unwrapWhat(stack);
                    var amt = wgs.unwrapAmount(stack);
                    if (key != null && amt > 0) {
                        EmiStack emiStack = null;
                        if (key instanceof AEItemKey itemKey)
                            emiStack = EmiStack.of(itemKey.toStack(Math.toIntExact(amt)));
                        else if (key instanceof AEFluidKey fluidKey)
                            emiStack = EmiStack.of(fluidKey.toVariant().getFluid(), amt);
                        if (emiStack != null) {
                            return new EmiStackInteraction(emiStack, null, false);
                        }
                    }
                } else if (!stack.isEmpty()) {
                    var emiStack = EmiStack.of(stack);
                    if (!emiStack.isEmpty()) {
                        return new EmiStackInteraction(emiStack, null, false);
                    }
                }
            }
        }
        return EmiStackInteraction.EMPTY;
    }

}