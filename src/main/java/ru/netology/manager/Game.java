package ru.netology.manager;

import ru.netology.domain.NotRegisteredException;
import ru.netology.domain.Player;
import java.util.ArrayList;
import java.util.List;

public class Game {
    // все зарегистрированные игроки в виде списка.
    List<Player> players = new ArrayList<>();

    // метод регистрации игрока
    public void register(Player player) {
        players.add(player);
    }

    public List<Player> findAll() {
        return players;
    }

    //полную информацию об игроке нужно будет найти в коллекции зарегистрированных игроков через имя
    //если не зарегестрирован, должно выкинуться исключение NotRegisteredException, чтобы не дублировать в round
    public Player findByName(String playerName) {
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }
        throw new NotRegisteredException(
                "Player: " + playerName + " not registered"
        );
    }

    //метод соревнования между двумя игроками
    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else {
            return 0;
        }
    }
}

