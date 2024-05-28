package com.app;
import java.io.*;
import java.util.*;
public class CampeonatoNacionalImpl implements CampeonatoNacional {
    private final ListaEquipos equipos;
    private final ListaDobleNexoPartidos partidos;
    private final ArrayList<String> campeones;
    private final ArrayList<Equipo> seguir;
    /**
     * Constructor de la clase CampeonatoNacionalImpl
     */
    public CampeonatoNacionalImpl() {
        this.campeones = new ArrayList<>();
        this.seguir = new ArrayList<>();
        this.equipos = new ListaEquipos(20);
        this.partidos = new ListaDobleNexoPartidos();
    }
    /**
     * Leer los archivos de texto.
     */
    @Override
    public void leerArchivos(){
        try{
            File archivo = new File("Equipos.txt");
            Scanner scanner = new Scanner(archivo);
            while(scanner.hasNextLine()){
                String[] partes = scanner.nextLine().split(",");
                equipos.agregarEquipo(new Equipo(partes[0], Integer.parseInt(partes[1]), Integer.parseInt(partes[2]),
                        Integer.parseInt(partes[3]), Float.parseFloat(partes[4]), partes[5], 0,
                        0,0,0,0,0,0));
            }
        } catch (Exception e){ System.out.println("Hubo un error en el archivo de equipos."); }
        try{
            File archivo = new File("Partidos.txt");
            Scanner scanner = new Scanner(archivo);
            while(scanner.hasNextLine()){
                String[] partes = scanner.nextLine().split(",");
                int fecha = Integer.parseInt(partes[0]);
                for(int i=0; i<Integer.parseInt(partes[1]); i++){
                    String[] partidoArchivo = scanner.nextLine().split("-");
                    Equipo local = equipos.buscarEquipo(partidoArchivo[0]);
                    Equipo visitante = equipos.buscarEquipo(partidoArchivo[1]);
                    Partido nuevoPartido1 = new Partido(fecha, local, visitante, local.getEstadio());
                    partidos.agregarPartido(nuevoPartido1);
                    Partido nuevoPartido2 = new Partido(fecha + 17, visitante, local, visitante.getEstadio());
                    partidos.agregarPartido(nuevoPartido2);
                }
            }
        } catch (Exception e){ System.out.println("Hubo un error en el archivo de partidos."); }
        partidos.ordenarLista();
    }
    /**
     * Jugar el partido de una fecha en específica.
     * @param fecha: Parámetro de la fecha del partido que se quiera jugar.
     */
    @Override
    public void jugarPartido(int fecha){
        NodoPartido partidoNodo = partidos.getHead();
        System.out.println("                FECHA N°"+fecha);
        while(partidoNodo.getPartido().getFecha() != fecha){
            partidoNodo = partidoNodo.getNext();
        }

        // Recorrer todos los partidos de la fecha
        while(partidoNodo.getPartido().getFecha() == fecha){
            int golesLocal = 0, golesVisitante = 0;
            Equipo local = partidoNodo.getPartido().getLocal();
            Equipo visitante = partidoNodo.getPartido().getVisitante();
            // Si el ataque local es mayor a la defensa visitante, sumar un gol al local
            if((Math.random()*(local.getDelantera())) > (Math.random()*(visitante.getDefensa()))){
                golesLocal += 1;
            }

            // Si el ataque visitante es mayor a la defensa local, sumar un gol al visitante
            else if((Math.random()*(visitante.getDelantera())) > (Math.random()*(local.getDefensa()))){
                golesVisitante += 1;
            }

            // Si el medio campo local es mayor al medio campo visitante, sumar un gol al local
            if((Math.random()*(local.getMedioCampo())) > (Math.random()*(visitante.getMedioCampo()))){
                golesLocal += 1;
            }

            // Si el medio campo visitante es mayor al medio campo local, sumar un gol al visitante
            else if((Math.random()*(visitante.getMedioCampo())) > (Math.random()*(local.getMedioCampo()))){
                golesVisitante += 1;
            }

            // Si el local es mayor al visitante, sumar un gol al local
            if((Math.random()*(local.getEstrella())) > (Math.random()*(visitante.getEstrella()))){
                golesLocal += 1;
            }

            // Si el visitante es mayor al local, sumar un gol al visitante
            else{
                golesVisitante += 1;
            }

            // Sumar los goles a favor y en contra de los equipos que jugaron
            local.setGolesAFavor(local.getGolesAFavor() + golesLocal);
            local.setGolesEnContra(local.getGolesEnContra() + golesVisitante);
            visitante.setGolesAFavor(visitante.getGolesAFavor() + golesVisitante);
            visitante.setGolesEnContra(visitante.getGolesEnContra() + golesLocal);
            visitante.setGolesVisitantes(visitante.getGolesVisitantes() + golesVisitante);

            // Si gana el local, sumar en la estadística:
            // - 3 puntos para el local
            // - 1 partido ganado para el local
            // - 1 partido perdido al visitante
            if(golesLocal > golesVisitante){
                local.setPuntos(local.getPuntos() + 3);
                local.setPartidosGanados(local.getPartidosGanados() + 1);
                visitante.setPartidosPerdidos(visitante.getPartidosPerdidos() + 1);
            }

            // Si gana el visitante, sumar en la estadística:
            // - 3 puntos para el visitante
            // - 1 partido ganado para el visitante
            // - 1 partido perdido al local
            else if(golesLocal < golesVisitante){
                visitante.setPuntos(visitante.getPuntos() + 3);
                visitante.setPartidosGanados(visitante.getPartidosGanados() + 1);
                local.setPartidosPerdidos(local.getPartidosPerdidos() + 1);
            }

            // Si empatan, sumar en la estadística:
            // - 1 punto para ambos equipos
            // - 1 partido empatado para el local
            // - 1 partido empatado para el visitante
            else {
                local.setPuntos(local.getPuntos() + 1);
                local.setPartidosEmpates(local.getPartidosEmpates() + 1);
                visitante.setPuntos(visitante.getPuntos() + 1);
                visitante.setPartidosEmpates(visitante.getPartidosEmpates() + 1);

            }

            // Si se sigue a algún equipo del partido, colocar una estrella al lado del resultado
            if(seguir.contains(equipos.buscarEquipo(local.getNombre())) ||
                    seguir.contains(equipos.buscarEquipo(visitante.getNombre()))) {
                System.out.print("\u001B[36m" +"★"+ "\u001B[0m");
            }

            // Si gana el local, colocar el nombre en verde y al visitante en rojo
            if(golesLocal > golesVisitante){
                System.out.println(
                    "[" + "\u001B[32m" + local.getNombre() + "\u001B[0m" + "]  " + golesLocal +
                    " : " + golesVisitante+"  [" + "\u001B[31m" +visitante.getNombre()
                    + "\u001B[0m" +"]  |  Estadio: " + partidoNodo.getPartido().getEstadio());
            }

            // Si gana el visitante, colocar el nombre en verde y al local en rojo
            else if(golesLocal < golesVisitante){
                System.out.println("["+ "\u001B[31m" +local.getNombre()+ "\u001B[0m" + "]  "+golesLocal+" : "+golesVisitante+"  [" + "\u001B[32m" +visitante.getNombre()+ "\u001B[0m" +"]  |  Estadio: "+partidoNodo.getPartido().getEstadio());
            }

            // Si empataron, colocar ambos nombres en amarillo
            else{
                System.out.println("["+ "\u001B[33m" +local.getNombre()+ "\u001B[0m" + "]  "+golesLocal+" : "+golesVisitante+"  [" + "\u001B[33m" +visitante.getNombre()+ "\u001B[0m" +"]  |  Estadio: "+partidoNodo.getPartido().getEstadio());
            }

            // Si no hay más partidos, terminar el ciclo
            if(partidoNodo.getNext() == null){
                break;
            }

            partidoNodo = partidoNodo.getNext();
        }

        equipos.ordenarLista();

        // Si se juega la última fecha, añadir a la lista de campeones al equipo que se encuentra en primer lugar
        if(fecha == 34){
            campeones.add(equipos.getEquipo(0).getNombre());
        }
    }
    /**
     * Mostrar la tabla de posiciones del campeonato.
     */
    @Override
    public void mostrarTabla(){
        System.out.println("                                     TABLA");
        for(int i = 0; i < equipos.getCantActual(); i++){
            String nombre = equipos.getEquipo(i).getNombre();
            int PG = equipos.getEquipo(i).getPartidosGanados();
            int PE = equipos.getEquipo(i).getPartidosEmpates();
            int PP = equipos.getEquipo(i).getPartidosPerdidos();
            int PJ = PG+PE+PP; // Partidos totales jugados
            int GF = equipos.getEquipo(i).getGolesAFavor();
            int GC = equipos.getEquipo(i).getGolesEnContra();
            int DG = GF - GC; // Goles de diferencia
            int PTS = equipos.getEquipo(i).getPuntos();
            if(seguir.contains(equipos.buscarEquipo(nombre))){ System.out.print("\u001B[36m" +"★ "+ "\u001B[0m"); }
            else{ System.out.print("  "); }
            if(i+1 < 10){
                // Mostrar en amarillo el primer lugar
                if(i == 0){
                    System.out.println(
                            "\u001B[33m" + (i + 1)
                            + ".  " + nombre
                            + " | PJ : " + PJ
                            + " | PG : " + PG
                            + " | PE : " + PE
                            + " | PP : " + PP
                            + " | GF : " + GF
                            + " | GC : " + GC
                            + " | DG : " + DG
                            + " | PTS : " + PTS
                            + "\u001B[0m");
                }

                // Mostrar en celeste los puestos de copa libertadores
                else if(i == 1 || i == 2){
                    System.out.println(
                            "\u001B[34m" + (i + 1)
                            + ".  " + nombre
                            + " | PJ : " + PJ
                            + " | PG : " + PG
                            + " | PE : " + PE
                            + " | PP : " + PP
                            + " | GF : " + GF
                            + " | GC : " + GC
                            + " | DG : " + DG
                            + " | PTS : " + PTS
                            + "\u001B[0m");
                }

                // Mostrar en cyan los puesto de copa sudamericana
                else if(i == 3 || i == 4 || i == 5 || i == 6){
                    System.out.println(
                            "\u001B[36m" + (i + 1)
                            + ".  " + nombre
                            + " | PJ : " + PJ
                            + " | PG : " + PG
                            + " | PE : " + PE
                            + " | PP : " + PP
                            + " | GF : " + GF
                            + " | GC : " + GC
                            + " | DG : " + DG
                            + " | PTS : " + PTS
                            + "\u001B[0m");
                }

                // Mostrar en blanco los puestos normales
                else{
                    System.out.println(
                            (i + 1)
                            + ".  " + nombre
                            + " | PJ : " + PJ
                            + " | PG : " + PG
                            + " | PE : " + PE
                            + " | PP : " + PP
                            + " | GF : " + GF
                            + " | GC : " + GC
                            + " | DG : " + DG
                            + " | PTS : "+PTS);
                }
            }
            else{
                //Mostrar en morado el puesto que disputa liguilla de promoción
                if(i == 14){
                    System.out.println(
                            "\u001B[35m" + (i + 1)
                            + ". " + nombre
                            + " | PJ : " + PJ
                            + " | PG : " + PG
                            + " | PE : " + PE
                            + " | PP : " + PP
                            + " | GF : " + GF
                            + " | GC : " + GC
                            + " | DG : " + DG
                            + " | PTS : " + PTS
                            + "\u001B[0m");
                }

                // Mostrar en rojo los puestos de descenso
                else if (i == 15 || i == 16) {
                    System.out.println(
                            "\u001B[31m" + (i + 1)
                            + ". " + nombre
                            + " | PJ : " + PJ
                            + " | PG : " + PG
                            + " | PE : " + PE
                            + " | PP : " + PP
                            + " | GF : " + GF
                            + " | GC : " + GC
                            + " | DG : " + DG
                            + " | PTS : " + PTS
                            + "\u001B[0m");
                }

                // Mostrar en blanco los puestos normales
                else {
                    System.out.println(
                            (i + 1)
                            + ". " + nombre
                            + " | PJ : " + PJ
                            + " | PG : " + PG
                            + " | PE : " + PE
                            + " | PP : " + PP
                            + " | GF : " + GF
                            + " | GC : " + GC
                            + " | DG : " + DG
                            + " | PTS : " + PTS);
                }
            }
        }
    }
    /**
     * Mostrar los resultados finales del campeonato.
     */
    @Override
    public void mostrarResultados(){
        equipos.ordenarLista();
        int campeon = 0;
        for (String campeones : campeones) {
            if (campeones.equals(equipos.getEquipo(0).getNombre())) {
                campeon++;
            }
        }
        if(campeon == 2){
            System.out.println("♛★★♛BICAMPEÓN♛★★♛");
        }
        else if(campeon == 3){
            System.out.println("♛★★TRICAMPEÓN♛★★♛");
        }
        else if(campeon == 4){
            System.out.println("♛★★TETRACAMPEÓN♛★★♛");
        }
        else if(campeon == 5){
            System.out.println("♛★★PENTACAMPEÓN♛★★♛");
        }
        else{
            System.out.println("♛★★♛CAMPEÓN♛★★♛");
        }
        System.out.println(equipos.getEquipo(0).getNombre());
        System.out.println("    CLASIFICA A COPA LIBERTADORES");
        System.out.println(equipos.getEquipo(0).getNombre());
        System.out.println(equipos.getEquipo(1).getNombre());
        System.out.println(equipos.getEquipo(2).getNombre());
        System.out.println("    CLASIFICA A COPA SUDAMERICANA");
        System.out.println(equipos.getEquipo(3).getNombre());
        System.out.println(equipos.getEquipo(4).getNombre());
        System.out.println(equipos.getEquipo(5).getNombre());
        System.out.println(equipos.getEquipo(6).getNombre());
        System.out.println("    DISPUTA LA LIGUILLA DE PROMOCIÓN");
        System.out.println(equipos.getEquipo(14).getNombre());
        System.out.println("    DESCIENDEN");
        System.out.println(equipos.getEquipo(15).getNombre());
        System.out.println(equipos.getEquipo(16).getNombre());
    }
    /**
     * Agregar un equipo a la lista de seguimiento del usuario.
     * @param cantidad: Parámetro de cantidad de equipo que se desean seguir.
     */
    public void agregarEquipos(int cantidad){
        mostrarTabla();
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < cantidad; i++){
            boolean confirmar = false;
            while(!confirmar){
                System.out.print(i+1+". Ingrese el número del equipo que desea seguir: ");
                int posicion = scanner.nextInt();
                if(seguir.contains(equipos.getEquipo(posicion-1))){
                    System.out.print("Este equipo ya se encuentra en la lista de seguidos.");
                }
                else{
                    seguir.add(equipos.getEquipo(posicion-1));
                    confirmar = true;
                }
            }
        }
    }

    /**
     * Mostrar los campeones de cada año.
     */
    @Override
    public void campeonesPorAnio(){
        int ano = 2021;
        System.out.println("█████████████████████████████████████████████████████████████████████████████████████");
        for (String campeones : campeones) {
            System.out.println("AÑO: " + ano);
            System.out.println("CAMPEÓN: " + campeones);
            System.out.println("══════════════════════════");
            ano++;
        }
        System.out.println("█████████████████████████████████████████████████████████████████████████████████████");
    }

    /**
     * Reiniciar estadísticas de los equipos.
     */
    @Override
    public void reiniciarCampeonato(){
        for(int i = 0; i < equipos.getCantActual(); i++){
            equipos.getEquipo(i).setPartidosGanados(0);
            equipos.getEquipo(i).setPartidosEmpates(0);
            equipos.getEquipo(i).setPartidosPerdidos(0);
            equipos.getEquipo(i).setGolesAFavor(0);
            equipos.getEquipo(i).setGolesVisitantes(0);
            equipos.getEquipo(i).setGolesEnContra(0);
            equipos.getEquipo(i).setPuntos(0);
        }
    }
}