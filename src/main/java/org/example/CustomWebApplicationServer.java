package org.example;
import org.example.calculator.Calculator;
import org.example.calculator.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class CustomWebApplicationServer {
    private final int port;
    private final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);
    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)){
            logger.info("[CustomWebApplicationServer] started {} port.", port);

            Socket clientSocket;
            logger.info("[CustomWebApplicationServer]  waiting for client.");

            while ((clientSocket = serverSocket.accept())  != null) {
                logger.info("[CustomWebApplicationServer] client connetcted");
                /**
                 * STEP2 -사용자 요청이 들어올 때마다 THREAD를 새로 생성하여 사용자 요청을 처리하도록 한다.
                 */
                new Thread(new ClientRequestHandler(clientSocket)).start();

            }
        }
    }
}
