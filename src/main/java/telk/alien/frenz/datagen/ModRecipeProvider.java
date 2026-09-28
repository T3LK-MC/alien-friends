package telk.alien.frenz.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import telk.alien.frenz.block.ModBlocks;
import telk.alien.frenz.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ZIB_STEEL_SWORD)
                .pattern("#")
                .pattern("#")
                .pattern("S")
                .define('#', ModItems.ZIB_STEEL_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has_zib_steel_ingot", has(ModItems.ZIB_STEEL_INGOT))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ZIB_STEEL_PICKAXE)
                .pattern("###")
                .pattern(" S ")
                .pattern(" S ")
                .define('#', ModItems.ZIB_STEEL_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has_zib_steel_ingot", has(ModItems.ZIB_STEEL_INGOT))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ZIB_STEEL_AXE)
                .pattern("##")
                .pattern("#S")
                .pattern(" S")
                .define('#', ModItems.ZIB_STEEL_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has_zib_steel_ingot", has(ModItems.ZIB_STEEL_INGOT))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ZIB_STEEL_SHOVEL)
                .pattern("#")
                .pattern("S")
                .pattern("S")
                .define('#', ModItems.ZIB_STEEL_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has_zib_steel_ingot", has(ModItems.ZIB_STEEL_INGOT))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ZIB_STEEL_HOE)
                .pattern("##")
                .pattern(" S")
                .pattern(" S")
                .define('#', ModItems.ZIB_STEEL_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has_zib_steel_ingot", has(ModItems.ZIB_STEEL_INGOT))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ZIB_STEEL_HELMET)
                .pattern("###")
                .pattern("# #")
                .define('#', ModItems.ZIB_STEEL_INGOT)
                .unlockedBy("has_zib_steel_ingot", has(ModItems.ZIB_STEEL_INGOT))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ZIB_STEEL_CHESTPLATE)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.ZIB_STEEL_INGOT)
                .unlockedBy("has_zib_steel_ingot", has(ModItems.ZIB_STEEL_INGOT))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ZIB_STEEL_LEGGINGS)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .define('#', ModItems.ZIB_STEEL_INGOT)
                .unlockedBy("has_zib_steel_ingot", has(ModItems.ZIB_STEEL_INGOT))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ZIB_STEEL_BOOTS)
                .pattern("# #")
                .pattern("# #")
                .define('#', ModItems.ZIB_STEEL_INGOT)
                .unlockedBy("has_zib_steel_ingot", has(ModItems.ZIB_STEEL_INGOT))
                .save(exporter);
    }
}
