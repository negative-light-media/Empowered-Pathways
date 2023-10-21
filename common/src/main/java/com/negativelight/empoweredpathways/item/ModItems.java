package com.negativelight.empoweredpathways.item;

import com.negativelight.empoweredpathways.Constants;
import com.negativelight.empoweredpathways.item.custom.GraderItem;
import com.negativelight.empoweredpathways.registration.RegistryObject;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;

import java.util.function.Supplier;

import static com.negativelight.empoweredpathways.Constants.ITEMS;

public class ModItems {

    public static RegistryObject<Item> GRADER_TOOL = registerItem("grader",
            () -> new GraderItem(Tiers.IRON, 1.5F, -3.0F, new Item.Properties()));
    public static void loadClass() {}

    public static <T extends Item> RegistryObject<T> registerItem(String name, Supplier<T> itemSupplier) {
        Constants.LOG.info("REGISTERING BLOCK AND ITEM " + name);
        //Items.DIRT
        return ITEMS.register(name, itemSupplier);
    }
}
