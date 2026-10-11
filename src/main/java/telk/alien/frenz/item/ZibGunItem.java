package telk.alien.frenz.item;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class ZibGunItem extends Item {
    private static final double RANGE = 30.0;
    private static final float DAMAGE = 6.0F;
    private static final int COOLDOWN_TICKS = 10;

    public ZibGunItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (player.getCooldowns().isOnCooldown(this)) {
            return InteractionResultHolder.fail(stack);
        }

        Vec3 start = player.getEyePosition();
        Vec3 look = player.getViewVector(1.0F);
        Vec3 end = start.add(look.scale(RANGE));

        EntityHitResult hit = ProjectileUtil.getEntityHitResult(level, player, start, end,
                player.getBoundingBox().expandTowards(look.scale(RANGE)).inflate(1.0D),
                target -> !target.isSpectator() && target.isPickable() && target != player,
                1.0F);

        if (!level.isClientSide) {
            if (hit != null) {
                Entity target = hit.getEntity();
                DamageSource source = level.damageSources().playerAttack(player);
                target.hurt(source, DAMAGE);
            }

            if (level instanceof ServerLevel serverLevel) {
                Vec3 hitPoint = hit != null ? hit.getLocation() : end;
                double distance = start.distanceTo(hitPoint);
                Vec3 direction = hitPoint.subtract(start).normalize();
                int particleCount = (int) (distance * 2);
                for (int i = 0; i < particleCount; i++) {
                    Vec3 point = start.add(direction.scale(i * 0.5));
                    serverLevel.sendParticles(ParticleTypes.END_ROD, point.x, point.y, point.z, 1, 0, 0, 0, 0.0);
                }
            }

            level.playSound(null, player.blockPosition(), SoundEvents.BEACON_ACTIVATE,
                    SoundSource.PLAYERS, 0.5F, 1.8F);
            player.getCooldowns().addCooldown(this, COOLDOWN_TICKS);
            stack.hurtAndBreak(1, player, player.getEquipmentSlotForItem(stack));
        }

        player.swing(hand);
        return InteractionResultHolder.success(stack);
    }
}