package com.petmod.client;

import com.petmod.client.model.BuddyModel;
import com.petmod.client.render.BuddyRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;

/**
 * Model Layer Registration
 *
 * This registers our pet's 3D model shape with Minecraft.
 */
public class ModModelLayers {

    public static void register() {
        EntityModelLayerRegistry.registerModelLayer(
            BuddyRenderer.BUDDY_LAYER,
            BuddyModel::getTexturedModelData
        );
    }
}
