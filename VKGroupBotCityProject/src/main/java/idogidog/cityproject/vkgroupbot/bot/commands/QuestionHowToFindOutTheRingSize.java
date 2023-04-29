package idogidog.cityproject.vkgroupbot.bot.commands;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.model.objects.additional.ClientInfo;
import api.longpoll.bots.model.objects.basic.Message;
import idogidog.cityproject.vkgroupbot.tools.CB;
import idogidog.cityproject.vkgroupbot.tools.commands.Command;

import java.io.File;

public class QuestionHowToFindOutTheRingSize extends Command {
    public QuestionHowToFindOutTheRingSize() {
        super("размер кольца", new String[]{"кольцо", "кольца", "Кольцо", "Кольца"});
    }

    @Override
    public void execute(Message message, ClientInfo info) {
        try {
            api.messages.send()
                    .setPeerId(message.getPeerId())
                    .setMessage("Чтобы узнать подходящий размер кольца, воспользуйтесь прикреплёной памяткой.\nВозьмите нитку, обмотайте её вокруг пальца там, где будет сидеть кольцо. Сделав один оборот, измерьте его длину и соотнесите полученную длину с таблицей.\n[см. прикрепленное фото]\n\nПомог ли вам ответ?")
                    .addPhoto(new File("src/main/resources/размер_кольца.jpg"))
                    .setKeyboard(CB.getKeyboard())
                    .execute();
        } catch (VkApiException e) {
            e.printStackTrace();
        }
    }
}
