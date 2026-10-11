package telk.alien.frenz.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import telk.alien.frenz.AlienFriends;
import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Item.TooltipContext;
import net.minecraft.network.chat.Component;
import telk.alien.frenz.entity.ModEntities;

import java.util.List;

public class ModItems {
    public static final Item ZIB_COIN = registerItem("zib_coin",
            new Item(new Item.Properties()) {
                @Override
                public Component getName(ItemStack stack) {
                    return super.getName(stack).copy().withStyle(ChatFormatting.GOLD);
                }

                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("item.alien-friends.zib_coin.tooltip")
                            .withStyle(ChatFormatting.LIGHT_PURPLE, ChatFormatting.ITALIC));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final Item ZAB_ZAB_SPAWN_EGG = registerItem("zab_zab_spawn_egg",
            new SpawnEggItem(ModEntities.ZAB_ZAB, 0x4E9A51, 0x8ED18F, new Item.Properties()));
    public static final Item ZIB_GUN = registerItem("zib_gun",
            new ZibGunItem(new Item.Properties().durability(250)));
    public static final Item RAW_ZIB_STEEL_ORE = registerItem("raw_zib_steel_ore", new Item(new Item.Properties()));
    public static final Item ZIB_STEEL_INGOT = registerItem("zib_steel_ingot", new Item(new Item.Properties()));
    // Tools (tier class from ModToolsMaterials)
    public static final Item ZIB_STEEL_SWORD = registerItem("zib_steel_sword",
            new SwordItem(ModToolsMaterials.ZIB_STEEL, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolsMaterials.ZIB_STEEL, 3, -2.4F))));

    public static final Item ZIB_STEEL_PICKAXE = registerItem("zib_steel_pickaxe",
            new PickaxeItem(ModToolsMaterials.ZIB_STEEL, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolsMaterials.ZIB_STEEL, 1.0F, -2.8F))));

    public static final Item ZIB_STEEL_AXE = registerItem("zib_steel_axe",
            new AxeItem(ModToolsMaterials.ZIB_STEEL, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolsMaterials.ZIB_STEEL, 5.0F, -3.0F))));

    public static final Item ZIB_STEEL_SHOVEL = registerItem("zib_steel_shovel",
            new ShovelItem(ModToolsMaterials.ZIB_STEEL, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolsMaterials.ZIB_STEEL, 1.5F, -3.0F))));

    public static final Item ZIB_STEEL_HOE = registerItem("zib_steel_hoe",
            new HoeItem(ModToolsMaterials.ZIB_STEEL, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolsMaterials.ZIB_STEEL, -3.0F, 0.0F))));

    // Armor (durability multiplier 30, between iron's 15 and diamond's 33)
    public static final Item ZIB_STEEL_HELMET = registerItem("zib_steel_helmet",
            new ArmorItem(ModArmorMaterials.ZIB_STEEL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(30))));

    public static final Item ZIB_STEEL_CHESTPLATE = registerItem("zib_steel_chestplate",
            new ArmorItem(ModArmorMaterials.ZIB_STEEL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(30))));

    public static final Item ZIB_STEEL_LEGGINGS = registerItem("zib_steel_leggings",
            new ArmorItem(ModArmorMaterials.ZIB_STEEL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(30))));

    public static final Item ZIB_STEEL_BOOTS = registerItem("zib_steel_boots",
            new ArmorItem(ModArmorMaterials.ZIB_STEEL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(30))));

    private static Item registerItem(String name, Item item) {
            return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(AlienFriends.MOD_ID, name), item);
        }


    public static void registerModItems() {
        AlienFriends.LOGGER.info("Registering Mod Items for " + AlienFriends.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(entries -> {
            entries.accept(ZIB_COIN);
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(entries -> {
            entries.accept(ZIB_GUN);
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.SPAWN_EGGS).register(entries -> {
            entries.accept(ZAB_ZAB_SPAWN_EGG);
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register(entries -> {
            entries.accept(RAW_ZIB_STEEL_ORE);
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(entries -> {
            entries.accept(ZIB_STEEL_INGOT);
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> {
            entries.accept(ZIB_STEEL_PICKAXE);
            entries.accept(ZIB_STEEL_AXE);
            entries.accept(ZIB_STEEL_SHOVEL);
            entries.accept(ZIB_STEEL_HOE);
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(entries -> {
            entries.accept(ZIB_STEEL_SWORD);
            entries.accept(ZIB_STEEL_AXE);
            entries.accept(ZIB_STEEL_HELMET);
            entries.accept(ZIB_STEEL_CHESTPLATE);
            entries.accept(ZIB_STEEL_LEGGINGS);
            entries.accept(ZIB_STEEL_BOOTS);
            entries.accept(ZIB_GUN);
        });
    }
}