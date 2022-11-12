package com.puzzle;

import com.puzzle.gui.MainFrame;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.File;
import com.puzzle.service.imagecrop;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


import java.awt.*;

@SpringBootApplication
public class PuzzleApplication {

	public static void main(String[] args) throws IOException {

		//이미지 테스트 시작
		BufferedImage image = ImageIO.read(new File("images/samples/test-image1.png"));
		BufferedImage imagearray[] = new BufferedImage[8];;
		imagearray = imagecrop.SaveImage(3, image);

		for(int i = 0; i < 8; i++) { //이미지 저장
			ImageIO.write(imagearray[i], "png", new File("testimage/"+Integer.toString(i)+"testimage.png"));
		}
		//이미지 테스트 끝


		ApplicationContext builder = new SpringApplicationBuilder(PuzzleApplication.class)
				.headless(false).run(args);
	}

	@Bean
	public CommandLineRunner startGUI(MainFrame mainFrame) {
		return args -> {
			mainFrame.setVisible(true);
		};
	}

}
