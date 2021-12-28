package net.tsotciri.vlwml.procedures;

import net.tsotciri.vlwml.init.VlwmlModGameRules;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fmllegacy.server.ServerLifecycleHooks;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.sounds.SoundSource;
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
									mcserv.getPlayerList().broadcastMessage(new TextComponent(((("x:" + x) + "" + (", y:" + y)) + "" + (", z:" + z))),
											ChatType.SYSTEM, Util.NIL_UUID);
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, new BlockPos((int) x, (int) y, (int) z),
											ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")),
											SoundSource.BLOCKS, 10, 1);
								} else {
									_level.playLocalSound(x, y, z,
											ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")),
											SoundSource.BLOCKS, 10, 1, false);
								}
							}
							if (world instanceof Level _level && !_level.isClientSide())
								_level.explode(null, x, y, z, 10, Explosion.BlockInteraction.BREAK);
							if (world instanceof ServerLevel _level && _level.getServer() != null) {
								Optional<CommandFunction> _fopt = _level.getServer().getFunctions()
										.get(new ResourceLocation("vlwml:belupacito_beat_drop_func"));
								if (_fopt.isPresent())
									_level.getServer().getFunctions().execute(_fopt.get(), new CommandSourceStack(CommandSource.NULL,
											new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null));
							}
							for (int index0 = 0; index0 < (int) (100); index0++) {
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
										if (world instanceof ServerLevel _level && _level.getServer() != null) {
											Optional<CommandFunction> _fopt = _level.getServer().getFunctions()
													.get(new ResourceLocation("vlwml:belupacito_beat_drop_func_extra"));
											if (_fopt.isPresent())
												_level.getServer().getFunctions().execute(_fopt.get(),
														new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",
																new TextComponent(""), _level.getServer(), null));
										}
										MinecraftForge.EVENT_BUS.unregister(this);
									}
								}.start(world, 1);
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
									if (world instanceof ServerLevel _level && _level.getServer() != null) {
										Optional<CommandFunction> _fopt = _level.getServer().getFunctions()
												.get(new ResourceLocation("vlwml:belupacito_beat_drop_func_end"));
										if (_fopt.isPresent())
											_level.getServer().getFunctions().execute(_fopt.get(), new CommandSourceStack(CommandSource.NULL,
													new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null));
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, 10);
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
