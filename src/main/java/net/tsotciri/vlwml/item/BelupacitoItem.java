
package net.tsotciri.vlwml.item;

import net.tsotciri.vlwml.procedures.BelupacitoBeatDropProcedure;
import net.tsotciri.vlwml.VlwmlModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.util.ActionResultType;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.BlockState;

import java.util.Map;
import java.util.HashMap;

@VlwmlModElements.ModElement.Tag
public class BelupacitoItem extends VlwmlModElements.ModElement {
	@ObjectHolder("vlwml:belupacito")
	public static final Item block = null;
	public BelupacitoItem(VlwmlModElements instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, VlwmlModElements.sounds.get(new ResourceLocation("vlwml:belupacito")),
					new Item.Properties().group(null).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("belupacito");
		}

		@Override
		public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
			ActionResultType retval = super.onItemUseFirst(stack, context);
			World world = context.getWorld();
			BlockPos pos = context.getPos();
			PlayerEntity entity = context.getPlayer();
			Direction direction = context.getFace();
			BlockState blockstate = world.getBlockState(pos);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			ItemStack itemstack = context.getItem();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				BelupacitoBeatDropProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
