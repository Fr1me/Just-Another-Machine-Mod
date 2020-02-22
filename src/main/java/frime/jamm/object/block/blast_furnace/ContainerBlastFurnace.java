package frime.jamm.object.block.blast_furnace;

import frime.jamm.object.block.blast_furnace.slot.SlotBlastFurnaceFuel;
import frime.jamm.object.block.blast_furnace.slot.SlotBlastFurnaceOutput;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerBlastFurnace extends Container {
	
	private final IInventory tileFurnace;
	private int cookTime, totalCookTime, furnaceBurnTime, currentItemBurnTime;
	
	public ContainerBlastFurnace(InventoryPlayer playerInventory, IInventory furnaceInventory) {
	this.tileFurnace = furnaceInventory;
		
		this.addSlotToContainer(new Slot(furnaceInventory, 0, 26, 35));
		this.addSlotToContainer(new SlotBlastFurnaceFuel(furnaceInventory, 1, 8, 8));
		this.addSlotToContainer(new SlotBlastFurnaceOutput(playerInventory.player, furnaceInventory, 2, 134, 17));
		this.addSlotToContainer(new SlotBlastFurnaceOutput(playerInventory.player, furnaceInventory, 3, 134, 35));
		this.addSlotToContainer(new SlotBlastFurnaceOutput(playerInventory.player, furnaceInventory, 4, 134, 53));
	
	for(int y = 0; y < 3; y++) {
		for(int x = 0; x < 9; x++) {
			this.addSlotToContainer(new Slot(playerInventory, x + y*9 + 9, 8 + x*18, 84 + y*18));
		}
	}
	
	for(int x = 0; x < 9; x++) {
		this.addSlotToContainer(new Slot(playerInventory, x, 8 + x*18, 142));
		}
	
	}
	
	@Override
	public void addListener(IContainerListener listener) {
		super.addListener(listener);
		listener.sendAllWindowProperties(this, this.tileFurnace);
	}
	
	@Override
	public void detectAndSendChanges() 
	{
		super.detectAndSendChanges();
		
		for(int i = 0; i < this.listeners.size(); ++i) 
		{
			IContainerListener listener = (IContainerListener)this.listeners.get(i);
			
			if(this.cookTime != this.tileFurnace.getField(2)) listener.sendWindowProperty(this, 2, this.tileFurnace.getField(2));
			if(this.furnaceBurnTime != this.tileFurnace.getField(0)) listener.sendWindowProperty(this, 0, this.tileFurnace.getField(0));
			if(this.currentItemBurnTime != this.tileFurnace.getField(1)) listener.sendWindowProperty(this, 1, this.tileFurnace.getField(1));
			if(this.totalCookTime != this.tileFurnace.getField(3)) listener.sendWindowProperty(this, 3, this.tileFurnace.getField(3));
		}
		
		this.cookTime = this.tileFurnace.getField(2);
		this.furnaceBurnTime = this.tileFurnace.getField(0);
		this.currentItemBurnTime = this.tileFurnace.getField(1);
		this.totalCookTime = this.tileFurnace.getField(3);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int id, int data) 
	{
		this.tileFurnace.setField(id, data);
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) 
	{
		return this.tileFurnace.isUsableByPlayer(playerIn);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index == 2) {
                if (!this.mergeItemStack(itemstack1, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (index != 1 && index != 0) {
                if (!BlastFurnaceRecipes.instance().getCookingResult(itemstack1).isEmpty()) {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                }
                else if (TileEntityBlastFurnace.isItemFuel(itemstack1)) {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false)) {
                        return ItemStack.EMPTY;
                    }
                }
                else if (index >= 3 && index < 30) {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false)) {
                        return ItemStack.EMPTY;
                    }
                }
                else if (index >= 30 && index < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)) {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            }
            else {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, itemstack1);
        }

        return itemstack;
    }
}