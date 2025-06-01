package org.dasgortych.krackkrack

import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

class KrackKrackMod : ModInitializer {

    companion object {
        const val id = "krackkrack"
        val logger = LoggerFactory.getLogger("KrackKrack")
    }

    override fun onInitialize() {
        ModItems.load()
        ModBlocks.load()
    }

}
