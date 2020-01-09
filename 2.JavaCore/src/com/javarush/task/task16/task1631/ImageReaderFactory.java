package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;


public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type){
        ImageReader reader = null;

        if (type == null) throw new IllegalArgumentException("Неизвестный тип картинки");

        switch (type){
            case JPG:
                reader = new JpgReader();
                break;
            case BMP:
                reader = new BmpReader();
                break;
            case PNG:
                reader = new PngReader();
                break;
                default:
                    throw new IllegalArgumentException("Неизвестный тип картинки");
        }
        return reader;
    }
}
