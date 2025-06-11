package org.dasgortych.krackkrack

import net.fabricmc.api.ModInitializer
import net.fabricmc.loader.api.FabricLoader
import net.fabricmc.loader.impl.FabricLoaderImpl
import org.dasgortych.krackkrack.block.ModBlocks
import org.dasgortych.krackkrack.entity.ModEntities
import org.dasgortych.krackkrack.item.ModItems
import org.slf4j.LoggerFactory

class KrackKrack : ModInitializer {

    companion object {
        val logger = LoggerFactory.getLogger("KrackKrack")
        val id = "krackkrack"
    }

    override fun onInitialize() {
        ModBlocks.init()
        ModEntities.init()
        ModItems.init()
    }

}
