
package net.mcreator.adventurequestmod.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.adventurequestmod.creativetab.TabAdventureQuest;
import net.mcreator.adventurequestmod.ElementsAdventureQuestMod;

import java.util.Set;
import java.util.HashMap;

@ElementsAdventureQuestMod.ModElement.Tag
public class ItemEnderiumToolsPickaxe extends ElementsAdventureQuestMod.ModElement {
	@GameRegistry.ObjectHolder("adventurequestmod:enderiumtoolspickaxe")
	public static final Item block = null;
	public ItemEnderiumToolsPickaxe(ElementsAdventureQuestMod instance) {
		super(instance, 61);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemPickaxe(EnumHelper.addToolMaterial("ENDERIUMTOOLSPICKAXE", 3, 16280, 24f, 21f, 140)) {
			{
				this.attackSpeed = -2f;
			}
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("pickaxe", 3);
				return ret.keySet();
			}
		}.setUnlocalizedName("enderiumtoolspickaxe").setRegistryName("enderiumtoolspickaxe").setCreativeTab(TabAdventureQuest.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("adventurequestmod:enderiumtoolspickaxe", "inventory"));
	}
}
