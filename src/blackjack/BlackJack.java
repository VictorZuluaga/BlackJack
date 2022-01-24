

package blackjack;

import java.util.ArrayList;
import java.util.Arrays;

public class BlackJack {
    
    public static boolean isWinner(ArrayList<String> croupier,ArrayList<String> jugador){
        //si el jugador supera los 21 pierde
        if(SupportFunctions.getValue(jugador)>21){
            return false;
        }
        if(SupportFunctions.isBlackJack(croupier)){
            return false;
        }
        if (SupportFunctions.isBlackJack(jugador)) {
            return true;
        }
        if(SupportFunctions.getValue(croupier)>=SupportFunctions.getValue(jugador)&&
                SupportFunctions.getValue(croupier)<=21){
            return false;
        }else{
            return true;
        }
        
    }
    public static ArrayList<String> getWinners(ArrayList<String> croupier,
                                      ArrayList<String> player1,
                                      ArrayList<String> player2,
                                      ArrayList<String> player3,
                                      ArrayList<String> deck){
        ArrayList<String> res = new ArrayList<>();
        //El croupier juega
        SupportFunctions.croupierPlay(croupier, deck);
        //se decide a quien se añade a la lista de ganadores
        if (isWinner(croupier,player1)) {
            res.add("player1");
        }
        if (isWinner(croupier, player2)) {
            res.add("player2");
        }
        if (isWinner(croupier, player3)) {
            res.add("player3");
        }
        return res;
        
    }
    
    public static void main(String[] args) {
        
        //caso1
        /*caso 
        String[] player1_s = {"J","A"};
        String[] player2_s = {"10", "5","6"};
        String[] player3_s = {"3", "6", "A", "3", "A", "K"};
        String[] croupier_s = {"9","7"};
        String[] deck_s = {"5","4","K","2"};
        
        ArrayList<String> player1 = new ArrayList(Arrays.asList(player1_s));
        ArrayList<String> player2 = new ArrayList(Arrays.asList(player2_s));
        ArrayList<String> player3 = new ArrayList(Arrays.asList(player3_s));
        ArrayList<String> croupier = new ArrayList(Arrays.asList(croupier_s));
        ArrayList<String> deck = new ArrayList(Arrays.asList(deck_s));
        
        */
        //caso2 
        String[] player1_s = {"10", "K"};
        String[] player2_s = {"10", "2", "6"};
        String[] player3_s = {"8", "8", "5"};
        String[] croupier_s = {"5", "10"};
        String[] deck_s = {"A", "3", "K", "2"};

        ArrayList<String> player1 = new ArrayList(Arrays.asList(player1_s));
        ArrayList<String> player2 = new ArrayList(Arrays.asList(player2_s));
        ArrayList<String> player3 = new ArrayList(Arrays.asList(player3_s));
        ArrayList<String> croupier = new ArrayList(Arrays.asList(croupier_s));
        ArrayList<String> deck = new ArrayList(Arrays.asList(deck_s));

        
        ArrayList<String> x = getWinners(croupier,player1,player2,player3,deck);
        System.out.println(x);
        
    }
    
}
