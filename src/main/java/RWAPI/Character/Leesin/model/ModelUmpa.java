package RWAPI.Character.Leesin.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelUmpa extends ModelBase {
	public ModelRenderer umpa_head;
    public ModelRenderer umpa_body1;
    public ModelRenderer umpa_body2;

    public ModelUmpa() {
    	this.textureWidth = 64;
        this.textureHeight = 32;
        this.umpa_head = new ModelRenderer(this, 0, 0);
        this.umpa_head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.umpa_head.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3, 0.0F);
        this.setRotateAngle(umpa_head, 0.0F, 1.5707963267948966F, 0.0F);
        this.umpa_body1 = new ModelRenderer(this, 10, 0);
        this.umpa_body1.setRotationPoint(1.0F, 0.4F, -6.0F);
        this.umpa_body1.addBox(0.0F, 0.0F, 1.0F, 1, 2, 5, 0.0F);
        this.umpa_body2 = new ModelRenderer(this, 10, 0);
        this.umpa_body2.setRotationPoint(1.0F, 0.9F, -7.9F);
        this.umpa_body2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
        this.umpa_head.addChild(this.umpa_body1);
        this.umpa_head.addChild(this.umpa_body2);

    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.umpa_head.render(f5);
    }
    public void setAngles() {
    	
	}
    
    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
