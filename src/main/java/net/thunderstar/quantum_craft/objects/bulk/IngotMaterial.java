package net.thunderstar.quantum_craft.objects.bulk;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.thunderstar.quantum_craft.objects.items.TooltipItem;

public class IngotMaterial {
    public RegistryObject<Item> NUGGET;
    public RegistryObject<Item> INGOT;
    public RegistryObject<Block> BLOCK;

    public IngotMaterial(DeferredRegister<Item> itemRegister, String name) {
        NUGGET = itemRegister.register(name + "_nugget",
                () -> new TooltipItem(new Item.Properties(), name + "_nugget", 0));

        INGOT = itemRegister.register(name + "_ingot",
                () -> new TooltipItem(new Item.Properties(), name + "_ingot", 1));
    }
}
