package telk.alien.frenz.event;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;
import telk.alien.frenz.entity.ModEntities;
import telk.alien.frenz.entity.ZabZabEntity;

import java.util.List;
import java.util.Random;

public class AlienInvasionEvent {
    private static final int INTERVAL_TICKS = 72000; // 1 hour at 20 ticks/sec
    private static final int MOBS_PER_WAVE = 4;
    private static final double SPAWN_RADIUS = 200.0;

    private static int ticksUntilNextWave = INTERVAL_TICKS;
    private static final Random RANDOM = new Random();

    private static void onServerTick(MinecraftServer server) {
        ticksUntilNextWave--;
        if (ticksUntilNextWave <= 0) {
            ticksUntilNextWave = INTERVAL_TICKS;
            triggerInvasion(server);
        }
    }

    private static void triggerInvasion(MinecraftServer server) {
        List<ServerPlayer> players = server.getPlayerList().getPlayers();
        if (players.isEmpty()) return;

        ServerPlayer target = players.get(RANDOM.nextInt(players.size()));
        ServerLevel level = target.serverLevel();
        Vec3 center = target.position();

        double packAngle = RANDOM.nextDouble() * 2 * Math.PI;
        double packX = center.x + Math.cos(packAngle) * SPAWN_RADIUS;
        double packZ = center.z + Math.sin(packAngle) * SPAWN_RADIUS;

        server.getPlayerList().broadcastSystemMessage(
                Component.translatable("event.alien-friends.invasion", target.getName(),
                        (int) packX, (int) packZ),
                false);

        for (int i = 0; i < MOBS_PER_WAVE; i++) {
            double offsetAngle = RANDOM.nextDouble() * 2 * Math.PI;
            double offsetDist = RANDOM.nextDouble() * 4.0; // spread within 4 blocks of the pack point
            double x = packX + Math.cos(offsetAngle) * offsetDist;
            double z = packZ + Math.sin(offsetAngle) * offsetDist;
            int y = level.getHeight(net.minecraft.world.level.levelgen.Heightmap.Types.MOTION_BLOCKING, (int) x, (int) z);

            ZabZabEntity invader = new ZabZabEntity(ModEntities.ZAB_ZAB, level);
            invader.moveTo(x, y, z, 0, 0);
            level.addFreshEntity(invader);

            target.sendSystemMessage(Component.literal(
                    String.format("Zab Zab spawned at %d, %d, %d", (int) x, y, (int) z)));
        }
    }

    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(AlienInvasionEvent::onServerTick);

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) ->
                dispatcher.register(Commands.literal("zabzabinvasion")
                        .requires(source -> source.hasPermission(2))
                        .executes(context -> {
                            triggerInvasion(context.getSource().getServer());
                            return 1;
                        })));
    }
}