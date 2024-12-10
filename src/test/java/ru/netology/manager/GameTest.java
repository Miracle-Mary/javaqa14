package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.NotRegisteredException;
import ru.netology.domain.Player;
import java.util.HashMap;

public class GameTest {
    Player player1 = new Player(11, "Irina55", 30);
    Player player2 = new Player(222, "Andrey", 30);
    Player player3 = new Player(3, "Ivan7", 20);

    @Test
    public void shouldRegisteredPlayers() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        HashMap<String, Player> actual = game.findAll();

        HashMap<String, Player> expected = new HashMap<>();
        expected.put("Irina55", player1);
        expected.put("Andrey", player2);
        expected.put("Ivan7", player3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindRegisteredPlayerByName() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertEquals(player2, game.findByName("Andrey"));
    }

    @Test
    public void shouldThrowNotRegisteredException() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.findByName("Lena");
        });
    }

    @Test
    public void shouldWinFirstPlayer() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertEquals(1, game.round("Irina55", "Ivan7"));
    }

    @Test
    public void shouldWinSecondPlayer() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertEquals(2, game.round("Ivan7", "Andrey"));
    }

    @Test
    public void shouldDraw() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertEquals(0, game.round("Irina55", "Andrey"));
    }

    @Test
    public void shouldThrowNotRegisteredExceptionNoRegisteredPlayers() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Lena", "Ivan");
        });
    }

    @Test
    public void shouldThrowNotRegisteredExceptionOneRegisteredPlayer() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Ivan7", "Ivan");
        });
    }
}
