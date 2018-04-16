package com.esipovich.masterclass.nio;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * @author Artem Esipovich 16.04.2018
 */

public class Main {

    public static void main(String[] args) {
        writeNio();
        readNio();

        writeObjectNio();
        readObjectNio();
    }

    private static void writeNio() {
        Path path = FileSystems.getDefault().getPath("fileNIO.txt"); //Path instead of File in java.io
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
            bufferedWriter.write("This string is written using NIO");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readNio() {
        Path path = FileSystems.getDefault().getPath("fileNIO.txt");
        try (Scanner scanner = new Scanner(Files.newBufferedReader(path))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeObjectNio() {
        Path path = FileSystems.getDefault().getPath("objectNIO.txt");
        Contact contact = new Contact("Artem", "Esipovich", "42867");
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))){
            objectOutputStream.writeObject(contact);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readObjectNio() {
        Path path = FileSystems.getDefault().getPath("objectNIO.txt");
        Contact contact = new Contact("Artem", "Esipovich", "42867");
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(path)))){
            System.out.println(objectInputStream.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
