package idogidog.cityproject.vkgroupbot.bot.commands;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.model.objects.additional.ClientInfo;
import api.longpoll.bots.model.objects.basic.Message;
import idogidog.cityproject.vkgroupbot.tools.commands.Command;

public class Test extends Command {
    public Test() {
        super("bot", new String[]{"бот", "тест","test"});
    }

    @Override
    public void execute(Message message, ClientInfo info) {
        try {
            api.messages.send()
                    .setPeerId(message.getPeerId())
                    .setMessage("Бот исправно работает")
                    .execute();
        } catch (VkApiException e) {
            e.printStackTrace();
        }
    }
}
