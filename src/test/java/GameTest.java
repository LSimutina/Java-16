import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testFirstPlayerWins() {
        Game game = new Game();
        Player tom = new Player(1, "Tom", 70);
        Player bill = new Player(1, "Bill", 80);

        game.register(tom);
        game.register(bill);

        int actual = game.round("Bill", "Tom");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSecondPlayerWon() {
        Game game = new Game();
        Player tom = new Player(1, "Tom", 70);
        Player bill = new Player(1, "Bill", 80);

        game.register(tom);
        game.register(bill);

        int actual = game.round("Tom", "Bill");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDrawPlayer() {
        Game game = new Game();
        Player tom = new Player(1, "Tom", 70);
        Player bill = new Player(1, "Bill", 70);

        game.register(tom);
        game.register(bill);

        int actual = game.round("Tom", "Bill");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testThereIsNoFirstPlayer() {
        Game game = new Game();
        Player tom = new Player(1, "Tom", 70);
        Player bill = new Player(1, "Bill", 70);

        game.register(tom);
        game.register(bill);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Jon", "Bill")
        );
    }

    @Test
    public void testThereIsNoTwoPlayer() {
        Game game = new Game();
        Player tom = new Player(1, "Tom", 70);
        Player bill = new Player(1, "Bill", 70);

        game.register(tom);
        game.register(bill);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Bill", "Jon")
        );
    }

    @Test
    public void testNoPlayer() {
        Game game = new Game();
        Player tom = new Player(1, "Tom", 70);
        Player bill = new Player(1, "Bill", 70);

        game.register(tom);
        game.register(bill);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Mike", "Jon")
        );
    }
}