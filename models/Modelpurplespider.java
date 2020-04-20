// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public static class Modelpurplespider extends ModelBase {
	private final ModelRenderer head;
	private final ModelRenderer neck;
	private final ModelRenderer body;
	private final ModelRenderer leg1;
	private final ModelRenderer leg2;
	private final ModelRenderer leg3;
	private final ModelRenderer leg4;
	private final ModelRenderer leg5;
	private final ModelRenderer leg6;
	private final ModelRenderer leg7;
	private final ModelRenderer leg8;

	public Modelpurplespider() {
		textureWidth = 64;
		textureHeight = 32;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 15.0F, -3.0F);
		head.cubeList.add(new ModelBox(head, 32, 4, -4.0F, -4.0F, -8.0F, 8, 8, 8, 0.0F, true));

		neck = new ModelRenderer(this);
		neck.setRotationPoint(0.0F, 15.0F, 0.0F);
		neck.cubeList.add(new ModelBox(neck, 0, 0, -3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F, true));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 15.0F, 9.0F);
		body.cubeList.add(new ModelBox(body, 0, 12, -5.0F, -4.0F, -6.0F, 10, 8, 12, 0.0F, true));

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(4.0F, 15.0F, 4.0F);
		leg1.cubeList.add(new ModelBox(leg1, 18, 0, -23.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F, true));

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(-4.0F, 15.0F, 4.0F);
		leg2.cubeList.add(new ModelBox(leg2, 18, 0, 7.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F, true));

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(4.0F, 15.0F, 1.0F);
		leg3.cubeList.add(new ModelBox(leg3, 18, 0, -23.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F, true));

		leg4 = new ModelRenderer(this);
		leg4.setRotationPoint(-4.0F, 15.0F, 1.0F);
		leg4.cubeList.add(new ModelBox(leg4, 18, 0, 7.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F, true));

		leg5 = new ModelRenderer(this);
		leg5.setRotationPoint(4.0F, 15.0F, -2.0F);
		leg5.cubeList.add(new ModelBox(leg5, 18, 0, -23.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F, true));

		leg6 = new ModelRenderer(this);
		leg6.setRotationPoint(-4.0F, 15.0F, -2.0F);
		leg6.cubeList.add(new ModelBox(leg6, 18, 0, 7.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F, true));

		leg7 = new ModelRenderer(this);
		leg7.setRotationPoint(4.0F, 15.0F, -5.0F);
		leg7.cubeList.add(new ModelBox(leg7, 18, 0, -23.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F, true));

		leg8 = new ModelRenderer(this);
		leg8.setRotationPoint(-4.0F, 15.0F, -5.0F);
		leg8.cubeList.add(new ModelBox(leg8, 18, 0, 7.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F, true));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		head.render(f5);
		neck.render(f5);
		body.render(f5);
		leg1.render(f5);
		leg2.render(f5);
		leg3.render(f5);
		leg4.render(f5);
		leg5.render(f5);
		leg6.render(f5);
		leg7.render(f5);
		leg8.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.leg1.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leg4.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leg5.rotateAngleY = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leg2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leg3.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
		this.leg8.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
		this.leg6.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leg7.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
		this.neck.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.body.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
	}
}