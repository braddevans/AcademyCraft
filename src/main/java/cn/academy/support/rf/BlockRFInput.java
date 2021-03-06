/**
* Copyright (c) Lambda Innovation, 2013-2016
* This file is part of the AcademyCraft mod.
* https://github.com/LambdaInnovation/AcademyCraft
* Licensed under GPLv3, see project root for more information.
*/
package cn.academy.support.rf;

import cn.academy.support.BlockConverterBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockRFInput extends BlockConverterBase {
    
    public BlockRFInput() {
        super("rf_input", "RF", "IF", TileRFInput.class);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileRFInput();
    }
    
}
