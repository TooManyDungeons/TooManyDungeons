package us.tmd.tmd.events;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import us.tmd.tmd.KeyBindings;
import us.tmd.tmd.Main;
import us.tmd.tmd.Utils.ChatUtils;
import us.tmd.tmd.Utils.TextRenderUtils;
import us.tmd.tmd.enums.Rarity;

import java.util.ArrayList;
import java.util.List;

public class OnRenderGameOverlayEventPost {

    private boolean showPickup = true;
    private final List<String> showing = new ArrayList<String>();
    private final List<String> unwanted = new ArrayList<String>();
    private final List<Rarity> showingRarity = new ArrayList<Rarity>();

    public OnRenderGameOverlayEventPost() {
        unwanted.add("Rotten Flesh");
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onRenderGameOverlayEventPost(RenderGameOverlayEvent.Post event) {
        if(event.type == RenderGameOverlayEvent.ElementType.TEXT && showPickup)
            for(int i = 0; i < showing.size(); i++) {

                TextRenderUtils.renderText(EnumChatFormatting.GREEN + "You picked up: " + EnumChatFormatting.WHITE + showing.get(i), 5, (5 * (i * 2)) + 5, true);
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
                    int x = showing.size() + 1;
                    ItemStack itemStack = event.pickedUp.getEntityItem();
                    if(!unwanted.contains(itemStack.getDisplayName())) {
                        showing.add(itemStack.getDisplayName());
                        try {
                            Thread.sleep(x * 1000);
                            showing.remove(0);
                        } catch (Exception ignored) {
                            showing.remove(0);
                        }
                    } else event.setCanceled(true);
                }
            }
        }.start();
    }

}
