package com.puzzle.service;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter
@Setter
public class PuzzleBlock extends JButton {
    private int number;
    public PuzzleBlock(int number) {
        this.number = number;
        this.setText(Integer.toString(number));
    }
}
