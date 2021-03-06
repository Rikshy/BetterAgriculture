package betteragriculture.client.render.mobs.layer;

import betteragriculture.client.model.ModelEntityMobSheep9Model1;
import betteragriculture.client.render.mobs.RenderEntityMobSheep9;
import betteragriculture.entity.entitymob.EntityMobSheep9;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EntityLayerSheepWool9 implements LayerRenderer<EntityMobSheep9>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation("betteragriculture:textures/models/sheep_9_fur.png");
    private final RenderEntityMobSheep9 sheepRenderer;
    private final ModelEntityMobSheep9Model1 sheepModel = new ModelEntityMobSheep9Model1();

    public EntityLayerSheepWool9(RenderEntityMobSheep9 sheepRendererIn)
    {
        this.sheepRenderer = sheepRendererIn;
    }

    public void doRenderLayer(EntityMobSheep9 entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        if (!entitylivingbaseIn.getSheared() && !entitylivingbaseIn.isInvisible())
        {
            this.sheepRenderer.bindTexture(TEXTURE);

            if (entitylivingbaseIn.hasCustomName() && "jeb_".equals(entitylivingbaseIn.getCustomNameTag()))
            {
                int i1 = 25;
                int i = entitylivingbaseIn.ticksExisted / 25 + entitylivingbaseIn.getEntityId();
                int j = EnumDyeColor.values().length;
                int k = i % j;
                int l = (i + 1) % j;
                float f = ((float)(entitylivingbaseIn.ticksExisted % 25) + partialTicks) / 25.0F;
                float[] afloat1 = EntityMobSheep9.getDyeRgb(EnumDyeColor.byMetadata(k));
                float[] afloat2 = EntityMobSheep9.getDyeRgb(EnumDyeColor.byMetadata(l));
                GlStateManager.color(afloat1[0] * (1.0F - f) + afloat2[0] * f, afloat1[1] * (1.0F - f) + afloat2[1] * f, afloat1[2] * (1.0F - f) + afloat2[2] * f);
            }
            else
            {
                float[] afloat = EntityMobSheep9.getDyeRgb(entitylivingbaseIn.getFleeceColor());
                GlStateManager.color(afloat[0], afloat[1], afloat[2]);
            }

            this.sheepModel.setModelAttributes(this.sheepRenderer.getMainModel());
            this.sheepModel.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
            this.sheepModel.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        }
    }

    public boolean shouldCombineTextures()
    {
        return true;
    }
}