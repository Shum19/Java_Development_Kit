package ru.geekbrains.first;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;
    private JLabel  gameMode, fieldSize,
                    selectedFieldSize, winLength,
                    selectedWinLength;
    private JRadioButton humanVsHuman, aiVsHuman;
    private JSlider sliderFieldSize, sliderWinLength;
    private JButton startGame;

    SettingsWindow(GameWindow gw){
        setLocationRelativeTo(gw);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Game Setting");
        JPanel settingPanel = new JPanel(new GridLayout(10,1));
        //initialization
        gameMode = new JLabel("Выберите режим игры");
        humanVsHuman = new JRadioButton("Человек против человека");
        humanVsHuman.setSelected(true);
        aiVsHuman = new JRadioButton("Компьютерр против человека");
        fieldSize = new JLabel("Выберите размер поля");
        sliderFieldSize = new JSlider(3, 10);
        selectedFieldSize = new JLabel("Установленный размер поля: " + sliderFieldSize.getValue());
        winLength = new JLabel("Выберите длину фишек для победы");
        sliderWinLength = new JSlider(3, 10);
        selectedWinLength = new JLabel("Установленная длина фишек для победы: " + sliderWinLength.getValue());

        startGame = new JButton("Начать Игру");

        ButtonGroup radioButtons = new ButtonGroup();
        radioButtons.add(humanVsHuman);
        radioButtons.add(aiVsHuman);

        // Компоновка окна настройки;
        settingPanel.add(gameMode);
        settingPanel.add(humanVsHuman);
        settingPanel.add(aiVsHuman);
        settingPanel.add(fieldSize);
        settingPanel.add(selectedFieldSize);
        settingPanel.add(sliderFieldSize);
        settingPanel.add(winLength);
        settingPanel.add(selectedWinLength);
        settingPanel.add(sliderWinLength);
        settingPanel.add(startGame);
        add(settingPanel);
        // Слушатели кнопок
        sliderFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                selectedFieldSize.setText("Установленный размер поля: " + sliderFieldSize.getValue());
            }
        });
        sliderWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                selectedWinLength.setText("Установленная длина фишек для победы: " + sliderWinLength.getValue());
            }
        });
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gw.startNewGame(humanVsHuman.isSelected() ? 0:1, sliderFieldSize.getValue(),
                                sliderFieldSize.getValue(), sliderWinLength.getValue());
                setVisible(false);
            }
        });




    }
}
