package idogidog.cityproject.vkgroupbot.tools;

import api.longpoll.bots.model.objects.additional.Keyboard;
import api.longpoll.bots.model.objects.additional.buttons.Button;
import api.longpoll.bots.model.objects.additional.buttons.CallbackButton;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.LinkedList;
import java.util.List;

public class CB {
    public static Keyboard getKeyboard(){
        JsonElement element = JsonParser.parseString("{\"type\": \"show_snackbar\", \"text\": \"да\"}");
        JsonElement element1 = JsonParser.parseString("{\"type\": \"show_snackbar\", \"text\": \"нет\"}");

        List<Button> line = new LinkedList<>();
        List<List<Button>> lines = new LinkedList<>();
        Button b1 = new CallbackButton(Button.Color.POSITIVE, new CallbackButton.Action("Да", element));
        Button b2 = new CallbackButton(Button.Color.NEGATIVE, new CallbackButton.Action("Нет", element1));
        line.add(b1);
        line.add(b2);
        lines.add(line);
        return new Keyboard(lines).setInline(true);
    }
    public static Keyboard getKeyboard2(){
        JsonElement element = JsonParser.parseString("{\"text\": \"вопрос 1\"}");
        JsonElement element1 = JsonParser.parseString("{\"text\": \"вопрос 2\"}");
        JsonElement element2 = JsonParser.parseString("{\"text\": \"вопрос 3\"}");
        JsonElement element3 = JsonParser.parseString("{\"text\": \"вопрос 4\"}");
        JsonElement element4 = JsonParser.parseString("{\"text\": \"вопрос 5\"}");
        JsonElement element5 = JsonParser.parseString("{\"text\": \"вопрос 6\"}");
        JsonElement element6 = JsonParser.parseString("{\"text\": \"вопрос 7\"}");

        List<Button> line = new LinkedList<>();
        List<Button> line2 = new LinkedList<>();

        List<List<Button>> lines = new LinkedList<>();
        Button b1 = new CallbackButton(Button.Color.SECONDARY, new CallbackButton.Action("№1", element));
        Button b2 = new CallbackButton(Button.Color.SECONDARY, new CallbackButton.Action("№2", element1));
        Button b3 = new CallbackButton(Button.Color.SECONDARY, new CallbackButton.Action("№3", element2));
        Button b4 = new CallbackButton(Button.Color.SECONDARY, new CallbackButton.Action("№4", element3));

        Button b5 = new CallbackButton(Button.Color.SECONDARY, new CallbackButton.Action("№5", element4));
        Button b6 = new CallbackButton(Button.Color.SECONDARY, new CallbackButton.Action("№6", element5));
        Button b7 = new CallbackButton(Button.Color.SECONDARY, new CallbackButton.Action("№7", element6));

        line.add(b1);
        line.add(b2);
        line.add(b3);
        line.add(b4);

        line2.add(b5);
        line2.add(b6);
        line2.add(b7);

        lines.add(line);
        lines.add(line2);
        return new Keyboard(lines).setInline(true);
    }
}
