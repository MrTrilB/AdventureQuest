
package net.mcreator.adventurequestmod.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.adventurequestmod.creativetab.TabAdventureQuest;
import net.mcreator.adventurequestmod.ElementsAdventureQuestMod;

@ElementsAdventureQuestMod.ModElement.Tag
public class ItemFlardArmor extends ElementsAdventureQuestMod.ModElement {
	@GameRegistry.ObjectHolder("adventurequestmod:flardarmorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("adventurequestmod:flardarmorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("adventurequestmod:flardarmorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("adventurequestmod:flardarmorboots")
	public static final Item boots = null;
	public ItemFlardArmor(ElementsAdventureQuestMod instance) {
		super(instance, 42);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("FLARDARMOR", "adventurequestmod:flard", 200, new int[]{25, 100, 50, 25}, 72,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 3f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("flardarmorhelmet")
				.setRegistryName("flardarmorhelmet").setCreativeTab(TabAdventureQuest.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("flardarmorbody")
				.setRegistryName("flardarmorbody").setCreativeTab(TabAdventureQuest.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("flardarmorlegs")
				.setRegistryName("flardarmorlegs").setCreativeTab(TabAdventureQuest.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("flardarmorboots")
				.setRegistryName("flardarmorboots").setCreativeTab(TabAdventureQuest.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("adventurequestmod:flardarmorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("adventurequestmod:flardarmorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("adventurequestmod:flardarmorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("adventurequestmod:flardarmorboots", "inventory"));
	}
}
