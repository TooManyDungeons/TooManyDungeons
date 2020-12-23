package us.tmd.tmd.events;

import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import us.tmd.tmd.KeyBindings;
import us.tmd.tmd.rendering.TextRenderUtils;

public class OnRenderGameOverlayEventPost {

    private boolean shouldRender;

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    @SideOnly(Side.CLIENT)
    public void onRenderGameOverlayEventPost(RenderGameOverlayEvent.Post event) {
        if(KeyBindings.getBind("menu").isPressed())
            shouldRender = !shouldRender;
        if(shouldRender && event.type == RenderGameOverlayEvent.ElementType.TEXT) TextRenderUtils.renderText(EnumChatFormatting.GREEN + "Hello, World!", 5, 5, true);
    }

}
