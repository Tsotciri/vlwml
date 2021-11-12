
package net.tsotciri.vlml.item;

import net.tsotciri.vlml.VlwmlModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

@VlwmlModElements.ModElement.Tag
public class SusItem extends VlwmlModElements.ModElement {
	@ObjectHolder("vlwml:sus")
	public static final Item block = null;
	public SusItem(VlwmlModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, VlwmlModElements.sounds.get(new ResourceLocation("vlwml:sus")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("sus");
		}
	}
}
