package RWAPI.packet;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ShopPurchasePacket implements IMessage {

    public ShopPurchasePacket(){

    }

    @Override
    public void fromBytes(ByteBuf buf) {

    }

    @Override
    public void toBytes(ByteBuf buf) {
    }

    public static class ShopPurchaseHandler implements IMessageHandler<ShopPurchasePacket,IMessage> {

        @Override
        public IMessage onMessage(ShopPurchasePacket message, MessageContext ctx) {
            return null;
        }
    }
}
