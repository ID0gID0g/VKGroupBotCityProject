package idogidog.cityproject.vkgroupbot.bot.commands;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.model.objects.additional.ClientInfo;
import api.longpoll.bots.model.objects.basic.Message;
import idogidog.cityproject.vkgroupbot.tools.CB;
import idogidog.cityproject.vkgroupbot.tools.commands.Command;

public class QuestionTypesOfProducts extends Command {
    public QuestionTypesOfProducts() {
        super("виды", new String[]{"изделия", "виды изделий", "товары", "вид", "товар"});
    }

    @Override
    public void execute(Message message, ClientInfo info) {
        try {
            api.messages.send()
                    .setPeerId(message.getPeerId())
                    .setMessage("У нас есть следующие виды изделий:\nкольца, браслеты, серьги, цепи, подвески, пирсинг.\n\nПомог ли вам ответ?")
                    .setKeyboard(CB.getKeyboard())
                    .execute();
        } catch (VkApiException e) {
            e.printStackTrace();
        }
    }
}
