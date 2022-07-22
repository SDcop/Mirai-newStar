package org.example;

import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.Listener;
import net.mamoe.mirai.event.ListeningStatus;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.FriendMessageEvent;

public class FirstModule extends SimpleListenerHost {
    @EventHandler
    private ListeningStatus onEvent(FriendMessageEvent event){
        String s = event.getMessage().contentToString();
        if(s.equals("hi")){
            event.getSender().sendMessage("hello!");
        }
        return ListeningStatus.LISTENING;
    }
}
