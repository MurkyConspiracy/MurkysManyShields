package net.minecraft.block;

import java.util.Random;
import net.minecraft.item.Items;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class BeetrootBlock extends CropsBlock {
   public static final IntegerProperty BEETROOT_AGE = BlockStateProperties.AGE_0_3;
   private static final VoxelShape[] SHAPE = new VoxelShape[]{Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D)};

   public BeetrootBlock(Block.Properties properties) {
      super(properties);
   }

   public IntegerProperty getAgeProperty() {
      return BEETROOT_AGE;
   }

   public int getMaxAge() {
      return 3;
   }

   protected IItemProvider getSeedsItem() {
      return Items.BEETROOT_SEEDS;
   }

   public void func_225534_a_(BlockState p_225534_1_, ServerWorld p_225534_2_, BlockPos p_225534_3_, Random p_225534_4_) {
      if (p_225534_4_.nextInt(3) != 0) {
         super.func_225534_a_(p_225534_1_, p_225534_2_, p_225534_3_, p_225534_4_);
      }

   }

   protected int getBonemealAgeIncrease(World worldIn) {
      return super.getBonemealAgeIncrease(worldIn) / 3;
   }

   protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
      builder.add(BEETROOT_AGE);
   }

   public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
      return SHAPE[state.get(this.getAgeProperty())];
   }
}