package com.puzzle.gui;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

@Component
public class GameStartView extends JPanel {

    private JButton playButton;
    private JSpinner mapSizeSpinner;
    private JPanel imagePreviewPanel;
    private Choice imageChoise;


    public GameStartView() {
        setLayout(null);
        setBounds(0, 0, 490, 500);

        JLabel label1 = new JLabel("8-Puzzle Game");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setBounds(154, 38, 148, 15);
        add(label1);

        mapSizeSpinner = new JSpinner(new SpinnerNumberModel(3, 2, 10, 1));
        mapSizeSpinner.setBounds(400, 369, 40, 22);
        add(mapSizeSpinner);

        JLabel label3 = new JLabel("맵 크기");
        label3.setBounds(274, 372, 50, 15);
        add(label3);

        playButton = new JButton("Play!");
        playButton.setBounds(39, 422, 400, 31);
        add(playButton);

        imagePreviewPanel = new JPanel();
        imagePreviewPanel.setBackground(Color.WHITE);
        imagePreviewPanel.setBounds(103, 82, 274, 256);
        add(imagePreviewPanel);

        JLabel label2 = new JLabel("이미지 선택");
        label2.setBounds(39, 372, 69, 15);
        add(label2);

        imageChoise = new Choice();
        imageChoise.setBounds(114, 371, 108, 20);
        add(imageChoise);
    }

    public void setPlayBtnClickEvent(ActionListener func){
        playButton.addActionListener(func);
    }

    public int getMapSize(){
        return (Integer) mapSizeSpinner.getValue();
    }
}
