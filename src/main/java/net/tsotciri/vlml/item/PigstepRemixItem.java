
package net.tsotciri.vlml.item;

import net.tsotciri.vlml.VlwmlModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

@VlwmlModElements.ModElement.Tag
public class PigstepRemixItem extends VlwmlModElements.ModElement {
	@ObjectHolder("vlwml:pigstep_remix")
	public static final Item block = null;
	public PigstepRemixItem(VlwmlModElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, VlwmlModElements.sounds.get(new ResourceLocation("vlwml:pigstep_remix")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("pigstep_remix");
		}
	}
}
