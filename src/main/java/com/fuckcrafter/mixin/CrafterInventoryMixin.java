package com.fuckcrafter.mixin;

import com.simibubi.create.content.kinetics.crafter.MechanicalCrafterBlockEntity.Inventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Inventory.class, remap = false)
public class CrafterInventoryMixin {
    @Inject(method = "<init>", at = @At("TAIL"))
    private void allowExtraction(CallbackInfo ci) {
        ((Inventory)(Object)this).allowExtraction();
    }
}
