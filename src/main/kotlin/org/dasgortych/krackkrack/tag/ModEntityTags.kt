package org.dasgortych.krackkrack.tag

import net.minecraft.entity.EntityType
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier
import org.dasgortych.krackkrack.KrackKrack

object ModEntityTags {

    fun of(id: Identifier): TagKey<EntityType<*>> {
        return TagKey.of(RegistryKeys.ENTITY_TYPE, id)
    }

    fun of(id: String): TagKey<EntityType<*>> {
        return of(Identifier.of(KrackKrack.id, id))
    }




}