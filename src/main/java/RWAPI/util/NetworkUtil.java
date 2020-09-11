package RWAPI.util;

import RWAPI.Character.ClientData;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class NetworkUtil {
    public static Object receive(String key){
        EntityPlayer player = Minecraft.getMinecraft().player;
        Object ob = null;
        if(player.inventory.getStackInSlot(9).getTagCompound() != null) {
            NBTTagCompound nbt = player.inventory.getStackInSlot(9).getTagCompound();
            byte[] bs = nbt.getByteArray(key);

            if (bs.length != 0) {
                ByteArrayInputStream bis = new ByteArrayInputStream(bs);
                try {
                    ObjectInputStream ois = new ObjectInputStream(bis);
                    ob = ois.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return ob;
     }

     public static double receiveItemCool(int idx){
         EntityPlayer player = Minecraft.getMinecraft().player;
         double cool = 0;
         if(player.inventory.getStackInSlot(idx).getTagCompound() != null) {
             NBTTagCompound nbt = player.inventory.getStackInSlot(idx).getTagCompound();
             cool = nbt.getDouble("cool");
         }
         return cool;
     }


}
