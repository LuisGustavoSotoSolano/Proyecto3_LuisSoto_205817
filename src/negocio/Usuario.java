/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import java.util.Objects;
import objetosServicio.Fecha;
import org.bson.types.ObjectId;

/**
 *
 * @author SotoPC
 */
public class Usuario {
    private ObjectId id;
    private String nombre, sexo;
    private int edad;
    private Fecha fecha_nacimiento;
    private List generosMusicales, peliculas;

    public Usuario(ObjectId id, String nombre, String sexo,int edad, Fecha fecha_nacimiento, List generosMusicales, List peliculas) {
         this.id = new ObjectId();
        this.nombre = nombre;
        this.edad = edad;

        this.sexo = sexo;

        this.fecha_nacimiento = fecha_nacimiento;
        this.generosMusicales = generosMusicales;
        this.peliculas = peliculas;
    }

    public Usuario(String nombre, String sexo, int edad, Fecha fecha_nacimiento, List generosMusicales, List peliculas) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.generosMusicales = generosMusicales;
        this.peliculas = peliculas;
    }

    public Usuario() {
        this.id = new ObjectId();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Fecha getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Fecha fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public List getGenerosMusicales() {
        return generosMusicales;
    }

    public void setGenerosMusicales(List generosMusicales) {
        this.generosMusicales = generosMusicales;
    }

    public List getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List peliculas) {
        this.peliculas = peliculas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.nombre);
        hash = 79 * hash + Objects.hashCode(this.sexo);
        hash = 79 * hash + this.edad;
        hash = 79 * hash + Objects.hashCode(this.fecha_nacimiento);
        hash = 79 * hash + Objects.hashCode(this.generosMusicales);
        hash = 79 * hash + Objects.hashCode(this.peliculas);
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
        final Usuario other = (Usuario) obj;
        if (this.edad != other.edad) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fecha_nacimiento, other.fecha_nacimiento)) {
            return false;
        }
        if (!Objects.equals(this.generosMusicales, other.generosMusicales)) {
            return false;
        }
        if (!Objects.equals(this.peliculas, other.peliculas)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", sexo=" + sexo + ", edad=" + edad + ", fecha_nacimiento=" + fecha_nacimiento + ", generosMusicales=" + generosMusicales + ", peliculas=" + peliculas + '}';
    }

}
