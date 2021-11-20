
package net.tsotciri.vlwml.item;

import net.tsotciri.vlwml.VlwmlModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

@VlwmlModElements.ModElement.Tag
public class OthersideItem extends VlwmlModElements.ModElement {
	@ObjectHolder("vlwml:otherside")
	public static final Item block = null;
	public OthersideItem(VlwmlModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, VlwmlModElements.sounds.get(new ResourceLocation("vlwml:otherside")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("otherside");
		}
	}
}
