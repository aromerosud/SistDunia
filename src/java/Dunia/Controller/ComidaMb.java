package Dunia.Controller;

import Dunia.Daos.ComidaJpaDao;
import Dunia.Entidades.Comida;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ComidaMb {
    private Comida comida;
    private List<Comida> lista;
    private ComidaJpaDao dao;
    
    public ComidaMb(){
        comida= new Comida();
        lista = new ArrayList<Comida>();
        dao = new ComidaJpaDao(Comida.class);
    }
    
    public void grabar(){
        dao.create(comida);
        //return "ok";
    }
    
    public void eliminar(String id){
        Comida c = dao.find(id);
        dao.remove(c);
    }
    
    public void actualizar(Comida c){
        dao.edit(c);
    }
    
    public Comida getComida() {
        return comida;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }

    public List<Comida> getLista() {
        lista = dao.findAll();
        return lista;
    }

    public void setLista(List<Comida> lista) {
        this.lista = lista;
    }
    
    
}
