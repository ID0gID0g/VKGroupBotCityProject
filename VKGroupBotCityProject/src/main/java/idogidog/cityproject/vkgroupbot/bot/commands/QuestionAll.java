package idogidog.cityproject.vkgroupbot.bot.commands;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.methods.impl.photos.GetMessagesUploadServer;
import api.longpoll.bots.methods.impl.photos.SaveMessagesPhoto;
import api.longpoll.bots.methods.impl.upload.UploadPhoto;
import api.longpoll.bots.model.objects.additional.ClientInfo;
import api.longpoll.bots.model.objects.additional.Template;
import api.longpoll.bots.model.objects.additional.buttons.Button;
import api.longpoll.bots.model.objects.additional.buttons.CallbackButton;
import api.longpoll.bots.model.objects.additional.buttons.TextButton;
import api.longpoll.bots.model.objects.additional.carousel.Carousel;
import api.longpoll.bots.model.objects.additional.carousel.Element;
import api.longpoll.bots.model.objects.basic.Message;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import idogidog.cityproject.vkgroupbot.tools.CB;
import idogidog.cityproject.vkgroupbot.tools.commands.Command;
import java.io.File;
import java.util.Arrays;

public class QuestionAll extends Command {
    public QuestionAll() {
        super("Начать", new String[]{"начать","вопрос","вопросы", "\"вопросы\"", "команды", "помощь", "help", "start", "старт"});
    }

    @Override
    public void execute(Message message, ClientInfo info) {
        if(info.isCarouselAllowed()){
            Button b1 = new CallbackButton(Button.Color.POSITIVE, new CallbackButton.Action("Узнать ответ", JsonParser.parseString("{\"text\": \"вопрос 1\"}")));
            Button b2 = new CallbackButton(Button.Color.POSITIVE, new CallbackButton.Action("Узнать ответ", JsonParser.parseString("{\"text\": \"вопрос 2\"}")));
            Button b3 = new CallbackButton(Button.Color.POSITIVE, new CallbackButton.Action("Узнать ответ", JsonParser.parseString("{\"text\": \"вопрос 3\"}")));
            Button b4 = new CallbackButton(Button.Color.POSITIVE, new CallbackButton.Action("Узнать ответ", JsonParser.parseString("{\"text\": \"вопрос 4\"}")));
            Button b5 = new CallbackButton(Button.Color.POSITIVE, new CallbackButton.Action("Узнать ответ", JsonParser.parseString("{\"text\": \"вопрос 5\"}")));
            Button b6 = new CallbackButton(Button.Color.POSITIVE, new CallbackButton.Action("Узнать ответ", JsonParser.parseString("{\"text\": \"вопрос 6\"}")));
            Button b7 = new CallbackButton(Button.Color.POSITIVE, new CallbackButton.Action("Узнать ответ", JsonParser.parseString("{\"text\": \"вопрос 7\"}")));

            Element el = new Element()
                    .setPhotoId(-206249029, 457239207)
                    .setTitle("Скидки")
                    .setDescription("Узнать, есть ли скидки на данный момент")
                    .setButtons(b1);
            Element el1 = new Element()
                    .setPhotoId(-206249029, 457239206)
                    .setTitle("Рассрочка")
                    .setDescription("Узнать, есть ли возможность взять товар в рассрочку")
                    .setButtons(b2);
            Element el2 = new Element()
                    .setPhotoId(-206249029, 457239205)
                    .setTitle("Посмотреть изделия")
                    .setDescription("Узнать, есть ли возможность посмотреть изделия вживую")
                    .setButtons(b3);
            Element el3 = new Element()
                    .setPhotoId(-206249029, 457239204)
                    .setTitle("Виды изделий")
                    .setDescription("Узнать, какие есть виды изделий")
                    .setButtons(b4);
            Element el4 = new Element()
                    .setPhotoId(-206249029, 457239203)
                    .setTitle("Материаллы")
                    .setDescription("Узнать из каких металлов есть изделия")
                    .setButtons(b5);
            Element el5 = new Element()
                    .setPhotoId(-206249029, 457239201)
                    .setTitle("Размер колца")
                    .setDescription("Узнать, как подобрать размер для кольца")
                    .setButtons(b6);
            Element el6 = new Element()
                    .setPhotoId(-206249029, 457239202)
                    .setTitle("Размер браслета")
                    .setDescription("Узнать, как подобрать размер браслета")
                    .setButtons(b7);

            Template template = new Carousel(Arrays.asList(el, el1, el2, el3, el4, el5, el6));

            try {
                api.messages.send()
                        .setPeerId(message.getPeerId())
                        .setMessage("Вопросы, на которые я могу вам ответить прямо сейчас:")
                        .setTemplate(template)
                        .execute();

            } catch (VkApiException e) {
                e.printStackTrace();
            }
        } else try {
            api.messages.send()
                    .setPeerId(message.getPeerId())
                    .setMessage("Вопросы, на которые я могу сейчас ответить:\n№1 Есть ли скидки?\n№2 Есть ли возможность взять товар в рассрочку?\n№3 Есть ли возможность посмотреть изделие вживую?\n№4 Какие есть виды изделий?\n№5 Из каких металлов сделаны изделия?\n№6 Как узнать размер пальца для выбора кольца?\n№7 Как узнать размер запястья для выбора браслета?")
                    .setKeyboard(CB.getKeyboard2())
                    .execute();
        } catch (VkApiException e) {
            e.printStackTrace();
        }
    }
}
