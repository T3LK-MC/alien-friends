package telk.alien.frenz.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import telk.alien.frenz.block.ModBlocks;
import telk.alien.frenz.item.ModItems;
import telk.alien.frenz.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.ZIB_STEEL_ORES)
                .add(ModBlocks.ZIB_STEEL_ORE.asItem())
                .add(ModBlocks.DEEPSLATE_ZIB_STEEL_ORE.asItem());
    }
}
