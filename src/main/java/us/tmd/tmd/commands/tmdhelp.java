package us.tmd.tmd.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class tmdhelp extends CommandBase {

    @Override
    public String getCommandName() {
        return "tmdhelp";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return null;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
            sender.addChatMessage(new ChatComponentText("Help for TMD."));
            sender.addChatMessage(new ChatComponentText("/tmdhelp:"));
            sender.addChatMessage(new ChatComponentText("This is the command to show this message!"));
            sender.addChatMessage(new ChatComponentText(""));
            sender.addChatMessage(new ChatComponentText("M* or /tmd:"));
            sender.addChatMessage(new ChatComponentText("Open the main GUI."));
            sender.addChatMessage(new ChatComponentText(""));
            sender.addChatMessage(new ChatComponentText("*: Main keybind - you can change this in your controls"));
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

}
