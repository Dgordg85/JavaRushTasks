package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private int countMinesOnField;

    private GameObject[][] gameField = new GameObject[SIDE][SIDE];

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame(){
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {
                if (getRandomNumber(10) == 0) {
                    gameField[y][x] = new GameObject(x, y, true);
                    countMinesOnField++;
                } else {
                    gameField[y][x] = new GameObject(x, y, false);
                }
                setCellColor(x, y, Color.AZURE);
            }
        }
        countMineNeighbors();
    }

    private void countMineNeighbors(){
        List<GameObject> list;
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                if (gameField[y][x].isMine){
                    continue;
                }
                list = getNeighbors(gameField[y][x]);

                for (GameObject obj : list){
                    if (obj.isMine) {
                        gameField[y][x].countMineNeighbors++;
                    }
                }
//                if (!(gameField[y][x].countMineNeighbors == 0)){
//                    setCellNumber(x, y, gameField[y][x].countMineNeighbors);
//                }

            }

        }
    }

    public List<GameObject> getNeighbors(GameObject obj){
        int x = obj.x;
        int y = obj.y;
        List<GameObject> list = new ArrayList<>();
        for (int i = y - 1; i <= y + 1; i++) {
            for (int j = x - 1; j <= x + 1; j++) {
                if (!(y < 0 || x < 0 || y > SIDE - 1 || x > SIDE - 1 || (y == i && x == j))){
                    try{
                        list.add(gameField[i][j]);
                    }catch (IndexOutOfBoundsException e){

                    }
                }
            }
        }
        return list;
    }
}
