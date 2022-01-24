
package blackjack;

import static blackjack.BlackJack.getWinners;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

public class BlackJackTest {
    
    public BlackJackTest() {
    }
    
    @Test
    public void testIsWinner() {
        boolean result;
        
        String[] croupier_s1 = {"J","8"};
        String[] croupier_s2 = {"K", "A"};
        String[] croupier_s3 = {"A", "A","7"};
        String[] jugador_s1 = {"J", "8"};
        String[] jugador_s2 = {"J", "A"};
        String[] jugador_s3 = {"7", "8"};
        
        
        ArrayList<String> croupier1 = new ArrayList(Arrays.asList(croupier_s1));
        ArrayList<String> croupier2 = new ArrayList(Arrays.asList(croupier_s2));
        ArrayList<String> croupier3 = new ArrayList(Arrays.asList(croupier_s3));
        
        ArrayList<String> jugador1 = new ArrayList(Arrays.asList(jugador_s1));
        ArrayList<String> jugador2 = new ArrayList(Arrays.asList(jugador_s2));
        ArrayList<String> jugador3 = new ArrayList(Arrays.asList(jugador_s3));
        
        result = BlackJack.isWinner(croupier1, jugador1);
        assertFalse(result);
        result = BlackJack.isWinner(croupier1, jugador2);
        assertTrue(result);
        result = BlackJack.isWinner(croupier2, jugador2);
        assertFalse(result);
        result = BlackJack.isWinner(croupier3, jugador3);
        assertFalse(result);
    }

    @Test
    public void testGetWinners() {
        
        String result1 = "[player1]";
        String result2 = "[player1, player3]";
        
        String[] player1_s = {"J", "A"};
        String[] player2_s = {"10", "5", "6"};
        String[] player3_s = {"3", "6", "A", "3", "A", "K"};
        String[] croupier_s = {"9", "7"};
        String[] deck_s = {"5", "4", "K", "2"};

        ArrayList<String> player1 = new ArrayList(Arrays.asList(player1_s));
        ArrayList<String> player2 = new ArrayList(Arrays.asList(player2_s));
        ArrayList<String> player3 = new ArrayList(Arrays.asList(player3_s));
        ArrayList<String> croupier = new ArrayList(Arrays.asList(croupier_s));
        ArrayList<String> deck = new ArrayList(Arrays.asList(deck_s));
        
        ArrayList<String> winners = getWinners(croupier, player1, player2, player3, deck);
        
        assertTrue(winners.toString().equals(result1));
        assertFalse(winners.toString().equals(result2));
        
        String[] player1_s2 = {"10", "K"};
        String[] player2_s2 = {"10", "2", "6"};
        String[] player3_s2 = {"8", "8", "5"};
        String[] croupier_s2 = {"5", "10"};
        String[] deck_s2 = {"A", "3", "K", "2"};

        ArrayList<String> player12 = new ArrayList(Arrays.asList(player1_s2));
        ArrayList<String> player22 = new ArrayList(Arrays.asList(player2_s2));
        ArrayList<String> player32 = new ArrayList(Arrays.asList(player3_s2));
        ArrayList<String> croupier2 = new ArrayList(Arrays.asList(croupier_s2));
        ArrayList<String> deck2 = new ArrayList(Arrays.asList(deck_s2));
        winners = getWinners(croupier2, player12, player22, player32, deck2);
        
        assertTrue(winners.toString().equals(result2));
        assertFalse(winners.toString().equals(result1));
        
    }

    
}
