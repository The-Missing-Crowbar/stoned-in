package io.github.officereso;

import nl.rutgerkok.worldgeneratorapi.BaseTerrainGenerator;
import nl.rutgerkok.worldgeneratorapi.BiomeGenerator;
import org.bukkit.Material;

public class Generate implements BaseTerrainGenerator {

    @Override
    public void setBlocksInChunk(GeneratingChunk generatingChunk) {
        generatingChunk.getBlocksForChunk().setRegion(0, 0, 0, CHUNK_SIZE, 230, CHUNK_SIZE, Material.STONE);
        generatingChunk.getBlocksForChunk().setRegion(0, 230, 0, CHUNK_SIZE, 254, CHUNK_SIZE, Material.BEDROCK);
    }

    @Override
    public int getHeight(BiomeGenerator biomeGenerator, int x, int z, HeightType type) {
        return 230;
    }
}
