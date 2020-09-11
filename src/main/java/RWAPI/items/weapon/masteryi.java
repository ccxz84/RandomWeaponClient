package RWAPI.items.weapon;

import RWAPI.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class masteryi extends WeaponBase{

    public masteryi(String name) {
        super(name);
        setCreativeTab(CreativeTabs.MATERIALS);
        ModItems.weapon.add(this);
    }
}
