
package net.mcreator.adventurequestmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.adventurequestmod.item.ItemEnderiumIngot;
import net.mcreator.adventurequestmod.item.ItemEnderiumDust;
import net.mcreator.adventurequestmod.ElementsAdventureQuestMod;

@ElementsAdventureQuestMod.ModElement.Tag
public class RecipeEnderiumOreSmelting extends ElementsAdventureQuestMod.ModElement {
	public RecipeEnderiumOreSmelting(ElementsAdventureQuestMod instance) {
		super(instance, 59);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemEnderiumDust.block, (int) (1)), new ItemStack(ItemEnderiumIngot.block, (int) (1)), 23F);
	}
}
