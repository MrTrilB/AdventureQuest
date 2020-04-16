
package net.mcreator.adventurequestmod.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

import net.mcreator.adventurequestmod.item.ItemTrilbiumSword;
import net.mcreator.adventurequestmod.ElementsAdventureQuestMod;

@ElementsAdventureQuestMod.ModElement.Tag
public class TabAdventureQuest extends ElementsAdventureQuestMod.ModElement {
	public TabAdventureQuest(ElementsAdventureQuestMod instance) {
		super(instance, 53);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabadventurequest") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(ItemTrilbiumSword.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static CreativeTabs tab;
}
