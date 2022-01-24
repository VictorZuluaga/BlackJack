
package blackjack;

import java.util.ArrayList;

public class SupportFunctions {
    
    public static int getValue(ArrayList<String> cards) {
        
        int valorTotal=0;
        int contadorHaces = 0;
        for (String i : cards) {
            if(i.matches("[+-]?\\d*(\\.\\d+)?")){
                valorTotal+=Integer.parseInt(i);
                continue;
            }
            if(!i.equals("A")){
                valorTotal += 10;
            }else{
                contadorHaces+=1;
            }
        }
        while(contadorHaces>0){
            if((valorTotal+11==21&&contadorHaces==1)||valorTotal+11<21){
                valorTotal += 11;
            }else{
                valorTotal+=1;
            }
            contadorHaces--;
        }
        
        return valorTotal;
    }
    
    
    public static void croupierPlay(ArrayList<String> croupier, ArrayList<String> deck){
        while(getValue(croupier)< 17){
            croupier.add(deck.get(0));
            deck.remove(0);
        }
    }
    
    public static boolean isBlackJack(ArrayList<String> jugador){
        if(jugador.size()==2&&jugador.contains("A")&&(jugador.contains("K")||
                jugador.contains("J")||jugador.contains("Q"))){
            return true;
        }
        return false;
    }
    
    
    
}
