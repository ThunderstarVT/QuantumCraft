package net.thunderstar.quantum_craft.objects.bulk;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.thunderstar.quantum_craft.objects.items.TooltipItem;

public class IngotMaterial {
    public RegistryObject<Item> INGOT;
    public RegistryObject<Item> RAW;

    public IngotMaterial(DeferredRegister<Item> itemRegister, String name) {
        INGOT = itemRegister.register(name + "_ingot",
                () -> new TooltipItem(new Item.Properties(), name + "_ingot", 0));

        RAW = itemRegister.register("raw_" + name,
                () -> new TooltipItem(new Item.Properties(), "raw_" + name, 0));
    }
}
