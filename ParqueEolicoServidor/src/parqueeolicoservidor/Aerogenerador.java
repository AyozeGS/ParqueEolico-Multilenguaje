/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueeolicoservidor;

import static parqueeolicoservidor.Estado.*;

/**
 *
 * @author Ayo
 */
public class Aerogenerador {
    
    private final int id;
    private Estado estado;
    private int velocidad;

    public Aerogenerador(int id, Estado estado) {
        this.id = id;
        this.estado = estado;
        if (estado == ACTIVADO)
            velocidad = 11;
        else
            velocidad = 0;
    }

    public int getId() {
        return id;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
        if (estado == ACTIVADO)
            setVelocidad(11);
        else
            if (estado == DESACTIVADO)
                setVelocidad(0);
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {
        return "Aerogenerador: " + id + ", Estado: " + estado + ", Velocidad: " + velocidad + " m/s";
    }
}
