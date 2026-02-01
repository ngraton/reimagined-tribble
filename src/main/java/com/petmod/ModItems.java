package com.petmod;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 * Item Registration
 *
 * This registers our spawn egg so we can summon our pet!
 */
public class ModItems {

    // Spawn egg to create our Buddy pet
    // Colors: primary (light blue) and secondary (pink) - fun colors!
    public static final Item BUDDY_SPAWN_EGG = Registry.register(
        Registries.ITEM,
        new Identifier(BuddyPetMod.MOD_ID, "buddy_spawn_egg"),
        new SpawnEggItem(ModEntities.BUDDY, 0x7DD3FC, 0xF9A8D4, new FabricItemSettings())
    );

    public static void register() {
        BuddyPetMod.LOGGER.info("Registering items for " + BuddyPetMod.MOD_ID);

        // Add our spawn egg to the Spawn Eggs creative tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> {
            content.add(BUDDY_SPAWN_EGG);
        });
    }
}
