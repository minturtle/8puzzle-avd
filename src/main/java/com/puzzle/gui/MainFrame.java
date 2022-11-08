package com.puzzle.gui;

import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class MainFrame {

	private JFrame frame;

	private final GameStartView gameStartView;
	private final GamePlayView gamePlayView;
	private final GameEndView gameEndView;

	private final int START_FRAME_WIDTH = 450;
	private final int START_FRAME_HEIGHT = 300;
	private int MAP_SIZE = 3;

	//3*3에서 n*n으로 변경시 GUI FRAME 크기 변경이 있을수 있음
	private int PLAY_FRAME_WIDTH = 500;
	private int PLAY_FRAME_HEIGHT = 500;




	public MainFrame(GameStartView gameStartView, GamePlayView gamePlayView, GameEndView gameEndView) {
		this.gameStartView = gameStartView;
		this.gamePlayView = gamePlayView;
		this.gameEndView = gameEndView;
		initialize();
	}


	private void initialize() {
		frame = new JFrame();

		frame.setBounds(100, 100, START_FRAME_WIDTH, START_FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("8-Puzzle Game");

		frame.getContentPane().add(gameStartView);
		frame.getContentPane().add(gamePlayView);
		frame.getContentPane().add(gameEndView);


		gamePlayView.setVisible(false);
		gameEndView.setVisible(false);
		gameStartView.setVisible(true);

		gameStartView.setPlayBtnClickEvent((e)->{
			gameStartView.setVisible(false);
			gamePlayView.setVisible(true);
			frame.setSize(PLAY_FRAME_WIDTH, PLAY_FRAME_HEIGHT);
		});


		gameEndView.setReturnBtnActionListener(e->{
			gameStartView.setVisible(true);
			gameEndView.setVisible(false);
		});

		gamePlayView.addClickGameCheckClear((isGameEnd)->{
			if(isGameEnd){
				gameEndView.setVisible(true);
				gamePlayView.setVisible(false);
				frame.setSize(START_FRAME_WIDTH, START_FRAME_HEIGHT);
			}
		});
	}




	public void setVisible(boolean visible){
		this.frame.setVisible(visible);
	}
}
