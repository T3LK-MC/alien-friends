package telk.alien.frenz.entity.client;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import telk.alien.frenz.AlienFriends;
import telk.alien.frenz.entity.ZabZabEntity;

public class ZabZabRenderer extends MobRenderer<ZabZabEntity, HumanoidModel<ZabZabEntity>> {
    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(AlienFriends.MOD_ID, "textures/entity/zab_zab.png");

    public ZabZabRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(ZabZabEntity entity) {
        return TEXTURE;
    }
}