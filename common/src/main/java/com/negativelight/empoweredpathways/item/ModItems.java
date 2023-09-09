package com.negativelight.empoweredpathways.item;

import com.negativelight.empoweredpathways.Constants;
import com.negativelight.empoweredpathways.block.ModBlocks;
import com.negativelight.empoweredpathways.registration.RegistrationProvider;
import com.negativelight.empoweredpathways.registration.RegistryObject;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModItems {
    public static final RegistrationProvider<Item> ITEMS = RegistrationProvider.get(BuiltInRegistries.ITEM, Constants.MOD_ID);

    //public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example",()-> new Item((new Item.Properties())));

    //public static final RegistryObject<Item> STONEWORK_BLOCK_ITEM = ITEMS.register("example",
    // ()-> new BlockItem(ModBlocks.STONEWORK_BLOCK.get(), new Item.Properties()));

    public static void registerBlock(String blockName, Block block) {
        ITEMS.register(blockName, ()-> new BlockItem(block, new Item.Properties()));
    }


    public static void loadClass() {}
}
