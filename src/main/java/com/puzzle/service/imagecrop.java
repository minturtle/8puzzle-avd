package com.puzzle.service;


import com.puzzle.gui.GamePlayView;
import com.puzzle.gui.MainFrame;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;

public class imagecrop {

    public static BufferedImage[] SaveImage(int mapsize, BufferedImage originalImage) throws IOException {
        BufferedImage resizeImage = imagecrop.imageResize(originalImage);

        BufferedImage croppedImage[] = new BufferedImage[mapsize*mapsize-1];
        Rectangle rectSize = new Rectangle(500/mapsize, 500/mapsize);
        for(int i = 0; i < mapsize; i++) {
            for (int j = 0; j < mapsize; j++) {
                if (i * mapsize + j < mapsize * mapsize - 1) { //빈 블록의 이미지는 남기지 않는다
                    croppedImage[i*mapsize + j] = cropImage(mapsize, resizeImage, rectSize, i, j);
                }
            }
        }
        return croppedImage;
    } //저장된 이미지 배열 반환
    
    public static BufferedImage cropImage(int mapsize, BufferedImage src, Rectangle rect, int i, int j) {
        int x = 500/mapsize*(j/mapsize)+(500/(mapsize*2)); //자르는 x 좌표의 위치
        int y = 500/mapsize*(i/mapsize)+(500/(mapsize*2)); //자르는 y 좌표의 위치
        BufferedImage dest = src.getSubimage(x, y, rect.width, rect.height);
        return dest;
    } //이미지 자르기

    public static BufferedImage imageResize(BufferedImage originalImage) {
        int w = 500;
        int h = 500;
        BufferedImage newImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        return newImage;
    } //이미지 크기 조정
}
