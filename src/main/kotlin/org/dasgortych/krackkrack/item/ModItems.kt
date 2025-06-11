package org.dasgortych.krackkrack.item

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.component.type.FoodComponents
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.item.Items
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import org.dasgortych.krackkrack.KrackKrack
import org.dasgortych.krackkrack.item.custom.FoodOnStickItem

object ModItems {

    fun init() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register() {group ->
            group.addAfter(Items.RABBIT_STEW, MASHED_POTATOES)
        }
    }

    fun reg(key: RegistryKey<Item>, factory: (Item.Settings) -> Item, settings: Item.Settings): Item {
        return Items.register(key, factory, settings)
    }

    fun reg(key: RegistryKey<Item>, settings: Item.Settings): Item {
        return reg(key, ::Item, settings)
    }

        fun keyOf(id: Identifier): RegistryKey<Item> {
        return RegistryKey.of(RegistryKeys.ITEM, id)
    }

    fun keyOf(id: String): RegistryKey<Item> {
        return keyOf(Identifier.of(KrackKrack.id, id))
    }

    val APPLE_ON_STICK = reg(keyOf("apple_on_stick"), ::FoodOnStickItem, Item.Settings().food(FoodComponents.APPLE))

    val MASHED_POTATOES = reg(keyOf("mashed_potatoes"), Item.Settings().food(ModFood.MASHED_POTATOES))

    val STICK_WITH_SWEET_CORNER = reg(keyOf("stick_with_sweet_tip"), ::FoodOnStickItem, Item.Settings().food(ModFood.STICK_WITH_SWEET_CORNER))

}