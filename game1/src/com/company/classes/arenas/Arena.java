package com.company.classes.arenas;

import com.company.Team;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public abstract class Arena implements BaseArena {
    protected String arenaName;
    protected Image arenaImage;
    protected Image wallImage;
    protected Color backgroundColor;
    protected java.util.List<int[]> walls;
    protected List<int[]> playersSpawnPoints;

    @Override
    public boolean open(Team team) {
        return false;
    }

    public Arena(String arenaName, Image wallImage, Color backgroundColor, List<int[]> walls, List<int[]> playersSpawnPoints) {
        this.arenaName = arenaName;
        this.wallImage = wallImage;
        this.backgroundColor = backgroundColor;
        this.walls = walls;
        this.playersSpawnPoints = playersSpawnPoints;
    }

    public void setImages(){
        this.wallImage = new ImageIcon(" winter_wall.png").getImage();
    }
    public String getArenaName() {
        return arenaName;
    }

    public void setArenaName(String arenaName) {
        this.arenaName = arenaName;
    }

    public Image getArenaImage() {
        return arenaImage;
    }

    public void setArenaImage(Image arenaImage) {
        this.arenaImage = arenaImage;
    }

    public Image getWallImage() {
        return wallImage;
    }

    public void setWallImage(Image wallImage) {
        this.wallImage = wallImage;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public List<int[]> getWalls() {
        return walls;
    }

    public void setWalls(List<int[]> walls) {
        this.walls = walls;
    }

    public List<int[]> getPlayersSpawnPoints() {
        return playersSpawnPoints;
    }

    public void setPlayersSpawnPoints(List<int[]> playersSpawnPoints) {
        this.playersSpawnPoints = playersSpawnPoints;
    }
}
