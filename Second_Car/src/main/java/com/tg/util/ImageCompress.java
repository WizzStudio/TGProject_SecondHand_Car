package com.tg.util;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.IOException;

public class ImageCompress {

    private static double SCALE = 0.5f;
    private  static double QUALITY = 0.5f;
    //图片压缩
    public static File compress(File originFile){
            File destFile = new File(originFile.getName());
            if(originFile.length()>30720)   //如果图片大小超过30k，就压缩图片
            {
                try {
                    Thumbnails.of(originFile)
                            .scale(SCALE)
                            .outputQuality(QUALITY)
                            .toFile(destFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                return originFile;
            }
        return destFile;
    }
}
