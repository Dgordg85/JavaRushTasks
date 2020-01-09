package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {


    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> wordsList = detectAllWords(crossword, "home", "same");

        for (Word elem : wordsList){
            System.out.println(elem);
        }

        /*
            Ожидаемый результат
            home - (5, 3) - (2, 0)
            same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<String> wordsList = new ArrayList<>();
        for (String str : words){
            wordsList.add(str);
        }

        List<Word> list = new ArrayList<>();
        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[0].length; j++) {
                for (int k = 0; k < wordsList.size(); k++) {
                    if (wordsList.get(k).charAt(0) == (char)crossword[i][j]){
                        List<Word> resultList = checkLetter(crossword, wordsList.get(k), j, i);
                        if (resultList != null){
                            for (Word wordElem : resultList){
                                list.add(wordElem);
                            }
                        }
                    }
                }
            }
        }
        list.sort((o1, o2) -> {
            if (o1.text.equals(o2)) return 0;
            if (o1.text.compareTo(o2.text) > 0) return 1;
            else return -1;
        });

        return list;
    }

    private static List<Word> checkLetter(int[][] crossword, String word, int j, int i){
        int[][] set = new int[][]{
                {-1, -1},
                {-1,  0},
                {-1,  1},
                {0,  -1},
                {0,   1},
                {1,  -1},
                {1,   0},
                {1,   1},
        };
        List<Word> result = new ArrayList<>();

        for (int k = 0; k < set.length; k++) {
            int newJ = j;
            int newI = i;

            for (int l = 1; l < word.length(); l++) {
                newJ += set[k][0];
                newI += set[k][1];

                try {
                    if (word.charAt(l) != (char) crossword[newI][newJ]) break;
                }catch (ArrayIndexOutOfBoundsException e){
                    break;
                }

                if (l == (word.length() - 1)) {
                    Word wordForResult = new Word(word);
                    wordForResult.setStartPoint(j, i);
                    wordForResult.setEndPoint(newJ, newI);
                    result.add(wordForResult);
                }
            }
        }
        return result;
    }

    public static class Word{
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
