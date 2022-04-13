package com.company;

import com.company.classes.CharacterClass;
import com.company.classes.characters.Constans;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameField extends JPanel {
    private Team team;
    private String deadPlayer;
    private CharacterClass[] players;
    private  JLabel gameOver = new JLabel("Game over");
    private  JLabel loser = new JLabel("\nloser: " + deadPlayer);
    public GameField(Team team) {
        this.team = team;
        this.players = team.getTeamMembers();
        setFocusable(true);
        addKeyListener(new FieldKeyListener());
        gameOver.setVisible(false);
        loser.setVisible(false);
        add(gameOver);
        add(new  JLabel("\n"));
        add(loser);



    }
    public void gameOverSign(CharacterClass player) {
        if (player.getHealthPoints() <= 0) {
            deadPlayer = player.getName();
            gameOver.setVisible(true);
            loser.setVisible(true);
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (CharacterClass player : players) {
            gameOverSign(player);
            g.drawImage(player.getImage(), player.getX(), player.getY(), this);
            g.drawString(""+player.getHealthPoints(), player.getX(), player.getY()+12);
            g.drawString("steps", player.getX(), player.getY() + 26);
            System.out.println("health points =   " + player.getHealthPoints());

        }
    }

    public class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

            super.keyPressed(e);


            int key = e.getKeyCode();
            for (CharacterClass player : players) {
                if (key == player.getLeftKey()) {
                    //player.setX(player.getX() - 40);
                    player.left();
                }
                if (key == player.getRightKey()) {
                    //player.setX(player.getX() + 40);
                    player.right();
                }
                if (key == player.getUpKey()) {
                    //player.setY(player.getY() - 40);
                    player.up();
                }
                if (key == player.getDownKey()) {
                    //player.setY(player.getY() + 40);
                    player.down();
                }
                if (key == player.getLeftAttackKey()) {
                    player.setAttackLeftImage();

                    //timer
                    new java.util.Timer().schedule(
                            new java.util.TimerTask() {
                                @Override
                                public void run() {
                                    player.setBaseImage();
                                    repaint();
                                }
                            }, 200
                    );
                }
                if (key == player.getLeftAttackKey()) {
                    player.setAttackLeftImage();
                    if (player.getX() > 0 && CharacterClass.occupiedCells[player.getX() - Constans.CHARACTER_WIDTH][player.getY()] > 0) {
                    player.attack(players[CharacterClass.occupiedCells[player.getX() - Constans.CHARACTER_WIDTH][player.getY()]-1]);
                   }
                    new java.util.Timer().schedule(
                            new java.util.TimerTask() {
                                @Override
                                public void run() {
                                    player.setBaseImage();
                                    repaint();
                                }
                            }, 200
                    );
                }

                if (key == player.getRightAttackKey()) {
                    player.setAttackRightImage();


                    if (player.getX() < 300 && CharacterClass.occupiedCells[player.getX() + Constans.CHARACTER_WIDTH][player.getY()] > 0) {
                        player.attack(players[CharacterClass.occupiedCells[player.getX() + Constans.CHARACTER_WIDTH][player.getY()]-1]);
                    }

                    //timer
                    new java.util.Timer().schedule(
                            new java.util.TimerTask() {
                                @Override
                                public void run() {
                                    player.setBaseImage();
                                    repaint();
                                }
                            }, 200
                    );
                }
            }
            repaint();
        }
    }
}
