package idogidog.cityproject.vkgroupbot.bot.commands;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.model.objects.additional.ClientInfo;
import api.longpoll.bots.model.objects.basic.Message;
import idogidog.cityproject.vkgroupbot.tools.CB;
import idogidog.cityproject.vkgroupbot.tools.commands.Command;

public class QuestionFumbleInLive extends Command {
    public QuestionFumbleInLive() {
        super("посмотреть", new String[]{"потрогать", "пощупать"});
    }

    @Override
    public void execute(Message message, ClientInfo info) {
        try {
            api.messages.send()
                    .setPeerId(message.getPeerId())
                    .setMessage("Вы можете посмотреть изделия в наших магазинах по таким адресам:\nМосква, улица Коминтерна, 15\nМосква, улица Косыгина, 1\n\nПомог ли вам ответ?")
                    .setKeyboard(CB.getKeyboard())
                    .execute();
        } catch (VkApiException e) {
            e.printStackTrace();
        }
    }
}
