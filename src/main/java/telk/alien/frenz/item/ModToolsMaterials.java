package telk.alien.frenz.item;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import telk.alien.frenz.util.ModTags;

public class ModToolsMaterials implements Tier {
    public static final Tier ZIB_STEEL = new ModToolsMaterials();

    @Override public int getUses() { return 1267; }
    @Override public float getSpeed() { return 12.0F; }
    @Override public float getAttackDamageBonus() { return 3.0F; }
    @Override public TagKey<Block> getIncorrectBlocksForDrops() { return ModTags.Blocks.INCORRECT_FOR_ZIB_STEEL_TOOL; }
    @Override public int getEnchantmentValue() { return 20; }
    @Override public Ingredient getRepairIngredient() { return Ingredient.of(ModItems.ZIB_STEEL_INGOT); }
}