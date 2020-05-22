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
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import negocio.Usuario;
import objetosServicio.Fecha;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author SotoPC
 */
public class UsuarioRepository {

    private final MongoDatabase database;

    public UsuarioRepository(MongoDatabase database) {
        this.collection = database.getCollection("usuario");
        this.database = database;
    }
    MongoCollection<Document> collection;

    public void add(Usuario usuario) {
        Document document = new Document()
                .append("id", usuario.getId())
                .append("nombre", usuario.getNombre())
                .append("sexo", usuario.getSexo())
                .append("edad", usuario.getEdad())
                .append("fecha_nac", usuario.getFecha_nacimiento().toString())
                .append("peliculas", usuario.getPeliculas())
                .append("musica", usuario.getGenerosMusicales());
        collection.insertOne(document);
    }

    public List<Usuario> find() {
        List<Usuario> result = new ArrayList<>();
        for (Document doc : collection.find()) {
            result.add(new Usuario(
                    doc.getObjectId("id"),
                    doc.getString("nombre"),
                    doc.getString("sexo"),
                    doc.getInteger("edad"),
                    new Fecha(doc.getString("fecha_nacimiento")),
                    doc.getList("peliculas", String.class),
                    doc.getList("musica", String.class)));
        }
        return result;
    }
    
    public Usuario buscarPorId(ObjectId id) {

        Document doc = collection.find(Filters.eq("id", id)).first();
        return new Usuario(
                id,
                doc.getString("nombre"),
                doc.getString("sexo"),
                doc.getInteger("edad"),
                new Fecha(doc.getString("fecha_nac")),
                doc.getList("peliculas", String.class),
                doc.getList("musica", String.class)
        );

    }
    public void update(Usuario usuario) {
        collection.updateOne(
                Filters.eq("id", usuario.getId()),
                Updates.set("nombre", usuario.getNombre()));
        collection.updateOne(
                Filters.eq("id", usuario.getId()),
                Updates.set("sexo", usuario.getSexo()));
        collection.updateOne(
                Filters.eq("id", usuario.getId()),
                Updates.set("edad", usuario.getEdad()));
        collection.updateOne(
                Filters.eq("id", usuario.getId()),
                Updates.set("fecha_naciminiento", usuario.getFecha_nacimiento().toString()));
        collection.updateOne(
                Filters.eq("id", usuario.getId()),
                Updates.set("peliculas", usuario.getPeliculas()));
        collection.updateOne(
                Filters.eq("id", usuario.getId()),
                Updates.set("musica", usuario.getGenerosMusicales()));
    }

    public void delete(Usuario usuario) {
        DeleteResult delete;
        delete = collection.deleteOne(Filters.eq("nombre",usuario.getNombre()));
    }
}
