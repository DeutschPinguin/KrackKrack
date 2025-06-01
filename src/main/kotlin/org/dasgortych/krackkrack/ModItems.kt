package org.dasgortych.krackkrack

import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object ModItems {

    fun load() {

    }

    private fun reg(id: String, o: Item): Item {
        return reg(Identifier.of(KrackKrackMod.id, id), o)
    }

    private fun reg(id: Identifier, o: Item): Item {
        return Registry.register(Registries.ITEM, id, o)
    }

}