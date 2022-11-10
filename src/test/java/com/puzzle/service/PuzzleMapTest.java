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

}