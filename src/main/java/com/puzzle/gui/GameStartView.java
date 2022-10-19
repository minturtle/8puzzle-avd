package com.puzzle.gui;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionListener;

@Component
public class GameStartView extends JPanel {

    private JButton playBtn;

    public GameStartView() {
        setLayout(null);
        setBounds(0, 0, 446, 263);

        JLabel gameTitle = new JLabel("8-Queen Game");
        gameTitle.setBounds(168, 43, 97, 52);
        add(gameTitle);

        playBtn = new JButton("Play!");
        playBtn.setBounds(168, 158, 91, 23);
        add(playBtn);
    }

    public void setPlayBtnClickEvent(ActionListener func){
        playBtn.addActionListener(func);
    }
}
