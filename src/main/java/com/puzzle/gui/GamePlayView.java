package com.puzzle.gui;

import com.puzzle.service.PuzzleBlock;
import com.puzzle.service.PuzzleMap;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;

@Component
public class GamePlayView extends JPanel{

    private int MAP_SIZE = 3;
    private final PuzzleMap puzzleMap;
    private JPanel playMap;
    private PuzzleBlock[][] blockArr;
    private Consumer<Boolean> gameEndMoveFunc;


    public GamePlayView(PuzzleMap puzzleMap) {
        this.puzzleMap = puzzleMap;
        setBounds(0, 0, 500, 460);
        setLayout(new BorderLayout(0, 0));

        playMap = new JPanel();
        add(playMap, BorderLayout.CENTER);

        load(3);
    }

    public void load(int mapSize){
        load(mapSize, null);
    }

    public void load(int mapSize, String[] imagePathList) throws RuntimeException{
        MAP_SIZE = mapSize;

        playMap.removeAll();
        playMap.setLayout(new GridLayout(MAP_SIZE, MAP_SIZE, 0, 0));

        puzzleMap.initialize(MAP_SIZE, imagePathList);
        blockArr = puzzleMap.getMap();

        updatePlayMap();

        for(int i = 0; i < MAP_SIZE; i++){
            for(int j = 0; j < MAP_SIZE; j++){
                PuzzleBlock puzzleBlock = blockArr[i][j];

                puzzleBlock.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        puzzleMap.swapToEmptyBlock(puzzleBlock);
                        updatePlayMap();
                        gameEndMoveFunc.accept(puzzleMap.isGameClear());
                    }
                });

            }
        }
    }

    public void addClickGameCheckClear(Consumer<Boolean> func){
        gameEndMoveFunc = func;
    }

    //게임이 끝났을 때, 사용자가 블럭을 몇번 옮겼는지 확인하는 함수
    public int getCount(){
        return puzzleMap.getCount();
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
