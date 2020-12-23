package us.tmd.tmd.Utils;

import net.minecraft.client.Minecraft;

public class TextRenderUtils {

    public static void renderText(String text, int x, int y, boolean dropShadow) {
        Minecraft.getMinecraft().fontRendererObj.drawString(text, x, y, 0, dropShadow);
    }

}
