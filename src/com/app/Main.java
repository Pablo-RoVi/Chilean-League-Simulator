package com.app;
import java.util.*;
public class Main {
    public static void main(String [] args){
        CampeonatoNacional sistema = new CampeonatoNacionalImpl();
        menu(sistema);
    }
    public static void menu(CampeonatoNacional sistema){
        int partido = 1;
        int ano = 2021;
        boolean salir = false;
        boolean elegir = false;
        sistema.leerArchivos();
        Scanner scanner = new Scanner(System.in);
        while(!salir){
            try{
                if(!elegir){
                    System.out.print("Ingrese cuántos equipos desea seguir: ");
                    int cantidad = scanner.nextInt();
                    sistema.agregarEquipos(cantidad);
                    elegir = true;
                }
                System.out.println();
                System.out.println("                        CAMPEONATO NACIONAL AÑO "+ano);
                System.out.println("█████████████████████████████████████████████████████████████████████████████████████");
                if(partido != 35){ System.out.println("1. Jugar partido N°"+partido); }
                else{ System.out.println("1. No hay más partidos"); }
                System.out.println("2. Ver tabla");
                System.out.println("3. Resultados finales");
                System.out.println("4. Mostrar campeones por año");
                System.out.println("5. Salir");
                if(partido == 35){ System.out.println("6. Comenzar año "+ (ano+1)); }
                System.out.println("══════════════════════════");
                System.out.print("Ingrese una opción: ");
                int opcion = scanner.nextInt();
                System.out.println("█████████████████████████████████████████████████████████████████████████████████████");
                switch (opcion) {
                    case 1 -> {
                        if(partido == 35){
                            System.out.println("No hay más partidos");
                            break;
                        }
                        sistema.jugarPartido(partido);
                        partido += 1;
                    }
                    case 2 -> sistema.mostrarTabla();
                    case 3 -> {
                        if(partido == 35){
                            sistema.mostrarResultados();
                        }
                        else{
                            System.out.println("El campeonato aún no termina para saber los resultados.");
                        }
                    }
                    case 4 -> sistema.campeonesPorAnio();
                    case 5 -> salir = true;
                    case 6 -> {
                        if(partido == 35){
                            sistema.reiniciarCampeonato();
                            partido = 1;
                            ano++;
                        }
                        else {
                            System.out.println("El campeonato aún no termina para reinicar la temporada.");
                        }
                    }
                    case 7 -> {
                        sistema.jugarTemporadaCompleta();
                        partido = 35;
                    }
                    default -> System.out.println("Opción incorrecta.");
                }
            } catch(InputMismatchException e){ System.out.println("Debe ser un número."); }
        }
 }
}