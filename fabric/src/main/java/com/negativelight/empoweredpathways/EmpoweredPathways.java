package com.negativelight.empoweredpathways;

import com.negativelight.empoweredpathways.block.ModBlocks;
import com.negativelight.empoweredpathways.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;

public class EmpoweredPathways implements ModInitializer {
    
    @Override
    public void onInitialize() {
        
        // This method is invoked by the Fabric mod loader when it is ready
        // to load your mod. You can access Fabric and Common code in this
        // project.

        // Use Fabric to bootstrap the Common mod.
        Constants.LOG.info("Hello Fabric world!");
        CommonClass.init();


        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(EmpoweredPathways::addBuildingBlocks);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(EmpoweredPathways::addTools);
    }

    private static void addBuildingBlocks(FabricItemGroupEntries entries) {
        entries.accept(ModBlocks.STONEWORK_BLOCK.get());
        entries.accept(ModBlocks.INFUSED_STONEWORK_BLOCK.get());
        entries.accept(ModBlocks.REINFORCED_STONEWORK_BLOCK.get());
    }

    private static void addTools(FabricItemGroupEntries entries) {
        entries.accept(ModItems.GRADER_TOOL.get());
    }



}
