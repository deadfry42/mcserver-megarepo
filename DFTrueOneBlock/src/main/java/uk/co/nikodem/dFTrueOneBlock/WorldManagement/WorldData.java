package uk.co.nikodem.dFTrueOneBlock.WorldManagement;

import com.infernalsuite.aswm.api.world.SlimeWorld;
import com.infernalsuite.aswm.api.world.properties.SlimeProperties;
import com.infernalsuite.aswm.api.world.properties.SlimePropertyMap;
import uk.co.nikodem.dFTrueOneBlock.DFTrueOneBlock;
import uk.co.nikodem.dFTrueOneBlock.Data.SkyblockWorld;

public class WorldData {
    private final DFTrueOneBlock plugin;

    public WorldData(DFTrueOneBlock plugin) {
        this.plugin = plugin;
    }

    public SlimeWorld createNewSlimeWorld(SkyblockWorld skyblockWorld) {
        SlimePropertyMap propertyMap = new SlimePropertyMap();
        propertyMap.setValue(SlimeProperties.DIFFICULTY, "normal");

        SlimeWorld slimeWorld = plugin.asp.createEmptyWorld(skyblockWorld.getRealId(), false, propertyMap, plugin.aspl);
        return slimeWorld;
    }
}
