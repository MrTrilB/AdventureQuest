
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
public class ItemTrilbiumArmor extends ElementsAdventureQuestMod.ModElement {
	@GameRegistry.ObjectHolder("adventurequestmod:trilbiumarmorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("adventurequestmod:trilbiumarmorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("adventurequestmod:trilbiumarmorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("adventurequestmod:trilbiumarmorboots")
	public static final Item boots = null;
	public ItemTrilbiumArmor(ElementsAdventureQuestMod instance) {
		super(instance, 17);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("TRILBIUMARMOR", "adventurequestmod:trilbium", 350, new int[]{50, 100, 150, 50},
				90, (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 4f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("trilbiumarmorhelmet")
				.setRegistryName("trilbiumarmorhelmet").setCreativeTab(TabAdventureQuest.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("trilbiumarmorbody")
				.setRegistryName("trilbiumarmorbody").setCreativeTab(TabAdventureQuest.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("trilbiumarmorlegs")
				.setRegistryName("trilbiumarmorlegs").setCreativeTab(TabAdventureQuest.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("trilbiumarmorboots")
				.setRegistryName("trilbiumarmorboots").setCreativeTab(TabAdventureQuest.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("adventurequestmod:trilbiumarmorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("adventurequestmod:trilbiumarmorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("adventurequestmod:trilbiumarmorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("adventurequestmod:trilbiumarmorboots", "inventory"));
	}
}
