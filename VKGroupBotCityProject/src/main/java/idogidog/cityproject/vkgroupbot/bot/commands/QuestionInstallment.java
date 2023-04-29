package idogidog.cityproject.vkgroupbot.bot.commands;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.model.objects.additional.ClientInfo;
import api.longpoll.bots.model.objects.basic.Message;
import idogidog.cityproject.vkgroupbot.tools.CB;
import idogidog.cityproject.vkgroupbot.tools.commands.Command;

import java.io.File;

public class QuestionInstallment extends Command {
    public QuestionInstallment() {
        super("рассрочка", new String[]{"кредит"});
    }

    @Override
    public void execute(Message message, ClientInfo info) {
        try {
            api.messages.send()
                    .setPeerId(message.getPeerId())
                    .setMessage("Можно ли взять товар в рассрочку указано в описании товара.\n[см. прикрепленное фото]\n\nПомог ли вам ответ?")
                    .addPhoto(new File("src/main/resources/товар_в_рассрочку_белый.png"))
                    .setKeyboard(CB.getKeyboard())
                    .execute();
        } catch (VkApiException e) {
            e.printStackTrace();
        }
    }
}
