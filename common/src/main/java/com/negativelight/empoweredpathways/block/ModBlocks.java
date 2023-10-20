package com.negativelight.empoweredpathways.block;

import com.negativelight.empoweredpathways.Constants;
import com.negativelight.empoweredpathways.block.custom.StoneworkPath;
import com.negativelight.empoweredpathways.registration.RegistryObject;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import java.util.function.Supplier;

import static com.negativelight.empoweredpathways.Constants.BLOCKS;
import static com.negativelight.empoweredpathways.Constants.ITEMS;

public class ModBlocks {

    //***************************CONSTANTS
        //TODO: Negative 2310 Create a Config File for these

    private  static  final float STONEWORK_STRENGTH = 3.5f;
    private  static  final float REINFORCED_BLAST_RESIST = 7f;
    private  static  final int INFUSED_LIGHT_LEVEL = 7;
    private  static final float PATH_SPEED_FACTOR = 1.33f;

    private static final BlockBehaviour.Properties PATH_PROPERTIES = BlockBehaviour.Properties.of()
                                                                            .requiresCorrectToolForDrops()
                                                                            .strength(STONEWORK_STRENGTH)
                                                                            .speedFactor(PATH_SPEED_FACTOR);
    private static final BlockBehaviour.Properties STONEWORK_PROPERTIES = BlockBehaviour.Properties.of()
                                                                            .requiresCorrectToolForDrops()
                                                                            .strength(STONEWORK_STRENGTH);
    //*************************** BLCOKS

    //Stonework Path
    public static final RegistryObject<Block> STONEWORK_PATH = registerBlock("stonework_path",
           ()-> new StoneworkPath(PATH_PROPERTIES));

    //Stonework Block
    public static final RegistryObject<Block> STONEWORK_BLOCK = registerBlock("stonework_block",
            ()-> new Block(STONEWORK_PROPERTIES));


    //Infused Path
    public static final RegistryObject<Block> INFUSED_STONEWORK_PATH = registerBlock("infused_stonework_path",
            ()-> new StoneworkPath(PATH_PROPERTIES.lightLevel(value -> INFUSED_LIGHT_LEVEL)));

    //Infused Block
    public static final RegistryObject<Block> INFUSED_STONEWORK_BLOCK = registerBlock("infused_stonework_block",
            ()-> new Block(STONEWORK_PROPERTIES.lightLevel(value -> INFUSED_LIGHT_LEVEL)));

    //Reinforced Path
    public static final RegistryObject<Block> REINFORCED_STONEWORK_PATH = registerBlock("reinforced_stonework_path",
            ()-> new StoneworkPath(PATH_PROPERTIES.strength(STONEWORK_STRENGTH, REINFORCED_BLAST_RESIST)));

    //Reinforced Block
    public static final RegistryObject<Block> REINFORCED_STONEWORK_BLOCK = registerBlock("reinforced_stonework_block",
            ()-> new Block(STONEWORK_PROPERTIES.strength(STONEWORK_STRENGTH, REINFORCED_BLAST_RESIST)));



    //****************** UTILITY FUNCTIONS
    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> blockSupplier) {
        Constants.LOG.info("REGISTERING BLOCK AND ITEM " + name);
        RegistryObject<T> retVal = BLOCKS.register(name, blockSupplier);
        if (retVal == null)
        {
            Constants.LOG.error("Registry Object is NULL");
        }
        ITEMS.register(name, ()-> {
            assert retVal != null;
            return new BlockItem(retVal.get(), new Item.Properties());
        });
        //Items.DIRT
        return retVal;
    }

    public static void loadClass() {}
}
