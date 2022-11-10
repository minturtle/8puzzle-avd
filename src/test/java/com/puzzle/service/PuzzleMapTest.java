package com.puzzle.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PuzzleMapTest {


    private PuzzleMap puzzleMap = new PuzzleMap();

    @BeforeEach
    void setUp() {
        puzzleMap.initialize(3);
    }

    @Test
    @DisplayName("isGameClear-게임이 클리어된 경우")
    void t1() throws Exception {
        puzzleMap.setMap(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}});
        assertThat(puzzleMap.isGameClear()).isEqualTo(true);
    }
    void t2() throws Exception {
        puzzleMap.setMap(new int[][]{{1,3,2}, {4,5,6}, {7,8,9}});
        assertThat(puzzleMap.isGameClear()).isEqualTo(false);
    }
    @DisplayName("isSolveAble-퍼즐판이 해결 불가능한 경우(n:홀수)")
    void t3() throws Exception {
        puzzleMap.setMap(new int[][]{{1, 2, 3},{4, 5, 6}, {8,7,9}});
        assertThat(puzzleMap.isSolveAble()).isEqualTo(false);
    }
    @DisplayName("isSolveAble-퍼즐판이 해결가능한 경우(n:홀수)")
    void t4() throws Exception {
        puzzleMap.setMap(new int[][]{{1, 2, 3},{9, 4, 7}, {5,6,8}});
        assertThat(puzzleMap.isSolveAble()).isEqualTo(true);
    }
    @DisplayName("isSolveAble-(n:짝수일때) 빈칸의 행 위치가 홀수이고 역전카운트가 짝수일때 O")
    void t5() throws Exception {
        puzzleMap.setMap(new int[][]{{2,3},{1,4}});
        assertThat(puzzleMap.isSolveAble()).isEqualTo(true);
    }
    @DisplayName("isSolveAble-(n:짝수일때) 빈칸의 행 위치가 짝수이고 역전카운트가 짝수일때 X")
    void t6() throws Exception {
        puzzleMap.setMap(new int[][]{{4,2},{3,1}});
        assertThat(puzzleMap.isSolveAble()).isEqualTo(false);
    }
    @DisplayName("isSolveAble-(n:짝수일때)빈칸의 행 위치가 홀수이고 역전카운트가 홀수일때 X")
    void t7() throws Exception {
        puzzleMap.setMap(new int[][]{{2,3},{1,4}});
        assertThat(puzzleMap.isSolveAble()).isEqualTo(false);
    }
    @DisplayName("isSolveAble-(n:짝수일때)빈칸의 행 위치가 짝수이고 역전카운트가 홀수일때 O")
    void t8() throws Exception {
        puzzleMap.setMap(new int[][]{{4,2},{3,1}});
        assertThat(puzzleMap.isSolveAble()).isEqualTo(true);
    }

}