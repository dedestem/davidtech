package net.davidnet.davidtech.items;

import net.davidnet.davidtech.Davidtech;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

// Blocks
import static net.davidnet.davidtech.blocks.ModBlocks.IRON_MACHINE_CASING;
import static net.davidnet.davidtech.blocks.ModBlocks.TIER0GENERATOR;

public class ModItems {
    // Items
    public static final Item STONEDUST = new Item(new Item.Settings());
    public static final Item STONEINGOT = new Item(new Item.Settings());
    public static final Item OBSIDIANDUST = new Item(new Item.Settings());
    public static final Item IRONPLATE = new Item(new Item.Settings());
    public static final Item IRONROD = new Item(new Item.Settings());
    public static final Item IRONBOLT = new Item(new Item.Settings());

    // Block Items
    public static final Item IRONMACHINECASING_ITEM = new BlockItem(IRON_MACHINE_CASING, new Item.Settings());
    public static final Item TIER0GENERATOR_ITEM = new BlockItem(TIER0GENERATOR, new Item.Settings());

    // Craft Items
    public static final Item MORTAR = new CraftItem(new Item.Settings()
            .maxDamage(32)
            .maxCount(1));

    public static final Item IRONMORTAR = new CraftItem(new Item.Settings()
            .maxDamage(64)
            .maxCount(1));

    public static final Item SOFTMALLET = new CraftItem(new Item.Settings()
            .maxDamage(32)
            .maxCount(1));

    public static final Item IRONHAMMER = new CraftItem(new Item.Settings()
            .maxDamage(64)
            .maxCount(1));

    public static final Item IRONFILE = new CraftItem(new Item.Settings()
            .maxDamage(64)
            .maxCount(1));
    public static final Item IRONWRENCH = new CraftItem(new Item.Settings()
            .maxDamage(64)
            .maxCount(1));


    // Code to register an item
    public static void register(Item item, String id) {
        Identifier itemID = Identifier.of(Davidtech.MOD_ID, id);

        Registry.register(Registries.ITEM, itemID, item);
        Davidtech.LOGGER.info("Registered item: {} with ID: {}", id, itemID.toString());
    }

    // Function to register all items
    public static void registerAll() {
        // Items
        register(STONEDUST, "stonedust");
        register(STONEINGOT, "stoneingot");
        register(OBSIDIANDUST, "obsidiandust");
        register(IRONPLATE, "ironplate");
        register(IRONROD, "ironrod");
        register(IRONBOLT, "ironbolt");

        // Block Items
        register(IRONMACHINECASING_ITEM, "ironmachinecasing");
        register(TIER0GENERATOR_ITEM, "tier0generator");

        // Craft Items
        register(MORTAR, "mortar");
        register(IRONMORTAR, "ironmortar");
        register(SOFTMALLET, "softmallet");
        register(IRONHAMMER, "ironhammer");
        register(IRONFILE, "ironfile");
        register(IRONWRENCH, "ironwrench");
    }

    // Function to sort all items into groups!
    public static void registerItemGroupEntries() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((itemGroup) -> {
            itemGroup.add(STONEDUST);
            itemGroup.add(STONEINGOT);
            itemGroup.add(OBSIDIANDUST);
            itemGroup.add(IRONPLATE);
            itemGroup.add(IRONROD);
            itemGroup.add(IRONBOLT);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register((itemGroup) -> {
            itemGroup.add(IRONMACHINECASING_ITEM);
            itemGroup.add(TIER0GENERATOR_ITEM);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemGroup) -> {
            itemGroup.add(MORTAR);
            itemGroup.add(IRONMORTAR);
            itemGroup.add(SOFTMALLET);
            itemGroup.add(IRONHAMMER);
            itemGroup.add(IRONFILE);
            itemGroup.add(IRONWRENCH);
        });
    }

    // QOL Functions
    public static Item GetItemByID(String namespace, String path) {
        Identifier itemId = Identifier.of(namespace, path);
        return Registries.ITEM.get(itemId);
    }
}
