package com.puzzle.gui;

import org.springframework.stereotype.Component;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

@Component
public class MainFrame {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("8-Queen Game");


		JPanel GameStartView = new JPanel();
		GameStartView.setBounds(0, 0, 446, 263);
		frame.getContentPane().add(GameStartView);
		GameStartView.setLayout(null);
		
		JLabel gameTitle = new JLabel("8-Queen Game");
		gameTitle.setBounds(167, 43, 97, 52);
		GameStartView.add(gameTitle);
		
		JButton playBtn = new JButton("Play!");
		playBtn.setBounds(168, 158, 91, 23);
		GameStartView.add(playBtn);
		
		JPanel GamePlayView = new JPanel();
		GamePlayView.setBounds(0, 0, 10, 10);
		frame.getContentPane().add(GamePlayView);
	}


	public void setVisible(boolean visible){
		this.frame.setVisible(visible);
	}
}
