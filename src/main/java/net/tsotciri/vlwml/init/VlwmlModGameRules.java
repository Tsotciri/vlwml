
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.tsotciri.vlwml.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class VlwmlModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> DOBELUPACITOBEATDROP = GameRules.register("doBelupacitoBeatdrop",
			GameRules.Category.MISC, GameRules.BooleanValue.create(true));
}
