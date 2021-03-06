package com.company;

import com.company.classes.CharacterClass;
import com.company.classes.arenas.Syberia;
import com.company.classes.characters.Constans;

public class Team {
    protected CharacterClass[] teamMembers;

    public void setArena(Syberia arena) {
        this.arena = arena;
    }

    private Syberia arena;
    public Team(CharacterClass... members) {
        teamMembers = new CharacterClass[members.length];
        for (int i = 0; i < teamMembers.length; i++) {
            teamMembers[i] = members[i];
        }
    }

    public CharacterClass[] getTeamMembers() {
        return teamMembers;
    }

    public void info(){
        //for(int i = 0; i < teamMembers.length; i++){
        for(CharacterClass teamMembers : teamMembers){
            teamMembers.info();
        }
    }

    public boolean enterArena(Syberia arena1) {
        return arena1.open(this);
    }

    public void setTeamMembers(CharacterClass[] teamMembers) {
        this.teamMembers = teamMembers;
    }

    public void runArena() {
        MainWindow mw = new MainWindow(Constans.WINDOW_WIDTH, Constans.WINDOW_HEIGHT, this);
    }
}

