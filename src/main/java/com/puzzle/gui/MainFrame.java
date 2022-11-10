package com.puzzle.gui;

import com.puzzle.service.Timer;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@Component
public class MainFrame {

	private JFrame frame;

	private final GameStartView gameStartView;
	private final GamePlayView gamePlayView;
	private final GameEndView gameEndView;
	private final com.puzzle.service.Timer timerRunnable;
	private Thread timer;
	private int MAP_SIZE = 3;

	private int FRAME_WIDTH = 500;
	private int FRAME_HEIGHT = 500;


	public MainFrame(GameStartView gameStartView, GamePlayView gamePlayView, GameEndView gameEndView, Timer timer) {
		this.gameStartView = gameStartView;
		this.gamePlayView = gamePlayView;
		this.gameEndView = gameEndView;
		this.timerRunnable = timer;
		initialize();
	}


	private void initialize() {
		frame = new JFrame();

		frame.setBounds(100, 100, FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("8-Puzzle Game");

		frame.getContentPane().add(gameStartView);
		frame.getContentPane().add(gamePlayView);
		frame.getContentPane().add(gameEndView);

		gamePlayView.setVisible(false);
		gameEndView.setVisible(false);
		gameStartView.setVisible(true);


		//start view => play view 로 넘어가는 버튼 클릭시
		gameStartView.setPlayBtnClickEvent((e)->{
			gameStartView.setVisible(false);
			gamePlayView.setVisible(true);
			gamePlayView.load(gameStartView.getMapSize());
			startTimer();
		});

		//게임을 클리어해 play view => end view로 넘어갈때
		gamePlayView.addClickGameCheckClear((isGameEnd)->{
			if(isGameEnd){
				stopTimer();
				gameEndView.setVisible(true);
				gamePlayView.setVisible(false);

				gameEndView.setCountText(gamePlayView.getCount() + "번");
				gameEndView.setClearTimeText(timerRunnable.getTime());
			}
		});

		gameEndView.setReturnBtnActionListener(e->{
			gameStartView.setVisible(true);
			gameEndView.setVisible(false);
		});
	}




	public void setVisible(boolean visible){
		this.frame.setVisible(visible);
	}

	private void startTimer(){
		timer = new Thread(timerRunnable);
		timer.start();
	}

	private void stopTimer(){
		timer.interrupt();
	}
	private String getPlayTime(){
		return timerRunnable.getTime();
	}
}
