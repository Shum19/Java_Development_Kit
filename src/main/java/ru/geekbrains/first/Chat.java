package ru.geekbrains.first;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class Chat extends JFrame {
    private int WINDOW_HEIGHT = 500;
    private int WINDOW_WIDTH = 300;
    private JTextField login, password, ipAddress, port;
    private JLabel loginLabel, passwordLabel,  ipAddressLabel, portLabel;
    private JTextArea chatTextArea, logChatArea;
    private JButton sendMsg, connectToChat, enterButton;
    private String loginString;
    CreateLogFile logFile;
    Chat(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        JPanel northPanel = new JPanel(new GridLayout (4, 2));
        loginLabel = new JLabel("Login");
        login = new JTextField();
        passwordLabel = new JLabel("Password");
        password = new JTextField();
        ipAddressLabel = new JLabel("IP address");
        ipAddress = new JTextField();
        portLabel = new JLabel("Port");
        port = new JTextField();
        northPanel.add(loginLabel);
        northPanel.add(login);
        northPanel.add(passwordLabel);
        northPanel.add(password);
        northPanel.add(ipAddressLabel);
        northPanel.add(ipAddress);
        northPanel.add(portLabel);
        northPanel.add(port);



        JPanel centerPanel = new JPanel(new GridLayout(2, 1));
        connectToChat = new JButton("Подключиться к чату");
        connectToChat.setSize(50,20);

        logChatArea = new JTextArea();
        JScrollPane logScrollArea = new JScrollPane(logChatArea);
        centerPanel.setSize(100,50);
        centerPanel.add(connectToChat);
        centerPanel.add(logScrollArea);


        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
        chatTextArea = new JTextArea();

        sendMsg = new JButton("Отправить сообщение");
        enterButton = new JButton();

        bottomPanel.add(chatTextArea);
        bottomPanel.add(sendMsg);


        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        connectToChat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginString = login.getText();
                try {
                    logFile = new CreateLogFile(loginString);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                logChatArea.setText(logFile.readLogFile());

                chatTextArea.setText(loginString + ":");

                login.setText("");
                password.setText("");
                ipAddress.setText("");
                port.setText("");
            }
        });
        sendMsg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logChatArea.append(chatTextArea.getText() + "\n");
                chatTextArea.setText(loginString + ": ");
                logFile.writeLog(chatTextArea.getText());
            }
        });
       chatTextArea.addKeyListener(new KeyListener() {
           @Override
           public void keyTyped(KeyEvent e) {

           }

           @Override
           public void keyPressed(KeyEvent e) {
               if( e.getKeyCode() == KeyEvent.VK_ENTER) {
                   logChatArea.append(chatTextArea.getText() + "\n");
                   logFile.writeLog(chatTextArea.getText());
               }
           }

           @Override
           public void keyReleased(KeyEvent e) {
               if( e.getKeyCode() == KeyEvent.VK_ENTER) {
                   chatTextArea.setText(loginString + ": ");
               }


           }

       });





        setVisible(true);

    }
}
