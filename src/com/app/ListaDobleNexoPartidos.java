package com.app;
public class ListaDobleNexoPartidos {
    private NodoPartido head;
    private NodoPartido tail;
    /**
     * Constructor de la clase Lista de Partidos.
     */
    public ListaDobleNexoPartidos() {
        this.head = null;
        this.tail = null;
    }
    /**
     * Agregar un nuevo partido a la lista de partidos.
     * @param partido : Nuevo partido a la lista de partidos.
     */
    public void agregarPartido(Partido partido){
        NodoPartido nuevoPartido = new NodoPartido(partido);
        if(head == null){
            head = nuevoPartido;
            head.setNext(null);
            head.setPrevious(null);
            tail = head;
        }
        else{
            tail.setNext(nuevoPartido);
            nuevoPartido.setPrevious(tail);
            nuevoPartido.setNext(null);
            tail = nuevoPartido;
        }
    }
    /**
     * Ordenar la lista de menor a mayor de fechas.
     */
    public void ordenarLista(){
        for(NodoPartido aux = this.head; aux != null; aux = aux.getNext()){
            for(NodoPartido aux2 = aux.getNext(); aux2 != null; aux2 = aux2.getNext()){
                if(aux2.getPartido().getFecha() < aux.getPartido().getFecha()){
                    Partido partidoAux2 = aux.getPartido();
                    aux.setPartido(aux2.getPartido());
                    aux2.setPartido(partidoAux2);
                }
            }
        }
    }
    /**
     * Obtener el parámetro "head" de la clase Lista Partido.
     * @return parámetro "head" de la clase Lista Partido.
     */
    public NodoPartido getHead() { return this.head; }
}