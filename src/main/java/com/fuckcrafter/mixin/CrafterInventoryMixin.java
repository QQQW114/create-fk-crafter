package com.fuckcrafter.mixin;

import com.simibubi.create.content.kinetics.crafter.MechanicalCrafterBlockEntity.Inventory;
import com.simibubi.create.foundation.item.SmartInventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = Inventory.class, remap = false)
public class CrafterInventoryMixin {

    @Redirect(
            method = "<init>",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/simibubi/create/foundation/item/SmartInventory;forbidExtraction()V",
                    remap = false
            ),
            remap = false
    )
    private void skipForbidExtraction(SmartInventory instance) {
        System.out.println("[FuckCrafter] Mixin applied! Extraction allowed.");
    }
}
