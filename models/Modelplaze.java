// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public static class Modelplaze extends ModelBase {
	private final ModelRenderer head;
	private final ModelRenderer stick1;
	private final ModelRenderer stick2;
	private final ModelRenderer stick3;
	private final ModelRenderer stick4;
	private final ModelRenderer stick5;
	private final ModelRenderer stick6;
	private final ModelRenderer stick7;
	private final ModelRenderer stick8;
	private final ModelRenderer stick9;
	private final ModelRenderer stick10;
	private final ModelRenderer stick11;
	private final ModelRenderer stick12;

	public Modelplaze() {
		textureWidth = 64;
		textureHeight = 32;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F, true));

		stick1 = new ModelRenderer(this);
		stick1.setRotationPoint(2.0F, 5.0F, -2.0F);
		stick1.cubeList.add(new ModelBox(stick1, 0, 16, -5.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F, true));

		stick2 = new ModelRenderer(this);
		stick2.setRotationPoint(-2.0F, 5.0F, -2.0F);
		stick2.cubeList.add(new ModelBox(stick2, 0, 16, 3.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F, true));

		stick3 = new ModelRenderer(this);
		stick3.setRotationPoint(-2.0F, 5.0F, 2.0F);
		stick3.cubeList.add(new ModelBox(stick3, 0, 16, 3.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F, true));

		stick4 = new ModelRenderer(this);
		stick4.setRotationPoint(2.0F, 5.0F, 2.0F);
		stick4.cubeList.add(new ModelBox(stick4, 0, 16, -5.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F, true));

		stick5 = new ModelRenderer(this);
		stick5.setRotationPoint(2.0F, 14.0F, -2.0F);
		stick5.cubeList.add(new ModelBox(stick5, 0, 16, -1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F, true));

		stick6 = new ModelRenderer(this);
		stick6.setRotationPoint(-2.0F, 14.0F, -2.0F);
		stick6.cubeList.add(new ModelBox(stick6, 0, 16, -1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F, true));

		stick7 = new ModelRenderer(this);
		stick7.setRotationPoint(-2.0F, 14.0F, 2.0F);
		stick7.cubeList.add(new ModelBox(stick7, 0, 16, 3.0F, 0.9F, -1.0F, 2, 7, 2, 0.0F, true));

		stick8 = new ModelRenderer(this);
		stick8.setRotationPoint(2.0F, 14.0F, 2.0F);
		stick8.cubeList.add(new ModelBox(stick8, 0, 16, -5.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F, true));

		stick9 = new ModelRenderer(this);
		stick9.setRotationPoint(2.0F, 23.0F, -2.0F);
		stick9.cubeList.add(new ModelBox(stick9, 0, 16, -5.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F, true));

		stick10 = new ModelRenderer(this);
		stick10.setRotationPoint(-2.0F, 23.0F, -2.0F);
		stick10.cubeList.add(new ModelBox(stick10, 0, 16, 3.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F, true));

		stick11 = new ModelRenderer(this);
		stick11.setRotationPoint(-2.0F, 23.0F, 2.0F);
		stick11.cubeList.add(new ModelBox(stick11, 0, 16, 3.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F, true));

		stick12 = new ModelRenderer(this);
		stick12.setRotationPoint(2.0F, 23.0F, 2.0F);
		stick12.cubeList.add(new ModelBox(stick12, 0, 16, -5.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F, true));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		head.render(f5);
		stick1.render(f5);
		stick2.render(f5);
		stick3.render(f5);
		stick4.render(f5);
		stick5.render(f5);
		stick6.render(f5);
		stick7.render(f5);
		stick8.render(f5);
		stick9.render(f5);
		stick10.render(f5);
		stick11.render(f5);
		stick12.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.stick12.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.stick11.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.stick1.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.stick3.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.stick2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.stick5.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
		this.stick4.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.stick7.rotateAngleY = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.stick6.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.stick9.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
		this.stick8.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.stick10.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
	}
}