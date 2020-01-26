package murkyconspiracy.shieldmod.handlers;

import murkyconspiracy.shieldmod.lists.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ShieldModItemGroup extends ItemGroup
{

	public ShieldModItemGroup() {
		super("shieldmodig");
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ItemList.wooden_shield);
	}

}
