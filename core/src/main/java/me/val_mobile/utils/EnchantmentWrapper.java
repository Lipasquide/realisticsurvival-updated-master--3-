package me.val_mobile.utils;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import javax.annotation.Nonnull;
public class EnchantmentWrapper extends Enchantment {
    protected final String name;
    protected final int maxLvl;
    protected final NamespacedKey key;
    public EnchantmentWrapper(String namespace, String name, int lvl) {
        this.name = name; this.maxLvl = lvl;
        this.key = NamespacedKey.minecraft(namespace);
    }
    @Override @Nonnull public String getName() { return name; }
    @Override public int getMaxLevel() { return maxLvl; }
    @Override public int getStartLevel() { return 1; }
    @Override @Nonnull public EnchantmentTarget getItemTarget() { return EnchantmentTarget.ALL; }
    @Override public boolean isTreasure() { return false; }
    @Override public boolean isCursed() { return false; }
    @Override public boolean conflictsWith(@Nonnull Enchantment other) { return false; }
    @Override public boolean canEnchantItem(@Nonnull ItemStack item) { return true; }
    @Override @NotNull public NamespacedKey getKey() { return key; }
    @Override @NotNull public String getTranslationKey() { return "enchantment.minecraft." + key.getKey(); }
    public boolean isTradeable() { return true; }
    public boolean isDiscoverable() { return true; }
    public boolean isRegistered() { return true; }
}
