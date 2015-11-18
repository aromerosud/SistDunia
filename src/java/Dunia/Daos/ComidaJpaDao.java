package Dunia.Daos;

import Dunia.Entidades.Comida;
import Dunia.Service.AbstractEntity;

public class ComidaJpaDao extends AbstractEntity<Comida>{

    public ComidaJpaDao(Class<Comida> obj) {
        super(obj);
    }
}
