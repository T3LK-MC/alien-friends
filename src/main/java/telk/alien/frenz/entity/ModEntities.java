package telk.alien.frenz.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import telk.alien.frenz.AlienFriends;

public class ModEntities {
    public static final EntityType<ZabZabEntity> ZAB_ZAB = Registry.register(
            BuiltInRegistries.ENTITY_TYPE,
            ResourceLocation.fromNamespaceAndPath(AlienFriends.MOD_ID, "zab_zab"),
            FabricEntityTypeBuilder.create(MobCategory.CREATURE, ZabZabEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 0.8f))
                    .build());

    public static void registerEntities() {
        AlienFriends.LOGGER.info("Registering entities for " + AlienFriends.MOD_ID);
    }
}
