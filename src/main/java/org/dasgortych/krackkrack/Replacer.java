package org.dasgortych.krackkrack;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Replacer {

    public static final Logger logger = LoggerFactory.getLogger("KrackKrack/Replacer");
    private static final Map<Identifier, BiFunction<RegistryKey<Item>, Item.Settings, Item>> map = new HashMap<>();

    @Nullable
    public static Item getReplacedOrNull(Identifier id, RegistryKey<Item> key, Item.Settings settings) {
        if (map.containsKey(id)) {
            return map.get(id).apply(key, settings);
        }

        return null;
    }

    private static void replace(Identifier id, BiFunction<RegistryKey<Item>, Item.Settings, Item> factory) {
        map.put(id, factory);
    }

    private static void replace(String id, BiFunction<RegistryKey<Item>, Item.Settings, Item> factory) {
        replace(Identifier.of(id), factory);
    }

    static {
        replace("beetroot_soup", (key, settings) -> new Item(new Item.Settings().registryKey(key).rarity(Rarity.EPIC)));
    }

}
