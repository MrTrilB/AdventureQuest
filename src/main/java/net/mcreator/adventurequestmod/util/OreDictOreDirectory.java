
package net.mcreator.adventurequestmod.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.adventurequestmod.item.ItemTrilbiumIngot;
import net.mcreator.adventurequestmod.item.ItemTrilbiumDust;
import net.mcreator.adventurequestmod.item.ItemFlardOreDust;
import net.mcreator.adventurequestmod.item.ItemFlardIngot;
import net.mcreator.adventurequestmod.item.ItemEnderiumIngot;
import net.mcreator.adventurequestmod.item.ItemEnderiumDust;
import net.mcreator.adventurequestmod.block.BlockTrilbiumOreBlock;
import net.mcreator.adventurequestmod.block.BlockTrilbiumOre;
import net.mcreator.adventurequestmod.block.BlockFlardOreBlock;
import net.mcreator.adventurequestmod.block.BlockFlardOre;
import net.mcreator.adventurequestmod.block.BlockEnderiumOreBlock;
import net.mcreator.adventurequestmod.block.BlockEnderiumOre;
import net.mcreator.adventurequestmod.ElementsAdventureQuestMod;

@ElementsAdventureQuestMod.ModElement.Tag
public class OreDictOreDirectory extends ElementsAdventureQuestMod.ModElement {
	public OreDictOreDirectory(ElementsAdventureQuestMod instance) {
		super(instance, 87);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		OreDictionary.registerOre("oredirectory", new ItemStack(BlockTrilbiumOre.block, (int) (1)));
		OreDictionary.registerOre("oredirectory", new ItemStack(BlockFlardOre.block, (int) (1)));
		OreDictionary.registerOre("oredirectory", new ItemStack(BlockEnderiumOre.block, (int) (1)));
		OreDictionary.registerOre("oredirectory", new ItemStack(BlockTrilbiumOreBlock.block, (int) (1)));
		OreDictionary.registerOre("oredirectory", new ItemStack(ItemTrilbiumIngot.block, (int) (1)));
		OreDictionary.registerOre("oredirectory", new ItemStack(BlockFlardOreBlock.block, (int) (1)));
		OreDictionary.registerOre("oredirectory", new ItemStack(BlockFlardOreBlock.block, (int) (1)));
		OreDictionary.registerOre("oredirectory", new ItemStack(ItemFlardIngot.block, (int) (1)));
		OreDictionary.registerOre("oredirectory", new ItemStack(BlockEnderiumOreBlock.block, (int) (1)));
		OreDictionary.registerOre("oredirectory", new ItemStack(ItemEnderiumDust.block, (int) (1)));
		OreDictionary.registerOre("oredirectory", new ItemStack(ItemEnderiumIngot.block, (int) (1)));
		OreDictionary.registerOre("oredirectory", new ItemStack(ItemTrilbiumDust.block, (int) (1)));
		OreDictionary.registerOre("oredirectory", new ItemStack(ItemFlardOreDust.block, (int) (1)));
	}
}
