package net.davidnet.davidtech.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;

import java.util.Objects;

public class Tier0Generator extends HorizontalFacingBlock {
    public Tier0Generator(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return null;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        // The block should always face the player when placed
        return this.getDefaultState().with(FACING, Objects.requireNonNull(context.getPlayer()).getFacing());
    }
}
