package me.lojosho.hibiscuscommons.util;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkEffectMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.jetbrains.annotations.NotNull;

public class ColorBuilder {

    public static boolean canBeColored(final Material material) {
        return canBeColored(new ItemStack(material));
    }

    public static boolean canBeColored(final @NotNull ItemStack itemStack) {
        final ItemMeta itemMeta = itemStack.getItemMeta();

        return (itemMeta instanceof LeatherArmorMeta
                || itemMeta instanceof PotionMeta
                || itemMeta instanceof FireworkEffectMeta
        );
    }

    /**
     * @param color armor color
     * @return this
     */

    public static ItemMeta color(ItemMeta itemMeta, final Color color) {
        if (itemMeta instanceof final PotionMeta meta) {
            meta.setColor(color);
        }
        if (itemMeta instanceof final LeatherArmorMeta meta) {
            meta.setColor(color);
        }
        if (itemMeta instanceof final FireworkEffectMeta meta) {
            meta.setEffect(FireworkEffect.builder().withColor(color).build());
        }
        return itemMeta;
    }

}
