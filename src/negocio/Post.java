/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import objetosServicio.Fecha;
import org.bson.types.ObjectId;

/**
 *
 * @author SotoPC
 */
public class Post {
    
private ObjectId id;
    private Usuario autor;
    private Fecha fechaHora;
    private String mensaje;
    private List<String> etiquetas;
    private List<Comentario> comentarios;
    

    public Post() {
        this.id=new ObjectId();
    }

    public Post(Usuario autor, Fecha fechaHora, String mensaje, List<String> etiquetas, List<Comentario> comentarios) {
        this.id=new ObjectId();
        this.autor = autor;
        this.fechaHora = fechaHora;
        this.mensaje = mensaje;
        this.etiquetas = etiquetas;
        this.comentarios = comentarios;
    }
    
    public Post(ObjectId id, Usuario autor, Fecha fechaHora, String mensaje, List<String> etiquetas, List<Comentario> comentarios) {
        this.id = id;
        this.autor = autor;
        this.fechaHora = fechaHora;
        this.mensaje = mensaje;
        this.etiquetas = etiquetas;
        this.comentarios=comentarios;
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

    public List<String> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<String> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.autor);
        hash = 29 * hash + Objects.hashCode(this.fechaHora);
        hash = 29 * hash + Objects.hashCode(this.mensaje);
        hash = 29 * hash + Objects.hashCode(this.etiquetas);
        hash = 29 * hash + Objects.hashCode(this.comentarios);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Post other = (Post) obj;
        if (!Objects.equals(this.mensaje, other.mensaje)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        if (!Objects.equals(this.fechaHora, other.fechaHora)) {
            return false;
        }
        if (!Objects.equals(this.etiquetas, other.etiquetas)) {
            return false;
        }
        if (!Objects.equals(this.comentarios, other.comentarios)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", usuario=" + autor + ", fechaHora=" + fechaHora +", hora="+fechaHora.getCadenaHora()+ ", mensaje=" + mensaje + ", etiquetas=" + etiquetas + ", comentarios=" + comentarios + '}';
    }
   

    
    
}
