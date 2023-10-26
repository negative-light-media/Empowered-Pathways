package com.negativelight.empoweredpathways;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class EmpoweredPathways {
    
    public EmpoweredPathways() {
    
        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.
    
        // Use Forge to bootstrap the Common mod.
        Constants.LOG.info("Hello Forge world!");
        CommonClass.init();

        MinecraftForge.EVENT_BUS.addListener(this::buildContents);
        //MinecraftForge.EVENT_BUS.addListener(this::onItemTooltip);
    }

    public void buildContents(BuildCreativeModeTabContentsEvent event) {
        Constants.LOG.info("Adding to Creative Mode Tab " + event.getTabKey());
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            //event.accept(ModBlocks.STONEWORK_BLOCK);
        }
    }

}