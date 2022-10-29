package com.puzzle.gui;

import com.puzzle.service.PuzzleBlock;
import com.puzzle.service.PuzzleMap;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.function.Consumer;
import java.util.function.Supplier;


@Component
public class GamePlayView extends JPanel{

    private int MAP_SIZE = 3;
    private final JButton resetButton;
    private final PuzzleMap puzzleMap;
    private JPanel playMap;
    private PuzzleBlock[][] blockArr;

    public GamePlayView(PuzzleMap puzzleMap) {
        this.puzzleMap = puzzleMap;
        this.resetButton = new JButton("Move to Start Page");
        initialize();
    }

    public void initialize() throws RuntimeException{
        setBounds(0, 0, 500, 460);
        setLayout(new BorderLayout(0, 0));

        playMap = new JPanel();
        add(playMap, BorderLayout.CENTER);
        playMap.setLayout(new GridLayout(MAP_SIZE, MAP_SIZE, 0, 0));

        add(resetButton, BorderLayout.SOUTH);

        puzzleMap.initialize(MAP_SIZE);
        blockArr = puzzleMap.getMap();

        updatePlayMap();
    }

    public void addOnclickGameCheck(Consumer<Boolean> func){
        for(int i = 0; i < MAP_SIZE; i++){
            for(int j = 0; j < MAP_SIZE; j++){
                PuzzleBlock puzzleBlock = blockArr[i][j];

                puzzleBlock.addActionListener((e)->{
                    puzzleMap.swapToEmptyBlock(puzzleBlock);
                    updatePlayMap();

                    func.accept(puzzleMap.isGameClear());
                });
            }
        }
    }

    public void setmapSize(int MAP_SIZE) {
        this.MAP_SIZE = MAP_SIZE;
        initialize();
    }

    public void setRestartBtnClick(ActionListener func){
        resetButton.addActionListener(func);
    }

    private void updatePlayMap(){
        playMap.removeAll();
        for(int i = 0; i < MAP_SIZE; i++){
            for(int j = 0; j < MAP_SIZE; j++){
                playMap.add(blockArr[i][j]);
            }
        }
        playMap.updateUI();
    }

}
