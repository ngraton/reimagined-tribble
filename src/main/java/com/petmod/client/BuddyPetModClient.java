package com.petmod.client;

import com.petmod.ModEntities;
import com.petmod.client.render.BuddyRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

/**
 * Client-side initialization
 *
 * This sets up rendering (how the pet looks on screen).
 * It only runs on the client, not on a server.
 */
public class BuddyPetModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // Register the 3D model shape
        ModModelLayers.register();

        // Tell Minecraft how to draw our pet
        EntityRendererRegistry.register(ModEntities.BUDDY, BuddyRenderer::new);
    }
}
