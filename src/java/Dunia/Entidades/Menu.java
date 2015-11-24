/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dunia.Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Arturo
 */
@Entity
@Table(name = "menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findByIdmenu", query = "SELECT m FROM Menu m WHERE m.idmenu = :idmenu")})
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmenu")
    private Integer idmenu;
    @OneToMany(mappedBy = "menuIdmenu")
    private List<Uusuario> uusuarioList;
    @JoinColumn(name = "actividad_idactividad", referencedColumnName = "idactividad")
    @ManyToOne
    private Actividad actividadIdactividad;
    @JoinColumn(name = "comida_idcomida", referencedColumnName = "idcomida")
    @ManyToOne
    private Comida comidaIdcomida;

    public Menu() {
    }

    public Menu(Integer idmenu) {
        this.idmenu = idmenu;
    }

    public Integer getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(Integer idmenu) {
        this.idmenu = idmenu;
    }

    @XmlTransient
    public List<Uusuario> getUusuarioList() {
        return uusuarioList;
    }

    public void setUusuarioList(List<Uusuario> uusuarioList) {
        this.uusuarioList = uusuarioList;
    }

    public Actividad getActividadIdactividad() {
        return actividadIdactividad;
    }

    public void setActividadIdactividad(Actividad actividadIdactividad) {
        this.actividadIdactividad = actividadIdactividad;
    }

    public Comida getComidaIdcomida() {
        return comidaIdcomida;
    }

    public void setComidaIdcomida(Comida comidaIdcomida) {
        this.comidaIdcomida = comidaIdcomida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmenu != null ? idmenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.idmenu == null && other.idmenu != null) || (this.idmenu != null && !this.idmenu.equals(other.idmenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dunia.Entidades.Menu[ idmenu=" + idmenu + " ]";
    }
    
}
