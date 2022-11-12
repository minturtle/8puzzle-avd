package com.puzzle;

import com.puzzle.gui.MainFrame;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.File;
import com.puzzle.service.ImageUtils;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

@SpringBootApplication
public class PuzzleApplication {

	public static void main(String[] args) throws IOException {
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
