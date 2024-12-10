package ru.netology.domain;

public class Player {
    private int id; // номер
    private String name; // имя
    private int strength; // сила

    public Player(int id, String name, int strength) {
        this.id = id;
        this.name = name;
        this.strength = strength;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }
}
