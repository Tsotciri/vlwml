
package net.tsotciri.vldm.item;

import net.tsotciri.vldm.VlwdmModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

@VlwdmModElements.ModElement.Tag
public class PigstepRemixItem extends VlwdmModElements.ModElement {
	@ObjectHolder("vlwdm:pigstep_remix")
	public static final Item block = null;
	public PigstepRemixItem(VlwdmModElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, VlwdmModElements.sounds.get(new ResourceLocation("vlwdm:pigstep_remix")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("pigstep_remix");
		}
	}
}
