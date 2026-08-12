package com.github.getchoo.smoothboot.mixin.client;

import com.github.getchoo.smoothboot.SmoothBoot;
import net.minecraft.client.Minecraft;
import net.minecraft.client.server.IntegratedServer;
import net.minecraft.server.Services;
import net.minecraft.server.WorldStem;
import net.minecraft.server.level.progress.LevelLoadListener;
import net.minecraft.server.packs.repository.PackRepository;
import net.minecraft.world.level.storage.LevelStorageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@Mixin(IntegratedServer.class)
public class IntegratedServerMixin {
    @Inject(method = "<init>", at = @At("RETURN"))
    public void onInit(Thread serverThread, Minecraft minecraft, LevelStorageSource.LevelStorageAccess levelStorageAccess, PackRepository packRepository, WorldStem worldStem, Optional gameRules, Services services, LevelLoadListener levelLoadListener, CallbackInfo ci) {
        serverThread.setPriority(SmoothBoot.config.threadPriority.integratedServer);
        SmoothBoot.LOGGER.debug("Initialized integrated server thread");
    }
}
