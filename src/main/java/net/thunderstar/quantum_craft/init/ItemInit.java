package net.thunderstar.quantum_craft.init;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thunderstar.quantum_craft.objects.bulk.Elements;
import net.thunderstar.quantum_craft.objects.items.TooltipItem;
import net.thunderstar.quantum_craft.util.ItemReference;
import net.thunderstar.quantum_craft.util.Reference;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MOD_ID);


    public static final RegistryObject<Item> TEST_ITEM = ITEMS.register("test_item",
            () -> new TooltipItem(new Item.Properties().rarity(Rarity.EPIC), "test_item", 2));


    public static final Elements ELEMENTS = new Elements(ITEMS, 2,
            new int[] {1, 0, 0},
            ItemReference.max_neutrons,
            new int[] {0, 2, 10});


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}