package com.puzzle;

import com.puzzle.gui.MainFrame;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.awt.*;

@SpringBootApplication
public class PuzzleApplication {

	public static void main(String[] args) {
		ApplicationContext builder = new SpringApplicationBuilder(PuzzleApplication.class)
				.headless(false).run(args);
	}


	@Bean
	public CommandLineRunner test(MainFrame mainFrame) {
		return args -> {
			mainFrame.setVisible(true);
		};
	}

}
