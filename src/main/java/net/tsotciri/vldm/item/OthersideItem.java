
package net.tsotciri.vldm.item;

import net.tsotciri.vldm.VldmModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

@VldmModElements.ModElement.Tag
public class OthersideItem extends VldmModElements.ModElement {
	@ObjectHolder("vldm:otherside")
	public static final Item block = null;
	public OthersideItem(VldmModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, VldmModElements.sounds.get(new ResourceLocation("vldm:otherside")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("otherside");
		}
	}
}
