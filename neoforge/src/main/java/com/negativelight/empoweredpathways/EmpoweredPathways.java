package com.negativelight.empoweredpathways;


import com.negativelight.empoweredpathways.block.ModBlocks;
import com.negativelight.empoweredpathways.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(Constants.MOD_ID)
public class EmpoweredPathways {

    /**
     * NeoForge Mod Contributor
     * @param eventBus - The NeoForge Event bug object
     */
    public EmpoweredPathways(IEventBus eventBus) {

        // This method is invoked by the NeoForge mod loader when it is ready
        // to load your mod. You can access NeoForge and Common code in this
        // project.


        // Use NeoForge to bootstrap the Common mod.
        Constants.LOG.info("Hello NeoForge world!");
        CommonClass.init();

        NeoForge.EVENT_BUS.register(this);
        eventBus.addListener(this::addCreative);

    }

    /**
     * Add Items to the Minecraft Creative Mod Tabs
     * @param event - triggering Event
     */
    @SubscribeEvent
    public void addCreative(BuildCreativeModeTabContentsEvent event) {
        Constants.LOG.info("Adding to Creative Mode Tab " + event.getTabKey());
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.STONEWORK_BLOCK.get());
            event.accept(ModBlocks.INFUSED_STONEWORK_BLOCK.get());
            event.accept(ModBlocks.REINFORCED_STONEWORK_BLOCK.get());
        }

        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.GRADER_TOOL.get());
        }
    }

}