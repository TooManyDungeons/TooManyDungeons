package us.tmd.tmd.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import org.lwjgl.input.Keyboard;
import us.tmd.tmd.KeyBindings;
import us.tmd.tmd.Utils.ChatUtils;

public class HelpCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "tmdhelp";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return null;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        int page = Integer.parseInt(args.length > 0 ? args[0] : "1");
        int pages = 1;
        switch(page) {
                case 1:
                    ChatUtils.logChat("Showing help for TMD. (Page 1 of " + pages + ")");
                    ChatUtils.logChat("Command: /tmdhelp");
                    ChatUtils.logChat("Description: Display the help message");
                    ChatUtils.logChat("");
                    ChatUtils.logChat("Use the \"" + Keyboard.getKeyName(KeyBindings.getBind("menu").getKeyCode()) + "\" keybind or the \"/tmd\" command to open the main gui");
                    break;
                case 2:
                    ChatUtils.logChat("Fuck you");
                    break;
            }
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

}
