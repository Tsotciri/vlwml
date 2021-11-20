package net.tsotciri.vlwml.procedures;

import net.tsotciri.vlwml.VlwmlModVariables;
import net.tsotciri.vlwml.VlwmlMod;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.passive.AmbientEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.AgeableEntity;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class BelupacitoBeatDropProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				VlwmlMod.LOGGER.warn("Failed to load dependency x for procedure BelupacitoBeatDrop!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				VlwmlMod.LOGGER.warn("Failed to load dependency y for procedure BelupacitoBeatDrop!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				VlwmlMod.LOGGER.warn("Failed to load dependency z for procedure BelupacitoBeatDrop!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				VlwmlMod.LOGGER.warn("Failed to load dependency world for procedure BelupacitoBeatDrop!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		VlwmlModVariables.MapVariables
				.get(world).block = (String) ((/* @BlockState */(world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))) + "" + (""));
		VlwmlModVariables.MapVariables.get(world).syncData(world);
		if (((VlwmlModVariables.MapVariables.get(world).block).equals("Block{minecraft:jukebox}[has_record=false]"))) {
			VlwmlModVariables.MapVariables.get(world).xdir = (double) 0;
			VlwmlModVariables.MapVariables.get(world).syncData(world);
			VlwmlModVariables.MapVariables.get(world).zdir = (double) 0;
			VlwmlModVariables.MapVariables.get(world).syncData(world);
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
					{
						List<Entity> _entfound = world
								.getEntitiesWithinAABB(Entity.class,
										new AxisAlignedBB(x - (5 / 2d), y - (5 / 2d), z - (5 / 2d), x + (5 / 2d), y + (5 / 2d), z + (5 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (((Entity) world.getEntitiesWithinAABB(AgeableEntity.class,
									new AxisAlignedBB(x - (5 / 2d), y - (5 / 2d), z - (5 / 2d), x + (5 / 2d), y + (5 / 2d), z + (5 / 2d)), null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity) {
								((LivingEntity) ((Entity) world.getEntitiesWithinAABB(AgeableEntity.class,
										new AxisAlignedBB(x - (5 / 2d), y - (5 / 2d), z - (5 / 2d), x + (5 / 2d), y + (5 / 2d), z + (5 / 2d)), null)
										.stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator
														.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
											}
										}.compareDistOf(x, y, z)).findFirst().orElse(null)))
												.attackEntityFrom(new DamageSource("beatdrop").setDamageBypassesArmor(), (float) 100);
							}
							if (((Entity) world.getEntitiesWithinAABB(AmbientEntity.class,
									new AxisAlignedBB(x - (5 / 2d), y - (5 / 2d), z - (5 / 2d), x + (5 / 2d), y + (5 / 2d), z + (5 / 2d)), null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity) {
								((LivingEntity) ((Entity) world.getEntitiesWithinAABB(AmbientEntity.class,
										new AxisAlignedBB(x - (5 / 2d), y - (5 / 2d), z - (5 / 2d), x + (5 / 2d), y + (5 / 2d), z + (5 / 2d)), null)
										.stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator
														.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
											}
										}.compareDistOf(x, y, z)).findFirst().orElse(null)))
												.attackEntityFrom(new DamageSource("beatdrop").setDamageBypassesArmor(), (float) 100);
							}
						}
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
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 10);
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 243);
		}
	}
}
