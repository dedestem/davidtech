package net.davidnet.davidtech.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CraftItem extends Item {
    public CraftItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasRecipeRemainder() {
        return true;
    }

    @Override
    public ItemStack getRecipeRemainder(ItemStack stack) {
        ItemStack newStack = stack.copy();
        newStack.setDamage(stack.getDamage() + 1);
        if (newStack.getDamage() >= newStack.getMaxDamage()) {
            return ItemStack.EMPTY;
        }
        return newStack;
    }
}

// Explaination
// This code does damage to an craft item instead of consuming it in an craft!