package com.petmod.client.model;

import com.petmod.entity.BuddyEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

/**
 * BuddyModel - How our pet is shaped!
 *
 * This defines the 3D shape of our pet using boxes (cuboids).
 * Think of it like building with LEGO blocks!
 *
 * Our buddy is a cute, simple creature:
 * - Round body
 * - Big head with eyes
 * - Small stubby legs
 */
public class BuddyModel extends EntityModel<BuddyEntity> {

    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart leftLeg;
    private final ModelPart rightLeg;

    public BuddyModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = root.getChild("head");
        this.leftLeg = root.getChild("left_leg");
        this.rightLeg = root.getChild("right_leg");
    }

    /**
     * Create the model's shape data
     * Numbers are: (x offset, y offset, z offset, width, height, depth)
     */
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();

        // Body - a chunky rectangle (the main part)
        root.addChild("body",
            ModelPartBuilder.create()
                .uv(0, 16)
                .cuboid(-4.0f, -6.0f, -4.0f, 8.0f, 6.0f, 8.0f),
            ModelTransform.pivot(0.0f, 20.0f, 0.0f)
        );

        // Head - slightly bigger, sits on top
        root.addChild("head",
            ModelPartBuilder.create()
                .uv(0, 0)
                .cuboid(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f),
            ModelTransform.pivot(0.0f, 14.0f, 0.0f)
        );

        // Left leg - small and stubby
        root.addChild("left_leg",
            ModelPartBuilder.create()
                .uv(32, 0)
                .cuboid(-1.5f, 0.0f, -1.5f, 3.0f, 4.0f, 3.0f),
            ModelTransform.pivot(-2.0f, 20.0f, 0.0f)
        );

        // Right leg - matches the left
        root.addChild("right_leg",
            ModelPartBuilder.create()
                .uv(32, 0)
                .cuboid(-1.5f, 0.0f, -1.5f, 3.0f, 4.0f, 3.0f),
            ModelTransform.pivot(2.0f, 20.0f, 0.0f)
        );

        return TexturedModelData.of(modelData, 64, 32);
    }

    /**
     * Animate the model (make legs move when walking)
     */
    @Override
    public void setAngles(BuddyEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        // Make the head look where the entity is looking
        this.head.yaw = headYaw * 0.017453292f;  // Convert degrees to radians
        this.head.pitch = headPitch * 0.017453292f;

        // Animate legs when walking (swing back and forth)
        this.leftLeg.pitch = (float) Math.cos(limbAngle * 0.6662f) * 1.4f * limbDistance;
        this.rightLeg.pitch = (float) Math.cos(limbAngle * 0.6662f + Math.PI) * 1.4f * limbDistance;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        body.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        head.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        leftLeg.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        rightLeg.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}
