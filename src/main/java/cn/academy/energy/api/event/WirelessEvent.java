/**
 * Copyright (c) Lambda Innovation, 2013-2015
 * 本作品版权由Lambda Innovation所有。
 * http://www.lambdacraft.cn/
 *
 * This project is open-source, and it is distributed under 
 * the terms of GNU General Public License. You can modify
 * and distribute freely as long as you follow the license.
 * 本项目是一个开源项目，且遵循GNU通用公共授权协议。
 * 在遵照该协议的情况下，您可以自由传播和修改。
 * http://www.gnu.org/licenses/gpl.html
 */
package cn.academy.energy.api.event;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cn.academy.energy.api.IWirelessTile;
import cpw.mods.fml.common.eventhandler.Event;

/**
 * Base class of any wireless event.
 * All WirelessEvent should only be executed in SERVER side.
 * @author WeathFolD
 */
public class WirelessEvent extends Event {
    
    public final IWirelessTile tile;

    public WirelessEvent(IWirelessTile _tile) {
        tile = _tile;
    }
    
    public TileEntity getTileEntity() {
        return (TileEntity) tile;
    }
    
    public World getWorld() {
        return getTileEntity().getWorldObj();
    }

}
