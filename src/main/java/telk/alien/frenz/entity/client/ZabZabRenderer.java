package telk.alien.frenz.entity.client;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import telk.alien.frenz.entity.ZabZabEntity;

public class ZabZabRenderer extends GeoEntityRenderer<ZabZabEntity> {
    public ZabZabRenderer(EntityRendererProvider.Context context) {
        super(context, new ZabZabModel());
        this.shadowRadius = 0.4f;
    }
}