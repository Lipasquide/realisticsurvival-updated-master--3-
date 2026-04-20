package me.val_mobile.utils;
import me.val_mobile.rsv.RSVPlugin;
import org.bukkit.enchantments.Enchantment;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Map;
public class RSVEnchants {
    private static final HashSet<Enchantment> enchants = new HashSet<>();
    public static final Enchantment WARMING = new EnchantmentWrapper("warming", "Warming", 1);
    public static final Enchantment COOLING = new EnchantmentWrapper("cooling", "Cooling", 1);
    public static final Enchantment OZZY_LINER = new EnchantmentWrapper("ozzy_liner", "Ozzy Liner", 1);
    private final RSVPlugin plugin;
    public RSVEnchants(RSVPlugin plugin) { this.plugin = plugin; populateEnchants(); }
    public void registerAllEnchants() { for (Enchantment enchant : enchants) register(enchant); }
    public void register(Enchantment ench) {
        try { if (Enchantment.getByKey(ench.getKey()) == null) registerEnchantment(ench); } catch (Exception e) {}
    }
    public void registerEnchantment(Enchantment ench) {
        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true); f.set(null, true);
            Method register = Enchantment.class.getDeclaredMethod("registerEnchantment", Enchantment.class);
            register.setAccessible(true); register.invoke(null, ench);
        } catch (Exception e) {}
    }
    public void populateEnchants() { enchants.add(WARMING); enchants.add(COOLING); enchants.add(OZZY_LINER); }
    public static HashSet<Enchantment> getEnchants() { return enchants; }
}
