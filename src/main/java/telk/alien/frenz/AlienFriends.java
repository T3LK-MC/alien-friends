package telk.alien.frenz;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import telk.alien.frenz.block.ModBlocks;
import telk.alien.frenz.entity.ModEntities;
import telk.alien.frenz.entity.ZabZabEntity;
import telk.alien.frenz.entity.client.ZabZabRenderer;
import telk.alien.frenz.item.ModItems;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import telk.alien.frenz.item.ModItemsGroups;
import telk.alien.frenz.event.AlienInvasionEvent;

public class AlienFriends implements ModInitializer {
	public static final String MOD_ID = "alien-friends";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemsGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		AlienInvasionEvent.register();
		ModEntities.registerEntities();
		FabricDefaultAttributeRegistry.register(ModEntities.ZAB_ZAB, ZabZabEntity.createAttributes().build());
		EntityRendererRegistry.register(ModEntities.ZAB_ZAB, ZabZabRenderer::new);
	}
}
