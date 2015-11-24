/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dunia.Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Arturo
 */
@Entity
@Table(name = "uusuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uusuario.findAll", query = "SELECT u FROM Uusuario u"),
    @NamedQuery(name = "Uusuario.findByIdUusuario", query = "SELECT u FROM Uusuario u WHERE u.idUusuario = :idUusuario"),
    @NamedQuery(name = "Uusuario.findByNombre", query = "SELECT u FROM Uusuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Uusuario.findByContrase\u00f1a", query = "SELECT u FROM Uusuario u WHERE u.contrase\u00f1a = :contrase\u00f1a")})
public class Uusuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUusuario")
    private Integer idUusuario;
    @Size(max = 20)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 8)
    @Column(name = "contrase\u00f1a")
    private String contraseña;
    @JoinColumn(name = "menu_idmenu", referencedColumnName = "idmenu")
    @ManyToOne
    private Menu menuIdmenu;

    public Uusuario() {
    }

    public Uusuario(Integer idUusuario) {
        this.idUusuario = idUusuario;
    }

    public Integer getIdUusuario() {
        return idUusuario;
    }

    public void setIdUusuario(Integer idUusuario) {
        this.idUusuario = idUusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Menu getMenuIdmenu() {
        return menuIdmenu;
    }

    public void setMenuIdmenu(Menu menuIdmenu) {
        this.menuIdmenu = menuIdmenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUusuario != null ? idUusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uusuario)) {
            return false;
        }
        Uusuario other = (Uusuario) object;
        if ((this.idUusuario == null && other.idUusuario != null) || (this.idUusuario != null && !this.idUusuario.equals(other.idUusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dunia.Entidades.Uusuario[ idUusuario=" + idUusuario + " ]";
    }
    
}
