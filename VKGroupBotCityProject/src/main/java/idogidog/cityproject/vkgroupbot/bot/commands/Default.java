package idogidog.cityproject.vkgroupbot.bot.commands;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.model.objects.additional.ClientInfo;
import api.longpoll.bots.model.objects.basic.Message;
import idogidog.cityproject.vkgroupbot.tools.commands.Command;

public class Default extends Command {
    public Default() {
        super("", new String[]{});
    }
    @Override
    public void execute(Message message, ClientInfo info) {
        try {
            api.messages.send()
                    .setPeerId(message.getPeerId())
                    .setMessage("Воспользуйтесь командой \"вопросы\" для начала работы с ботом.")
                    .execute();
        } catch (VkApiException e) {
            e.printStackTrace();
        }
    }
}
