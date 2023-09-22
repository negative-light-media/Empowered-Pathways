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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

import static com.negativelight.empoweredpathways.Constants.BLOCKS;
import static com.negativelight.empoweredpathways.Constants.ITEMS;

public class ModBlocks {




    public static final RegistryObject<Block> STONEWORK_BLOCK = registerBlock("stonework_block", ()-> new Block(BlockBehaviour.Properties.of()));


    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> blockSupplier) {
        Constants.LOG.info("REGISTERING BLOCK AND ITEM " + name);
        RegistryObject<T> retVal = BLOCKS.register(name, blockSupplier);
        if (retVal == null)
        {
            Constants.LOG.error("Registry Object is NULL");
        } else if (retVal == null) {
            Constants.LOG.error("Registry Object get is null");
        }
        ITEMS.register("stonework_block", ()-> new BlockItem(retVal.get(), new Item.Properties()));
        //Items.DIRT
        return retVal;
    }

    public static void loadClass() {}
}
