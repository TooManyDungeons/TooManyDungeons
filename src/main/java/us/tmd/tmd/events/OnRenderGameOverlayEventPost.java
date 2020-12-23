package us.tmd.tmd.events;

import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import us.tmd.tmd.rendering.TextRenderUtils;

import java.util.ArrayList;
import java.util.List;

public class OnRenderGameOverlayEventPost {

    private final List<String> showing = new ArrayList<String>();

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    @SideOnly(Side.CLIENT)
    public void onRenderGameOverlayEventPost(RenderGameOverlayEvent.Post event) {
        if(event.type == RenderGameOverlayEvent.ElementType.TEXT)
            for(int i = 0; i < showing.size(); i++)
                TextRenderUtils.renderText(EnumChatFormatting.GREEN + "You picked up: " + EnumChatFormatting.WHITE + showing.get(i), 5, (5 * (i * 2)) + 5, true);
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    @SideOnly(Side.CLIENT)
    public void onItemPickupEvent(final PlayerEvent.ItemPickupEvent event) {
        new Thread() {
            @Override
            public void run() {
                int x = showing.size() + 1;
                showing.add(event.pickedUp.getEntityItem().getDisplayName());
                try {
                    Thread.sleep(x * 1000);
                    showing.remove(showing.size() - 1);
                } catch (Exception ignored) {
                    showing.remove(showing.size() - 1);
                }
            }
        }.start();
    }

}
