package net.thunderstar.quantum_craft.init;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thunderstar.quantum_craft.objects.bulk.Elements;
import net.thunderstar.quantum_craft.objects.bulk.IngotMaterial;
import net.thunderstar.quantum_craft.objects.items.TooltipItem;
import net.thunderstar.quantum_craft.util.ItemReference;
import net.thunderstar.quantum_craft.util.Reference;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MOD_ID);


    public static final RegistryObject<Item> TEST_ITEM = ITEMS.register("test_item",
            () -> new TooltipItem(new Item.Properties().rarity(Rarity.EPIC), "test_item", 2));


    public static final RegistryObject<Item> CORE_URANIUM_235 = ITEMS.register("core_uranium-235",
            () -> new TooltipItem(new Item.Properties(), "core_uranium-235", 0));


    public static final RegistryObject<Item> CID = ITEMS.register("cid",
            () -> new TooltipItem(new Item.Properties(), "cid", 1)); // this item will explode when crafted


    public static final IngotMaterial URANIUM = new IngotMaterial(ITEMS, "uranium");
    public static final IngotMaterial DEPLETED_URANIUM = new IngotMaterial(ITEMS, "depleted_uranium");


    public static final Elements ELEMENTS = new Elements(ITEMS, 118,
            ItemReference.min_neutrons,
            ItemReference.max_neutrons,
            ItemReference.ex_neutrons,
            ItemReference.ion_nums);


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
