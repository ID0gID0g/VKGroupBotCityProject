package idogidog.cityproject.vkgroupbot.tools;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.model.events.messages.MessageEvent;
import api.longpoll.bots.model.events.messages.MessageNew;
import api.longpoll.bots.model.objects.additional.EventData;
import api.longpoll.bots.model.objects.basic.Message;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import idogidog.cityproject.vkgroupbot.bot.commands.*;
import idogidog.cityproject.vkgroupbot.tools.commands.CommandManager;

public class Seeker extends LongPollBot {
    public static String token;
    public static void setToken(String token) {
        Seeker.token = token;
    }

    @Override
    public void onMessageNew(MessageNew messageNew) {
        CommandManager.setMessage(messageNew.getMessage(), messageNew.getClientInfo());
    }

    @Override
    public void onMessageEvent(MessageEvent messageEvent) {
        Gson gson = new Gson();
        JsonElement element = messageEvent.getPayload();
        Payload payload = gson.fromJson(element, Payload.class);
        if (payload.getText().equals("да")){
            try {
                vk.messages.sendEventAnswer()
                        .setUserId(messageEvent.getUserId())
                        .setPeerId(messageEvent.getPeerId())
                        .setEventId(messageEvent.getEventId())
                        .setEventData(new EventData.ShowSnackbar("Вы нажали на Да!"))
                        .execute();
                vk.messages.edit()
                        .setPeerId(messageEvent.getPeerId())
                        .setConversationMessageId(Integer.parseInt(messageEvent.getConversationMessageId()))
                        .setMessage("Благодарим за отзыв!")
                        .execute();
            } catch (VkApiException e) {
                e.printStackTrace();
            }
        }
        if (payload.getText().equals("нет")){
            try {
                vk.messages.sendEventAnswer()
                        .setUserId(messageEvent.getUserId())
                        .setPeerId(messageEvent.getPeerId())
                        .setEventId(messageEvent.getEventId())
                        .setEventData(new EventData.ShowSnackbar("Вы нажали на Нет!"))
                        .execute();
                vk.messages.edit()
                        .setPeerId(messageEvent.getPeerId())
                        .setConversationMessageId(Integer.parseInt(messageEvent.getConversationMessageId()))
                        .setMessage("Благодарим за отзыв!\nВ скором времени мы проверим данный вопрос и по возможности дополним ответ на него!")
                        .execute();
            } catch (VkApiException e) {
                e.printStackTrace();
            }
        }
        if (payload.getText().equals("вопрос 1")){
            QuestionDiscount q = new QuestionDiscount();
            Message message = new Message();
            message.setPeerId(messageEvent.getPeerId());
            q.execute(message, null);
        }
        if (payload.getText().equals("вопрос 2")){
            QuestionInstallment q = new QuestionInstallment();
            Message message = new Message();
            message.setPeerId(messageEvent.getPeerId());
            q.execute(message, null);
        }
        if (payload.getText().equals("вопрос 3")){
            QuestionFumbleInLive q = new QuestionFumbleInLive();
            Message message = new Message();
            message.setPeerId(messageEvent.getPeerId());
            q.execute(message, null);
        }
        if (payload.getText().equals("вопрос 4")){
            QuestionTypesOfProducts q = new QuestionTypesOfProducts();
            Message message = new Message();
            message.setPeerId(messageEvent.getPeerId());
            q.execute(message, null);
        }
        if (payload.getText().equals("вопрос 5")){
            QuestionMaterial q = new QuestionMaterial();
            Message message = new Message();
            message.setPeerId(messageEvent.getPeerId());
            q.execute(message, null);
        }
        if (payload.getText().equals("вопрос 6")){
            QuestionHowToFindOutTheRingSize q = new QuestionHowToFindOutTheRingSize();
            Message message = new Message();
            message.setPeerId(messageEvent.getPeerId());
            q.execute(message, null);
        }
        if (payload.getText().equals("вопрос 7")){
            QuestionHowToFindOutTheSizeOfTheBracelet q = new QuestionHowToFindOutTheSizeOfTheBracelet();
            Message message = new Message();
            message.setPeerId(messageEvent.getPeerId());
            q.execute(message, null);
        }
    }

    @Override
    public String getAccessToken() {
        return token;
    }
}
