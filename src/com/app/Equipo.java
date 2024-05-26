package com.app;
public class Equipo {
    private final String nombre;
    private final int delantera;
    private final int medioCampo;
    private final int defensa;
    private final float estrella;
    private final String estadio;
    private int partidosGanados;
    private int partidosEmpates;
    private int partidosPerdidos;
    private int golesAFavor;
    private int golesEnContra;
    private int golesVisitantes;
    private int puntos;
    /**
     * Constructor de la clase Equipo.
     * @param nombre: Parámetro del nombre del equipo.
     * @param delantera: Parámetro de la puntuación de la delantera del equipo.
     * @param medioCampo: Parámetro de la puntuación del medio campo del equipo.
     * @param defensa: Parámetro de la puntuación de la defensa del equipo.
     * @param estrella: Parámetro de la cantidad de estrellas del equipo.
     * @param estadio: Parámetro del nombre del estadio local del equipo.
     * @param partidosGanados: Parámetro de los partidos ganados del equipo.
     * @param partidosEmpates: Parámetro de los partidos empatados del equipo.
     * @param partidosPerdidos: Parámetro de los partidos perdidos del equipo.
     * @param golesAFavor: Parámetro de los goles a favor del equipo.
     * @param golesEnContra: Parámetro de los goles en contra del equipo.
     * @param golesVisitantes: Parámetro de los goles de visitante del equipo.
     * @param puntos: Parámetro de los puntos del equipo.
     */
    public Equipo(String nombre, int delantera, int medioCampo, int defensa, float estrella, String estadio, int partidosGanados,
                  int partidosEmpates, int partidosPerdidos, int golesAFavor, int golesEnContra, int golesVisitantes, int puntos) {
        this.nombre = nombre;
        this.delantera = delantera;
        this.medioCampo = medioCampo;
        this.defensa = defensa;
        this.estrella = estrella;
        this.estadio = estadio;
        this.partidosGanados = partidosGanados;
        this.partidosEmpates = partidosEmpates;
        this.partidosPerdidos = partidosPerdidos;
        this.golesAFavor = golesAFavor;
        this.golesEnContra = golesEnContra;
        this.golesVisitantes = golesVisitantes;
        this.puntos = puntos;
    }
    /**
     * Obtener el parámetro "nombre" de la clase equipo.
     * @return parámetro "nombre" de la clase equipo.
     */
    public String getNombre() { return this.nombre; }
    /**
     * Obtener el parámetro "delantera" de la clase equipo.
     * @return parámetro "delantera" de la clase equipo.
     */
    public int getDelantera() { return this.delantera; }
    /**
     * Obtener el parámetro "medioCampo" de la clase equipo.
     * @return parámetro "medioCampo" de la clase equipo.
     */
    public int getMedioCampo() { return this.medioCampo; }
    /**
     * Obtener el parámetro "defensa" de la clase equipo.
     * @return parámetro "defensa" de la clase equipo.
     */
    public int getDefensa() { return this.defensa; }
    /**
     * Obtener el parámetro "estrella" de la clase equipo.
     * @return parámetro "estrella" de la clase equipo.
     */
    public float getEstrella() { return this.estrella; }
    /**
     * Obtener el parámetro "estadio local" de la clase equipo.
     * @return parámetro "estadio local" de la clase equipo.
     */
    public String getEstadio() { return this.estadio; }
    /**
     * Obtener el parámetro "partidos ganados" de la clase equipo.
     * @return parámetro "partidos ganados" de la clase equipo.
     */
    public int getPartidosGanados() { return partidosGanados; }
    /**
     * Modificar el parámetro "partidos ganados" de la clase equipo.
     * @param partidosGanados: Nuevo el parámetro "partidos ganados" de la clase equipo.
     */
    public void setPartidosGanados(int partidosGanados) { this.partidosGanados = partidosGanados; }
    /**
     * Obtener el parámetro "partidos empates" de la clase equipo.
     * @return parámetro "partidos empates" de la clase equipo.
     */
    public int getPartidosEmpates() { return partidosEmpates; }
    /**
     * Modificar el parámetro "partidos empates" de la clase equipo.
     * @param partidosEmpates: Nuevo el parámetro "partidos empates" de la clase equipo.
     */
    public void setPartidosEmpates(int partidosEmpates) { this.partidosEmpates = partidosEmpates; }
    /**
     * Obtener el parámetro "partidos perdidos" de la clase equipo.
     * @return parámetro "partidos perdidos" de la clase equipo.
     */
    public int getPartidosPerdidos() { return partidosPerdidos; }
    /**
     * Modificar el parámetro "partidos perdidos" de la clase equipo.
     * @param partidosPerdidos: Nuevo el parámetro "partidos perdidos" de la clase equipo.
     */
    public void setPartidosPerdidos(int partidosPerdidos) { this.partidosPerdidos = partidosPerdidos; }
    /**
     * Obtener el parámetro "goles a favor" de la clase equipo.
     * @return parámetro "goles a favor" de la clase equipo.
     */
    public int getGolesAFavor() { return golesAFavor; }
    /**
     * Modificar el parámetro "goles a favor" de la clase equipo.
     * @param golesAFavor: Nuevo el parámetro "goles a favor" de la clase equipo.
     */
    public void setGolesAFavor(int golesAFavor) { this.golesAFavor = golesAFavor; }
    /**
     * Obtener el parámetro "goles en contra" de la clase equipo.
     * @return parámetro "goles en contra" de la clase equipo.
     */
    public int getGolesEnContra() { return golesEnContra; }
    /**
     * Modificar el parámetro "goles en contra" de la clase equipo.
     * @param golesEnContra: Nuevo el parámetro "goles en contra" de la clase equipo.
     */
    public void setGolesEnContra(int golesEnContra) { this.golesEnContra = golesEnContra; }
    /**
     * Obtener el parámetro "goles visitantes" de la clase equipo.
     * @return parámetro "goles visitantes" de la clase equipo.
     */
    public int getGolesVisitantes() { return golesVisitantes; }
    /**
     * Modificar el parámetro "goles visitantes" de la clase equipo.
     * @param golesVisitantes: Nuevo el parámetro "goles visitantes" de la clase equipo.
     */
    public void setGolesVisitantes(int golesVisitantes) { this.golesVisitantes = golesVisitantes; }
    /**
     * Obtener el parámetro "puntos" de la clase equipo.
     * @return parámetro "puntos" de la clase equipo.
     */
    public int getPuntos() { return puntos; }
    /**
     * Modificar el parámetro "puntos" de la clase equipo.
     * @param puntos: Nuevo el parámetro "puntos" de la clase equipo.
     */
    public void setPuntos(int puntos) { this.puntos = puntos; }
}