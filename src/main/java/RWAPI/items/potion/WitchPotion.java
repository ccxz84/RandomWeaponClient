package RWAPI.items.potion;

import RWAPI.init.ModPotion;
import RWAPI.main;
import RWAPI.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;

public class WitchPotion extends Potion {

    private static final ResourceLocation fire_resistance = new ResourceLocation("rwapi:textures/mob_effect/witch_fire.png");
    private static final ResourceLocation SLOWNESS = new ResourceLocation("rwapi:textures/mob_effect/witch_slow.png");
    private static final ResourceLocation STRONG_HARMING = new ResourceLocation("rwapi:textures/mob_effect/witch_dark.png");

    private String pname;

    public WitchPotion(String name, boolean isBadPotion, int color, int iconIndeX, int ioncIndexY){
        super(isBadPotion, color);
        ModPotion.POTIONS.add(this);
        setPotionName("effect." + name);
        setIconIndex(iconIndeX,ioncIndexY);
        pname = name;
        setRegistryName(new ResourceLocation(Reference.MODID + ":" + name));
    }

    @Override
    public boolean hasStatusIcon() {
        return super.hasStatusIcon();
    }

    @Override
    public void renderInventoryEffect(PotionEffect effect, Gui gui, int x, int y, float z) {
        if(pname.equals("witch_dark")){
            Minecraft.getMinecraft().getTextureManager().bindTexture(STRONG_HARMING);
            gui.drawModalRectWithCustomSizedTexture(x + 6, y + 7, 0, 0, 18, 18, 18, 18);
        }
        else if (pname.equals("witch_fire")){
            Minecraft.getMinecraft().getTextureManager().bindTexture(fire_resistance);
            gui.drawModalRectWithCustomSizedTexture(x + 6, y + 7, 0, 0, 18, 18, 18, 18);
        }
        else if(pname.equals("witch_ice")){
            Minecraft.getMinecraft().getTextureManager().bindTexture(SLOWNESS);
            gui.drawModalRectWithCustomSizedTexture(x + 6, y + 7, 0, 0, 18, 18, 18, 18);
        }

        //super.renderInventoryEffect(effect, gui, x, y, z);
    }

    @Override
    public void renderHUDEffect(PotionEffect effect, Gui gui, int x, int y, float z, float alpha) {
        //super.renderHUDEffect(effect, gui, x, y, z, alpha);
        if(pname.equals("witch_dark")){
            Minecraft.getMinecraft().getTextureManager().bindTexture(STRONG_HARMING);
            gui.drawModalRectWithCustomSizedTexture(x + 6, y + 7, 0, 0, 18, 18, 18, 18);
        }
        else if (pname.equals("witch_fire")){
            Minecraft.getMinecraft().getTextureManager().bindTexture(fire_resistance);
            gui.drawModalRectWithCustomSizedTexture(x + 6, y + 7, 0, 0, 18, 18, 18, 18);
        }
        else if(pname.equals("witch_ice")){
            Minecraft.getMinecraft().getTextureManager().bindTexture(SLOWNESS);
            gui.drawModalRectWithCustomSizedTexture(x + 6, y + 7, 0, 0, 18, 18, 18, 18);
        }
    }
}
