package com.app;
public class NodoPartido {
    private Partido partido;
    private NodoPartido next;
    private NodoPartido previous;
    /**
     * Constructor de la clase NodoPartido.
     * @param partido: Parámetro del partido del NodoPartido.
     */
    public NodoPartido(Partido partido) {
        this.partido = partido;
        this.next = null;
        this.previous = null;
    }
    /**
     * Obtener partido de la clase NodoPartido.
     * @return partido de la clase NodoPartido.
     */
    public Partido getPartido() { return this.partido; }
    /**
     * Modificar partido de la clase NodoPartido.
     * @param partido: Nuevo partido de la clase NodoPartido.
     */
    public void setPartido(Partido partido) { this.partido = partido; }
    /**
     * Obtener nodo siguiente de la clase NodoPartido.
     * @return nodo siguiente de la clase NodoPartido.
     */
    public NodoPartido getNext() { return next; }
    /**
     * Modificar nodo siguiente de la clase NodoPartido.
     * @param next: Nuevo nodo siguiente de la clase NodoPartido.
     */
    public void setNext(NodoPartido next) { this.next = next; }
    /**
     * Modificar nodo anterior de la clase NodoPartido.
     * @param previous: Nuevo nodo anterior de la clase NodoPartido.
     */
    public void setPrevious(NodoPartido previous) { this.previous = previous; }
}