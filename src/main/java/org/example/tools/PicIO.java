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
            int index = rand(son);
            picName = son[index].getName();
            nameList = picName.split("＊");
            image = ImageIO.read(son[index]);
        }
    }
    public int rand(File[] list){
        Random random = new Random();
        int index = random.nextInt(list.length-1);
        String name =list[index].getName();
        int lastIndex=name.lastIndexOf(".")-1;
        String suffix = name.substring(lastIndex);
        if(!suffix.equals("jpg")&&!suffix.equals("png")){
            rand(list);
        }
        return index;
    }
}
