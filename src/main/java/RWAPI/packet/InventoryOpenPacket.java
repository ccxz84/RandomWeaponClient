package RWAPI.packet;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class InventoryOpenPacket implements IMessage{
	
	public InventoryOpenPacket() {
		
	}
	
	public InventoryOpenPacket(String uuid) {
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
	}
	
	public static class InventoryOpenHandler implements IMessageHandler<InventoryOpenPacket, IMessage> {

		@Override
		public IMessage onMessage(InventoryOpenPacket message, MessageContext ctx) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}
