package main.com.anarcode.edu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger implements ILogger {


    private PrintWriter writer;

    public FileLogger(String s) {
        File file = new File(s);
        file.setWritable(true);
        try {
            file.delete();
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(String s) {
        writer.println(s);
        writer.flush();
    }
}
