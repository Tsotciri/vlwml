
package net.tsotciri.vldm.item;

import net.tsotciri.vldm.VlwdmModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

@VlwdmModElements.ModElement.Tag
public class OthersideItem extends VlwdmModElements.ModElement {
	@ObjectHolder("vlwdm:otherside")
	public static final Item block = null;
	public OthersideItem(VlwdmModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, VlwdmModElements.sounds.get(new ResourceLocation("vlwdm:otherside")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("otherside");
		}
	}
}
