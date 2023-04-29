package idogidog.cityproject.vkgroupbot.bot.commands;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.model.objects.additional.ClientInfo;
import api.longpoll.bots.model.objects.basic.Message;
import idogidog.cityproject.vkgroupbot.tools.CB;
import idogidog.cityproject.vkgroupbot.tools.commands.Command;

import java.io.File;

public class QuestionHowToFindOutTheSizeOfTheBracelet extends Command {
    public QuestionHowToFindOutTheSizeOfTheBracelet() {
        super("размер браслета", new String[]{"браслет", "Браслет", "Браслеты", "браслеты"});
    }

    @Override
    public void execute(Message message, ClientInfo info) {
        try {
            api.messages.send()
                    .setPeerId(message.getPeerId())
                    .setMessage("Чтобы узнать подходящий размер браслета, воспользуйтесь прикреплённой памяткой.\nВозьмите нитку, обмотайте её вокруг запястья там, где будет сидеть браслет. Сделав один оборот, измерьте его длину и соотнесите полученную длину с таблицей.\n[см. прикрепленное фото]\n\nПомог ли вам ответ?")
                    .addPhoto(new File("src/main/resources/размер_браслета.jpg"))
                    .setKeyboard(CB.getKeyboard())
                    .execute();
        } catch (VkApiException e) {
            e.printStackTrace();
        }
    }
}
