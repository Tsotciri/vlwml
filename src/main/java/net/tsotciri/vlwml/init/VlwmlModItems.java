
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.tsotciri.vlwml.init;

import net.tsotciri.vlwml.item.ShulkItem;
import net.tsotciri.vlwml.item.OthersideItem;
import net.tsotciri.vlwml.item.BelupacitoItem;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.item.Item;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class VlwmlModItems {
	private static final List<Item> REGISTRY = new ArrayList<>();
	public static final Item OTHERSIDE = register(new OthersideItem());
	public static final Item SHULK = register(new ShulkItem());
	public static final Item BELUPACITO = register(new BelupacitoItem());

	private static Item register(Item item) {
		REGISTRY.add(item);
		return item;
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Item[0]));
	}
}
