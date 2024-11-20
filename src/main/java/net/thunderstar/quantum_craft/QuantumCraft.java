package net.thunderstar.quantum_craft;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.thunderstar.quantum_craft.init.ItemInit;
import net.thunderstar.quantum_craft.util.Reference;

@Mod(Reference.MOD_ID)
public class QuantumCraft {
    public QuantumCraft() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.ITEMS.register(eventBus);
    }
}
