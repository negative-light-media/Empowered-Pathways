package com.negativelight.empoweredpathways.item.custom;

import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Maps;
import com.negativelight.empoweredpathways.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.Map;

public class GraderItem extends DiggerItem {
    public static void loadClass() {}
    protected static final Map<Block, BlockState> GRADEABLES = Maps.newHashMap(
            new Builder()
                    .put(ModBlocks.STONEWORK_BLOCK.get(), ModBlocks.STONEWORK_PATH.get().defaultBlockState())
                    .put(ModBlocks.INFUSED_STONEWORK_BLOCK.get(), ModBlocks.INFUSED_STONEWORK_PATH.get().defaultBlockState())
                    .put(ModBlocks.REINFORCED_STONEWORK_BLOCK.get(), ModBlocks.REINFORCED_STONEWORK_PATH.get().defaultBlockState())
                    .build()
    );
    public GraderItem(Tier tier, float $$1, float $$2, Item.Properties properties) {
        super($$1, $$2, tier, BlockTags.MINEABLE_WITH_PICKAXE, properties);
    }


    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos targetPos = context.getClickedPos();
        BlockState targetState = level.getBlockState(targetPos);
        if (context.getClickedFace() == Direction.DOWN) {
            return InteractionResult.PASS;
        }

        Player player = context.getPlayer();
        BlockState fromState = GRADEABLES.get(targetState.getBlock());
        BlockState toState = null;

        if (fromState != null && level.getBlockState(targetPos.above()).isAir()) {
            level.playSound(player, targetPos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
            toState = fromState;
        } else if (targetState.getBlock() instanceof CampfireBlock && targetState.getValue(CampfireBlock.LIT)) {
            if (!level.isClientSide()) {
                level.levelEvent(null, 1009, targetPos, 0);
            }

            CampfireBlock.dowse(context.getPlayer(), level, targetPos, targetState);
            toState = targetState.setValue(CampfireBlock.LIT, Boolean.valueOf(false));
        }

        if (toState != null) {
            if (!level.isClientSide) {
                level.setBlock(targetPos, toState, 11);
                level.gameEvent(GameEvent.BLOCK_CHANGE, targetPos, GameEvent.Context.of(player, toState));
                if (player != null) {
                    context.getItemInHand().hurtAndBreak(1, player, $$1x -> $$1x.broadcastBreakEvent(context.getHand()));
                }
            }

            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return InteractionResult.PASS;
        }

    }
}
