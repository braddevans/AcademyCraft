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

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import cn.academy.crafting.item.ItemMatterUnit;
import cn.annoreg.core.Registrant;
import cn.annoreg.mc.RegItem;
import cn.annoreg.mc.RegSubmoduleInit;

/**
 * @author WeAthFolD
 */
@Registrant
@RegSubmoduleInit
public class ModuleCrafting {
	
	@RegItem
	@RegItem.HasRender
	public static ItemMatterUnit matterUnit;
	
	public static Fluid fluidImagIon = new Fluid("imagFlux");
    static {
    	fluidImagIon.setLuminosity(8).setDensity(7000)
    		.setViscosity(6000).setTemperature(0).setDensity(1);
		FluidRegistry.registerFluid(fluidImagIon);
    }
	
	public static void init() {
		FluidContainerRegistry.registerFluidContainer(new FluidStack(fluidImagIon, 1000), 
			matterUnit.create("imag_ionic"), matterUnit.create("none"));
	}
	
}