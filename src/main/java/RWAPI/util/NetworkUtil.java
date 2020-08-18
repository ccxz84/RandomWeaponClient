package RWAPI.util;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

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



}
