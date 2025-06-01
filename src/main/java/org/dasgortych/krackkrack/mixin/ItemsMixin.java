package org.dasgortych.krackkrack.mixin;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import org.dasgortych.krackkrack.Replacer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Function;

@Mixin(Items.class)
public class ItemsMixin {

    @Inject(
        method = "register(Lnet/minecraft/registry/RegistryKey;Ljava/util/function/Function;Lnet/minecraft/item/Item$Settings;)Lnet/minecraft/item/Item;",
        at = @At("HEAD"),
        cancellable = true
    )
    private static void register(RegistryKey key, Function factory, Item.Settings settings, CallbackInfoReturnable<Item> cir) {
        Identifier id = key.getValue();
        Item item = Replacer.getReplacedOrNull(id, key, settings);
        if (item == null) return; // item wasn't replaced

        Replacer.logger.info("Replaced [{}]", id.toString());

        if (item instanceof BlockItem blockItem) {
            blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
        }

        Item registered = Registry.register(Registries.ITEM, key, item);
        cir.setReturnValue(registered);
    }

}
