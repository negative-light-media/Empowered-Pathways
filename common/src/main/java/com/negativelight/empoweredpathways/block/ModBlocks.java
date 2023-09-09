package com.negativelight.empoweredpathways.block;

import com.negativelight.empoweredpathways.Constants;
import com.negativelight.empoweredpathways.item.ModItems;
import com.negativelight.empoweredpathways.registration.RegistrationProvider;
import com.negativelight.empoweredpathways.registration.RegistryObject;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class ModBlocks {

    public static final RegistrationProvider<Block> BLOCKS = RegistrationProvider.get(BuiltInRegistries.BLOCK, Constants.MOD_ID);

    //public static final RegistryObject<Block> STONEWORK_BLOCK = registerBlock(
    //                              "stonework_block",
    //                              () -> new Block(BlockBehaviour.Properties.of()));

    public static final RegistryObject<Block> STONEWORK_BLOCK = BLOCKS.register("example",
                                                                                ()-> new Block(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> EXAMPLE = registerBlock("example2",
            ()-> new Block(BlockBehaviour.Properties.of()));

    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> blockSupplier) {
        Constants.LOG.info("REGISTERING BLOCK AND ITEM " + name);
        RegistryObject<T> retVal = BLOCKS.register(name, blockSupplier);
        ModItems.registerBlock(name, retVal.get());
        //Items.DIRT
        return retVal;
    }

    public static void loadClass() {}
}
