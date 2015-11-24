package Dunia.Controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import Dunia.Daos.UsuarioDaoFactory;
import Dunia.Entidades.Uusuario;
import Dunia.Service.UsuarioService;
import Dunia.util.Constantes;

@ManagedBean(name = "comerciante")
@SessionScoped
public class UsuarioMb {
    private String user;
    private String password;

    private String nombre;
    
    public String validarUsuario(){
        UsuarioService servicio;
        servicio=UsuarioDaoFactory.
                getFabrica().
                getUsuarioDao(Constantes.JPA);
        Uusuario usuario = servicio.ingreso(user, password);
        if(usuario!=null){
            nombre = usuario.getNombre()+" "+usuario.getContraseña();
            return "principal";
        }else{
            return "error";
        }
        
    }
    
    public String getUsuario() {
        return user;
    }

    public void setUsuario(String usuario) {
        this.user = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
