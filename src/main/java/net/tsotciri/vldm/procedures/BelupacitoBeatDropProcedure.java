package net.tsotciri.vldm.procedures;

import net.tsotciri.vldm.VlwdmModVariables;
import net.tsotciri.vldm.VlwdmMod;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class BelupacitoBeatDropProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				VlwdmMod.LOGGER.warn("Failed to load dependency entity for procedure BelupacitoBeatDrop!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				VlwdmMod.LOGGER.warn("Failed to load dependency x for procedure BelupacitoBeatDrop!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				VlwdmMod.LOGGER.warn("Failed to load dependency y for procedure BelupacitoBeatDrop!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				VlwdmMod.LOGGER.warn("Failed to load dependency z for procedure BelupacitoBeatDrop!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				VlwdmMod.LOGGER.warn("Failed to load dependency world for procedure BelupacitoBeatDrop!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		VlwdmModVariables.MapVariables
				.get(world).block = (String) ((/* @BlockState */(world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))) + "" + (""));
		VlwdmModVariables.MapVariables.get(world).syncData(world);
		if (((VlwdmModVariables.MapVariables.get(world).block).equals("Block{minecraft:jukebox}[has_record=false]"))) {
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;
				public void start(IWorld world, int waitTicks) {
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
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).attackEntityFrom(new DamageSource("beatdrop").setDamageBypassesArmor(), (float) 20);
					}
					new Object() {
						private int ticks = 0;
						private float waitTicks;
						private IWorld world;
						public void start(IWorld world, int waitTicks) {
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
							if (world instanceof World && !((World) world).isRemote) {
								((World) world).createExplosion(null, (int) x, (int) y, (int) z, (float) 10, Explosion.Mode.BREAK);
							}
							new Object() {
								private int ticks = 0;
								private float waitTicks;
								private IWorld world;
								public void start(IWorld world, int waitTicks) {
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
									if (world instanceof World && !((World) world).isRemote) {
										((World) world).createExplosion(null, (int) x, (int) y, (int) z, (float) 10, Explosion.Mode.BREAK);
									}
									new Object() {
										private int ticks = 0;
										private float waitTicks;
										private IWorld world;
										public void start(IWorld world, int waitTicks) {
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
											if (world instanceof World && !((World) world).isRemote) {
												((World) world).createExplosion(null, (int) x, (int) (y - 5), (int) z, (float) 10,
														Explosion.Mode.BREAK);
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 5);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 5);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 10);
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 243);
		}
	}
}
