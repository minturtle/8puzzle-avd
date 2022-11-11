package com.puzzle.service;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class PuzzleMap {

    private PuzzleBlock[][] map;
    private PuzzleBlock emptyBlock;
    private final int[][] NEAR_VECTORS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우
    private int mapSize;
    private int count;


    public void initialize(int size, String[] imageList){
        this.mapSize = size;
        this.count = 0;

        map = new PuzzleBlock[size][size];
        int number = 1;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                map[i][j] = new PuzzleBlock(j, i, number++);
                if(imageList != null) map[i][j].setImagePath(imageList[i * mapSize + j]);
            }
        }
        emptyBlock = map[size-1][size-1];
        emptyBlock.setEmpty(true);

        shuffle();
    }
    public void initialize(int size){
        initialize(size, null);
    }


    /*
    *  게임 시작시에 Map의 Puzzle들을 섞는 메서드
    * */
    public void shuffle(){
        for (int i = 0; i < 100; i++) {
            int randomX = (int) (Math.random() * mapSize);
            int randomY = (int) (Math.random() * mapSize);

            swap(0, 0, randomX, randomY);
        }

        while(!isSolveAble()){
            int randomX = (int) (Math.random() * mapSize);
            int randomY = (int) (Math.random() * mapSize);

            swap(0, 0, randomX, randomY);
        }
    }
    public int count_inversions(){
        int count = 0;
        int[] numberArr = new int[mapSize * mapSize];
        for(int i = 0; i < mapSize; i++){
            for(int j=0; j < mapSize; j++){
                numberArr[i * mapSize + j] = map[i][j].getNumber();
            }
        }

        for(int i = 0; i < numberArr.length-1; i++){
            for(int j = i+1; j < numberArr.length; j++){
                if(numberArr[i] == mapSize*mapSize) continue;
                if(numberArr[i] > numberArr[j]) count++;
            }
        }

        return count;
    }
    public boolean isSolveAble(){
        int row_blank;
        int n = map.length;
        if (n % 2 == 1){
            return count_inversions() % 2 == 0;
        }
        else{
            row_blank = emptyBlock.getGridX()/n;
            if(row_blank % 2 == 0) return count_inversions() % 2 == 1;
            else return count_inversions() % 2 == 0;
        }
    }

    /*

    * 사용자가 게임을 클리어 했는지 확인하는 메서드
    * 사용자가 블록을 클릭해 블록의 위치가 바뀔 때 마다 게임이 끝났는지 체크해줘야함.
    *
    * */
    public boolean isGameClear(){
        int number = 1;
        for(int i = 0; i < mapSize; i++){
            for(int j = 0; j < mapSize; j++){
                if(map[i][j].getNumber() != number) return false;
                number++;
            }
        }

        return true;
    }

    /*
    * 입력받은 puzzleBlock과 emptyBlock을 swap하는 메서드
    * puzzleBlock과 emptyBlock이 서로 인접하지 않다면 블럭의 위치는 바뀌지 않는다.
    * */
    public void swapToEmptyBlock(PuzzleBlock puzzleBlock){
        if(!isNearbyEmptyBlock(puzzleBlock)) return;

        count++; // 블럭의 위치가 바뀌면 count를 1 더한다.
        swap(puzzleBlock.getGridX(), puzzleBlock.getGridY(), emptyBlock.getGridX(), emptyBlock.getGridY());
    }


    private void swap(int x1, int y1, int x2 ,int y2){
        PuzzleBlock temp = map[y1][x1];
        map[y1][x1] = map[y2][x2];
        map[y2][x2] = temp;

        map[y1][x1].setGridX(x1);
        map[y1][x1].setGridY(y1);

        map[y2][x2].setGridX(x2);
        map[y2][x2].setGridY(y2);

    }

    /*
     *  사용자가 블럭을 클릭했을 때, 해당 블럭이 Empty블럭이랑 인접해 있는지 확인하는 메서드
     * */
    public boolean isNearbyEmptyBlock(PuzzleBlock puzzleBlock){

        int clickedBlockX = puzzleBlock.getGridX();
        int clickedBlockY = puzzleBlock.getGridY();
            for(int[] vector : NEAR_VECTORS) {
                int checkX = clickedBlockX + vector[0];
                int checkY = clickedBlockY + vector[1];

                if(checkX >= mapSize || checkX < 0 || checkY >= mapSize || checkY < 0){
                    continue;
                }
                if (map[checkY][checkX].equals(emptyBlock)) {
                    return true;
                }
            }


        return false;
    }

    //테스트용 메서드
    protected void setMap(int [][] map){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                this.map[i][j] = new PuzzleBlock(j, i, map[i][j]);
            }
        }
    }
}
