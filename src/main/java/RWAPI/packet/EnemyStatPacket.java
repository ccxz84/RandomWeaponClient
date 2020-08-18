package RWAPI.packet;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import RWAPI.main;
import RWAPI.Character.ClientData;
import RWAPI.gui.StatusOverlay;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class EnemyStatPacket implements IMessage{
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
	
	public static class EnemyStatHandler implements IMessageHandler<EnemyStatPacket, IMessage> {

		@Override
		public IMessage onMessage(EnemyStatPacket message, MessageContext ctx) {
			// TODO Auto-generated method stub
			//StatusOverlay.Enemydata = message.data;
			return null;
		}
		
	}
}
