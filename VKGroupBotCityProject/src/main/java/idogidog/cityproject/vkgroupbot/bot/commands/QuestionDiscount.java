package idogidog.cityproject.vkgroupbot.bot.commands;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.model.objects.additional.ClientInfo;
import api.longpoll.bots.model.objects.basic.Message;
import idogidog.cityproject.vkgroupbot.tools.CB;
import idogidog.cityproject.vkgroupbot.tools.commands.Command;

public class QuestionDiscount extends Command {
    public QuestionDiscount() {
        super("скидки", new String[]{"скидка", "скидок"});
    }

    @Override
    public void execute(Message message, ClientInfo info) {
        try {
            api.messages.send()
                    .setPeerId(message.getPeerId())
                    .setMessage("На данный момент нет действующих скидок.\n\nПомог ли вам ответ?")
                    .setKeyboard(CB.getKeyboard())
                    .execute();
        } catch (VkApiException e) {
            e.printStackTrace();
        }
    }
}
