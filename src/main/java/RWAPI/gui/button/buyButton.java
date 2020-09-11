package RWAPI.gui.button;

import RWAPI.main;
import RWAPI.packet.ShopPurchasePacket;
import RWAPI.packet.ShopScrollPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

public class buyButton extends GuiButton{

	public buyButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText) {
		super(buttonId, x, y, widthIn, heightIn, buttonText);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
		// TODO Auto-generated method stub
		super.drawButton(mc, mouseX, mouseY, partialTicks);
	}

	@Override
	public void mouseReleased(int mouseX, int mouseY) {
		if(this.isMouseOver()){
			main.network.sendToServer(new ShopPurchasePacket());

		}
		super.mouseReleased(mouseX, mouseY);
	}
}
