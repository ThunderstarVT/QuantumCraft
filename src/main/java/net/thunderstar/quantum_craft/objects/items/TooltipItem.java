package net.thunderstar.quantum_craft.objects.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.thunderstar.quantum_craft.util.Reference;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TooltipItem extends Item {
    String name;
    int tooltip_count;

    public TooltipItem(Properties properties, String name, int tooltip_count) {
        super(properties);
        this.name = name;
        this.tooltip_count = tooltip_count;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag flag) {

        for (int i = 0; i < tooltip_count; i++) {
            tooltipComponents.add(Component.translatable("tooltip." + Reference.MOD_ID + "." + name + ".line_" + i));
        }

        super.appendHoverText(stack, level, tooltipComponents, flag);
    }
}
