package idogidog.cityproject.vkgroupbot.tools.commands;

import idogidog.cityproject.vkgroupbot.bot.commands.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandRegistry {
    private final Map<String, Command> commands = new HashMap<>();
    public void registry(Command command){
        this.commands.put(command.commandName, command);
    }

    public CommandRegistry(){
        this.registry(new QuestionAll());
        this.registry(new Test());
        this.registry(new QuestionDiscount());
        this.registry(new QuestionInstallment());
        this.registry(new QuestionFumbleInLive());
        this.registry(new QuestionTypesOfProducts());
        this.registry(new QuestionMaterial());
        this.registry(new QuestionHowToFindOutTheRingSize());
        this.registry(new QuestionHowToFindOutTheSizeOfTheBracelet());
    }

    public Command getCommand(String nameOrAliases){
        var command = this.commands.get(nameOrAliases);
        if (command == null){
            for (Command target : this.commands.values()){
                if (List.of(target.getAliases()).contains(nameOrAliases)){
                    command = target;
                }
            }
        }
        return command;
    }
}
