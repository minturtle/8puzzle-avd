package com.puzzle.service;


import lombok.Getter;

@Getter
public class PuzzleMap {

    private PuzzleBlock[][] map;

    public PuzzleMap(int size) {
        map = new PuzzleBlock[size][size];
        int number = 0;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                map[i][j] = new PuzzleBlock(number++);
            }
        }
        map[0][0].setText("");
        shuffle();
    }

    public void shuffle(){

    }
}
