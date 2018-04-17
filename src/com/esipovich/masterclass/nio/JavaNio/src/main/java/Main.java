package main.java;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * @author Artem Esipovich 16.04.2018
 */

public class Main {

    public static void main(String[] args) {
       readWriteLines();

        writeBinFile();

        copyFile();
    }

    private static void readWriteLines() {
        try {
//            FileInputStream file = new FileInputStream("data.txt");
//            FileChannel channel = file.getChannel();
            Path path = FileSystems.getDefault().getPath("data.txt");
            Files.write(path, "\nLine 4".getBytes("UTF-8"), StandardOpenOption.APPEND);
            List<String> lines = Files.readAllLines(path);
            for (String line : lines){
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeBinFile() {
        try (FileOutputStream binFile = new FileOutputStream("binData.txt")) {
            FileChannel channel = binFile.getChannel();
            byte[] outputBytes = "Hello World".getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(outputBytes);
            int numBytes = channel.write(buffer);
            System.out.println("Num bytes " + numBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFile() {
        Path sourceFile = FileSystems.getDefault().getPath("data.txt");
        Path resultFile = FileSystems.getDefault().getPath("copiedData.txt");
        try {
            Files.copy(sourceFile, resultFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
