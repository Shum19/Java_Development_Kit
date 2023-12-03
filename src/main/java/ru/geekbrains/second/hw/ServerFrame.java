package ru.geekbrains.second.hw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ServerFrame extends JFrame  implements ListenerServerFrame {
    private JButton startServer, stopServer;
    private JTextArea textArea;
    private int WINDOW_HEIGHT = 300;
    private int WINDOW_WIDTH = 200;
     private ArrayList log;
     private String timeLog;
    ServerFrame(){
        ServerListener server = new Server(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Server");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        JPanel bottomPnl = new JPanel(new GridLayout(1, 2));
        JPanel centerPnl = new JPanel();

        startServer = new JButton("Start Server");
        stopServer = new JButton("Stop Server");
        bottomPnl.add(startServer);
        bottomPnl.add(stopServer);

        textArea = new JTextArea();
        textArea.setText(server.getServerStatus());
        textArea.setBackground(Color.RED);
        textArea.setEditable(false);
        centerPnl.add(textArea);

        add(centerPnl, BorderLayout.CENTER);
        add(bottomPnl, BorderLayout.SOUTH);
        log = new ArrayList<String>();



        startServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLog = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MM yyyy hh:mm:ss")).toString();
                server.serverListener(true);
                textArea.setBackground(Color.GREEN);
            }
        });
        stopServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLog = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MM yyyy hh:mm:ss")).toString();;
                server.serverListener(false);
                textArea.setBackground(Color.RED);
            }
        });


        setVisible(true);
    }

    @Override
    public void messageReceived(String msg) {
        textArea.setText(msg);
        log.add(timeLog+ ": " + msg);
        System.out.println(timeLog+ ": " + msg);

    }
}
