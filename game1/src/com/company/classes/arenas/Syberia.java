package com.company.classes.arenas;

import com.company.Team;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Syberia implements BaseArena{



    private boolean isOpened = false;




    public boolean open(Team team) {
        if (team.getTeamMembers().length < 1) {
            System.out.println("Not enough party members!");
            isOpened = false;
        } else {
            System.out.println("Welcome, heroes");
            isOpened = true;
        }
        return isOpened;
    }
}
