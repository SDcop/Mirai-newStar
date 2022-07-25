/*
 * @Author:shq
 * @UpdateDate:2022/07/23
 * @Title: 机器人行为组件
 */
package org.example;
import net.mamoe.mirai.contact.Contact;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.ListeningStatus;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.*;
import net.mamoe.mirai.message.data.Image;
import net.mamoe.mirai.message.data.PlainText;
import org.example.tools.PicIO;

import java.io.*;
import java.util.Base64;
import java.util.Locale;

public class FirstModule extends SimpleListenerHost {
    //bot被@时的qq
    private final String botAccount = "@392290694";
    /**对好友说你好*/
    @EventHandler
    private ListeningStatus sayHello(FriendMessageEvent event){
        String s = event.getMessage().contentToString();
        if(compare(s.trim())){
            event.getSender().sendMessage("你好，很高兴见到你");
        }
        return ListeningStatus.LISTENING;
    }
    /**
     *被AT时对群友事件
     */
    @EventHandler
    private ListeningStatus sayHelloToMembers(GroupMessageEvent event) throws IOException {
        String s = event.getMessage().contentToString();
        String sender = event.getSenderName().toString();
        System.out.println(s);
        if(!s.contains(botAccount)){
            return ListeningStatus.LISTENING;
        }
        s = s.replace(botAccount,"");
        s = s.trim();
        System.out.println("changed="+s);
        //说hello
        if(compare(s.trim())){
            event.getSubject().sendMessage("你好，很高兴见到你");
        }
        //发图
        if(s.equals("来点涩图")||s.equals("来点色图")||s.equals("ldst")){
            event.getSubject().sendMessage("不行！不可以瑟瑟哦！");
        }else if(s.equals("来点图图")){
            PicIO picIO = new PicIO();
            picIO.getPic();
            String path = picIO.path;
            String picName = picIO.picName;
            String[] nameList = picIO.nameList;
            File f = new File(path+"\\"+picName);
            Image image = Contact.uploadImage(event.getSubject(),f);
            String msg ="作品id:"+nameList[0].replace("_p0","")+"\n"+"作者id:"+nameList[1]+"\n"+"作者名:"+nameList[2]+"\n"+"如果喜欢就去pixiv关注画师吧";
            event.getSubject().sendMessage(new PlainText(msg).plus(image));
        }
        return ListeningStatus.LISTENING;
    }
    /**
     *被邀请进群时
     */
//    @EventHandler
//    private ListeningStatus beIvToGroup(BotInvitedJoinGroupRequestEvent in){
//    }
    /**
     * 群成员临时会话
     */
    @EventHandler
    private ListeningStatus tempMessageEvent(GroupTempMessageEvent event){
        String s = event.getMessage().contentToString();
        event.getSender().sendMessage("呃呃");
        return ListeningStatus.LISTENING;
    }

    /**
     *字符串对比方法
     */
    public boolean compare(String obj) {
        String[] strings = {"hello","hi","你好"};
        String str = obj.toLowerCase(Locale.ROOT);
        for(String t : strings){
            if(obj.equals(t)){
                return true;
            }
        }
        return false;
    }
}
