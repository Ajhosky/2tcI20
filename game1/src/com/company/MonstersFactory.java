package com.company;

import com.company.classes.CharacterClass;
import com.company.classes.characters.Constans;

import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;

public class MonstersFactory extends TimerTask{
    public GameField gameField;
    private ArrayList<MonsterBase> monsters;
    public MonstersFactory(GameField gameField, ArrayList<MonsterBase> monsters){
        this.gameField = gameField;
        this.monsters = monsters;
    }

    @Override
    public void run() {
        //CharacterClass.occupiedCells
                if(this.monsters.size() < 3){
                    Random rnd =  new Random();
                    int x, y;

                    do {
                        x = rnd.nextInt(8) * Constans.CHARACTER_WIDTH;
                        y = rnd.nextInt(5) * Constans.CHARACTER_HEIGHT;
                    } while (CharacterClass.occupiedCells[x][y] > 0);

                    CharacterClass.occupiedCells[x][y] = 10;
                    MonsterBase monster = new MonsterBase(x, y);

                    monsters.add(monster);
                    gameField.repaint();
                }
    }
}
