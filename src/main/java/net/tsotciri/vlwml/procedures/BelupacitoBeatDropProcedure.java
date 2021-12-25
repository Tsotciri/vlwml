package net.tsotciri.vlwml.procedures;

import net.tsotciri.vlwml.init.VlwmlModGameRules;

import net.minecraftforge.fmllegacy.server.ServerLifecycleHooks;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.MinecraftServer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.ChatType;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandFunction;
import net.minecraft.Util;

import java.util.Optional;

public class BelupacitoBeatDropProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.getLevelData().getGameRules().getBoolean(VlwmlModGameRules.DOBELUPACITOBEATDROP) == true) {
			if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)) + "").equals("Block{minecraft:jukebox}[has_record=true]")) {
				if (!world.isClientSide()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().broadcastMessage(new TextComponent("Waiting"), ChatType.SYSTEM, Util.NIL_UUID);
				}
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private LevelAccessor world;

					public void start(LevelAccessor world, int waitTicks) {
						this.waitTicks = waitTicks;
						MinecraftForge.EVENT_BUS.register(this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(TickEvent.ServerTickEvent event) {
						if (event.phase == TickEvent.Phase.END) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
						if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)) + "").equals("Block{minecraft:jukebox}[has_record=true]")) {
							if (!world.isClientSide()) {
								MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
								if (mcserv != null)
									mcserv.getPlayerList().broadcastMessage(new TextComponent("Boom"), ChatType.SYSTEM, Util.NIL_UUID);
							}
							if (world instanceof ServerLevel _level && _level.getServer() != null) {
								Optional<CommandFunction> _fopt = _level.getServer().getFunctions()
										.get(new ResourceLocation("vlwml:belupacito_beat_drop_func"));
								if (_fopt.isPresent())
									_level.getServer().getFunctions().execute(_fopt.get(), new CommandSourceStack(CommandSource.NULL,
											new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null));
							}
							for (int index0 = 0; index0 < (int) (100); index0++) {
								if (world instanceof ServerLevel _level && _level.getServer() != null) {
									Optional<CommandFunction> _fopt = _level.getServer().getFunctions()
											.get(new ResourceLocation("vlwml:belupacito_beat_drop_func_extra"));
									if (_fopt.isPresent())
										_level.getServer().getFunctions().execute(_fopt.get(), new CommandSourceStack(CommandSource.NULL,
												new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null));
								}
							}
						} else {
							if (!world.isClientSide()) {
								MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
								if (mcserv != null)
									mcserv.getPlayerList().broadcastMessage(new TextComponent("No block lol"), ChatType.SYSTEM, Util.NIL_UUID);
							}
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, 243);
			}
		}
	}
}
