package com.petmod.client.render;

import com.petmod.BuddyPetMod;
import com.petmod.client.model.BuddyModel;
import com.petmod.entity.BuddyEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

/**
 * BuddyRenderer - Draws our pet on screen!
 *
 * This connects the model (shape) with the texture (colors/skin)
 * and tells Minecraft how to display our pet in the game.
 */
public class BuddyRenderer extends MobEntityRenderer<BuddyEntity, BuddyModel> {

    // This identifies our model layer for registration
    public static final EntityModelLayer BUDDY_LAYER = new EntityModelLayer(
        new Identifier(BuddyPetMod.MOD_ID, "buddy"), "main"
    );

    // Path to our texture file
    private static final Identifier TEXTURE = new Identifier(BuddyPetMod.MOD_ID, "textures/entity/buddy.png");

    public BuddyRenderer(EntityRendererFactory.Context context) {
        super(context, new BuddyModel(context.getPart(BUDDY_LAYER)), 0.5f);
        // The 0.5f is the shadow size
    }

    @Override
    public Identifier getTexture(BuddyEntity entity) {
        return TEXTURE;
    }
}
