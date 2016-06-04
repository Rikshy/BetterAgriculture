package betteragriculture.client.render.mobs;

import betteragriculture.entity.entitymob.EntityMobSheep5;
import net.minecraft.client.model.ModelSheep1;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;

public class RenderEntityMobSheep5 extends RenderLiving<EntityMobSheep5>
{
	private final ResourceLocation textures = new ResourceLocation("betteragriculture:textures/models/sheep5.png");

	public RenderEntityMobSheep5(RenderManager renderManager)
	{
		super(renderManager, new ModelSheep1(), 0);
		this.addLayer(new LayerHeldItem(this));
	}

	

	@Override
	protected ResourceLocation getEntityTexture(EntityMobSheep5 entity)
	{
		return textures;
	}
}