package com.javarush.games.minesweeper;

public class GameObject {
    public int x, y;
    public int countMineNeighbors = 0;
    public boolean isMine;

    public GameObject(int x, int y, boolean isMine) {
        this.x = x;
        this.y = y;
        this.isMine = isMine;
    }



}
