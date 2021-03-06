/**
* Copyright (c) Lambda Innovation, 2013-2016
* This file is part of the AcademyCraft mod.
* https://github.com/LambdaInnovation/AcademyCraft
* Licensed under GPLv3, see project root for more information.
*/
package cn.academy.ability.block;

import cn.academy.ability.develop.DeveloperType;
import cn.academy.core.block.ACBlockMulti;
import cn.lambdalib.annoreg.core.Registrant;
import cn.lambdalib.template.client.render.block.RenderEmptyBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * @author WeAthFolD
 *
 */
@Registrant
public class BlockDeveloper extends ACBlockMulti {
    
    public final DeveloperType type;

    public BlockDeveloper(DeveloperType _type) {
        super("developer", Material.rock);
        type = _type;
        setHardness(4.0f);
        setHarvestLevel("pickaxe", 2);
        
        String tmp = type.toString().toLowerCase();
        setBlockName("ac_developer_" + tmp);
        setBlockTextureName("academy:developer_" + tmp);
        
        this.addSubBlock(0, 1, 0);
        this.addSubBlock(0, 0, 1);
        this.addSubBlock(0, 1, 1);
        this.addSubBlock(0, 2, 1);
        this.addSubBlock(0, 0, 2);
        this.addSubBlock(0, 1, 2);
        this.addSubBlock(0, 2, 2);
        
        finishInit();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getRenderType() {
        return RenderEmptyBlock.id;
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, 
            float tx, float ty, float tz) {
        TileEntity te = world.getTileEntity(x, y, z);
        if(te instanceof TileDeveloper && !player.isSneaking()) {
            if(!world.isRemote) {
                TileDeveloper td = (TileDeveloper) te;
                if(td.getUser() == null) {
                    td.use(player);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return type == DeveloperType.NORMAL ? new TileDeveloper.Normal() : new TileDeveloper.Advanced();
    }

    @Override
    public double[] getRotCenter() {
        return new double[] { 0.5, 0, 0.5 };
    }

}
