package com.chivalrycode.expensetracker.asset;

import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
@Service
public class SaveCSV {
    public String createCSVFile(String filename,String fileContent) throws IOException {
        try(FileWriter fileWriter = new FileWriter(filename)){
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(fileContent);
            bufferedWriter.flush();
            return "file successfully saved";
        }
    }//filewriter create an empty file and bufferedwriter write to the file.write to exact location
}
