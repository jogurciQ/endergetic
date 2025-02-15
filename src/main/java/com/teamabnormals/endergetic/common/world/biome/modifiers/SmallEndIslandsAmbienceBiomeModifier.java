package com.teamabnormals.endergetic.common.world.biome.modifiers;

import com.teamabnormals.endergetic.core.registry.EESounds;
import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.AmbientAdditionsSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;

public enum SmallEndIslandsAmbienceBiomeModifier implements BiomeModifier {
	INSTANCE;

	public static final Codec<SmallEndIslandsAmbienceBiomeModifier> CODEC = Codec.unit(INSTANCE);

	@Override
	public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
		if (phase == Phase.MODIFY && biome.is(Biomes.SMALL_END_ISLANDS)) {
			builder.getSpecialEffects()
					.ambientLoopSound(EESounds.SMALL_END_ISLANDS_LOOP.get())
					.ambientAdditionsSound(new AmbientAdditionsSettings(EESounds.SMALL_END_ISLANDS_ADDITIONS.get(), 0.0111D));
		}
	}

	@Override
	public Codec<? extends BiomeModifier> codec() {
		return CODEC;
	}
}
