package ru.geekbrains.second;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private static final int WIDTH_WINDOW = 800;
    private static final int HEIGHT_WINDOW = 600;
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private final Sprite [] sprites = new Sprite[10];
    MainWindow(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH_WINDOW, HEIGHT_WINDOW);
        setTitle("Circles");
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
        MainCanvas mainCanvas = new MainCanvas(this);
        add(mainCanvas);


        setVisible(true);
    }
    public void onDrawFrame(MainCanvas mainCanvas, Graphics g, float deltaTime){
        update(mainCanvas, deltaTime);
        render(mainCanvas, g);
    }
    private void update(MainCanvas mainCanvas, float deltaTime){
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(mainCanvas, deltaTime);
        }
    }
    private void render(MainCanvas mainCanvas, Graphics g){
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(mainCanvas, g);
        }

    }
}
