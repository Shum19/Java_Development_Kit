package ru.geekbrains.second;

import javax.swing.*;
import java.awt.*;

public class MainCanvas extends JPanel {
    private final MainWindow controller;
    private long lastFrameTime;
    MainCanvas(MainWindow controller){
        setBackground(Color.BLUE);
        this.controller = controller;
        lastFrameTime = System.nanoTime();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        this.controller.onDrawFrame();
        try {
            Thread.sleep(10000);
        }catch (InterruptedException e){
            System.out.println("Interrupted");
        }
        float deltaTime = (System.nanoTime() - lastFrameTime) * 0.000000001f;
        controller.onDrawFrame(this, g, deltaTime);
        lastFrameTime = System.nanoTime();
        repaint( );
    }
    public int getLeft(){return 0;}
    public int getRight(){return getWidth() - 1;}
    public int getTop(){return 0;}
    public int getBottom(){return getHeight() - 1;}
}