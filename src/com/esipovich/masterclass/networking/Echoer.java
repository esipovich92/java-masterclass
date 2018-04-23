package com.esipovich.masterclass.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Artem Esipovich 23.04.2018
 */

public class Echoer extends Thread {

    private Socket socket;

    public Echoer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                String echo = input.readLine();
                System.out.println("Received client's input: " + echo);
                if (echo.equals("exit")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Oops: " + e.getMessage());
        }
        finally {
            try {
                socket.close();
            } catch (IOException e) {

            }
        }
    }
}
