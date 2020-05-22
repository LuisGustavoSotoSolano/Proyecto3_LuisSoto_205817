/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import java.util.ArrayList;
import java.util.List;
import negocio.Comentario;
import negocio.Post;
import objetosServicio.Fecha;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author SotoPC
 */
public class PostRepository {

    private final MongoDatabase database;
    private UsuarioRepository usuarios;

    public PostRepository(MongoDatabase database) {
        this.collection = database.getCollection("post");
        this.database = database;
    }
    MongoCollection<Document> collection;

    public void add(Post post) {
        List<Document> comentarios = new ArrayList<>();
        for (Comentario comentario : post.getComentarios()) {
            comentarios.add(
                    new Document()
                            .append("id", comentario.getId())
                            .append("autor", comentario.getAutor().getNombre())
                            .append("fecha", comentario.getFechaHora().toString() + " " + comentario.getFechaHora().getCadenaHora())
                            .append("texto", comentario.getMensaje())
            );
        }

        Document document = new Document()
                .append("id", post.getId())
                .append("autor", post.getAutor().getNombre())
                .append("fecha", post.getFechaHora().toString() + " " + post.getFechaHora().getCadenaHora())
                .append("mensaje", post.getMensaje())
                .append("tags", post.getEtiquetas())
                .append("comentarios", comentarios);
        collection.insertOne(document);

    }

    public List<Post> find() {
        List<Post> result = new ArrayList<>();
        List comentarios;
        for (Document doc : collection.find()) {
            comentarios = new ArrayList<Comentario>();
            for (Document docComentario : doc.getList("comentarios", Document.class)) {
                comentarios.add(new Comentario(
                                docComentario.getObjectId("id"),
                                usuarios.buscarPorId(docComentario.getObjectId("autor")),
                                new Fecha(docComentario.getString("fecha")),
                                docComentario.getString("mensaje")));
            }

            result.add(
                    new Post(
                            doc.getObjectId("id"),
                            usuarios.buscarPorId(doc.getObjectId("autor")),
                            new Fecha(doc.getString("fecha")),
                            doc.getString("mensaje"),
                            doc.getList("tags", String.class),
                            comentarios
                    )
            );
        }
        return result;
    }
    
    public void actualizar(Post publicacion) {
        
        collection.updateOne(
                Filters.eq("id", publicacion.getId()),
                Updates.addToSet("usuario", publicacion.getAutor().getId()));
        collection.updateOne(
                Filters.eq("id", publicacion.getId()),
                Updates.addToSet("fecha", publicacion.getFechaHora().toString() + " " + publicacion.getFechaHora().getCadenaHora()));
        collection.updateOne(
                Filters.eq("id", publicacion.getId()),
                Updates.addToSet("mensaje", publicacion.getMensaje()));
        collection.updateOne(
                Filters.eq("id", publicacion.getId()),
                Updates.addToSet("tags", publicacion.getEtiquetas()));
    }

    public void eliminar(ObjectId id) {
        DeleteResult delete;
        delete = collection.deleteOne(Filters.eq("id",id));
    }

    public void eliminarComentario(ObjectId idPost, ObjectId idComentario) {
        collection.updateOne(Filters.eq("id",idPost),Updates.pull("comentarios",Filters.eq("id",idComentario)));
        
        ;
    }
}
