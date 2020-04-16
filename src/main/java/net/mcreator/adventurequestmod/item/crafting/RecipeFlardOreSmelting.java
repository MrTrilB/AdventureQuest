
package net.mcreator.adventurequestmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.adventurequestmod.item.ItemFlardIngot;
import net.mcreator.adventurequestmod.block.BlockFlardOre;
import net.mcreator.adventurequestmod.ElementsAdventureQuestMod;

@ElementsAdventureQuestMod.ModElement.Tag
public class RecipeFlardOreSmelting extends ElementsAdventureQuestMod.ModElement {
	public RecipeFlardOreSmelting(ElementsAdventureQuestMod instance) {
		super(instance, 47);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockFlardOre.block, (int) (1)), new ItemStack(ItemFlardIngot.block, (int) (1)), 10.6F);
	}
}
