package ru.geekbrains.second;

import java.awt.*;
import java.rmi.server.RemoteRef;
import java.util.Comparator;
import java.util.Random;

public class Ball extends Sprite{
    private static Random rnd = new Random();
    private final Color color;
    private float vX;
    private float vY;
    Ball(){
        halfHeight = 20 + (float)(Math.random()*50f);
        halfWidth = halfHeight;
        color = new Color(rnd.nextInt());
        vX = 100f + (float)(Math.random() * 200f);
        vY = 100f + (float)(Math.random() * 200f);
    }

    @Override
    void update(MainCanvas mainCanvas, float deltaTime) {
        x += vX * deltaTime;
        y += vY * deltaTime;
        if (getLeft() < mainCanvas.getLeft()){
            setLeft(mainCanvas.getLeft());
            vX = -vX;
        }
        if (getRight() > mainCanvas.getRight()){
            setRight(mainCanvas.getRight());
            vX = -vX;
        }
        if (getTop() < mainCanvas.getTop()){
            setTop(mainCanvas.getTop());
            vY = -vY;
        }
        if (getBottom() > mainCanvas.getBottom()){
            setBottom(mainCanvas.getBottom());
            vY = -vY;
        }
    }

    @Override
    void render(MainCanvas mainCanvas, Graphics g) {
        g.setColor(color);
        g.fillOval((int)getLeft(), (int) getTop(),
                (int)getWidth(), (int)getHeight());
    }
}
