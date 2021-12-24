
package net.tsotciri.vlwml.item;

import net.tsotciri.vlwml.procedures.BelupacitoBeatDropProcedure;
import net.tsotciri.vlwml.init.VlwmlModSounds;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;
import net.minecraft.resources.ResourceLocation;

public class BelupacitoItem extends RecordItem {
	public BelupacitoItem() {
		super(0, VlwmlModSounds.REGISTRY.get(new ResourceLocation("vlwml:belupacito")),
				new Item.Properties().tab(null).stacksTo(1).rarity(Rarity.RARE));
		setRegistryName("belupacito");
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		InteractionResult retval = super.useOn(context);
		BelupacitoBeatDropProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(),
				context.getClickedPos().getZ());
		return retval;
	}
}
