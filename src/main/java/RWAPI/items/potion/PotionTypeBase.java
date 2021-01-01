package RWAPI.items.potion;

import RWAPI.init.ModPotion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;

import javax.annotation.Nullable;

public class PotionTypeBase extends PotionType {

    public PotionTypeBase(@Nullable String p_i46740_1_, PotionEffect... p_i46740_2_){
        super(p_i46740_1_,p_i46740_2_);
        ModPotion.POTIONTYPES.add(this);
    }
}
