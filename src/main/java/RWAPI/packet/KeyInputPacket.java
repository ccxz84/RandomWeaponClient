package RWAPI.packet;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class KeyInputPacket implements IMessage {
	
	private int keynum;
	
	

	public KeyInputPacket() {
		
	}

	public KeyInputPacket(int keynum) {
		this.keynum = keynum;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
		buf.writeInt(keynum);
	}
	
	public static class KeyInputHandler implements IMessageHandler<KeyInputPacket, IMessage> {

		@Override
		public IMessage onMessage(KeyInputPacket message, MessageContext ctx) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}
