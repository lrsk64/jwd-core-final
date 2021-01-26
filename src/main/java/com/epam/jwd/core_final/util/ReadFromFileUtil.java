package com.epam.jwd.core_final.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFromFileUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReadFromFileUtil.class);

    public static String getFromFile(String fileName, String fileDir){

        StringBuilder textFromFile = new StringBuilder();

        try (Scanner scanner = new Scanner(new File(fileDir, fileName))) {

            while(scanner.hasNext()){
                textFromFile.append(scanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            LOGGER.error("File '" + fileName + "' not found in " + fileDir);
        }

        return textFromFile.toString();
    }


    public static Matcher getMatchByPattern(String text, String regexp){
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(text);
        return matcher;

    }
}
