//package ru.geekbrains.first;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class Map extends JPanel {
//    private int panelHeight, panelWidth, cellHeight,
//                cellWidth, fSzX, fSzY;
//
//    Map(){
//        setBackground(Color.BLACK);
//    }
//    public  void startNewGame(int mode, int fSzX, int fSzY, int wLen){
//        this.fSzX = fSzX;
//        System.out.println(this.fSzX);
//        this.fSzY = fSzY;
//        System.out.printf("Mode: %d\nSize x=%d, y=%d\nLength: %d", mode, fSzX, fSzY, wLen);
//
//
//    }
//    @Override
//    protected void paintComponent(Graphics gr){
//        super.paintComponent(gr);
//        render(gr);
//    }
//    private void render(Graphics gr){
//        panelHeight = getHeight();
//        panelWidth = getWidth();
//        cellHeight = panelHeight / fSzX;
//        cellWidth = panelWidth / fSzY;
//
//        gr.setColor(Color.BLACK);
//        for (int h = 0; h < fSzY; h++ ){
//            int y = h * cellHeight;
//            gr.drawLine(0, y, panelWidth, y);
//        }
//        for (int w = 0; w < fSzX; w++){
//            int x = w * cellWidth;
//            gr.drawLine(x, 0, x, panelWidth);
//        }
//        repaint();
//
//    }
//
//
//}
