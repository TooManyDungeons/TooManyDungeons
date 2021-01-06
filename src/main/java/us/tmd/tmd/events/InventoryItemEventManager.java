package us.tmd.tmd.events;

import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import us.tmd.tmd.KeyBindings;
import us.tmd.tmd.Utils.ChatUtils;
import us.tmd.tmd.Utils.TextRenderUtils;
import us.tmd.tmd.enums.Rarity;
import us.tmd.tmd.packets.InventoryPacketHandler;

import java.util.ArrayList;
import java.util.List;

public class InventoryItemEventManager {

    public static boolean showPickup = true;
    private final List<String> pickedUp = new ArrayList<String>();
    private final List<String> dropped = new ArrayList<String>();
    private final List<String> unwanted = new ArrayList<String>();
    private final List<String> noDrop = new ArrayList<String>();
    private final List<Rarity> showingRarity = new ArrayList<Rarity>();

    public InventoryItemEventManager() {
        unwanted.add("Rotten Flesh");
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onRenderGameOverlayEventPost(RenderGameOverlayEvent event) {
        if(event.type == RenderGameOverlayEvent.ElementType.TEXT && showPickup) {
            int lastZ = 0;
            for (int i = 0; i < pickedUp.size(); i++) {
                lastZ = (5 * (i * 2)) + 5;
                TextRenderUtils.renderText(EnumChatFormatting.GREEN + "+ " + EnumChatFormatting.WHITE + pickedUp.get(i), 5, lastZ, true);
            }
            for(int i = 0; i < dropped.size(); i++) {
                TextRenderUtils.renderText(EnumChatFormatting.RED + "- " + EnumChatFormatting.WHITE + dropped.get(i), 5, (5 * (i * 2)) + lastZ + ((pickedUp.size() > 0) ? 10 : 5), true);
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onInput(InputEvent event) {
        if(KeyBindings.getBind("pickup").isPressed()) {
            showPickup = !showPickup;
            ChatUtils.logChat((showPickup) ? EnumChatFormatting.GREEN + "Turned on ItemPickupNotification" : EnumChatFormatting.RED + "Turned off ItemPickupNotification");
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onItemPickupEvent(final PlayerEvent.ItemPickupEvent event) {
        new Thread() {
            @Override
            public void run() {
                if(showPickup) {
                    int x = pickedUp.size() + 1;
                    ItemStack itemStack = event.pickedUp.getEntityItem();
                    if(!unwanted.contains(itemStack.getDisplayName())) {
                        String msg = "(" + itemStack + ") " + itemStack.getDisplayName();
                        pickedUp.add(msg);
                        try {
                            Thread.sleep(x * 1000);
                            pickedUp.remove(msg);
                        } catch (Exception ignored) {
                            pickedUp.remove(msg);
                        }
                    } else event.setCanceled(true);
                }
            }
        }.start();
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onItemDropEvent(final ItemTossEvent event) {
        new Thread() {
            @Override
            public void run() {
                if(showPickup) {
                    int x = dropped.size() + 1;
                    ItemStack itemStack = event.entityItem.getEntityItem();
                    if(!noDrop.contains(itemStack.getDisplayName())) {
                        String msg = "(" + itemStack.stackSize + ") " + itemStack.getDisplayName();
                        dropped.add(msg);
                        try {
                            Thread.sleep(x * 1000);
                            dropped.remove(msg);
                        } catch (Exception ignored) {
                            dropped.remove(msg);
                        }
                    } else event.setCanceled(true);
                }
            }
        }.start();
    }



}
