package RWAPI.packet;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ShopScrollPacket implements IMessage {

    int num, windowid;

    public ShopScrollPacket(){

    }

    public ShopScrollPacket(int num, int windowid){
        this.num = num;
        this.windowid = windowid;
    }
    @Override
    public void fromBytes(ByteBuf buf) {

    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(num);
        buf.writeInt(windowid);
    }

    public static class ShopScrollHandler implements IMessageHandler<ShopScrollPacket,IMessage> {

        @Override
        public IMessage onMessage(ShopScrollPacket message, MessageContext ctx) {
            return null;
        }
    }
}
