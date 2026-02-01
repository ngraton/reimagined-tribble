package com.petmod;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Buddy Pet Mod - Main Entry Point
 *
 * This is where our mod starts! When Minecraft loads,
 * it calls onInitialize() and we register our pet.
 */
public class BuddyPetMod implements ModInitializer {

    // Our mod's unique ID - used everywhere to identify our stuff
    public static final String MOD_ID = "buddypet";

    // Logger for printing messages (helpful for debugging!)
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // This runs when Minecraft starts up
        LOGGER.info("Buddy Pet Mod is loading!");

        // Register our pet entity and spawn egg
        ModEntities.register();
        ModItems.register();

        LOGGER.info("Buddy Pet Mod loaded successfully!");
    }
}
