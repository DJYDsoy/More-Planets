/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.asteroids.darkasteroids.world.gen;

import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import net.minecraft.world.biome.BiomeGenBase;
import stevekung.mods.moreplanets.core.config.ConfigManagerMP;
import stevekung.mods.moreplanets.core.entities.EntityEvolvedWitch;
import stevekung.mods.moreplanets.core.world.biome.BiomeGenBaseMP;
import stevekung.mods.moreplanets.planets.diona.entities.EntityEvolvedEnderman;

public class BiomeGenBaseDarkAsteroids extends BiomeGenBaseMP
{
	public static BiomeGenBase darkAsteroids = new BiomeGenBaseDarkAsteroids().setBiomeName("Dark Asteroids");

	public BiomeGenBaseDarkAsteroids()
	{
		super(ConfigManagerMP.idDarkAsteroidsBiome);
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedZombie.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedSpider.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedSkeleton.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedCreeper.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedEnderman.class, 10, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedWitch.class, 15, 2, 4));
	}
}