package telk.alien.frenz.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import telk.alien.frenz.AlienFriends;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import telk.alien.frenz.block.ModBlocks;

public class ModItemsGroups {
    public static final CreativeModeTab ALIEN_ITEMS_GROUP = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            ResourceLocation.fromNamespaceAndPath(AlienFriends.MOD_ID, "alien_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.ZIB_STEEL_INGOT))
                    .title(Component.translatable("itemgroup.alien-friends.alien_items"))
                    .displayItems((displayContext, entries) -> {
                        entries.accept(ModItems.ZIB_COIN);
                        entries.accept(ModItems.ZIB_STEEL_INGOT);
                        entries.accept(ModItems.RAW_ZIB_STEEL_ORE);
                        entries.accept(ModItems.ZAB_ZAB_SPAWN_EGG);
                        entries.accept(ModItems.ZIB_STEEL_AXE);
                        entries.accept(ModItems.ZIB_STEEL_PICKAXE);
                        entries.accept(ModItems.ZIB_STEEL_BOOTS);
                        entries.accept(ModItems.ZIB_STEEL_CHESTPLATE);
                        entries.accept(ModItems.ZIB_STEEL_HELMET);
                        entries.accept(ModItems.ZIB_STEEL_LEGGINGS);
                        entries.accept(ModItems.ZIB_STEEL_SHOVEL);
                        entries.accept(ModItems.ZIB_STEEL_HOE);
                        entries.accept(ModItems.ZIB_STEEL_SWORD);
                        entries.accept(ModBlocks.ZIB_STEEL_BLOCK);
                        entries.accept(ModBlocks.ZIB_STEEL_ORE);
                        entries.accept(ModBlocks.DEEPSLATE_ZIB_STEEL_ORE);
                        entries.accept(ModItems.ZIB_GUN);
                    }).build());

    public static void registerItemGroups() {
        AlienFriends.LOGGER.info("Registering Item Groups for " + AlienFriends.MOD_ID);
    }
}
