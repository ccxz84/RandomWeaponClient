package RWAPI.event;

import org.lwjgl.input.Keyboard;

import RWAPI.main;
import RWAPI.init.handler.GuiHandler;
import RWAPI.packet.KeyInputPacket;
import RWAPI.proxy.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleDragonBreath;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SkillKeyEvent {
	
	private Minecraft mc;
	
	public SkillKeyEvent() {
		mc = Minecraft.getMinecraft();
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onEvent(KeyInputEvent event)
	{
		GameSettings gs = mc.gameSettings;
	    // DEBUG	
	    // make local copy of key binding array
	    KeyBinding[] keyBindings = ClientProxy.keyBindings;
	   
	    // check each enumerated key binding type for pressed and take appropriate action
	    if (keyBindings[0].isPressed()) //skill1
	    {
	        // DEBUG
	        main.network.sendToServer(new KeyInputPacket(Keyboard.KEY_Z));
	        // do stuff for this key binding here
	        // remember you may need to send packet to server
	    }
	    if (keyBindings[1].isPressed()) //skill2
	    {
	        // DEBUG
	    	 main.network.sendToServer(new KeyInputPacket(Keyboard.KEY_X));
	        // do stuff for this key binding here
	        // remember you may need to send packet to server
	    }
	    if (keyBindings[2].isPressed()) //skill3
	    {
	        // DEBUG
	    	EntityPlayer player = Minecraft.getMinecraft().player;
	    	//player.world.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, player.posX, player.posY, player.posZ, 0, 0, 0, null);
	    	//Minecraft.getMinecraft().effectRenderer.addEffect(new ParticleDragonBreath(player.world,player.posX,player.posY,player.posZ,0,0,0));
	    	main.network.sendToServer(new KeyInputPacket(Keyboard.KEY_C));
	        // do stuff for this key binding here
	        // remember you may need to send packet to server
	    }
	    if (keyBindings[4].isPressed()) //skill4
	    {
	        // DEBUG
	    	main.network.sendToServer(new KeyInputPacket(Keyboard.KEY_V));
	        // do stuff for this key binding here
	        // remember you may need to send packet to server
	    }

		if (keyBindings[3].isPressed()) //skill4
		{
			// DEBUG
			main.network.sendToServer(new KeyInputPacket(Keyboard.KEY_B));
			// do stuff for this key binding here
			// remember you may need to send packet to server
		}

		if (keyBindings[5].isPressed()) //skill4
		{
			// DEBUG
			System.out.println("information");
			main.network.sendToServer(new KeyInputPacket(Keyboard.KEY_G));
			// do stuff for this key binding here
			// remember you may need to send packet to server
		}
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void mouse(InputEvent.MouseInputEvent event)
	{
		GameSettings gs = mc.gameSettings;
		RayTraceResult rs = mc.objectMouseOver;
        if (gs.keyBindAttack.isPressed()) // add your additional conditions here
        {
            float data = mc.player.getCooledAttackStrength(0.0F);
	    	if(data >= 1){
	    		
	    		switch (rs.typeOfHit)
                {
                    case ENTITY:
                    	mc.playerController.attackEntity(mc.player, rs.entityHit);
                        break;
                    case BLOCK:
                       

                    case MISS:

                    	mc.player.resetCooldown();
                        net.minecraftforge.common.ForgeHooks.onEmptyLeftClick(mc.player);
                }
	    		
	    		mc.player.swingArm(EnumHand.MAIN_HAND);
	    	}else {
	    		//System.out.println("cool : " + mc.player.getCooledAttackStrength(0.0F));
	    	}
        }
	}
}
