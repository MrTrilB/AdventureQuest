
package net.mcreator.adventurequestmod.entity;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.pathfinding.PathNavigateFlying;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.ai.EntityFlyHelper;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.Minecraft;
import net.minecraft.block.state.IBlockState;

import net.mcreator.adventurequestmod.item.ItemTrilionAlloyRod;
import net.mcreator.adventurequestmod.ElementsAdventureQuestMod;

import java.util.Random;
import java.util.Iterator;
import java.util.ArrayList;

@ElementsAdventureQuestMod.ModElement.Tag
public class EntityPlaze extends ElementsAdventureQuestMod.ModElement {
	public static final int ENTITYID = 4;
	public static final int ENTITYID_RANGED = 5;
	public EntityPlaze(ElementsAdventureQuestMod instance) {
		super(instance, 83);
	}

	@Override
	public void initElements() {
		elements.entities
				.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("adventurequestmod", "plaze"), ENTITYID)
						.name("plaze").tracker(64, 3, true).egg(-10092391, -6749953).build());
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityArrowCustom.class)
				.id(new ResourceLocation("adventurequestmod", "entitybulletplaze"), ENTITYID_RANGED).name("entitybulletplaze").tracker(64, 1, true)
				.build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = allbiomes(Biome.REGISTRY);
		EntityRegistry.addSpawn(EntityCustom.class, 20, 3, 30, EnumCreatureType.MONSTER, spawnBiomes);
	}

	private Biome[] allbiomes(net.minecraft.util.registry.RegistryNamespaced<ResourceLocation, Biome> in) {
		Iterator<Biome> itr = in.iterator();
		ArrayList<Biome> ls = new ArrayList<Biome>();
		while (itr.hasNext())
			ls.add(itr.next());
		return ls.toArray(new Biome[ls.size()]);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new Modelplaze(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("adventurequestmod:textures/purple_blaze.png");
				}
			};
		});
		RenderingRegistry.registerEntityRenderingHandler(EntityArrowCustom.class, renderManager -> {
			return new RenderSnowball<EntityArrowCustom>(renderManager, null, Minecraft.getMinecraft().getRenderItem()) {
				public ItemStack getStackToRender(EntityArrowCustom entity) {
					return new ItemStack(Items.FIRE_CHARGE, (int) (1));
				}
			};
		});
	}
	public static class EntityCustom extends EntityBlaze implements IRangedAttackMob {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 1.8f);
			experienceValue = 5;
			this.isImmuneToFire = true;
			setNoAI(!true);
			this.navigator = new PathNavigateFlying(this, this.world);
			this.moveHelper = new EntityFlyHelper(this);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIWander(this, 1));
			this.tasks.addTask(2, new EntityAILookIdle(this));
			this.tasks.addTask(3, new EntityAISwimming(this));
			this.tasks.addTask(4, new EntityAILeapAtTarget(this, (float) 0.8));
			this.tasks.addTask(5, new EntityAIPanic(this, 1.2));
			this.targetTasks.addTask(6, new EntityAIHurtByTarget(this, false));
			this.tasks.addTask(1, new EntityAIAttackRanged(this, 1.25D, 20, 10.0F));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEFINED;
		}

		@Override
		protected Item getDropItem() {
			return new ItemStack(ItemTrilionAlloyRod.block, (int) (1)).getItem();
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.blaze.ambient"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.blaze.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.blaze.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public void fall(float l, float d) {
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3D);
			this.getAttributeMap().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
			this.getEntityAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.3);
		}

		@Override
		public void setSwingingArms(boolean swingingArms) {
		}

		public void attackEntityWithRangedAttack(EntityLivingBase target, float flval) {
			EntityArrowCustom entityarrow = new EntityArrowCustom(this.world, this);
			double d0 = target.posY + (double) target.getEyeHeight() - 1.1;
			double d1 = target.posX - this.posX;
			double d3 = target.posZ - this.posZ;
			entityarrow.shoot(d1, d0 - entityarrow.posY + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 1.6F, 12.0F);
			this.world.spawnEntity(entityarrow);
		}

		@Override
		public void onUpdate() {
			super.onUpdate();
			this.setNoGravity(true);
		}

		@Override
		protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {
		}

		@Override
		public void setNoGravity(boolean ignored) {
			super.setNoGravity(true);
		}

		public void onLivingUpdate() {
			super.onLivingUpdate();
			int i = (int) this.posX;
			int j = (int) this.posY;
			int k = (int) this.posZ;
			Random random = this.rand;
			if (true)
				for (int l = 0; l < 4; ++l) {
					double d0 = (i + 0.5) + (random.nextFloat() - 0.5) * 0.5D * 20;
					double d1 = ((j + 0.7) + (random.nextFloat() - 0.5) * 0.5D) + 0.5;
					double d2 = (k + 0.5) + (random.nextFloat() - 0.5) * 0.5D * 20;
					world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0, d1, d2, 0, 0, 0);
				}
		}
	}

	public static class EntityArrowCustom extends EntityTippedArrow {
		public EntityArrowCustom(World a) {
			super(a);
		}

		public EntityArrowCustom(World worldIn, double x, double y, double z) {
			super(worldIn, x, y, z);
		}

		public EntityArrowCustom(World worldIn, EntityLivingBase shooter) {
			super(worldIn, shooter);
		}
	}

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
}
