package ru.netology.manager;

import ru.netology.domain.NotRegisteredException;
import ru.netology.domain.Player;

import java.util.HashMap;

public class Game {
    // все зарегистрированные игроки в виде мапы с ключом - имя.
    HashMap<String, Player> players = new HashMap<>();

    // метод регистрации игрока
    public void register(Player player) {
        players.put(player.getName(), player);
    }

    public HashMap<String, Player> findAll() {
        return players;
    }

    //полную информацию об игроке нужно будет найти в мапе зарегистрированных игроков через имя
    //если не зарегестрирован, должно выкинуться исключение NotRegisteredException, чтобы не дублировать в round
    public Player findByName(String playerName) {
        Player player = players.get(playerName);
        if (player != null) {
            return player;
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

