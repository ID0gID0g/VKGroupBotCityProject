package idogidog.cityproject.vkgroupbot.bot;

import idogidog.cityproject.vkgroupbot.tools.Seeker;

public class Bot {
    public Bot(String token){
        Seeker.setToken(token);
        try {
            new Seeker().startPolling();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
