package ru.geekbrains.first;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POS_X = 500;
    private static final  int WINDOW_POS_Y = 100;
    private JButton startButton = new JButton("Start Game");
    private JButton stopButton = new JButton("Exit");
    Map map;
    SettingsWindow settings;
    GameWindow(){
        //  Конфигурация основного окна игры
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(WINDOW_POS_X, WINDOW_POS_Y);
        setTitle("Tic Tac Toe");
        setResizable(false);

        map = new Map();
        add(map);
        settings = new SettingsWindow(this);
        JPanel bottomPanel = new JPanel(new GridLayout(1,2));
        bottomPanel.add(startButton);
        bottomPanel.add(stopButton);
        add(bottomPanel, BorderLayout.SOUTH);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });





        setVisible(true);

    }
    public void startNewGame(int mode, int fSzX, int fSzY, int wLen){
        map.startNewGame(mode, fSzX, fSzY, wLen);
    }
}
