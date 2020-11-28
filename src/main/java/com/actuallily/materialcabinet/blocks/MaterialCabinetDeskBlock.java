package com.actuallily.materialcabinet.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import java.util.stream.Stream;

public class MaterialCabinetDeskBlock extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(4, 0, 1, 5, 15, 15),
            Block.makeCuboidShape(1, 8, 1, 4, 9, 15),
            Block.makeCuboidShape(1, 1, 1, 4, 2, 15),
            Block.makeCuboidShape(12, 1, 1, 15, 2, 15),
            Block.makeCuboidShape(12, 8, 1, 15, 9, 15),
            Block.makeCuboidShape(11, 15, 15, 16, 16, 16),
            Block.makeCuboidShape(0, 15, 1, 16, 16, 15),
            Block.makeCuboidShape(0, 15, 0, 5, 16, 1),
            Block.makeCuboidShape(0, 15, 15, 5, 16, 16),
            Block.makeCuboidShape(11, 15, 0, 16, 16, 1),
            Block.makeCuboidShape(14, 0, 15, 16, 15, 16),
            Block.makeCuboidShape(0, 0, 15, 2, 15, 16),
            Block.makeCuboidShape(0, 0, 0, 2, 15, 1),
            Block.makeCuboidShape(14, 0, 0, 16, 15, 1),
            Block.makeCuboidShape(11, 0, 1, 12, 15, 15)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(1, 0, 4, 15, 15, 5),
            Block.makeCuboidShape(1, 8, 1, 15, 9, 4),
            Block.makeCuboidShape(1, 1, 1, 15, 2, 4),
            Block.makeCuboidShape(1, 1, 12, 15, 2, 15),
            Block.makeCuboidShape(1, 8, 12, 15, 9, 15),
            Block.makeCuboidShape(0, 15, 11, 1, 16, 16),
            Block.makeCuboidShape(1, 15, 0, 15, 16, 16),
            Block.makeCuboidShape(15, 15, 0, 16, 16, 5),
            Block.makeCuboidShape(0, 15, 0, 1, 16, 5),
            Block.makeCuboidShape(15, 15, 11, 16, 16, 16),
            Block.makeCuboidShape(0, 0, 14, 1, 15, 16),
            Block.makeCuboidShape(0, 0, 0, 1, 15, 2),
            Block.makeCuboidShape(15, 0, 0, 16, 15, 2),
            Block.makeCuboidShape(15, 0, 14, 16, 15, 16),
            Block.makeCuboidShape(1, 0, 11, 15, 15, 12)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(11, 0, 1, 12, 15, 15),
            Block.makeCuboidShape(12, 8, 1, 15, 9, 15),
            Block.makeCuboidShape(12, 1, 1, 15, 2, 15),
            Block.makeCuboidShape(1, 1, 1, 4, 2, 15),
            Block.makeCuboidShape(1, 8, 1, 4, 9, 15),
            Block.makeCuboidShape(0, 15, 0, 5, 16, 1),
            Block.makeCuboidShape(0, 15, 1, 16, 16, 15),
            Block.makeCuboidShape(11, 15, 15, 16, 16, 16),
            Block.makeCuboidShape(11, 15, 0, 16, 16, 1),
            Block.makeCuboidShape(0, 15, 15, 5, 16, 16),
            Block.makeCuboidShape(0, 0, 0, 2, 15, 1),
            Block.makeCuboidShape(14, 0, 0, 16, 15, 1),
            Block.makeCuboidShape(14, 0, 15, 16, 15, 16),
            Block.makeCuboidShape(0, 0, 15, 2, 15, 16),
            Block.makeCuboidShape(4, 0, 1, 5, 15, 15)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(1, 0, 11, 15, 15, 12),
            Block.makeCuboidShape(1, 8, 12, 15, 9, 15),
            Block.makeCuboidShape(1, 1, 12, 15, 2, 15),
            Block.makeCuboidShape(1, 1, 1, 15, 2, 4),
            Block.makeCuboidShape(1, 8, 1, 15, 9, 4),
            Block.makeCuboidShape(15, 15, 0, 16, 16, 5),
            Block.makeCuboidShape(1, 15, 0, 15, 16, 16),
            Block.makeCuboidShape(0, 15, 11, 1, 16, 16),
            Block.makeCuboidShape(15, 15, 11, 16, 16, 16),
            Block.makeCuboidShape(0, 15, 0, 1, 16, 5),
            Block.makeCuboidShape(15, 0, 0, 16, 15, 2),
            Block.makeCuboidShape(15, 0, 14, 16, 15, 16),
            Block.makeCuboidShape(0, 0, 14, 1, 15, 16),
            Block.makeCuboidShape(0, 0, 0, 1, 15, 2),
            Block.makeCuboidShape(1, 0, 4, 15, 15, 5)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    public MaterialCabinetDeskBlock() {
        super(Block.Properties.create(Material.WOOD)
                .hardnessAndResistance(3.0f, 5.0f)
                .sound(SoundType.WOOD)
                .harvestLevel(0)
                .harvestTool(ToolType.AXE)
        );
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.7f;
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
