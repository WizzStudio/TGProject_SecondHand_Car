package com.tg.test;

import net.coobird.thumbnailator.Thumbnails;
import org.junit.Test;

import java.io.*;
import java.io.IOException;

/**
 * 图片压缩类
 */
public class ImageCompression {

    @Test
    public void testDemo01() throws IOException {
//        Thumbnails.of("target/SecondCar-0.0.1-SNAPSHOT/TG_Photo/c356eae3d43882adf5b041d75ce47089_0.jpg")
//                .size(200, 300)
//                .toFile("target/SecondCar-0.0.1-SNAPSHOT/TG_Photo/1.jpg");
//        Thumbnails.of("target/SecondCar-0.0.1-SNAPSHOT/TG_Photo/c3961f1c20de34daed858eb5247cbeff_2.jpg")
//                .scale(0.5f)
//                .outputQuality(0.5f)
//                .toFile("target/SecondCar-0.0.1-SNAPSHOT/TG_Photo/2.jpg");
        File file = new File("target/SecondCar-0.0.1-SNAPSHOT/TG_Photo/c356eae3d43882adf5b041d75ce47089_1.jpg");
        System.out.println(file.length());
//        Thumbnails.of(file)
//                .scale(0.5f)
//                .outputQuality(0.5f)
//                .toFile(file);
    }
}
