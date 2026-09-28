package telk.alien.frenz;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import telk.alien.frenz.datagen.ModBlockTagProvider;
import telk.alien.frenz.datagen.ModLootTableProvider;
import telk.alien.frenz.datagen.ModModelProvider;
import telk.alien.frenz.datagen.ModRecipeProvider;

public class AlienFriendsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		//pack.addProvider(ModBlockTagProvider::new);
		//pack.addProvider(ModLootTableProvider::new);
		//pack.addProvider(ModModelProvider::new);
		//pack.addProvider(ModRecipeProvider::new);
		//pack.addProvider(ModBlockTagProvider::new);
	}
}
