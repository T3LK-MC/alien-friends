package telk.alien.frenz.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import telk.alien.frenz.AlienFriends;

public class ModBlocks {
    public static final Block ZIB_STEEL_ORE = registerBlock("zib_steel_ore",
            new Block(BlockBehaviour.Properties.of().strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.METAL)
                    .lightLevel(blockState -> 8)));
    public static final Block ZIB_STEEL_BLOCK = registerBlock("zib_steel_block",
            new Block(BlockBehaviour.Properties.of().strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.METAL)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return  Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(AlienFriends.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(AlienFriends.MOD_ID, name),
                new BlockItem(block, new Item.Properties()));
    }

    public static void registerModBlocks() {
        AlienFriends.LOGGER.info("Registering Mod Blocks for " + AlienFriends.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register(entries -> {
            entries.accept(ZIB_STEEL_ORE);
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(entries -> {
            entries.accept(ZIB_STEEL_BLOCK);
        });
    }
}
