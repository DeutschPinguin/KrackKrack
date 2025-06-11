package org.dasgortych.krackkrack.tag

import net.minecraft.item.Item
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier
import org.dasgortych.krackkrack.KrackKrack

object ModItemTags {

    fun of(id: Identifier): TagKey<Item> {
        return TagKey.of(RegistryKeys.ITEM, id)
    }

    fun of(id: String): TagKey<Item> {
        return of(Identifier.of(KrackKrack.id, id))
    }




}