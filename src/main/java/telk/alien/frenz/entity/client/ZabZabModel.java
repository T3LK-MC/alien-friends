package telk.alien.frenz.entity.client;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import telk.alien.frenz.AlienFriends;
import telk.alien.frenz.entity.ZabZabEntity;

public class ZabZabModel extends GeoModel<ZabZabEntity> {
    @Override
    public ResourceLocation getModelResource(ZabZabEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(AlienFriends.MOD_ID, "geo/entity/zab_zab.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ZabZabEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(AlienFriends.MOD_ID, "textures/entity/zab_zab.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ZabZabEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(AlienFriends.MOD_ID, "animations/entity/zab_zab.animation.json");
    }
}