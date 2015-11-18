package Dunia.Controller;

import Dunia.Daos.ProductoJpaDao;
import Dunia.Entidades.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ProductoMb {
    private Producto producto;
    private List<Producto> lista;
    private ProductoJpaDao dao;
    
    public ProductoMb(){
        producto= new Producto();
        lista = new ArrayList<Producto>();
        dao = new ProductoJpaDao(Producto.class);
    }
    
    public void grabar(){
        dao.create(producto);
        //return "ok";
    }
    
    public void eliminar(String id){
        Producto c = dao.find(id);
        dao.remove(c);
    }
    
    public void actualizar(Producto c){
        dao.edit(c);
    }
    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getLista() {
        lista = dao.findAll();
        return lista;
    }

    public void setLista(List<Producto> lista) {
        this.lista = lista;
    }
    
    
}
