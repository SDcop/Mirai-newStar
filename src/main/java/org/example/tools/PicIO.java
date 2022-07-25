package org.example.tools;

import net.mamoe.mirai.message.data.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class PicIO {
    public String path = "C:\\Users\\qin\\Downloads\\pixiv";
    public String picName;
    public String[] nameList;
    public BufferedImage image;
    public void getPic() throws IOException {
        File f = new File(path);
        File[] son = f.listFiles();
        if(son!=null){
            //随机一个数
            Random random = new Random();
            int index = random.nextInt(son.length-1);
            picName = son[index].getName();
            System.out.println(picName);
            nameList = picName.split("＊");
            image = ImageIO.read(son[index]);
            System.out.println("字符长度"+nameList.length);
        }
    }
}
