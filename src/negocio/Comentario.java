/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.Objects;
import objetosServicio.Fecha;
import org.bson.types.ObjectId;

/**
 *
 * @author SotoPC
 */
public class Comentario {
    
    private ObjectId id;
    private Usuario autor;
    private Fecha fechaHora;
    private String mensaje;

    public Comentario() {
        this.id=new ObjectId();
    }

    public Comentario(ObjectId id, Usuario autor, Fecha fechaHora, String mensaje) {
        this.id = id;
        this.autor = autor;
        this.fechaHora = fechaHora;
        this.mensaje = mensaje;
    }

    public Comentario(Usuario autor, Fecha fechaHora, String mensaje) {
        this.id=new ObjectId();
        this.autor = autor;
        this.fechaHora = fechaHora;
        this.mensaje = mensaje;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public Fecha getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Fecha fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "Comentario{" + "id=" + id + ", Autor=" + autor + ", texto=" + mensaje + ", fechaHora=" + fechaHora + ", hora="+this.fechaHora.getCadenaHora()+'}';
    }
    
}
