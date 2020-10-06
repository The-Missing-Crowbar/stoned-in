package io.github.officereso;

import nl.rutgerkok.worldgeneratorapi.decoration.Decoration;
import nl.rutgerkok.worldgeneratorapi.decoration.DecorationArea;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.data.BlockData;
import org.bukkit.util.BlockIterator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static nl.rutgerkok.worldgeneratorapi.decoration.DecorationArea.DECORATION_RADIUS;

public class DecorationGenerator implements Decoration {
    World world;
    List<List<List<BlockData>>> tree1 = new ArrayList<>();
    List<List<List<BlockData>>> tree2 = new ArrayList<>();
    List<List<List<BlockData>>> tree3 = new ArrayList<>();
    List<List<List<BlockData>>> tree4 = new ArrayList<>();
    List<List<List<List<BlockData>>>> trees = new ArrayList<>();

    public DecorationGenerator() {
        this.world = Bukkit.getWorld("world");
        String tree1String = null;
        String tree2String = null;
        String tree3String = null;
        String tree4String = null;
        try {
            tree1String = new String (Files.readAllBytes(Paths.get("plugins/stonedIn/tree1.txt")));
            tree2String = new String (Files.readAllBytes(Paths.get("plugins/stonedIn/tree2.txt")));
            tree3String = new String (Files.readAllBytes(Paths.get("plugins/stonedIn/tree3.txt")));
            tree4String = new String (Files.readAllBytes(Paths.get("plugins/stonedIn/tree4.txt")));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        tree1String = tree1String.replace("Â", "");
        tree2String = tree2String.replace("Â", "");
        tree3String = tree3String.replace("Â", "");
        tree4String = tree4String.replace("Â", "");

        for (String YChunk : tree1String.split("\u00A7")) {
            List<List<BlockData>> layer = new ArrayList<>();
            for (String ZChunk : YChunk.split("\u00B6")) {
                List<BlockData> row = new ArrayList<>();
                layer.add(row);
                for (String XChunk : ZChunk.split("âœ“")){
                    BlockData blockData = Bukkit.getServer().createBlockData(XChunk);
                    row.add(blockData);
                }
            }
            tree1.add(layer);
        }

        for (String YChunk : tree2String.split("\u00A7")) {
            List<List<BlockData>> layer = new ArrayList<>();
            for (String ZChunk : YChunk.split("\u00B6")) {
                List<BlockData> row = new ArrayList<>();
                layer.add(row);
                for (String XChunk : ZChunk.split("âœ“")){
                    BlockData blockData = Bukkit.getServer().createBlockData(XChunk);
                    row.add(blockData);
                }
            }
            tree2.add(layer);
        }

        for (String YChunk : tree3String.split("\u00A7")) {
            List<List<BlockData>> layer = new ArrayList<>();
            for (String ZChunk : YChunk.split("\u00B6")) {
                List<BlockData> row = new ArrayList<>();
                layer.add(row);
                for (String XChunk : ZChunk.split("âœ“")){
                    BlockData blockData = Bukkit.getServer().createBlockData(XChunk);
                    row.add(blockData);
                }
            }
            tree3.add(layer);
        }

        for (String YChunk : tree4String.split("\u00A7")) {
            List<List<BlockData>> layer = new ArrayList<>();
            for (String ZChunk : YChunk.split("\u00B6")) {
                List<BlockData> row = new ArrayList<>();
                layer.add(row);
                for (String XChunk : ZChunk.split("âœ“")){
                    BlockData blockData = Bukkit.getServer().createBlockData(XChunk);
                    row.add(blockData);
                }
            }
            tree4.add(layer);
        }

        trees.add(tree1);
        trees.add(tree2);
        trees.add(tree3);
        trees.add(tree4);

    }

    @Override
    public void decorate(DecorationArea decorationArea, Random random) {
        structures(decorationArea, random);
        andesite(decorationArea, random);
        diorite(decorationArea, random);
        granite(decorationArea, random);
        gravel(decorationArea, random);
        sand(decorationArea, random);
        coal(decorationArea, random);
        redstone(decorationArea, random);
        lapis(decorationArea, random);
        iron(decorationArea, random);
        gold(decorationArea, random);
        diamond(decorationArea, random);
    }


    public void coal(DecorationArea decorationArea, Random random) {
        int veinCount = random.nextInt(20) + 10;
        int veinRadius = random.nextInt(5) + 1;
        int veinLength = 6;

        for (int i = 0; i < veinCount; i++) {
            int x = decorationArea.getCenterX() - DECORATION_RADIUS + random.nextInt(16);
            int y = random.nextInt(220) + 6;
            int z = decorationArea.getCenterZ() - DECORATION_RADIUS + random.nextInt(16);

            for (int vr = 0; vr <= veinRadius; vr++) {
                Location loc1 = new Location(world, x, y, z, (random.nextFloat() - .5f) * 360F, (random.nextFloat() - .5f) * 360F);
                BlockIterator veinLine = new BlockIterator(loc1, 0, random.nextInt(veinLength)+1);

                while (veinLine.hasNext()) {
                    Location loc = veinLine.next().getLocation();
                    Material material = decorationArea.getBlock((int) loc.getX(), (int) loc.getY(), (int) loc.getZ());
                    if (material == Material.STONE) {
                        decorationArea.setBlock((int) loc.getX(), (int) loc.getY(), (int) loc.getZ(), Material.COAL_ORE);
                    }
                }
            }
        }
    }

    public void iron(DecorationArea decorationArea, Random random) {
        int veinCount = random.nextInt(15) + 10;
        int veinRadius = random.nextInt(2)+1;
        int veinLength = 3;

        for (int i = 0; i < veinCount; i++) {
            int x = decorationArea.getCenterX() - DECORATION_RADIUS + random.nextInt(16);
            int y = random.nextInt(130) + 6;
            int z = decorationArea.getCenterZ() - DECORATION_RADIUS + random.nextInt(16);

            for (int vr = 0; vr <= veinRadius; vr++) {
                Location loc1 = new Location(world, x, y, z, (random.nextFloat() - .5f) * 360F, (random.nextFloat() - .5f) * 360F);
                BlockIterator veinLine = new BlockIterator(loc1, 0, random.nextInt(veinLength)+1);

                while (veinLine.hasNext()) {
                    Location loc = veinLine.next().getLocation();
                    Material material = decorationArea.getBlock((int) loc.getX(), (int) loc.getY(), (int) loc.getZ());
                    if (material == Material.STONE) {
                        decorationArea.setBlock((int) loc.getX(), (int) loc.getY(), (int) loc.getZ(), Material.IRON_ORE);
                    }
                }
            }
        }
    }

    public void gold(DecorationArea decorationArea, Random random) {
        int veinCount = random.nextInt(8) + 5;
        int veinRadius = random.nextInt(2) + 2;
        int veinLength = 2;

        for (int i = 0; i < veinCount; i++) {
            int x = decorationArea.getCenterX() - DECORATION_RADIUS + random.nextInt(16);
            int y = random.nextInt(180) + 6;
            int z = decorationArea.getCenterZ() - DECORATION_RADIUS + random.nextInt(16);

            for (int vr = 0; vr <= veinRadius; vr++) {
                Location loc1 = new Location(world, x, y, z, (random.nextFloat() - .5f) * 360F, (random.nextFloat() - .5f) * 360F);
                BlockIterator veinLine = new BlockIterator(loc1, 0, random.nextInt(veinLength)+1);

                while (veinLine.hasNext()) {
                    Location loc = veinLine.next().getLocation();
                    Material material = decorationArea.getBlock((int) loc.getX(), (int) loc.getY(), (int) loc.getZ());
                    if (material == Material.STONE) {
                        decorationArea.setBlock((int) loc.getX(), (int) loc.getY(), (int) loc.getZ(), Material.GOLD_ORE);
                    }
                }
            }
        }
    }

    public void diamond(DecorationArea decorationArea, Random random) {
        int veinCount = random.nextInt(3) + 1;
        int veinRadius = random.nextInt(1) + 1;

        for (int i = 0; i < veinCount; i++) {
            int x = decorationArea.getCenterX() - DECORATION_RADIUS + random.nextInt(16);
            int y = random.nextInt(110) + 6;
            int z = decorationArea.getCenterZ() - DECORATION_RADIUS + random.nextInt(16);

            for (int vr = 0; vr <= veinRadius; vr++) {
                Location loc1 = new Location(world, x, y, z, (random.nextFloat() - .5f) * 360F, (random.nextFloat() - .5f) * 360F);
                BlockIterator veinLine = new BlockIterator(loc1, 0, 1);

                while (veinLine.hasNext()) {
                    Location loc = veinLine.next().getLocation();
                    Material material = decorationArea.getBlock((int) loc.getX(), (int) loc.getY(), (int) loc.getZ());
                    if (material == Material.STONE) {
                        decorationArea.setBlock((int) loc.getX(), (int) loc.getY(), (int) loc.getZ(), Material.DIAMOND_ORE);
                    }
                }
            }
        }
    }

    public void redstone(DecorationArea decorationArea, Random random) {
        int veinCount = random.nextInt(7) + 3;
        int veinRadius = random.nextInt(5) + 2;
        int veinLength = 4;

        for (int i = 0; i < veinCount; i++) {
            int x = decorationArea.getCenterX() - DECORATION_RADIUS + random.nextInt(16);
            int y = random.nextInt(170) + 6;
            int z = decorationArea.getCenterZ() - DECORATION_RADIUS + random.nextInt(16);

            for (int vr = 0; vr <= veinRadius; vr++) {
                Location loc1 = new Location(world, x, y, z, (random.nextFloat() - .5f) * 360F, (random.nextFloat() - .5f) * 360F);
                BlockIterator veinLine = new BlockIterator(loc1, 0, random.nextInt(veinLength)+1);

                while (veinLine.hasNext()) {
                    Location loc = veinLine.next().getLocation();
                    Material material = decorationArea.getBlock((int) loc.getX(), (int) loc.getY(), (int) loc.getZ());
                    if (material == Material.STONE) {
                        decorationArea.setBlock((int) loc.getX(), (int) loc.getY(), (int) loc.getZ(), Material.REDSTONE_ORE);
                    }
                }
            }
        }
    }

    public void andesite(DecorationArea decorationArea, Random random) {
        int veinCount = random.nextInt(20) + 20;
        int veinRadius = random.nextInt(30) + 35;
        int veinLength = 6;

        for (int i = 0; i < veinCount; i++) {
            int x = decorationArea.getCenterX() - DECORATION_RADIUS + random.nextInt(16);
            int y = random.nextInt(240) + 6;
            int z = decorationArea.getCenterZ() - DECORATION_RADIUS + random.nextInt(16);

            for (int vr = 0; vr <= veinRadius; vr++) {
                Location loc1 = new Location(world, x, y, z, (random.nextFloat() - .5f) * 360F, (random.nextFloat() - .5f) * 360F);
                BlockIterator veinLine = new BlockIterator(loc1, 0, random.nextInt(veinLength)+1);

                while (veinLine.hasNext()) {
                    Location loc = veinLine.next().getLocation();
                    Material material = decorationArea.getBlock((int) loc.getX(), (int) loc.getY(), (int) loc.getZ());
                    if (material == Material.STONE) {
                        decorationArea.setBlock((int) loc.getX(), (int) loc.getY(), (int) loc.getZ(), Material.ANDESITE);
                    }
                }
            }
        }
    }

    public void granite(DecorationArea decorationArea, Random random) {
        int veinCount = random.nextInt(20) + 20;
        int veinRadius = random.nextInt(30) + 35;
        int veinLength = 6;

        for (int i = 0; i < veinCount; i++) {
            int x = decorationArea.getCenterX() - DECORATION_RADIUS + random.nextInt(16);
            int y = random.nextInt(240) + 6;
            int z = decorationArea.getCenterZ() - DECORATION_RADIUS + random.nextInt(16);

            for (int vr = 0; vr <= veinRadius; vr++) {
                Location loc1 = new Location(world, x, y, z, (random.nextFloat() - .5f) * 360F, (random.nextFloat() - .5f) * 360F);
                BlockIterator veinLine = new BlockIterator(loc1, 0, random.nextInt(veinLength)+1);

                while (veinLine.hasNext()) {
                    Location loc = veinLine.next().getLocation();
                    Material material = decorationArea.getBlock((int) loc.getX(), (int) loc.getY(), (int) loc.getZ());
                    if (material == Material.STONE) {
                        decorationArea.setBlock((int) loc.getX(), (int) loc.getY(), (int) loc.getZ(), Material.GRANITE);
                    }
                }
            }
        }
    }

    public void diorite(DecorationArea decorationArea, Random random) {
        int veinCount = random.nextInt(20) + 20;
        int veinRadius = random.nextInt(30) + 35;
        int veinLength = 6;

        for (int i = 0; i < veinCount; i++) {
            int x = decorationArea.getCenterX() - DECORATION_RADIUS + random.nextInt(16);
            int y = random.nextInt(240) + 6;
            int z = decorationArea.getCenterZ() - DECORATION_RADIUS + random.nextInt(16);

            for (int vr = 0; vr <= veinRadius; vr++) {
                Location loc1 = new Location(world, x, y, z, (random.nextFloat() - .5f) * 360F, (random.nextFloat() - .5f) * 360F);
                BlockIterator veinLine = new BlockIterator(loc1, 0, random.nextInt(veinLength)+1);

                while (veinLine.hasNext()) {
                    Location loc = veinLine.next().getLocation();
                    Material material = decorationArea.getBlock((int) loc.getX(), (int) loc.getY(), (int) loc.getZ());
                    if (material == Material.STONE) {
                        decorationArea.setBlock((int) loc.getX(), (int) loc.getY(), (int) loc.getZ(), Material.DIORITE);
                    }
                }
            }
        }
    }

    public void gravel(DecorationArea decorationArea, Random random) {
        int veinCount = random.nextInt(20) + 20;
        int veinRadius = random.nextInt(30) + 35;
        int veinLength = 6;

        for (int i = 0; i < veinCount; i++) {
            int x = decorationArea.getCenterX() - DECORATION_RADIUS + random.nextInt(16);
            int y = random.nextInt(240) + 6;
            int z = decorationArea.getCenterZ() - DECORATION_RADIUS + random.nextInt(16);

            for (int vr = 0; vr <= veinRadius; vr++) {
                Location loc1 = new Location(world, x, y, z, (random.nextFloat() - .5f) * 360F, (random.nextFloat() - .5f) * 360F);
                BlockIterator veinLine = new BlockIterator(loc1, 0, random.nextInt(veinLength)+1);

                while (veinLine.hasNext()) {
                    Location loc = veinLine.next().getLocation();
                    Material material = decorationArea.getBlock((int) loc.getX(), (int) loc.getY(), (int) loc.getZ());
                    if (material == Material.STONE) {
                        decorationArea.setBlock((int) loc.getX(), (int) loc.getY(), (int) loc.getZ(), Material.GRAVEL);
                    }
                }
            }
        }
    }

    public void sand(DecorationArea decorationArea, Random random) {
        int veinCount = random.nextInt(20) + 20;
        int veinRadius = random.nextInt(30) + 35;
        int veinLength = 6;

        for (int i = 0; i < veinCount; i++) {
            int x = decorationArea.getCenterX() - DECORATION_RADIUS + random.nextInt(16);
            int y = random.nextInt(75) + 150;
            int z = decorationArea.getCenterZ() - DECORATION_RADIUS + random.nextInt(16);

            for (int vr = 0; vr <= veinRadius; vr++) {
                Location loc1 = new Location(world, x, y, z, (random.nextFloat() - .5f) * 360F, (random.nextFloat() - .5f) * 360F);
                BlockIterator veinLine = new BlockIterator(loc1, 0, random.nextInt(veinLength)+1);

                while (veinLine.hasNext()) {
                    Location loc = veinLine.next().getLocation();
                    Material material = decorationArea.getBlock((int) loc.getX(), (int) loc.getY(), (int) loc.getZ());
                    if (material == Material.STONE) {
                        decorationArea.setBlock((int) loc.getX(), (int) loc.getY(), (int) loc.getZ(), Material.SAND);
                    }
                }
            }
        }
    }

    public void lapis(DecorationArea decorationArea, Random random) {
        int veinCount = random.nextInt(2) + 1;
        int veinRadius = random.nextInt(3) + 3;
        int veinLength = 1;

        for (int i = 0; i < veinCount; i++) {
            int x = decorationArea.getCenterX() - DECORATION_RADIUS + random.nextInt(16);
            int y = random.nextInt(30) + 200;
            int z = decorationArea.getCenterZ() - DECORATION_RADIUS + random.nextInt(16);

            for (int vr = 0; vr <= veinRadius; vr++) {
                Location loc1 = new Location(world, x, y, z, (random.nextFloat() - .5f) * 360F, (random.nextFloat() - .5f) * 360F);
                BlockIterator veinLine = new BlockIterator(loc1, 0, random.nextInt(veinLength)+1);

                while (veinLine.hasNext()) {
                    Location loc = veinLine.next().getLocation();
                    Material material = decorationArea.getBlock((int) loc.getX(), (int) loc.getY(), (int) loc.getZ());
                    if (material == Material.STONE) {
                        decorationArea.setBlock((int) loc.getX(), (int) loc.getY(), (int) loc.getZ(), Material.LAPIS_ORE);
                    }
                }
            }
        }
    }

    public void structures(DecorationArea decorationArea, Random random) {
        int rand = random.nextInt(300);
        int y = random.nextInt(50) + 175;
        if (rand == 0){
            List<List<List<BlockData>>> tree = trees.get(random.nextInt(trees.size()));
            int startX = decorationArea.getCenterX() - DECORATION_RADIUS;
            int startZ = decorationArea.getCenterZ() - DECORATION_RADIUS;

            int blockY = y-tree.size();
            for (List<List<BlockData>> layer : tree){
                blockY++;
                int blockZ = startZ;
                for (List<BlockData> row : layer){
                    blockZ++;
                    int blockX = startX;
                    for (BlockData block : row){
                        blockX++;
                        decorationArea.setBlock(blockX, blockY, blockZ, block.getMaterial());
                        decorationArea.setBlockData(blockX, blockY, blockZ, block);
                    }
                }
            }
        }
    }
}
