package com.company;

import com.company.classes.characters.Constans;

import javax.swing.*;
import java.awt.*;

public class MonsterBase {
    public Image image;
    private int x,y,health;
    public MonsterBase(int x, int y){
        this.x = x;
        this.y = y;
        this.health = 200;
        String baseImage = Constans.IMG_FOLDER + "/monster/zombie.png";
        this.image = new ImageIcon(baseImage).getImage();
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHealthPoints() {
        return health;
    }



}
