
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.tsotciri.vlwml.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class VlwmlModSounds {
	public static Map<ResourceLocation, SoundEvent> REGISTRY = new HashMap<>();
	static {
		REGISTRY.put(new ResourceLocation("vlwml", "belupacito"), new SoundEvent(new ResourceLocation("vlwml", "belupacito")));
		REGISTRY.put(new ResourceLocation("vlwml", "pigstep_remix"), new SoundEvent(new ResourceLocation("vlwml", "pigstep_remix")));
		REGISTRY.put(new ResourceLocation("vlwml", "sus"), new SoundEvent(new ResourceLocation("vlwml", "sus")));
		REGISTRY.put(new ResourceLocation("vlwml", "hobbit.hobbit_ts"), new SoundEvent(new ResourceLocation("vlwml", "hobbit.hobbit_ts")));
		REGISTRY.put(new ResourceLocation("vlwml", "marvel.avengers_assemble"),
				new SoundEvent(new ResourceLocation("vlwml", "marvel.avengers_assemble")));
		REGISTRY.put(new ResourceLocation("vlwml", "marvel.marvel_ot"), new SoundEvent(new ResourceLocation("vlwml", "marvel.marvel_ot")));
		REGISTRY.put(new ResourceLocation("vlwml", "memes.coffind_meme"), new SoundEvent(new ResourceLocation("vlwml", "memes.coffind_meme")));
		REGISTRY.put(new ResourceLocation("vlwml", "memes.nyan"), new SoundEvent(new ResourceLocation("vlwml", "memes.nyan")));
		REGISTRY.put(new ResourceLocation("vlwml", "memes.rick_roll"), new SoundEvent(new ResourceLocation("vlwml", "memes.rick_roll")));
		REGISTRY.put(new ResourceLocation("vlwml", "memes.suniversal"), new SoundEvent(new ResourceLocation("vlwml", "memes.suniversal")));
		REGISTRY.put(new ResourceLocation("vlwml", "minigames.battle.music"),
				new SoundEvent(new ResourceLocation("vlwml", "minigames.battle.music")));
		REGISTRY.put(new ResourceLocation("vlwml", "minigames.tumble.music"),
				new SoundEvent(new ResourceLocation("vlwml", "minigames.tumble.music")));
		REGISTRY.put(new ResourceLocation("vlwml", "minigames.glide.music"), new SoundEvent(new ResourceLocation("vlwml", "minigames.glide.music")));
		REGISTRY.put(new ResourceLocation("vlwml", "songs.avengers_ts"), new SoundEvent(new ResourceLocation("vlwml", "songs.avengers_ts")));
		REGISTRY.put(new ResourceLocation("vlwml", "songs.universal_ot"), new SoundEvent(new ResourceLocation("vlwml", "songs.universal_ot")));
		REGISTRY.put(new ResourceLocation("vlwml", "songs.coffind_full"), new SoundEvent(new ResourceLocation("vlwml", "songs.coffind_full")));
		REGISTRY.put(new ResourceLocation("vlwml", "shulk"), new SoundEvent(new ResourceLocation("vlwml", "shulk")));
		REGISTRY.put(new ResourceLocation("vlwml", "otherside"), new SoundEvent(new ResourceLocation("vlwml", "otherside")));
		REGISTRY.put(new ResourceLocation("vlwml", "tuber.craniac"), new SoundEvent(new ResourceLocation("vlwml", "tuber.craniac")));
		REGISTRY.put(new ResourceLocation("vlwml", "tuber.congrats"), new SoundEvent(new ResourceLocation("vlwml", "tuber.congrats")));
		REGISTRY.put(new ResourceLocation("vlwml", "songs.megalovania"), new SoundEvent(new ResourceLocation("vlwml", "songs.megalovania")));
		REGISTRY.put(new ResourceLocation("vlwml", "songs.veratasium"), new SoundEvent(new ResourceLocation("vlwml", "songs.veratasium")));
	}

	@SubscribeEvent
	public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
		for (Map.Entry<ResourceLocation, SoundEvent> sound : REGISTRY.entrySet())
			event.getRegistry().register(sound.getValue().setRegistryName(sound.getKey()));
	}
}
