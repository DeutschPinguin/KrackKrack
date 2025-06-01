package org.dasgortych.krackkrack

import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object ModBlocks {

    fun load() {

    }

    private fun reg(id: String, o: Block): Block {
        return Registry.register(Registries.BLOCK, Identifier.of(KrackKrackMod.id, id), o)
    }

}