/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto03_203675;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import java.util.Arrays;
import negocio.Comentario;
import negocio.Post;
import negocio.Usuario;
import objetosServicio.Fecha;
import repositorios.PostRepository;
import repositorios.UsuarioRepository;

/**
 *
 * @author SotoPC
 */
public class Proyecto03_203675 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MongoClient mongo = new MongoClient("localhost");
        MongoDatabase database = mongo.getDatabase("faceboot");

        UsuarioRepository usuarios = new UsuarioRepository(database);
        PostRepository publicaciones = new PostRepository(database);

        System.out.println("Usuarios");
        System.out.println("");
        Usuario usuario = new Usuario("Luis Audeves", "hombre", 19, new Fecha("2000/08/30"), Arrays.asList("Clasica", "Rock"), Arrays.asList("Terror", "Ciencia Ficcion"));

        Usuario usuario2 = new Usuario("Maria Martinez", "mujer", 53, new Fecha("1966/08/15"), Arrays.asList("", ""), Arrays.asList("Ciencia ficción", "Romance"));

        usuarios.add(usuario);
        usuarios.add(usuario2);

        for (Usuario usuario1 : usuarios.find()) {
            System.out.println(usuario1);
        }

        usuario2.setNombre("Maria Martina");

        usuarios.update(usuario2);
        System.out.println("");
        System.out.println("Usuarios actualizados");

        for (Usuario usuario1 : usuarios.find()) {
            System.out.println(usuario1);
        }

        Comentario comentario1 = new Comentario(usuario2, new Fecha(), "Que Bien te miras Luis");
        Comentario comentario2 = new Comentario(usuario, new Fecha(), "Gracias");

        Post publicacion = new Post(usuario,new Fecha("2020/05/20 08:00"),"publicación en Faceboot",Arrays.asList("primero", "faceboot"),Arrays.asList(comentario1));

        Post publicacion2 = new Post(usuario2,new Fecha("2020/06/20 12:00"),"publicación en Faceboot 2",Arrays.asList("segunda", "faceboot"),Arrays.asList(comentario2));

        publicaciones.add(publicacion);
        publicaciones.add(publicacion2);
        System.out.println("");
        System.out.println("Publicaciones");

        for (Post pub : publicaciones.find()) {
            System.out.println(pub);
        }

        publicaciones.eliminarComentario(publicacion.getId(), comentario1.getId());
        System.out.println("");
        System.out.println("publicaciones con comentarios eliminados");
        for (Post pub : publicaciones.find()) {
            System.out.println(pub);
        }
        usuarios.delete(usuario2);
        System.out.println("");
        System.out.println("Usuarios");

        for (Usuario usuarioss : usuarios.find()) {
            System.out.println(usuarioss);
        }
    }

}
