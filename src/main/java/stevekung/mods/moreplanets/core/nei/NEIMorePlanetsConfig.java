/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.core.nei;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import micdoodle8.mods.galacticraft.core.items.GCItems;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import stevekung.mods.moreplanets.core.MorePlanetsCore;
import stevekung.mods.moreplanets.core.config.ConfigManagerMP;
import stevekung.mods.moreplanets.core.init.MPBlocks;
import stevekung.mods.moreplanets.core.init.MPItems;
import stevekung.mods.moreplanets.moons.io.blocks.IoBlocks;
import stevekung.mods.moreplanets.moons.koentus.blocks.KoentusBlocks;
import stevekung.mods.moreplanets.planets.diona.blocks.DionaBlocks;
import stevekung.mods.moreplanets.planets.fronos.blocks.FronosBlocks;
import stevekung.mods.moreplanets.planets.kapteynb.blocks.KapteynBBlocks;
import stevekung.mods.moreplanets.planets.mercury.blocks.MercuryBlocks;
import stevekung.mods.moreplanets.planets.nibiru.blocks.NibiruBlocks;
import stevekung.mods.moreplanets.planets.pluto.blocks.PlutoBlocks;
import stevekung.mods.moreplanets.planets.polongnius.blocks.PolongniusBlocks;
import stevekung.mods.moreplanets.planets.polongnius.items.PolongniusItems;
import stevekung.mods.moreplanets.planets.siriusb.blocks.SiriusBBlocks;
import stevekung.mods.moreplanets.planets.venus.blocks.VenusBlocks;
import codechicken.nei.PositionedStack;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

public class NEIMorePlanetsConfig implements IConfigureNEI
{
	private static HashMap<HashMap<Integer, PositionedStack>, PositionedStack> circuitFabricatorRecipes = new HashMap<HashMap<Integer, PositionedStack>, PositionedStack>();

	@Override
	public void loadConfig()
	{
		API.registerRecipeHandler(new CircuitFabricatorRecipeHandlerMP());
		API.registerUsageHandler(new CircuitFabricatorRecipeHandlerMP());
		API.registerHighlightIdentifier(MPBlocks.stone_slab_full, new NEIHighlightHandlerMP());
		API.registerHighlightIdentifier(MPBlocks.stone_slab_full2, new NEIHighlightHandlerMP());
		API.registerHighlightIdentifier(MPBlocks.wooden_slab_full, new NEIHighlightHandlerMP());
		API.registerHighlightIdentifier(MPBlocks.dungeon_brick_slab_full, new NEIHighlightHandlerMP());
		API.registerHighlightIdentifier(DionaBlocks.diona_block, new NEIHighlightHandlerMP());
		API.registerHighlightIdentifier(PolongniusBlocks.polongnius_block, new NEIHighlightHandlerMP());
		API.registerHighlightIdentifier(NibiruBlocks.nibiru_block, new NEIHighlightHandlerMP());
		API.registerHighlightIdentifier(NibiruBlocks.ancient_dark_leaves, new NEIHighlightHandlerMP());
		API.registerHighlightIdentifier(NibiruBlocks.orange_leaves, new NEIHighlightHandlerMP());
		API.registerHighlightIdentifier(KoentusBlocks.koentus_block, new NEIHighlightHandlerMP());
		API.registerHighlightIdentifier(KoentusBlocks.koentus_ice, new NEIHighlightHandlerMP());
		API.registerHighlightIdentifier(FronosBlocks.fronos_block, new NEIHighlightHandlerMP());
		API.registerHighlightIdentifier(FronosBlocks.frosted_cake, new NEIHighlightHandlerMP());
		API.registerHighlightIdentifier(FronosBlocks.fronos_tall_grass, new NEIHighlightHandlerMP());
		API.registerHighlightIdentifier(KapteynBBlocks.kapteyn_b_block, new NEIHighlightHandlerMP());
		API.registerHighlightIdentifier(KapteynBBlocks.kapteyn_b_ice, new NEIHighlightHandlerMP());
		API.registerHighlightIdentifier(KapteynBBlocks.uranium_waste, new NEIHighlightHandlerMP());
		API.registerHighlightIdentifier(SiriusBBlocks.sirius_b_block, new NEIHighlightHandlerMP());
		API.registerHighlightIdentifier(MercuryBlocks.mercury_block, new NEIHighlightHandlerMP());
		API.registerHighlightIdentifier(VenusBlocks.venus_block, new NEIHighlightHandlerMP());
		API.registerHighlightIdentifier(VenusBlocks.venus_redstone_ore_active, new NEIHighlightHandlerMP());
		API.registerHighlightIdentifier(PlutoBlocks.pluto_block, new NEIHighlightHandlerMP());
		this.registerRecipe();
	}

	@Override
	public String getName()
	{
		return "More Planet's NEI Plugin";
	}

	@Override
	public String getVersion()
	{
		return MorePlanetsCore.VERSION;
	}

	public void registerCircuitFabricatorRecipe(HashMap<Integer, PositionedStack> input, PositionedStack output)
	{
		NEIMorePlanetsConfig.circuitFabricatorRecipes.put(input, output);
	}

	public static Set<Entry<HashMap<Integer, PositionedStack>, PositionedStack>> getCircuitFabricatorRecipes()
	{
		return NEIMorePlanetsConfig.circuitFabricatorRecipes.entrySet();
	}

	public void registerRecipe()
	{
		this.addPurpleCrystalWaferRecipes();
		this.addPurpleCrystalSolarWaferRecipes();
		this.registerHideBlocks();
		this.registerHideItems();
	}

	private void addPurpleCrystalWaferRecipes()
	{
		HashMap<Integer, PositionedStack> input1 = new HashMap<Integer, PositionedStack>();
		int siliconCount = OreDictionary.getOres(ConfigManagerCore.otherModsSilicon).size();
		ItemStack[] silicons = new ItemStack[siliconCount + 1];
		silicons[0] = new ItemStack(GCItems.basicItem, 1, 2);

		for (int j = 0; j < siliconCount; j++)
		{
			silicons[j + 1] = OreDictionary.getOres("itemSilicon").get(j);
		}

		input1.put(0, new PositionedStack(new ItemStack(PolongniusItems.polongnius_item, 1, 1), 10, 22));
		input1.put(1, new PositionedStack(silicons, 69, 51));
		input1.put(2, new PositionedStack(silicons, 69, 69));
		input1.put(3, new PositionedStack(new ItemStack(Items.redstone), 117, 51));
		input1.put(4, new PositionedStack(new ItemStack(Items.repeater), 140, 25));
		this.registerCircuitFabricatorRecipe(input1, new PositionedStack(new ItemStack(PolongniusItems.purple_crystal_solar_module, ConfigManagerCore.quickMode ? 2 : 1, 0), 147, 91));
	}

	private void addPurpleCrystalSolarWaferRecipes()
	{
		HashMap<Integer, PositionedStack> input1 = new HashMap<Integer, PositionedStack>();
		int siliconCount = OreDictionary.getOres(ConfigManagerCore.otherModsSilicon).size();
		ItemStack[] silicons = new ItemStack[siliconCount + 1];
		silicons[0] = new ItemStack(GCItems.basicItem, 1, 2);

		for (int j = 0; j < siliconCount; j++)
		{
			silicons[j + 1] = OreDictionary.getOres("itemSilicon").get(j);
		}

		input1.put(0, new PositionedStack(new ItemStack(Items.diamond), 10, 22));
		input1.put(1, new PositionedStack(silicons, 69, 51));
		input1.put(2, new PositionedStack(silicons, 69, 69));
		input1.put(3, new PositionedStack(new ItemStack(Items.redstone), 117, 51));
		input1.put(4, new PositionedStack(new ItemStack(PolongniusItems.polongnius_item, 1, 1), 140, 25));
		this.registerCircuitFabricatorRecipe(input1, new PositionedStack(new ItemStack(PolongniusItems.purple_crystal_solar_module, 9, 1), 147, 91));
	}

	private void registerHideBlocks()
	{
		API.hideItem(new ItemStack(PolongniusBlocks.ultra_violet_solar_fake, 1, 0));
		API.hideItem(new ItemStack(PolongniusBlocks.cheese_of_milk));
		API.hideItem(new ItemStack(NibiruBlocks.ancient_dark_door, 1, 0));
		API.hideItem(new ItemStack(NibiruBlocks.orange_door, 1, 0));
		API.hideItem(new ItemStack(NibiruBlocks.infected_farmland, 1, 0));
		API.hideItem(new ItemStack(FronosBlocks.fronos_farmland, 1, 0));
		API.hideItem(new ItemStack(FronosBlocks.candy_extractor_active, 1, 0));
		API.hideItem(new ItemStack(FronosBlocks.strawberry_crops, 1, 0));
		API.hideItem(new ItemStack(FronosBlocks.golden_crops, 1, 0));
		API.hideItem(new ItemStack(FronosBlocks.glass_gem_corn1, 1, 0));
		API.hideItem(new ItemStack(FronosBlocks.glass_gem_corn2, 1, 0));
		API.hideItem(new ItemStack(FronosBlocks.glass_gem_corn3, 1, 0));
		API.hideItem(new ItemStack(FronosBlocks.coconut_door, 1, 0));
		API.hideItem(new ItemStack(FronosBlocks.maple_door, 1, 0));
		API.hideItem(new ItemStack(FronosBlocks.glass_gem_corn3, 1, 0));
		API.hideItem(new ItemStack(FronosBlocks.coconut_milk, 1, 0));
		API.hideItem(new ItemStack(FronosBlocks.mineral_water, 1, 0));
		API.hideItem(new ItemStack(FronosBlocks.ovantine, 1, 0));
		API.hideItem(new ItemStack(FronosBlocks.tea, 1, 0));
		API.hideItem(new ItemStack(FronosBlocks.caramel, 1, 0));
		API.hideItem(new ItemStack(FronosBlocks.cup, 1, 0));
		API.hideItem(new ItemStack(FronosBlocks.mineral_water_cup, 1, 0));
		API.hideItem(new ItemStack(FronosBlocks.cheese_of_milk_cup, 1, 0));
		API.hideItem(new ItemStack(FronosBlocks.ovantine_cup, 1, 0));
		API.hideItem(new ItemStack(FronosBlocks.coconut_milk_cup, 1, 0));
		API.hideItem(new ItemStack(FronosBlocks.tea_cup, 1, 0));
		API.hideItem(new ItemStack(FronosBlocks.caramel_cup, 1, 0));
		API.hideItem(new ItemStack(KapteynBBlocks.frozen_water, 1, 0));
		API.hideItem(new ItemStack(KapteynBBlocks.chest_temp, 1, 0));
		API.hideItem(new ItemStack(KoentusBlocks.crystal_door, 1, 0));
		API.hideItem(new ItemStack(KoentusBlocks.crystal_farmland, 1, 0));
		API.hideItem(new ItemStack(SiriusBBlocks.sirius_lava, 1, 0));
		API.hideItem(new ItemStack(SiriusBBlocks.sirius_fire, 1, 0));
		API.hideItem(new ItemStack(SiriusBBlocks.sirius_redstone_lamp_on, 1, 0));
		API.hideItem(new ItemStack(IoBlocks.io_lava, 1, 0));
		API.hideItem(new ItemStack(IoBlocks.liquid_red_sulfur, 1, 0));
		API.hideItem(new ItemStack(IoBlocks.liquid_yellow_sulfur, 1, 0));
		API.hideItem(new ItemStack(IoBlocks.liquid_orange_sulfur, 1, 0));
		API.hideItem(new ItemStack(IoBlocks.liquid_brown_sulfur, 1, 0));
		API.hideItem(new ItemStack(IoBlocks.io_black_lava, 1, 0));
		API.hideItem(new ItemStack(VenusBlocks.venus_redstone_ore_active, 1, 0));
		API.hideItem(new ItemStack(PlutoBlocks.liquid_methane, 1, 0));
		API.hideItem(new ItemStack(PlutoBlocks.liquid_nitrogen, 1, 0));
		API.hideItem(new ItemStack(PlutoBlocks.space_potato_block, 1, 0));
		API.hideItem(new ItemStack(MercuryBlocks.dirty_water, 1, 0));
		API.hideItem(new ItemStack(MPBlocks.stone_slab_full, 1, OreDictionary.WILDCARD_VALUE));
		API.hideItem(new ItemStack(MPBlocks.stone_slab_full2, 1, OreDictionary.WILDCARD_VALUE));
		API.hideItem(new ItemStack(MPBlocks.wooden_slab_full, 1, OreDictionary.WILDCARD_VALUE));
		API.hideItem(new ItemStack(MPBlocks.dungeon_brick_slab_full, 1, OreDictionary.WILDCARD_VALUE));
		API.hideItem(new ItemStack(FronosBlocks.double_fronos_sandstone_slab, 1, OreDictionary.WILDCARD_VALUE));
	}

	private void registerHideItems()
	{
		if (ConfigManagerMP.enableThaiFlagAndCanvas == false)
		{
			API.hideItem(new ItemStack(MPItems.flag, 1, 0));
			API.hideItem(new ItemStack(MPItems.flag, 1, 1));
			API.hideItem(new ItemStack(MPItems.flag, 1, 2));
			API.hideItem(new ItemStack(MPItems.flag, 1, 3));
			API.hideItem(new ItemStack(MPItems.flag, 1, 4));
			API.hideItem(new ItemStack(MPItems.flag, 1, 5));
			API.hideItem(new ItemStack(MPItems.flag, 1, 6));
			API.hideItem(new ItemStack(MPItems.flag, 1, 7));
			API.hideItem(new ItemStack(MPItems.flag, 1, 8));
			API.hideItem(new ItemStack(MPItems.flag, 1, 9));
		}
	}
}