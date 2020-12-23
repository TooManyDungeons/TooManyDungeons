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
        sender.addChatMessage(new ChatComponentText("This is the TMD help command!"));

    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

}
