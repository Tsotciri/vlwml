
package net.tsotciri.vlwml.item;

import net.tsotciri.vlwml.init.VlwmlModSounds;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.resources.ResourceLocation;

public class ShulkItem extends RecordItem {
	public ShulkItem() {
		super(0, VlwmlModSounds.REGISTRY.get(new ResourceLocation("vlwml:shulk")),
				new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(1).rarity(Rarity.RARE));
		setRegistryName("shulk");
	}
}
