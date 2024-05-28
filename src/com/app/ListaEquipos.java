package com.app;
public class ListaEquipos {
    private final Equipo[] equipos;
    private final int cantMax;
    private int cantActual;
    /**
     * Constructor de la clase Lista de Equipos.
     * @param cantMax: Parámetro de la cantidad máxima de equipos en la lista.
     */
    public ListaEquipos(int cantMax) {
        this.equipos = new Equipo[cantMax];
        this.cantMax = cantMax;
        this.cantActual = 0;
    }
    /**
     * Agregar un nuevo equipo a la lista de equipos.
     * @param equipo : Nuevo equipo a la lista de equipos.
     */
    public void agregarEquipo(Equipo equipo){
        if(this.cantActual < this.cantMax){
            this.equipos[this.cantActual] = equipo;
            this.cantActual++;
        }
    }
    /**
     * Buscar un equipo por su nombre.
     * @param nombre: Parámetro del nombre del equipo que se desea buscar.
     * @return equipo buscado
     */
    public Equipo buscarEquipo(String nombre){
        Equipo retornar = null;
        for(int i = 0; i < this.cantActual; i++){
            if(nombre.equals(this.equipos[i].getNombre())){
                retornar = this.equipos[i];
                break;
            }
        }
        return retornar;
    }
    /**
     * Ordenar lista de mayor a menor con los puntos, goles de diferencia y goles de visitante.
     */
    public void ordenarLista(){
        for(int i = 0; i < this.cantActual; i++){
            for(int j = 0; j < this.cantActual; j++){
                int dif1 = this.equipos[i].getGolesAFavor()-this.equipos[i].getGolesEnContra();
                int dif2 = this.equipos[j].getGolesAFavor()-this.equipos[j].getGolesEnContra();
                if(
                            // Diferencia de puntos
                    this.equipos[i].getPuntos() > this.equipos[j].getPuntos() ||
                            // Goles de diferencia
                    (this.equipos[i].getPuntos() == this.equipos[j].getPuntos() && dif1 > dif2) ||
                            // Goles de visitante
                    (this.equipos[i].getPuntos() == this.equipos[j].getPuntos() && dif1 == dif2 &&
                    this.equipos[i].getGolesVisitantes() > this.equipos[j].getGolesVisitantes())) {
                        Equipo aux3 = this.equipos[i];
                        this.equipos[i] = this.equipos[j];
                        this.equipos[j] = aux3;
                }
            }
        }
    }
    /**
     * Obtener el parámetro "cantidad actual" de la clase Lista Equipo.
     * @return parámetro "cantidad actual" de la clase Lista Equipo.
     */
    public int getCantActual() {
        return this.cantActual;
    }
    /**
     * Obtener el equipo de una posición específica.
     * @param posicion: Parámetro de la posición del equipo que se quiere obtener.
     * @return equipo.
     */
    public Equipo getEquipo(int posicion){
        return this.equipos[posicion];
    }
}