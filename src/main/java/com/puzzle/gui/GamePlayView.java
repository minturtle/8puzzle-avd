package com.puzzle.gui;

import com.puzzle.service.PuzzleMap;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


@Component
public class GamePlayView extends JPanel{

    private int MAP_SIZE = 3;
    private JButton resetButton;


    public GamePlayView() {
        initialize();
    }

    public void initialize(){
        setBounds(0, 0, 500, 460);
        setLayout(new BorderLayout(0, 0));

        JPanel playMap = new JPanel();
        add(playMap, BorderLayout.CENTER);
        playMap.setLayout(new GridLayout(MAP_SIZE, MAP_SIZE, 0, 0));

        resetButton = new JButton("Move to Start Page");
        add(resetButton, BorderLayout.SOUTH);

        PuzzleMap puzzleMap = new PuzzleMap(MAP_SIZE);

        JButton[][] blockArr = puzzleMap.getMap();

        for(int i = 0; i < MAP_SIZE; i++){
            for(int j = 0; j < MAP_SIZE; j++){
                playMap.add(blockArr[i][j]);
            }
        }
    }

    public void setmapSize(int MAP_SIZE) {
        this.MAP_SIZE = MAP_SIZE;
    }

    public void setRestartBtnClick(ActionListener func){
        resetButton.addActionListener(func);
    }

}
