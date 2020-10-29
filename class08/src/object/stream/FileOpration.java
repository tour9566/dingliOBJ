package object.stream;

import java.io.File;
import java.io.IOException;

public class FileOpration {
    public static void main(String[] args) {
        //1.创建文件路径
        String dir="D:"+ File.separator+"WorkSpaces"+File.separator+"DingLi"+File.separator+"share1"+File.separator;
        String touch="file.txt";
        //2.实例化File对象
        String path=dir+touch;
        //3.创建文件夹
        createDir(dir);
        //4.创建文件
        createFile(path);
    }

    //创建文件
    private static void createFile(String path) {
        File file = new File(path);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            file.delete();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //创建文件夹
    private static File createDir(String dir) {
        File fileDir = new File(dir);
        if(!fileDir.exists()){
            fileDir.mkdir();
        }
        return fileDir;
    }
}
