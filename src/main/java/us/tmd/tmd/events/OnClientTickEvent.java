package us.tmd.tmd.events;

import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;
import us.tmd.tmd.KeyBindings;
import us.tmd.tmd.rendering.TextRenderUtils;

import java.awt.*;


public class OnClientTickEvent {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    @SideOnly(Side.CLIENT)
    public void onClientTickEvent(RenderGameOverlayEvent event) {
        if(Keyboard.isKeyDown(KeyBindings.GUI_KEY)) {
            TextRenderUtils.renderText("Hello, World!", 5, 5, Color.green, true);
        }
    }

}
