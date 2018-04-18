package com.knoxhack.betteragriculture.entities.sheep;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;



public class EntityMobSheep10 extends EntitySheep
{

	public EntityMobSheep10(World worldIn) {
		super(worldIn);
	}

	@Override
    public EntityMobSheep10 createChild(EntityAgeable ageable)
    {
        return new EntityMobSheep10(this.world);
    }
	


    @Nullable
    @Override
    protected ResourceLocation getLootTable()
    {
        return LootTableList.ENTITIES_SHEEP_BROWN;
    }


	
}