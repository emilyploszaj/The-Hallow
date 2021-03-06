package io.github.alloffabric.thehallow.world.biome;

import io.github.alloffabric.thehallow.registry.HallowedBlocks;
import io.github.alloffabric.thehallow.world.feature.HallowedBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MineshaftFeature;
import net.minecraft.world.gen.feature.MineshaftFeatureConfig;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

// TODO
public class HallowedShoreBiome extends HallowedBaseBiome {
	private static final TernarySurfaceConfig TAINTED_GRAVEL_CONFIG = new TernarySurfaceConfig(
		HallowedBlocks.TAINTED_GRAVEL.getDefaultState(),
		HallowedBlocks.TAINTED_GRAVEL.getDefaultState(),
		HallowedBlocks.TAINTED_GRAVEL.getDefaultState()
	);

	public HallowedShoreBiome() {
		super(new Settings().surfaceBuilder(new ConfiguredSurfaceBuilder<TernarySurfaceConfig>(SurfaceBuilder.DEFAULT, TAINTED_GRAVEL_CONFIG)).precipitation(Precipitation.NONE).category(Category.OCEAN).depth(0.02f).scale(0.025f).temperature(0.5f).downfall(0.8f).waterColor(0x3F76E4).waterFogColor(0x050533));

		this.addStructureFeature(Feature.MINESHAFT.configure(new MineshaftFeatureConfig(0.004D, MineshaftFeature.Type.NORMAL)));

		HallowedBiomeFeatures.addGrass(this);
		HallowedBiomeFeatures.addLakes(this);
		HallowedBiomeFeatures.addDefaultHallowedTrees(this);
	}
}
