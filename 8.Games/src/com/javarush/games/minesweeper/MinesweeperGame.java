package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private int countMinesOnField;
    private int countFlags;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private boolean isGameStopped;
    private int countClosedTiles = SIDE * SIDE;
    private int score = 0;

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
                setCellValue(x, y, "");
            }
        }
        countFlags = countMinesOnField;
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

    private void openTile(int x, int y){

        if (!isGameStopped && !gameField[y][x].isFlag && !gameField[y][x].isOpen){
            if (!gameField[y][x].isMine) {
                gameField[y][x].isOpen = true;
                countClosedTiles--;
                score += 5;
                setScore(score);
                if (countMinesOnField == countClosedTiles) win();

                setCellColor(x, y, Color.GREEN);

                if (gameField[y][x].countMineNeighbors == 0) {
                    setCellValue(x, y, "");
                    for (GameObject obj : getNeighbors(gameField[y][x])) {
                        openTile(obj.x, obj.y);
                    }
                } else {
                    setCellNumber(x, y, gameField[y][x].countMineNeighbors);
                }
            } else {
                setCellValueEx(x, y, Color.RED, MINE);
                gameOver();
            }
        }
    }

    private void markTile(int x, int y){
        if (!gameField[y][x].isOpen && !isGameStopped) {
            if (!gameField[y][x].isFlag && countFlags > 0) {
                setCellValue(x, y, FLAG);
                setCellColor(x, y, Color.YELLOW);
                gameField[y][x].isFlag = true;
                countFlags--;
            } else if (gameField[y][x].isFlag) {
                gameField[y][x].isFlag = false;
                countFlags++;
                setCellValue(x, y, "");
                setCellColor(x, y, Color.AZURE);
            }
        }
    }

    private void gameOver(){
        isGameStopped = true;
        showMessageDialog(Color.RED, "Игра окончена", Color.ALICEBLUE, 25);
    }

    private void win(){
        isGameStopped = true;
        showMessageDialog(Color.GREEN, "Вы выиграли", Color.GRAY, 25);

    }

    private void restart(){
        isGameStopped = false;
        countClosedTiles = SIDE * SIDE;
        countMinesOnField = 0;
        score = 0;
        setScore(score);
        createGame();

    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        if (isGameStopped) restart();
        else openTile(x, y);
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }
}
