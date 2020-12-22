package us.tmd.tmd.rendering;

import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;

import java.awt.*;

public class TextRenderUtils {

    public static void renderText(String text, int x, int y, Color color, boolean dropShadow) {
        Minecraft.getMinecraft().fontRendererObj.drawString(text, x, y, ((color != null) ? color.getRGB() : 0), dropShadow);
    }

}
