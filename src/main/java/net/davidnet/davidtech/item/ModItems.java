package net.davidnet.davidtech.item;

import net.davidnet.davidtech.DavidTech;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DavidTech.MODID);

    // Dusts
    public static final DeferredItem<Item> OBSIDIAN_DUST = ITEMS.register("obsidian_dust", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> WOOD_DUST = ITEMS.register("wood_dust", () -> new Item(new Item.Properties()));

    // Flint
    public static final DeferredItem<Item> BOUND_FLINT = ITEMS.register("bound_flint", () -> new Item(new Item.Properties()));

    // Flint Tools
    public static final DeferredItem<Item> SHARP_FLINT = ITEMS.register("sharp_flint", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> FLINT_MORTAR = ITEMS.register("flint_mortar", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
