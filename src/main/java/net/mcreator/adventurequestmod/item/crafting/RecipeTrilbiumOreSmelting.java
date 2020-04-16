
package net.mcreator.adventurequestmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.adventurequestmod.item.ItemTrilbiumIngot;
import net.mcreator.adventurequestmod.block.BlockTrilbiumOre;
import net.mcreator.adventurequestmod.ElementsAdventureQuestMod;

@ElementsAdventureQuestMod.ModElement.Tag
public class RecipeTrilbiumOreSmelting extends ElementsAdventureQuestMod.ModElement {
	public RecipeTrilbiumOreSmelting(ElementsAdventureQuestMod instance) {
		super(instance, 6);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockTrilbiumOre.block, (int) (1)), new ItemStack(ItemTrilbiumIngot.block, (int) (1)), 7F);
	}
}
