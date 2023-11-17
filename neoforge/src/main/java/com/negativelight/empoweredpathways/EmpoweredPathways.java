package com.negativelight.empoweredpathways;

import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class EmpoweredPathways {
    
    public EmpoweredPathways() {
    
        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.

        // Use Forge to bootstrap the Common mod.
        Constants.LOG.info("Hello NeoForge world!");
        CommonClass.init();


        //MinecraftForge.EVENT_BUS.addListener(this::onItemTooltip);
    }

}