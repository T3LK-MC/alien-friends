package telk.alien.frenz.entity;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;
import telk.alien.frenz.item.ModItems;

public class ZabZabEntity extends TamableAnimal implements GeoEntity {
    private static final SimpleWeightedRandomList<Item> SHINIES = SimpleWeightedRandomList.<Item>builder()
            .add(Items.EMERALD, 20)
            .add(Items.AMETHYST_SHARD, 20)
            .add(Items.RAW_GOLD, 15)
            .add(ModItems.ZIB_STEEL_INGOT, 15)
            .add(Items.LAPIS_LAZULI, 15)
            .add(Items.QUARTZ, 10)
            .add(Items.PRISMARINE_CRYSTALS, 10)
            .add(Items.DIAMOND, 3)
            .add(Items.NAUTILUS_SHELL, 2)
            .build();

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public ZabZabEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 12.0)
                .add(Attributes.MOVEMENT_SPEED, 0.20)
                .add(Attributes.FOLLOW_RANGE, 16.0);
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(ModItems.ZIB_COIN);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new TemptGoal(this, 1.25, Ingredient.of(ModItems.ZIB_COIN), false));
        this.goalSelector.addGoal(2, new FollowOwnerGoal(this, 1.0, 1.0f, 10.0f));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!this.isTame() && stack.is(ModItems.ZIB_COIN)) {
            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
            }
            if (!this.level().isClientSide) {
                if (this.random.nextInt(3) == 0) {
                    this.tame(player);
                    this.navigation.stop();
                    this.level().broadcastEntityEvent(this, (byte) 7); // heart particles
                } else {
                    this.level().broadcastEntityEvent(this, (byte) 6); // smoke particles
                }
            }
            return InteractionResult.SUCCESS;
        }

        if (this.isTame() && this.isOwnedBy(player) && stack.is(ModItems.ZIB_COIN)) {
            if (!this.level().isClientSide) {
                if (!player.getAbilities().instabuild) {
                    stack.shrink(1);
                }
                SHINIES.getRandomValue(this.random).ifPresent(item -> {
                    ItemStack shiny = new ItemStack(item);
                    if (!player.getInventory().add(shiny)) {
                        player.drop(shiny, false);
                    }
                    this.level().playSound(null, this.blockPosition(), SoundEvents.AMETHYST_BLOCK_CHIME,
                            SoundSource.NEUTRAL, 1.0F, 1.0F);
                    ((ServerLevel) this.level()).sendParticles(ParticleTypes.HAPPY_VILLAGER,
                            this.getX(), this.getEyeY(), this.getZ(), 6, 0.3, 0.3, 0.3, 0.0);
                });
            }
            return InteractionResult.SUCCESS;
        }

        if (this.isTame() && this.isOwnedBy(player) && hand == InteractionHand.MAIN_HAND) {
            this.setOrderedToSit(!this.isOrderedToSit());
            return InteractionResult.SUCCESS;
        }

        return super.mobInteract(player, hand);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "main", 5, this::animationPredicate));
    }

    private PlayState animationPredicate(AnimationState<ZabZabEntity> state) {
        if (state.isMoving()) {
            state.getController().setAnimation(RawAnimation.begin().thenLoop("animation.zab_zab.walk"));
            return PlayState.CONTINUE;
        }
        return PlayState.STOP; // back to the bind pose until an idle animation is added
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return null; // no breeding for now
    }
}