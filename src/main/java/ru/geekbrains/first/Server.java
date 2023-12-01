package ru.geekbrains.first;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Server  extends JFrame {
    private JButton startServer, stopServer;
    private JTextArea textArea;
    private int WINDOW_HEIGHT = 300;
    private int WINDOW_WIDTH = 200;


    Server (){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Server");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        JPanel bottomPnl = new JPanel(new GridLayout(1, 2));
        JPanel centerPnl = new JPanel();

        startServer = new JButton("Start Server");
        stopServer = new JButton("Stop Server");
        bottomPnl.add(startServer);
        bottomPnl.add(stopServer);
        textArea = new JTextArea();
        textArea.setEditable(false);
        centerPnl.add(textArea);
        add(centerPnl, BorderLayout.CENTER);
        add(bottomPnl, BorderLayout.SOUTH);
        stopServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("Server is stopped");
            }
        });
        startServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("Server is started");
            }
        });



        setVisible(true);





    }

}
