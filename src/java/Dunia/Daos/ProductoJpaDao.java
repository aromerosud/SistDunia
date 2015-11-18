package Dunia.Daos;

import Dunia.Entidades.Producto;
import Dunia.Service.AbstractEntity;

public class ProductoJpaDao extends AbstractEntity<Producto>{

    public ProductoJpaDao(Class<Producto> obj) {
        super(obj);
    }
}
