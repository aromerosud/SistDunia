/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dunia.Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Arturo
 */
@Entity
@Table(name = "presupuesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Presupuesto.findAll", query = "SELECT p FROM Presupuesto p"),
    @NamedQuery(name = "Presupuesto.findByIdPresupuesto", query = "SELECT p FROM Presupuesto p WHERE p.idPresupuesto = :idPresupuesto"),
    @NamedQuery(name = "Presupuesto.findByPresupuestocol", query = "SELECT p FROM Presupuesto p WHERE p.presupuestocol = :presupuestocol"),
    @NamedQuery(name = "Presupuesto.findByIdusuario", query = "SELECT p FROM Presupuesto p WHERE p.idusuario = :idusuario")})
public class Presupuesto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPresupuesto")
    private Integer idPresupuesto;
    @Size(max = 45)
    @Column(name = "Presupuestocol")
    private String presupuestocol;
    @Size(max = 45)
    @Column(name = "idusuario")
    private String idusuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPresupuesto")
    private List<Presupuestodetalle> presupuestodetalleList;

    public Presupuesto() {
    }

    public Presupuesto(Integer idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public Integer getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(Integer idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public String getPresupuestocol() {
        return presupuestocol;
    }

    public void setPresupuestocol(String presupuestocol) {
        this.presupuestocol = presupuestocol;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    @XmlTransient
    public List<Presupuestodetalle> getPresupuestodetalleList() {
        return presupuestodetalleList;
    }

    public void setPresupuestodetalleList(List<Presupuestodetalle> presupuestodetalleList) {
        this.presupuestodetalleList = presupuestodetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPresupuesto != null ? idPresupuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Presupuesto)) {
            return false;
        }
        Presupuesto other = (Presupuesto) object;
        if ((this.idPresupuesto == null && other.idPresupuesto != null) || (this.idPresupuesto != null && !this.idPresupuesto.equals(other.idPresupuesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dunia.Entidades.Presupuesto[ idPresupuesto=" + idPresupuesto + " ]";
    }
    
}
