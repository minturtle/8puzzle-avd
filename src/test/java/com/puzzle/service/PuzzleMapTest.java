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
    @Test
    @DisplayName("isGameClear-게임이 클리어 되지 않은 경우")
    void t2() throws Exception {
        puzzleMap.setMap(new int[][]{{1,3,2}, {4,5,6}, {7,8,9}});
        assertThat(puzzleMap.isGameClear()).isEqualTo(false);
    }
    @Test
    @DisplayName("isSolveAble-퍼즐판이 해결 불가능한 경우(n:홀수)")
    void t3() throws Exception {
        puzzleMap.setMap(new int[][]{{1, 2, 3},{4, 5, 6}, {8,7,9}});
        assertThat(puzzleMap.isSolveAble()).isEqualTo(false);
    }
    @Test
    @DisplayName("isSolveAble-퍼즐판이 해결가능한 경우(n:홀수)")
    void t4() throws Exception {
        puzzleMap.setMap(new int[][]{{1, 2, 3},{9, 4, 7}, {5,6,8}});
        assertThat(puzzleMap.isSolveAble()).isEqualTo(true);
    }
    @Test
    @DisplayName("isSolveAble-(n:짝수일때) 빈칸의 행 위치가 홀수이고 역전카운트가 짝수일때 O")
    void t5() throws Exception {
        puzzleMap.setMap(new int[][]{{2,3},{1,4}});
        assertThat(puzzleMap.isSolveAble()).isEqualTo(true);
    }
    @Test
    @DisplayName("isSolveAble-(n:짝수일때) 빈칸의 행 위치가 짝수이고 역전카운트가 짝수일때 X")
    void t6() throws Exception {
        puzzleMap.setMap(new int[][]{{4,2},{3,1}});
        assertThat(puzzleMap.isSolveAble()).isEqualTo(false);
    }
    @Test
    @DisplayName("isSolveAble-(n:짝수일때)빈칸의 행 위치가 홀수이고 역전카운트가 홀수일때 X")
    void t7() throws Exception {
        puzzleMap.setMap(new int[][]{{2,3},{1,4}});
        assertThat(puzzleMap.isSolveAble()).isEqualTo(false);
    }
    @Test
    @DisplayName("isSolveAble-(n:짝수일때)빈칸의 행 위치가 짝수이고 역전카운트가 홀수일때 O")
    void t8() throws Exception {
        puzzleMap.setMap(new int[][]{{4,2},{3,1}});
        assertThat(puzzleMap.isSolveAble()).isEqualTo(true);
    }
    @Test
    @DisplayName("count_inversions- 역전카운트 홀수")
    void t9() throws Exception {
        puzzleMap.setMap(new int[][]{{1,2,3},{4,5,6},{8,7,9}});
        assertThat(puzzleMap.count_inversions()).isEqualTo(1);
    }
    @Test
    @DisplayName("count_inversions- 역전카운트 짝수")
    void t10() throws Exception {
        puzzleMap.setMap(new int[][]{{1,2,3},{4,5,8},{6,7,9}});
        assertThat(puzzleMap.count_inversions()).isEqualTo(2);
    }

    @Test
    @DisplayName("isNearByEmptyBlock- emptyblock과 인접")
    void t11() throws Exception {
        puzzleMap.setMap(new int[][]{{1,2,3},{4,5,6},{8,7,9}});
        assertThat(puzzleMap.isNearByEmptyBlock(puzzleMap.getMap()[0][2])).isEqualTo(true);
    }
    @Test
    @DisplayName("isNearByEmptyBlock- emptyblock과 인접 X ")
    void t12() throws Exception {
        puzzleMap.setMap(new int[][]{{1,2,3},{4,5,6},{8,7,9}});
        assertThat(puzzleMap.isNearByEmptyBlock()).isEqualTo(true);
    }

    @Test
    @DisplayName("swap- emptyblock과 인접 X ")
    void t12() throws Exception {
        puzzleMap.setMap(new int[][]{{1,2,3},{4,5,6},{8,7,9}});
        assertThat(puzzleMap.isNearByEmptyBlock()).isEqualTo(true);
    }

    @Test
    @DisplayName("swap- emptyblock과 인접 X ")
    void t12() throws Exception {
        puzzleMap.setMap(new int[][]{{1,2,3},{4,5,6},{8,7,9}});
        assertThat(puzzleMap.isNearByEmptyBlock()).isEqualTo(true);
    }

}