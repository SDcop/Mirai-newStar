package org.example;

import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.utils.BotConfiguration;

public class CreateBot {
    public void Create(){
        Bot bot = BotFactory.INSTANCE.newBot(392290694, "*",new BotConfiguration(){{
            fileBasedDeviceInfo();
            setHeartbeatStrategy(HeartbeatStrategy.STAT_HB);//心跳策略
        }});
        bot.login();
    }
}
