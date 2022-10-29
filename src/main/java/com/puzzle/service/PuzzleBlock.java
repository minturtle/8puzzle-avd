package com.puzzle.service;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.util.Objects;

@Getter
@Setter
public class PuzzleBlock extends JButton {
    private int number;
    private int gridX;
    private int gridY;


    public PuzzleBlock( int x, int y, int number) {
        this.number = number;
        this.gridX = x;
        this.gridY = y;

        this.setText(Integer.toString(number));
    }

    
    /*
    * PuzzleBlock의 number값은 게임마다 하나씩만 존재하는 고유한 값이기 때문에 , equals로 사용이 가능
    * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PuzzleBlock that = (PuzzleBlock) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
