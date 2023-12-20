package dao;

import conexao.ConnectionFactory;
import model.Usuario;

import javax.persistence.EntityManager;
import java.util.List;

public class UsuarioDao {

    public Usuario salvar (Usuario usuario){

        EntityManager em = new ConnectionFactory().getConnection();
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return usuario;
}
    public  List<Usuario> findAll(){

        EntityManager em = new ConnectionFactory().getConnection();
        List<Usuario> usuarios = null;

        try {
            usuarios = em.createQuery("from Usuario ").getResultList();
        }   catch (Exception e){
            em.getTransaction().rollback();
        }   finally {
            em.close();
        }
            return usuarios;
        }
    public  Usuario update (Usuario usuario){
        EntityManager em = new ConnectionFactory().getConnection();

        try{
            em.getTransaction().begin();
            em.merge(usuario);
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return usuario;
    }

    public Usuario delete (Integer id){
        EntityManager em = new ConnectionFactory().getConnection();

        Usuario usuario = em.find(Usuario.class, id);
        try{
            em.getTransaction().begin();
            em.remove(usuario);
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return usuario;
    }
}
