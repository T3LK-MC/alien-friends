package telk.alien.frenz.util;

import net.minecraft.tags.TagKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import telk.alien.frenz.AlienFriends;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_ZIB_STEEL_TOOL = createTag("needs_zib_steel_tool");
        public static final TagKey<Block> INCORRECT_FOR_ZIB_STEEL_TOOL = createTag("incorrect_for_zib_steel_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(AlienFriends.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> ZIB_STEEL_ORES = createTag("zib_steel_ores");

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(AlienFriends.MOD_ID, name));
        }
    }
}
