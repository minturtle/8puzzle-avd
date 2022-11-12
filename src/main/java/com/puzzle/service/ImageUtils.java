package com.puzzle.service;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;

public class ImageUtils {

    public final static String ORIGINAL_IMAGE_PATH = "images/samples/";
    public final static String SPLITED_IMAGE_PATH = "images/splited/";


    // nxn 사이즈로 잘라 저장한 지정 폴더에 저장한 후, 파일 이름들을 리턴한다.
    public static BufferedImage[] sliceImage(String imageName, int n){
        try{
            final BufferedImage bimg = ImageIO.read(new File(ORIGINAL_IMAGE_PATH + imageName));

            int slicedWidth = bimg.getWidth() / n;
            int slicedHeight = bimg.getHeight() / n;

            BufferedImage[] images = new BufferedImage[n * n];

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    images[i * n + j] = bimg.getSubimage(j * slicedWidth ,i * slicedHeight ,slicedWidth, slicedHeight);
                }
            }

            return images;
        }catch (IOException e){ e.printStackTrace();}
        return null;
    }


}
