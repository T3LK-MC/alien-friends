package telk.alien.frenz.util;

import net.minecraft.tags.TagKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import telk.alien.frenz.AlienFriends;

public class ModTags {
    public static class Blocks {
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
