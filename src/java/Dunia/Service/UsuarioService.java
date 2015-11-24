package Dunia.Service;

import Dunia.Entidades.Uusuario;


public interface UsuarioService {
    
    public Uusuario ingreso(String user,String Password);
    public boolean cambiarPassword(String pold,String pnew);
    
}
