package idogidog.cityproject.vkgroupbot.bot.commands;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.model.objects.additional.ClientInfo;
import api.longpoll.bots.model.objects.basic.Message;
import idogidog.cityproject.vkgroupbot.tools.CB;
import idogidog.cityproject.vkgroupbot.tools.commands.Command;

import java.io.File;

public class QuestionMaterial extends Command {
    public QuestionMaterial() {
        super("материал", new String[]{"из какого материала", "металлы", "из какого металла", "из каких металлов"});
    }

    @Override
    public void execute(Message message, ClientInfo info) {
        try {
            api.messages.send()
                    .setPeerId(message.getPeerId())
                    .setMessage("Наши изделия сделаны из золота, серебра и платины.\nЕсли вы хотите узнать про какое-то конкретное изделие, то в описании к каждому товару указано, из какого металла создано изделие.\n[см. прикрепленное фото]\n\nПомог ли вам ответ?")
                    .addPhoto(new File("src/main/resources/материал_изделия_белый.png"))
                    .setKeyboard(CB.getKeyboard())
                    .execute();
        } catch (VkApiException e) {
            e.printStackTrace();
        }
    }
}
