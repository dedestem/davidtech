package net.davidnet.davidtech.blocks;

import net.davidnet.davidtech.Davidtech;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import net.davidnet.davidtech.blocks.Tier0Generator;

public class ModBlocks {
    // Blocks
    public static final Block IRON_MACHINE_CASING = register("ironmachinecasing",
            new Block(AbstractBlock.Settings.create().strength(1f)
                    .sounds(BlockSoundGroup.COPPER)));

    public static final Block TIER0GENERATOR = register("tier0generator",
            new Tier0Generator(AbstractBlock.Settings.create().strength(1f)
                    .sounds(BlockSoundGroup.STONE)) {
            });

    // Code to register
    private static Block register(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(Davidtech.MOD_ID, name), block);
    }

    public static void registerAll() {
        Davidtech.LOGGER.info("Registering Mod Blocks for " + Davidtech.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.IRON_MACHINE_CASING);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(ModBlocks.TIER0GENERATOR);
        });
    }
}
