/**
 * Copyright (c) Lambda Innovation, 2013-2015
 * 本作品版权由Lambda Innovation所有。
 * http://www.li-dev.cn/
 *
 * This project is open-source, and it is distributed under  
 * the terms of GNU General Public License. You can modify
 * and distribute freely as long as you follow the license.
 * 本项目是一个开源项目，且遵循GNU通用公共授权协议。
 * 在遵照该协议的情况下，您可以自由传播和修改。
 * http://www.gnu.org/licenses/gpl.html
 */
package cn.academy.crafting;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import cn.academy.core.item.ACItem;
import cn.academy.core.registry.ACRecipeNamesRegistration.RegACRecipeNames;
import cn.academy.crafting.api.ImagFusorRecipes;
import cn.academy.crafting.block.BlockGenericOre;
import cn.academy.crafting.block.BlockImagFusor;
import cn.academy.crafting.block.BlockInciser;
import cn.academy.crafting.item.ItemMatterUnit;
import cn.annoreg.core.Registrant;
import cn.annoreg.mc.RegBlock;
import cn.annoreg.mc.RegInit;
import cn.annoreg.mc.RegItem;
import cn.liutils.crafting.CustomMappingHelper.RecipeName;

/**
 * @author WeAthFolD
 */
@Registrant
@RegInit
@RegACRecipeNames
public class ModuleCrafting {
	
	@RegItem
	@RegItem.HasRender
	@RecipeName("matter_unit")
	public static ItemMatterUnit matterUnit;
	
	@RegItem
	@RecipeName("crystal0")
	public static Item crystalLow = new ACItem("crystal_low");
	
	@RegItem
	@RecipeName("crystal1")
	public static Item crystalNormal = new ACItem("crystal_normal");
	
	@RegItem
	@RecipeName("crystal2")
	public static Item crystalPure = new ACItem("crystal_pure");
	
	@RegItem
	@RecipeName("frame")
	public static Item machineFrame = new ACItem("machine_frame");
	
	@RegItem
	@RecipeName("calc_chip")
	public static Item calcChip = new ACItem("calc_chip");
	
	@RegItem
	@RecipeName("data_chip")
	public static Item dataChip = new ACItem("data_chip");
	
	@RegBlock
	@RecipeName("fusor")
    public static BlockImagFusor imagFusor;
	
	@RegBlock
	@RecipeName("inciser")
	public static BlockInciser inciser;
	
	@RegBlock
	@RecipeName("cons_ore")
	public static BlockGenericOre oreConstraintMetal = new BlockGenericOre("constraint_metal_ore", 3.0f, 2);
	
	@RegBlock
	@RecipeName("crystal_ore")
	public static BlockGenericOre oreCrystal = new BlockGenericOre("crystal_ore", 2.0f, 2);
	
	@RegBlock
	@RecipeName("imagsil_ore")
	public static BlockGenericOre oreImagSil = new BlockGenericOre("imag_silicon_ore", 2.75f, 2);
	
	@RegItem
	@RecipeName("wafer")
	public static Item wafer = new ACItem("wafer");
	
	@RegItem
	@RecipeName("cons_ingot")
	public static Item ingotConst = new ACItem("constraint_ingot");
	
	@RegItem
	@RecipeName("imagsil_ingot")
	public static Item ingotImagSil = new ACItem("imag_silicon_ingot");
	
	@RegItem
	@RegItem.OreDict("plateIron")
	@RecipeName("rf_iron_plate")
	public static Item rfIronPlate = new ACItem("reinforced_iron_plate");
	
	@RegItem
	@RecipeName("brain_comp")
	public static Item brainComp = new ACItem("brain_component");
	
	@RegItem
	@RecipeName("data_comp")
	public static Item dataComp = new ACItem("data_component");
	
	@RegItem
	@RecipeName("info_comp")
	public static Item infoComp = new ACItem("info_component");
	
	@RegItem
	@RecipeName("reso_comp")
	public static Item resoComp = new ACItem("resonance_component");
	
	@RegItem
	@RecipeName("conv_comp")
	public static Item comvComp = new ACItem("energy_convert_component");
	
	public static Fluid fluidImagProj = new Fluid("imagProj");
    static {
    	fluidImagProj.setLuminosity(8).setDensity(7000)
    		.setViscosity(6000).setTemperature(0).setDensity(1);
		FluidRegistry.registerFluid(fluidImagProj);
    }
	
	public static void init() {
		FluidContainerRegistry.registerFluidContainer(new FluidStack(fluidImagProj, 1000), 
			matterUnit.create("phase_liquid"), matterUnit.create("none"));
		
		oreCrystal.setDropData(crystalLow, 1, 3);
		
		ImagFusorRecipes.INSTANCE.addRecipe(new ItemStack(crystalLow), 1000, new ItemStack(crystalNormal));
	}
	
}
