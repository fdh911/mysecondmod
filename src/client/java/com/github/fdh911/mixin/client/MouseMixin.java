package com.github.fdh911.mixin.client;

import com.github.fdh911.modules.garden.MouseLock;
import net.minecraft.client.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mouse.class)
public class MouseMixin {
    @Inject(at = @At("HEAD"), method = "updateMouse", cancellable = true)
    public void updateMouse_mysecondmod(double timeDelta, CallbackInfo ci) {
        if(MouseLock.INSTANCE.isLocked())
            ci.cancel();
    }
}
