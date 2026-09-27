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
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.util.valueproviders.UniformInt;

public class ModBlocks {
    public static final Block ZIB_STEEL_ORE = registerBlock("zib_steel_ore",
            new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.of().strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final Block DEEPSLATE_ZIB_STEEL_ORE = registerBlock("deepslate_zib_steel_ore",
            new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.of().strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
                    // .lightLevel(blockState -> 8))); (Light level on whole block)
    public static final Block ZIB_STEEL_BLOCK = registerBlock("zib_steel_block",
            new Block(BlockBehaviour.Properties.of().strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.COPPER)));

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
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register(entries -> {
            entries.accept(DEEPSLATE_ZIB_STEEL_ORE);
        });
    }
}
