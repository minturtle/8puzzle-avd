package com.puzzle.service;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

@Getter
@Setter
public class PuzzleBlock extends JPanel {
    private int number;
    private int gridX;
    private int gridY;
    private boolean isEmpty = false;
    private Image image;

    public PuzzleBlock(int x, int y, int number) {
        this.number = number;
        this.gridX = x;
        this.gridY = y;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(isEmpty) return;

        if (image != null)g.drawImage(image, 0,0 , getWidth(), getHeight(), null);
        else g.drawString(Integer.toString(number), getWidth() /2, getHeight()/2);
    }

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
