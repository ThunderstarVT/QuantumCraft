package net.thunderstar.quantum_craft.objects.bulk;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.thunderstar.quantum_craft.objects.items.TooltipItem;
import net.thunderstar.quantum_craft.util.Reference;

import java.util.ArrayList;
import java.util.List;

public class Elements {
    private static final String[] element_names = {
            "neutronium",
            "hydrogen",
            "helium",
            "lithium",
            "beryllium",
            "boron",
            "carbon",
            "nitrogen",
            "oxygen",
            "fluorine",
            "neon",
            "sodium",
            "magnesium",
            "aluminium",
            "silicon",
            "phosphorus",
            "sulfur",
            "chlorine",
            "argon",
            "potassium",
            "calcium",
            "scandium",
            "titanium",
            "vanadium",
            "chromium",
            "manganese",
            "iron",
            "cobalt",
            "nickel",
            "copper",
            "zinc",
            "gallium",
            "germanium",
            "arsenic",
            "selenium",
            "bromine",
            "krypton",
            "rubidium",
            "strontium",
            "yttrium",
            "zirconium",
            "niobium",
            "molybdenum",
            "technetium",
            "ruthenium",
            "rhodium",
            "palladium",
            "silver",
            "cadmium",
            "indium",
            "tin",
            "antimony",
            "tellurium",
            "iodine",
            "xenon",
            "caesium",
            "barium",
            "lanthanum",
            "cerium",
            "praseodymium",
            "neodymium",
            "promethium",
            "samarium",
            "europium",
            "gadolinium",
            "terbium",
            "dysprosium",
            "holmium",
            "erbium",
            "thulium",
            "ytterbium",
            "lutetium",
            "hafnium",
            "tantalum",
            "tungsten",
            "rhenium",
            "osmium",
            "iridium",
            "platinum",
            "gold",
            "mercury",
            "thallium",
            "lead",
            "bismuth",
            "polonium",
            "astatine",
            "radon",
            "francium",
            "radium",
            "actinium",
            "thorium",
            "protactinium",
            "uranium",
            "neptunium",
            "plutonium",
            "americium",
            "curium",
            "berkelium",
            "californium",
            "einsteinium",
            "fermium",
            "mendelevium",
            "nobelium",
            "lawrencium",
            "rutherfordium",
            "dubnium",
            "seaborgium",
            "bohrium",
            "hassium",
            "meitnerium",
            "darmstadtium",
            "roentgenium",
            "copernicium",
            "nihonium",
            "flerovium",
            "moscovium",
            "livermorium",
            "tennessine",
            "oganesson"
    };

    private List<List<List<RegistryObject<Item>>>> registered_items = new ArrayList<>();
    private int[] min_neutrons;

    public Elements(DeferredRegister<Item> itemRegister, int elements, int[] min_neutrons, int[] max_neutrons, int[][] ex_neutrons, int[] max_electrons) {
        this.min_neutrons = min_neutrons;

        for (int P = 0; P <= elements; P++) {
            List<List<RegistryObject<Item>>> n_list = new ArrayList<>();
            for (int N = min_neutrons[P]; N <= max_neutrons[P]; N++) {
                List<RegistryObject<Item>> e_list = new ArrayList<>();
                if (!Reference.inArrayInt(N, ex_neutrons[P])) {
                    for (int E = 0; E <= max_electrons[P]; E++) {
                        String name = element_names[P] + "-" + (P + N);
                        if (P != E) {
                            name = name + "_" + (P - E);
                        }

                        String finalName = name; // some weird java stuff
                        e_list.add(itemRegister.register(name,
                                () -> new TooltipItem(new Item.Properties(), finalName, 4)));
                    }
                }
                n_list.add(e_list);
            }
            registered_items.add(n_list);
        }
    }

    public RegistryObject<Item> get(int P, int N, int E) {
        return registered_items.get(P).get(N - min_neutrons[P]).get(E);
    }
}
