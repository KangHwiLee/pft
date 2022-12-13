package config;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import socket.TCPSocketServer;
 
@Component
public class TestCommandLineRunner implements CommandLineRunner {
 
    @Override
    public void run(String... args) throws Exception {
        TCPSocketServer socket = null;
        socket.main(args);
    }
}
