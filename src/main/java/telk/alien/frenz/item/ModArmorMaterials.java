package telk.alien.frenz.item;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import telk.alien.frenz.AlienFriends;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class ModArmorMaterials {
    public static final Holder<ArmorMaterial> ZIB_STEEL = register("zib_steel",
            Map.of(ArmorItem.Type.HELMET, 3,
                    ArmorItem.Type.CHESTPLATE, 8,
                    ArmorItem.Type.LEGGINGS, 6,
                    ArmorItem.Type.BOOTS, 3),
            20,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.of(ModItems.ZIB_STEEL_INGOT),
            2.0F,
            0.0F);

    private static Holder<ArmorMaterial> register(String id, Map<ArmorItem.Type, Integer> defense,
                                                  int enchantability, Holder<SoundEvent> equipSound,
                                                  Supplier<Ingredient> repairIngredient,
                                                  float toughness, float knockbackResistance) {
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(AlienFriends.MOD_ID, id);
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(location, "", false));
        ArmorMaterial material = new ArmorMaterial(defense, enchantability, equipSound,
                repairIngredient, layers, toughness, knockbackResistance);
        material = Registry.register(BuiltInRegistries.ARMOR_MATERIAL, location, material);
        return Holder.direct(material);
    }
}