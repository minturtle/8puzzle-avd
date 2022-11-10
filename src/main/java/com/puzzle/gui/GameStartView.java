package com.puzzle.gui;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

@Component
public class GameStartView extends JPanel {

    private JButton playButton;
    private JSpinner mapSizeSpinner;
    private JPanel imagePreviewPanel;
    private Choice imageChoise;

    public final String NO_IMAGE = "NO IMAGE";

    public GameStartView() {
        setLayout(null);
        setBounds(0, 0, 490, 500);

        JLabel label1 = new JLabel("8-Puzzle Game");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setBounds(154, 38, 148, 15);
        add(label1);

        mapSizeSpinner = new JSpinner(new SpinnerNumberModel(3, 2, 10, 1));
        mapSizeSpinner.setBounds(400, 369, 40, 22);
        add(mapSizeSpinner);

        JLabel label3 = new JLabel("맵 크기");
        label3.setBounds(274, 372, 50, 15);
        add(label3);

        playButton = new JButton("Play!");
        playButton.setBounds(39, 422, 400, 31);
        add(playButton);

        imagePreviewPanel = new JPanel();
        imagePreviewPanel.setBackground(Color.WHITE);
        imagePreviewPanel.setBounds(103, 82, 250, 250);
        add(imagePreviewPanel);

        JLabel label2 = new JLabel("이미지 선택");
        label2.setBounds(39, 372, 69, 15);
        add(label2);

        imageChoise = new Choice();
        imageChoise.setBounds(114, 371, 130, 20);
        add(imageChoise);

        File[] sampleImages = new File("images/samples").listFiles();
        imageChoise.add(NO_IMAGE);
        for (File sampleImage : sampleImages) {
            imageChoise.add(sampleImage.getName());
        }


        //이미지 이름을 선택하는 칸에서 이미지를 골랐을 때 실행되는 함수
        imageChoise.addItemListener(e->{
            drawImageInPreview("images/samples/" + e.getItem());
        });

    }


    public void setPlayBtnClickEvent(ActionListener func){
        playButton.addActionListener(func);
    }

    public int getMapSize(){
        return (Integer) mapSizeSpinner.getValue();
    }
    public String getSelectedImagePath(){
        return imageChoise.getSelectedItem().equals(NO_IMAGE) ? null :imageChoise.getSelectedItem() ;
    }


    private void drawImageInPreview(String imagePath) {
        if(imagePath.equals("images/samples/" + NO_IMAGE)){
            imagePath = "images/NO_IMAGE.png";
        }
        imagePreviewPanel.getGraphics().drawImage(new ImageIcon(imagePath).getImage(), 0,0, 250,250, null);
    }

}
