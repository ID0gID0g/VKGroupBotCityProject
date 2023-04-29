package idogidog.cityproject.vkgroupbot.tools.commands;

import api.longpoll.bots.methods.VkBotsMethods;
import api.longpoll.bots.model.objects.additional.ClientInfo;
import api.longpoll.bots.model.objects.basic.Message;
import idogidog.cityproject.vkgroupbot.tools.Seeker;

public abstract class Command {
    public final String commandName;
    public final String[] aliases;
    public final VkBotsMethods api = new VkBotsMethods(Seeker.token);

    public Command(String commandName, String[] aliases) {
        this.commandName = commandName.toLowerCase();

        String[] result = new String[aliases.length + 1];
        result[0] = commandName;
        System.arraycopy(aliases, 0, result, 1, aliases.length);

        this.aliases = result;
    }

    public String[] getAliases(){
        return aliases;
    }

    public abstract void execute(Message message, ClientInfo info);
}
