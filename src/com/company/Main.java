package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        File src = new File("D://NETOLOGY_PROGECTS//Games/src");
        //src.mkdir();
        File main = new File("D://NETOLOGY_PROGECTS//Games/src/main");
        //main.mkdir();
        File srcTest = new File("D://NETOLOGY_PROGECTS//Games/src/test");
        //srcTest.mkdir();
        File srcMainJava = new File("D://NETOLOGY_PROGECTS//Games/src/main/Main.java");
//        try {
//            srcMainJava.createNewFile();
//        } catch (IOException e) {
//            System.out.println(String.format("файл %s не создан", srcMainJava.getName()));
//        }
        File srcMainUtilsJava = new File("D://NETOLOGY_PROGECTS//Games/src/main/Utils.java");
//        try {
//            srcMainUtilsJava.createNewFile();
//        } catch (IOException e) {
//            System.out.println(String.format("файл %s не создан", srcMainUtilsJava.getName()));
//        }


        File res = new File("D://NETOLOGY_PROGECTS//Games/res");
        //res.mkdir();
        File resDrawables = new File("D://NETOLOGY_PROGECTS//Games/res/drawables");
        //resDrawables.mkdir();
        File resVectors = new File("D://NETOLOGY_PROGECTS//Games/res/vectors");
        //resVectors.mkdir();
        File resIcons = new File("D://NETOLOGY_PROGECTS//Games/res/icons");
        //resIcons.mkdir();


        File saveGames = new File("D://NETOLOGY_PROGECTS//Games/savegames");
        //saveGames.mkdir();

        File gamesTemp = new File("D://NETOLOGY_PROGECTS//Games/temp");
        //gamesTemp.mkdir();
        File tempTemp = new File("D://NETOLOGY_PROGECTS//Games/temp/temp.txt");
//        try {
//            tempTemp.createNewFile();
//        } catch (IOException e) {
//            System.out.println(String.format("Файл %s не создан", tempTemp.getName()));
//        }

        List<File> files = new ArrayList<>(Arrays.asList(src, res, saveGames, gamesTemp, main, srcTest, srcMainJava,
                srcMainUtilsJava, resDrawables, resVectors, resIcons, tempTemp));

        StringBuilder str = new StringBuilder();

        files.forEach(file -> {
            boolean isCreated = false;

            if (file.getName().contains(".")) {
                try {
                    isCreated = file.createNewFile();
                    if (isCreated) {
                        str.append(String.format("Файл %s создан %n", file.getName()));
                    } else {
                        str.append(String.format("Файл %s не создан %n", file.getName()));
                    }
                } catch (IOException e) {
                    str.append(String.format("Ошибка, Файл %s не создан %n", file.getName()));
                }
            } else {
                isCreated = file.mkdir();
                if (isCreated) {
                    str.append(String.format("Дирректория %s создана %n", file.getName()));
                } else {
                    str.append(String.format("Дирректория %s не создана %n", file.getName()));
                }
            }
        });
        String text = str.toString();
        try (FileWriter fileWriter = new FileWriter(tempTemp, true)){
            fileWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
