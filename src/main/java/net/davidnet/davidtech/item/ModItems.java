package net.davidnet.davidtech.item;

import net.davidnet.davidtech.DavidTech;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DavidTech.MODID);

    // Dusts
    public static final DeferredItem<Item> OBSIDIAN_DUST = ITEMS.register("obsidian_dust", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> WOOD_DUST = ITEMS.register("wood_dust", () -> new Item(new Item.Properties()));

    // Flint
    public static final DeferredItem<Item> BOUND_FLINT = ITEMS.register("bound_flint", () -> new Item(new Item.Properties()));

    // Flint Tools
    public static final DeferredItem<Item> SHARP_FLINT = ITEMS.register("sharp_flint", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> FLINT_MORTAR = ITEMS.register("flint_mortar",
            () -> new Item(new Item.Properties().stacksTo(1).durability(32)) { // 32 durability
                @Override
                public boolean hasCraftingRemainingItem(ItemStack stack) {
                    return true;
                }

                @Override
                public ItemStack getCraftingRemainingItem(ItemStack stack) {
                    ItemStack copy = stack.copy();
                    copy.setDamageValue(copy.getDamageValue() + 1); // Reduce durability

                    if (copy.getDamageValue() >= copy.getMaxDamage()) {
                        Level level = net.minecraft.client.Minecraft.getInstance().level;
                        Player player = net.minecraft.client.Minecraft.getInstance().player;
                        if (level != null && player != null) {
                            level.playSound(player, player.blockPosition(), SoundEvents.ITEM_BREAK, SoundSource.PLAYERS, 1.0F, 1.0F);
                        }
                        return ItemStack.EMPTY; // Remove the item
                    }

                    return copy;
                }
            }
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
