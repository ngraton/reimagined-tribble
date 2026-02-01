package com.petmod;

import com.petmod.entity.BuddyEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 * Entity Registration
 *
 * This class registers our pet entity with Minecraft.
 * Think of it like signing up our pet to be part of the game!
 */
public class ModEntities {

    // Create our Buddy entity type
    public static final EntityType<BuddyEntity> BUDDY = Registry.register(
        Registries.ENTITY_TYPE,
        new Identifier(BuddyPetMod.MOD_ID, "buddy"),
        EntityType.Builder.create(BuddyEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 0.8f)  // Size: slightly smaller than a player
            .build()
    );

    public static void register() {
        BuddyPetMod.LOGGER.info("Registering entities for " + BuddyPetMod.MOD_ID);

        // Register the attributes (health, speed, etc.) for our pet
        FabricDefaultAttributeRegistry.register(BUDDY, BuddyEntity.createBuddyAttributes());
    }
}
