package Dunia.Daos;

import Dunia.Service.UsuarioService;
import Dunia.util.Constantes;

public class UsuarioDaoFactory {

    private static UsuarioDaoFactory fabrica;
    
    private UsuarioDaoFactory() {
    }

    public static UsuarioDaoFactory getFabrica() {
        if(fabrica==null){
            fabrica = new UsuarioDaoFactory();
        }
        return fabrica;
    }
    
    public UsuarioService getUsuarioDao(int type){
        switch(type){
            case Constantes.JDBC: return new UsuarioJdbcDao();
            case Constantes.JPA: return new UsuarioJpaDao();
            default: return null;
        }
        
    }
    
}
