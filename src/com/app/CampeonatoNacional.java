package com.app;

public interface CampeonatoNacional {
    void leerArchivos();
    void jugarPartido(int fecha);
    void mostrarTabla();
    void mostrarResultados();
    void agregarEquipos(int cantidad);
    void campeonesPorAño();
    void reiniciarCampeonato();
}