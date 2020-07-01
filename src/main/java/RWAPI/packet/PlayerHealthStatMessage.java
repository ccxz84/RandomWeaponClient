package RWAPI.packet;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.charset.Charset;

import RWAPI.main;
import RWAPI.Character.ClientData;
import RWAPI.gui.StatusOverlay;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/*public class PlayerHealthStatMessage implements IMessage {
	
	private boolean start;
	
	private float MaxHealth;
	private float CurrentHealth;
	private float MaxMana;
	private float CurrentMana;
	private int gold;
	private int level;
	private float expPer;
	private String timerFlag;
	private int timer;
	private int[] Skillset = new int[5];
	
	public PlayerHealthStatMessage() {
		
	}
	
	public PlayerHealthStatMessage(float maxhealth, float currenthealth, float maxmana, float currentmana) {
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
		
		this.start = buf.readBoolean();
		MaxHealth = buf.readFloat();
		CurrentHealth = buf.readFloat();
		MaxMana = buf.readFloat();
		CurrentMana = buf.readFloat();
		gold = buf.readInt();
		level = buf.readInt();
		expPer = buf.readFloat();
		
		this.Skillset[0] = buf.readInt();
		this.Skillset[1] = buf.readInt();
		this.Skillset[2] = buf.readInt();
		this.Skillset[3] = buf.readInt();
		this.Skillset[4] = buf.readInt();

		timer = buf.readInt();
		timerFlag = buf.toString(Charset.defaultCharset());
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
	}
	
	public static class HealthStatusHandler implements IMessageHandler<PlayerHealthStatMessage, IMessage> {

		@Override
		public IMessage onMessage(PlayerHealthStatMessage message, MessageContext ctx) {
			// TODO Auto-generated method stub
			
			StatusOverlay.PlayerMaxHealth = message.MaxHealth;
			StatusOverlay.PlayerCurrentHealth = message.CurrentHealth;
			StatusOverlay.PlayerMaxMana = message.MaxMana;
			StatusOverlay.PlayerCurrentMana = message.CurrentMana;
			StatusOverlay.Gold = message.gold;
			StatusOverlay.level = message.level;
			StatusOverlay.expPer = 0.5;
			main.gameStart = message.start;

			StatusOverlay.skillSet = message.Skillset;
			
			StatusOverlay.timerFlag = message.timerFlag;
			StatusOverlay.timer = message.timer;
			return null;
		}
		
	}

}*/

public class PlayerHealthStatMessage implements IMessage {

	ClientData data;
	
	@Override
	public void fromBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
		int length = buf.readableBytes();
		
		byte[] bs = new byte[length];
		
		for(int i = 0 ;i<length;i++) {
			bs[i] = buf.getByte(i);
		}
		
		ByteArrayInputStream bis = new ByteArrayInputStream(bs);

		try {
			ObjectInputStream ois = new ObjectInputStream(bis);
			this.data = (ClientData)ois.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void toBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
		
	}
	
	public static class HealthStatusHandler implements IMessageHandler<PlayerHealthStatMessage, IMessage> {

		@Override
		public IMessage onMessage(PlayerHealthStatMessage message, MessageContext ctx) {
			// TODO Auto-generated method stub
			main.data = message.data;
			return null;
		}
		
	}
}