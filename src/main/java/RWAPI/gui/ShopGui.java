package RWAPI.gui;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import RWAPI.main;
import RWAPI.packet.ShopScrollPacket;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.inventory.*;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketSetSlot;
import net.minecraft.util.NonNullList;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import RWAPI.gui.button.buyButton;
import RWAPI.init.ModItems;
import RWAPI.items.gameItem.ItemBase;
import RWAPI.items.inventory.Inventory;
import RWAPI.items.inventory.ItemButton;
import RWAPI.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ShopGui extends GuiContainer{
	private static final ResourceLocation base_gui = new ResourceLocation(Reference.MODID + ":textures/gui/shop.png");
	ShopUI inv;
	
	public ShopGui(Container inventorySlotsIn) {
		super(inventorySlotsIn);
		inv = (ShopUI) inventorySlotsIn;
		// TODO Auto-generated constructor stub
		this.mc = Minecraft.getMinecraft();
		this.xSize = 256; 
        this.ySize = 233; 
        this.guiLeft += 30;
	}

	@Override
	public void initGui() {
		super.initGui();
		((ShopUI) this.inventorySlots).addShopGui(this);

	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		// TODO Auto-generated method stub
		GL11.glColor4f(1, 1, 1, 1);
		this.mc.renderEngine.bindTexture(base_gui);
		drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		GL11.glColor4f(1, 1, 1, 1);
		this.mc.renderEngine.bindTexture(base_gui);
		drawTexturedModalRect(this.guiLeft + 121, this.guiTop + 15 + ((75/inv.scrollMax)*inv.scroll), 244, 239, 12, 17);
		if(this.inventorySlots.inventoryItemStacks.size()>66&&!this.inventorySlots.inventoryItemStacks.get(66).equals(ItemStack.EMPTY)){
			ItemStack stack = this.inventorySlots.inventoryItemStacks.get(66);
			NBTTagCompound nbt = stack.getTagCompound();
			if(nbt != null){
				drawText(((ItemBase)stack.getItem()).name, this.guiLeft + 163 - (((ItemBase)stack.getItem()).name.length()),this.guiTop + 95, 0xffffff, 1);
				drawText( nbt.getInteger("remaingold")+ " Gold", this.guiLeft + 163 - (((ItemBase)stack.getItem()).name.length()),this.guiTop + 105, 0xffffff, 1);
			}
		}

		//drawTexturedModalRect(this.guiLeft + 121, this.guiTop + 15, 244, 239, 12, 17);
	}
	
	@Override
	public void handleMouseInput() throws IOException {	
		super.handleMouseInput();
		int wheelState = Mouse.getEventDWheel();
		if (wheelState != 0) {
			inv.scroll += wheelState > 0 ? -1 : 1;
			handleScrollPos();
			inv.scrollTo(inv.scroll);
		}
	}
	
	private void handleScrollPos(){
		if(inv.scroll < 0)
			inv.scroll = 0;
		else if(inv.scroll > inv.scrollMax)
			inv.scroll = inv.scrollMax;
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		// TODO Auto-generated method stub
		super.drawScreen(mouseX, mouseY, partialTicks);
		renderHoveredToolTip(mouseX,mouseY);
		this.inventorySlots.detectAndSendChanges();

	}

	private void Createbutton(ItemStack stack) {
		
		buyButton button = new buyButton(1,guiLeft+223,guiTop + 95,30,20,"구매");
		this.addButton(button);

		int x = inv.inventorySlots.size();
		for(int i =66;i<x;i++) {
			inv.inventorySlots.remove(inv.inventorySlots.get(66));
			
		}
		DrawButton(stack,ModItems.ITEMS.get(ModItems.ITEMS.indexOf(stack.getItem())).down_item,187,18,ModItems.ITEMS.get(ModItems.ITEMS.indexOf(stack.getItem())).phase);
		inv.addSlotToContainer(new Slot(new ItemButton(stack),0,137,97));
	}
	
	private void DrawButton(ItemStack stack, ItemBase[] down_item, int x, int y,int phase) {
		inv.addSlotToContainer(new Slot(new ItemButton(stack),0,x,y));
		
		if(phase == 1) {
			for(int i = 0; i < down_item.length; i++) {
				if(i == 0) {
					DrawButton(new ItemStack(down_item[i]),down_item[i].down_item,x-40,y+20,down_item[i].phase);
				}
				else if(i == 1) {

					DrawButton(new ItemStack(down_item[i]),down_item[i].down_item,x+40,y+20,down_item[i].phase);
				}
				else if(i == 2) {
					DrawButton(new ItemStack(down_item[i]),down_item[i].down_item,x,y+20,down_item[i].phase);
				}
				
			}
		}
		
		if(phase == 2) {
			if(down_item.length== 2) {
				for(int i = 0; i < down_item.length; i++) {
					DrawButton(new ItemStack(down_item[i]),down_item[i].down_item,x-10+i*20,y+20,down_item[i].phase);
				}
			}
			else if(down_item.length == 3) {
				for(int i = 0; i < down_item.length; i++) {
					DrawButton(new ItemStack(down_item[i]),down_item[i].down_item,x-40+i*40,y+20,down_item[i].phase);
				}
			}
			else if(down_item.length == 1) {
				for(int i = 0; i < down_item.length; i++) {
					DrawButton(new ItemStack(down_item[i]),down_item[i].down_item,x,y+20,down_item[i].phase);
				}
			}
			else if(down_item.length == 0) {
				return;
			}
		}
	}

	private void drawText(String text, int x, int y, int hexColor , float size) {
		GL11.glScalef(size,size,size);
		float mSize = (float)Math.pow(size,-1);
		this.mc.fontRenderer.drawString(text, Math.round(x / size),Math.round(y / size), hexColor);
		GL11.glScalef(mSize,mSize,mSize);
	}
	
	
	@SideOnly(Side.CLIENT)
	public static class ShopUI extends Container implements IContainerListener{
		public int scroll = 0;
		public int scrollMax = ModItems.ITEMS.size()- 30 <= 0 ? 0:((ModItems.ITEMS.size()-30)/6)+1;
		private Inventory inven;
		private ShopGui gui;
		
		public ShopUI(InventoryPlayer playerInv) {
			inven = new Inventory();

			// Player Inventory, Slot 9-35, Slot IDs 9-35
			for (int y = 0; y < 5; ++y) {
				for (int x = 0; x < 6; ++x) {
					this.addSlotToContainer(new Slot(inven, x + y * 6, 8 + x * 18, 18+y * 18));
				}
			}



			// Player Inventory, Slot 0-8, Slot IDs 36-44

			for (int y = 0; y < 3; ++y) {
				for (int x = 0; x < 9; ++x) {
					this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 121+y * 18));
				}
			}

			for (int x = 0; x < 9; ++x) {
				this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 179));
			}

		    //this.addSlotToContainer(new Slot(new ItemButton(ItemStack.EMPTY),0,190,18));
		    scrollTo(0);
			this.addListener(this);
		}

		
		@Override
		public Slot addSlotToContainer(Slot slotIn) {
			// TODO Auto-generated method stub
			return super.addSlotToContainer(slotIn);
		}



		public void scrollTo(int pos)
	    {
	        this.scroll = pos;
	        //inven.setLowerLimit(scroll * 6);
			main.network.sendToServer(new ShopScrollPacket(pos,this.windowId));
	    }
		
		@Override
		public boolean canInteractWith(EntityPlayer playerIn) {
			// TODO Auto-generated method stub
			return this.inven.isUsableByPlayer(playerIn);
		}
		
		

		@Override
		public ItemStack slotClick(int slotId, int dragType, ClickType clickTypeIn, EntityPlayer player) {
			// TODO Auto-generated method stub
			
			if(slotId<30) {
				
				if(dragType==1) {//right click
					
				}
				if(dragType==0) {//left click
					ItemStack stack = inven.getStackInSlot(slotId);
					
					if(stack == null || stack.equals(ItemStack.EMPTY)) {
						return ItemStack.EMPTY;
					}
					
					gui.Createbutton(stack);
				}
				
				return ItemStack.EMPTY;
			}

			if(slotId == 30 || slotId == 57)
				return ItemStack.EMPTY;
			
			if(slotId > 65) {
				if(dragType==0) {//left click
					ItemStack stack = this.getSlot(slotId).getStack();
					
					if(stack == null || stack.equals(ItemStack.EMPTY)) {
						System.out.println("test");
						return ItemStack.EMPTY;
					}
					
					gui.Createbutton(stack);
				}
				return ItemStack.EMPTY;
			}
			
			System.out.println("Slot ID : "+slotId + " Click Type  : " + clickTypeIn + " DragType : " + dragType);
			return super.slotClick(slotId, dragType, clickTypeIn, player);
		}



		public ShopGui addShopGui(ShopGui instance) {
			gui = instance;
			return gui;
		}

		public ShopGui getShopGui(){
			return gui;
		}


		@Override
		public void detectAndSendChanges() {
			super.detectAndSendChanges();
		}

		@Override
		public void addListener(IContainerListener listener) {
			super.addListener(listener);
		}

		@Override
		public void sendAllContents(Container containerToSend, NonNullList<ItemStack> itemsList) {

		}

		@Override
		public void sendSlotContents(Container containerToSend, int slotInd, ItemStack stack) {

		}

		@Override
		public void sendWindowProperty(Container containerIn, int varToUpdate, int newValue) {
		}

		@Override
		public void sendAllWindowProperties(Container containerIn, IInventory inventory) {
		}
	}
}
