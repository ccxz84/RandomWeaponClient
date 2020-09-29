package RWAPI.items.weapon;

import RWAPI.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;

public class formaster extends WeaponBase{

    public formaster(String name) {
        super(name);
        setCreativeTab(CreativeTabs.MATERIALS);
        ModItems.weapon.add(this);
    }
}
