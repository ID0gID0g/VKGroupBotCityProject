package idogidog.cityproject.vkgroupbot.tools.commands;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.model.objects.additional.ClientInfo;
import api.longpoll.bots.model.objects.basic.Message;
import idogidog.cityproject.vkgroupbot.bot.commands.Default;

public class CommandManager {
    private static Message message;
    private static ClientInfo clientInfo;
    private static String commandName;

    public static void setMessage(Message message) {
        CommandManager.message = message;
        messageToCommand(message);
    }

    public static void setMessage(Message message, ClientInfo info) {
        CommandManager.message = message;
        CommandManager.clientInfo = info;
        messageToCommand(message);
    }
    public static void messageToCommand(Message message){
        commandName = message.getText().split(" ")[0];
        execute();
    }

    public static void execute(){
        CommandRegistry cmdr = new CommandRegistry();
        Command cmd = cmdr.getCommand(commandName.toLowerCase());
        if (cmd != null & clientInfo != null) cmd.execute(message, clientInfo);
        else new Default().execute(message, clientInfo);
    }
}
