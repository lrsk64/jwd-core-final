package com.epam.jwd.core_final.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFileUtil {
    public static File writeToFile(File file, String string){
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(string);
        } catch (IOException e) {
            //LOGGER.error("Cannot create file");
            //todo throw new exception and change logger message
        }
        return file;
    }
}
