
package net.mcreator.adventurequestmod.fuel;

import net.minecraft.item.ItemStack;

import net.mcreator.adventurequestmod.item.ItemFlardOreDust;
import net.mcreator.adventurequestmod.ElementsAdventureQuestMod;

@ElementsAdventureQuestMod.ModElement.Tag
public class FuelFlardFule extends ElementsAdventureQuestMod.ModElement {
	public FuelFlardFule(ElementsAdventureQuestMod instance) {
		super(instance, 78);
	}

	@Override
	public int addFuel(ItemStack fuel) {
		if (fuel.getItem() == new ItemStack(ItemFlardOreDust.block, (int) (1)).getItem())
			return 10000000;
		return 0;
	}
}
