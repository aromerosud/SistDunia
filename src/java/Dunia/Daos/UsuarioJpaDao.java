package Dunia.Daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import Dunia.Entidades.Uusuario;
import Dunia.Service.AbstractEntity;
import Dunia.Service.UsuarioService;

public class UsuarioJpaDao extends AbstractEntity<Uusuario>
            implements UsuarioService{

    EntityManagerFactory emf;
    EntityManager em;
    
    public UsuarioJpaDao(){
        emf = Persistence.createEntityManagerFactory("SistDuniaPU");
        em = emf.createEntityManager();
    }
    
    @Override
    public Uusuario ingreso(String user, String password) {
        Uusuario usuario; 
        Query query = em.createNamedQuery("validar");
        query.setParameter("us",user);
        query.setParameter("ps",password);
        try{
            usuario = (Uusuario)query.getSingleResult();
        }catch (NoResultException ex){
            usuario = null;
        }
        return usuario;
    }

    @Override
    public boolean cambiarPassword(String pold, String pnew) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
