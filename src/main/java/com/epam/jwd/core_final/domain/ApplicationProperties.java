package com.epam.jwd.core_final.domain;

import com.epam.jwd.core_final.util.PropertyReaderUtil;

import java.util.Properties;

/**
 * This class should be IMMUTABLE!
 * <p>
 * Expected fields:
 * <p>
 * inputRootDir {@link String} - base dir for all input files
 * outputRootDir {@link String} - base dir for all output files
 * crewFileName {@link String}
 * missionsFileName {@link String}
 * spaceshipsFileName {@link String}
 * <p>
 * fileRefreshRate {@link Integer}
 * dateTimeFormat {@link String} - date/time format for {@link java.time.format.DateTimeFormatter} pattern
 */
public final class ApplicationProperties {
    //todo
    private static ApplicationProperties instance;

    private final String inputRootDir;
    private final String outputRootDir;
    private final String crewFileName;
    private final String missionsFileName;
    private final String spaceshipsFileName;
    private final Integer fileRefreshRate;
    private final String dateTimeFormat;
    private final Properties properties = PropertyReaderUtil.loadProperties();

//    public ApplicationProperties(String inputRootDir, String outputRootDir, String crewFileName, String missionsFileName,
//                                 String spaceshipsFileName, Integer fileRefreshRate, String dateTimeFormat) {
//        this.inputRootDir = inputRootDir;
//        this.outputRootDir = outputRootDir;
//        this.crewFileName = crewFileName;
//        this.missionsFileName = missionsFileName;
//        this.spaceshipsFileName = spaceshipsFileName;
//        this.fileRefreshRate = fileRefreshRate;
//        this.dateTimeFormat = dateTimeFormat;
//    }


    private ApplicationProperties() {
        this.inputRootDir = properties.getProperty("inputRootDir");
        this.outputRootDir = properties.getProperty("outputRootDir");
        this.crewFileName = properties.getProperty("crewFileName");
        this.missionsFileName = properties.getProperty("missionsFileName");
        this.spaceshipsFileName = properties.getProperty("spaceshipsFileName");
        this.fileRefreshRate = Integer.parseInt(properties.getProperty("fileRefreshRate"));
        this.dateTimeFormat = properties.getProperty("dateTimeFormat");
    }

    public static ApplicationProperties getInstance(){
        if(instance == null){
            instance = new ApplicationProperties();
        }
        return instance;
    }

    public String getInputRootDir() {
        return inputRootDir;
    }

    public String getOutputRootDir() {
        return outputRootDir;
    }

    public String getCrewFileName() {
        return crewFileName;
    }

    public String getMissionsFileName() {
        return missionsFileName;
    }

    public String getSpaceshipsFileName() {
        return spaceshipsFileName;
    }

    public Integer getFileRefreshRate() {
        return fileRefreshRate;
    }

    public String getDateTimeFormat() {
        return dateTimeFormat;
    }
}
