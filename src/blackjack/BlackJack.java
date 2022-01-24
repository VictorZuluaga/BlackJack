

package blackjack;

import java.util.ArrayList;

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
        
        System.out.println("Hola Mundo");
        
    }
    
}
