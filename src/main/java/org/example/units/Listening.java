package org.example.units;
/**
 * @author shq
 * @date 2022/8/3
 * @deprecated 监听对话，做出反应
 */

import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.ListeningStatus;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.event.events.GroupMessageEvent;

public class Listening extends SimpleListenerHost {
    static String bootAccount = "@392290694";
    //好友信息监听
    @EventHandler
    private ListeningStatus friendListening(FriendMessageEvent event){
        String s = event.getMessage().contentToString();
        return ListeningStatus.LISTENING;
    }
    //群友监听
    private ListeningStatus groupListening(GroupMessageEvent event){
        String s = event.getMessage().contentToString();
        return ListeningStatus.LISTENING;
    }
}
