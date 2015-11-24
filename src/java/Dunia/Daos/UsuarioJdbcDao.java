package Dunia.Daos;

import Dunia.Entidades.Uusuario;
import Dunia.Service.AbstractEntity;
import Dunia.Service.UsuarioService;

public class UsuarioJdbcDao extends AbstractEntity<Uusuario>
            implements UsuarioService{

    @Override
    public Uusuario ingreso(String user, String Password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean cambiarPassword(String pold, String pnew) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
