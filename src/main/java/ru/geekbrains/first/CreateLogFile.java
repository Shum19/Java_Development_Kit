package ru.geekbrains.first;

import java.io.*;

public class CreateLogFile {
    File logFile;
    CreateLogFile(String fileName) throws IOException {
        this.logFile = new File("./File_log/" + fileName + ".txt");
        if (!logFile.exists()) {
            logFile.createNewFile();
        }
    }
    public File getLogFile(){
        return logFile;
    }
    public void writeLog(String log){
        try (FileWriter writer = new FileWriter(this.logFile, true)){
            writer.append(log + "\n");
            writer.close();
        }catch (IOException e){
            System.out.println("no such file");
        }

    }
    public String readLogFile(){
        String log = "";
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(this.logFile))){
            while ((line = br.readLine()) != null){
                log += line + "\n";
            }
            br.close();
        }catch (IOException e){
            System.out.println("no such file");
        }
        return log;
    }


}
