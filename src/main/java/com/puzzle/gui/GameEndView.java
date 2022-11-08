package com.puzzle.gui;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionListener;

@Component
public class GameEndView extends JPanel {

    private JButton returnButton;

    public GameEndView() {
        setBounds(0, 0, 436, 263);
        setLayout(null);

        JLabel gameClearLabel = new JLabel("축하합니다. 게임에 클리어하셨습니다!");
        gameClearLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gameClearLabel.setBounds(100, 27, 250, 82);
        add(gameClearLabel);

        returnButton = new JButton("시작화면으로 돌아가기");
        returnButton.setBounds(120, 180, 200, 23);
        add(returnButton);
    }

    public void setReturnBtnActionListener(ActionListener actionListener){
        returnButton.addActionListener(actionListener);
    }
}
