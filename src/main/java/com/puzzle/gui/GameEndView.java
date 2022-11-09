package com.puzzle.gui;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionListener;

@Component
public class GameEndView extends JPanel {

    private JButton returnButton;
    private JLabel timeLabel;
    private JLabel countLabel;

    public GameEndView() {
        setBounds(0, 0, 436, 263);
        setLayout(null);

        JLabel gameClearLabel = new JLabel("축하합니다. 게임에 클리어하셨습니다!");
        gameClearLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gameClearLabel.setBounds(74, 38, 279, 31);
        add(gameClearLabel);

        JLabel label1 = new JLabel("클리어 시간 :");
        label1.setBounds(33, 95, 91, 15);
        add(label1);

        JLabel label2 = new JLabel("블록 이동 횟수 :");
        label2.setBounds(33, 134, 91, 15);
        add(label2);

        timeLabel = new JLabel("00시 00분 00초");
        timeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        timeLabel.setBounds(120, 95, 136, 15);
        add(timeLabel);

        countLabel = new JLabel("000번");
        countLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        countLabel.setBounds(149, 134, 107, 15);
        add(countLabel);


        returnButton = new JButton("시작 화면으로");
        returnButton.setBounds(117, 197, 217, 23);
        add(returnButton);
    }

    public void setReturnBtnActionListener(ActionListener actionListener){
        returnButton.addActionListener(actionListener);
    }

    public void setCountText(String txt){
        countLabel.setText(txt);
    }
    public void setClearTimeText(String txt){
        timeLabel.setText(txt);
    }
}
