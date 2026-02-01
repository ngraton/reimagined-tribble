package com.petmod.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

/**
 * BuddyEntity - Our Pet!
 *
 * This is the actual pet creature. It can:
 * - Follow the player around
 * - Sit when you right-click it
 * - Be tamed with cookies (yum!)
 *
 * It extends TameableEntity which gives us lots of pet behavior for free,
 * just like wolves and cats in vanilla Minecraft!
 */
public class BuddyEntity extends TameableEntity {

    public BuddyEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    /**
     * Set up the pet's attributes (stats)
     * - Health: 20 (same as player)
     * - Speed: 0.3 (pretty quick!)
     */
    public static DefaultAttributeContainer.Builder createBuddyAttributes() {
        return MobEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3);
    }

    /**
     * Set up the pet's AI goals (what it wants to do)
     * Goals have priorities - lower number = more important
     */
    @Override
    protected void initGoals() {
        // Priority 1: Float in water so it doesn't drown
        this.goalSelector.add(1, new SwimGoal(this));

        // Priority 2: If sitting, stay put!
        this.goalSelector.add(2, new SitGoal(this));

        // Priority 3: Follow the owner around (stay within 10 blocks, start following at 2 blocks away)
        this.goalSelector.add(3, new FollowOwnerGoal(this, 1.0, 10.0f, 2.0f, false));

        // Priority 4: Wander around randomly when bored
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 1.0));

        // Priority 5: Look at nearby players
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));

        // Priority 6: Look around randomly
        this.goalSelector.add(6, new LookAroundGoal(this));
    }

    /**
     * What happens when a player right-clicks the pet
     */
    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);

        // If not tamed yet, try to tame with a cookie!
        if (!this.isTamed()) {
            if (itemStack.isOf(Items.COOKIE)) {
                if (!player.getAbilities().creativeMode) {
                    itemStack.decrement(1);  // Use up the cookie
                }

                // Tame the pet!
                this.setOwner(player);
                this.navigation.stop();
                this.setSitting(true);
                this.getWorld().sendEntityStatus(this, (byte) 7);  // Heart particles!

                return ActionResult.SUCCESS;
            }
        } else if (this.isOwner(player)) {
            // If already tamed and owner clicks, toggle sitting
            this.setSitting(!this.isSitting());
            this.navigation.stop();
            return ActionResult.SUCCESS;
        }

        return super.interactMob(player, hand);
    }

    /**
     * This is required - we don't have a baby version of our pet (yet!)
     */
    @Override
    public BuddyEntity createChild(net.minecraft.server.world.ServerWorld world, net.minecraft.entity.passive.PassiveEntity mate) {
        return null;  // No babies for now - maybe in a future sprint!
    }
}
