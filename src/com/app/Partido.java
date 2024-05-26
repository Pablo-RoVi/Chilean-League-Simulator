package com.app;
public class Partido {
    private final int fecha;
    private final Equipo local;
    private final Equipo visitante;
    private final String estadio;
    /**
     * Constructor de la clase Partido.
     * @param fecha: Parámetro  de la fecha del partido.
     * @param local: Parámetro del equipo que juega de local.
     * @param visitante: Parámetro del equipo que juega de visitante.
     * @param estadio: Parámetro del estadio donde se juega el partido.
     */
    public Partido(int fecha, Equipo local, Equipo visitante, String estadio) {
        this.fecha = fecha;
        this.local = local;
        this.visitante = visitante;
        this.estadio = estadio;
    }
    /**
     * Obtener el parámetro "fecha" de la clase Partido.
     * @return parámetro "fecha" de la clase Partido.
     */
    public int getFecha() { return this.fecha; }
    /**
     * Obtener el parámetro "local" de la clase Partido.
     * @return parámetro "local" de la clase Partido.
     */
    public Equipo getLocal() { return this.local; }
    /**
     * Obtener el parámetro "visitante" de la clase Partido.
     * @return parámetro "visitante" de la clase Partido.
     */
    public Equipo getVisitante() { return this.visitante; }
    /**
     * Obtener el parámetro "estadio donde se va a jugar" de la clase Partido.
     * @return parámetro "estadio donde se va a jugar" de la clase Partido.
     */
    public String getEstadio() { return this.estadio; }
}