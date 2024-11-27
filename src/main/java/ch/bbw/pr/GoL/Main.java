/**
 * @author Lucien
 * Main Klasse zum ausführen des Game Of Life
 * Am besten macht man es über das Terminal
 */
package ch.bbw.pr.GoL;

import java.util.Scanner;
import ch.bbw.pr.GoL.Logic.Logic;

public class Main {
    public static void main(String[] args) {
        System.out.println("Es startet mit 50 Zellen. Das ist die Ausgangslage:");
        GridMaker game = new GridMaker();
        Logic logic = new Logic();
        game.printGrid();

        Scanner reader = new Scanner(System.in);
        System.out.println("Wie viele Generation sollen erstellt werden?");
        int anzahlGen = reader.nextInt();
        System.out.println("Wie schnell soll es zwischen den Bilder gehen? (gezählt in zehntel Sekunden)");
        int speed = reader.nextInt()*100;

        int gen = 1;
        boolean weiter = true;
        while (weiter){

            for (int i = 0; i < anzahlGen ; i++) {
                try{
                    Thread.sleep(speed);
                }catch(InterruptedException e){
                    System.out.println("Thread interrupted: " + e.getMessage());
                    Thread.currentThread().interrupt();
                }
                clearConsole();
                System.out.println();
                System.out.println("Generation " + gen);
                logic.checkEveryCell(game.getGrid(), game);
                System.out.println("Anzahl Lebender Zellen: "+ logic.wieVielX(game.getGrid()));
                game.printGrid();
                gen++;
            }
            System.out.println("Want to continue with this Map? (Antworte mit true oder false)");
            weiter = reader.nextBoolean();
            if (weiter){
                System.out.println("Wie viele Generation sollen erstellt werden?");
                anzahlGen = reader.nextInt();
            }
        }
    }

    private static void clearConsole(){
       try{
           new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
       }
       catch(Exception e){
           System.out.println("Problem mit Console clearen");
       }
    }
}
