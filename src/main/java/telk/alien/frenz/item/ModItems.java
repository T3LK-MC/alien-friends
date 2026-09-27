package telk.alien.frenz.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import telk.alien.frenz.AlienFriends;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Item.TooltipContext;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.TooltipFlag;
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
    public static final Item ZAB_ZAB_SPAWN_EGG = registerItem("zab_zab_spawn_egg", new Item(new Item.Properties()));
    public static final Item RAW_ZIB_STEEL_ORE = registerItem("raw_zib_steel_ore", new Item(new Item.Properties()));
    public static final Item ZIB_STEEL_INGOT = registerItem("zib_steel_ingot", new Item(new Item.Properties()));

    private static Item registerItem(String name, Item item) {
            return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(AlienFriends.MOD_ID, name), item);
        }

    public static void registerModItems() {
        AlienFriends.LOGGER.info("Registering Mod Items for " + AlienFriends.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(entries -> {
            entries.accept(ZIB_COIN);
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
    }
}