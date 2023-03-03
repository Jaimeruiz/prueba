/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Jaime
 */
public  class Tenis2 {
    
    char [] partido;
    String secuencia;
    public int sets;
    public int puntosA = 0, puntosB = 0, breaksA = 0, breaksB = 0, setA = 0, setB = 0;
    public String marcadorA = "0";
    public String marcadorB = "0";
    
    public void  PartidoPorPantalla() {
        do {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el numero de sets (3 o 5):  ");
        sets = sc.nextInt();
        }while(sets % 2 == 0 || sets > 5 || sets < 2);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Introduzca la secuencia de puntos del partido:  ");
        String secuencia = sc2.nextLine();
        partido = secuencia.toCharArray();
        
    }
    
    public boolean breakA(int puntosA, int puntosB) {
        return puntosA >= 4 && puntosA - puntosB >= 2;
    
    }
    
    public boolean breakB(int puntosA, int puntosB) {
        return puntosB >= 4 && puntosB - puntosA >= 2;
    }
    
    public boolean setsA(int breaksA, int breaksB) {
        return breaksA >= 6 && breaksA - breaksB >= 2;
    
    }
    
    public boolean setsB(int breaksA, int breaksB) {
        return breaksB >= 6 && breaksB - breaksA >= 2;
    }
    
     public boolean tieBreakA(int puntosA, int puntosB){
         return puntosA >= 7 && puntosA - puntosB >=2;
     }
    
     public boolean tieBreakB(int puntosA, int puntosB){
         return puntosB >= 7 && puntosB - puntosA >=2;
     }
     
    public void marcador(){
           for(int i = 0; i < partido.length; i++){
            if(partido[i] == 'A' ){
                puntosA++;
              if(puntosA >= 4){
                 if ( breakA(puntosA, puntosB) ) {
                   breaksA++;
                   puntosA = 0;
                   puntosB = 0;         
        }
                 else if (puntosA == puntosB){
                  puntosA--;
                  puntosB--;
              }
              }
              
              else if(breaksA >= 6){
                if ( setsA(breaksA, breaksB) ) {
                   setA++;
                   breaksA = 0;
                   breaksB = 0; 
                 
              }
                else if(breaksA == 7 && breaksB == 6){
                    setA++;
                    breaksA = 0;
                    breaksB = 0;
                }
              }
            }
            
              if(partido[i] == 'B' ){
                puntosB++;
              if(puntosB >= 4){
                 if ( breakB(puntosA, puntosB) ) {
                   breaksB++;
                   puntosA = 0;
                   puntosB = 0;         
        }
                  else if (puntosA == puntosB){
                  puntosA--;
                  puntosB--;
              }
              }
              if(breaksB >= 6){
                if ( setsB(breaksA, breaksB) ) {
                   setB++;
                   breaksA = 0;
                   breaksB = 0; 
             
              }
                 else if(breaksA == 6 && breaksB == 7){
                    setB++;
                    breaksA = 0;
                    breaksB = 0;
                }
                 
              }
            }
           }
       System.out.println("Resultado final del partido: ");
       System.out.println(setA + " - " + setB);
       System.out.println(breaksA + " - " + breaksB);
       System.out.println(puntosA + " - " + puntosB);
       
           }

    public void resultado(){
       if(setA + setB < sets){
         if(sets == 3){  
           if(sets - setA < 2 && setA > setB  ){
            System.out.print("PARTIDO TERMINADO\n");
            System.out.print("JUGADOR A gana\n");
           }
           else if(sets - setB < 2 && setB > setA  ){
            System.out.print("PARTIDO TERMINADO\n");
            System.out.print("JUGADOR B gana\n");
           }
           else{
           System.out.print("PARTIDO EN JUEGO\n");
           }
        }
         else{
             if(sets - setA <= 2 && setA > setB  ){
            System.out.print("PARTIDO TERMINADO\n");
            System.out.print("JUGADOR A gana\n");
           }
           else if(sets - setB <= 2 && setB > setA  ){
            System.out.print("PARTIDO TERMINADO\n");
            System.out.print("JUGADOR B gana\n");
           }
           else{
           System.out.print("PARTIDO EN JUEGO\n");
           }
         }
       }
        else if(setA + setB > sets || (setA + setB == sets && breaksA + breaksB > 0) || (setA + setB == sets && puntosA + puntosB > 0) ){
            System.out.print("RESULTADO INCORRECTO\n");
        }
        else{
            System.out.print("PARTIDO TERMINADO\n");
            if(setA > setB){
                System.out.print("JUGADOR A gana\n");
            }else{
                System.out.print("JUGADOR B gana\n");
            }
        }
    }
    
    public char[] getPartido() {
        return partido;
    }

    public void setPartido(char[] partido) {
        this.partido = partido;
    }
}

