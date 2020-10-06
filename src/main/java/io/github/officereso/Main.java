package io.github.officereso;

import nl.rutgerkok.worldgeneratorapi.WorldGeneratorApi;
import nl.rutgerkok.worldgeneratorapi.WorldRef;
import nl.rutgerkok.worldgeneratorapi.decoration.BaseDecorationType;
import nl.rutgerkok.worldgeneratorapi.decoration.DecorationType;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        return WorldGeneratorApi
                .getInstance(this, 0, 5)
                .createCustomGenerator(WorldRef.ofName(worldName), generator -> {
                    generator.setBaseTerrainGenerator(new Generate());
                    generator.getWorldDecorator().withoutDefaultDecorations(DecorationType.UNDERGROUND_DECORATION);
                    generator.getWorldDecorator().withoutDefaultBaseDecorations(BaseDecorationType.SURFACE);
                    generator.getWorldDecorator().withoutDefaultDecorations(DecorationType.SURFACE_STRUCTURES);
                    generator.getWorldDecorator().withoutDefaultDecorations(DecorationType.VEGETAL_DECORATION);
                    generator.getWorldDecorator().withoutDefaultDecorations(DecorationType.TOP_LAYER_MODIFICATION);
                    generator.getWorldDecorator().withoutDefaultDecorations(DecorationType.UNDERGROUND_ORES);
                    generator.getWorldDecorator().withCustomDecoration(DecorationType.UNDERGROUND_ORES, new DecorationGenerator());
                });
    }
}
