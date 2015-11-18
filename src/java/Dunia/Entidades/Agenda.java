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
@Table(name = "agenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agenda.findAll", query = "SELECT a FROM Agenda a"),
    @NamedQuery(name = "Agenda.findByIdAgenda", query = "SELECT a FROM Agenda a WHERE a.idAgenda = :idAgenda"),
    @NamedQuery(name = "Agenda.findByIdusuario", query = "SELECT a FROM Agenda a WHERE a.idusuario = :idusuario")})
public class Agenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAgenda")
    private Integer idAgenda;
    @Size(max = 45)
    @Column(name = "idusuario")
    private String idusuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agendaidAgenda")
    private List<Detalleactividad> detalleactividadList;

    public Agenda() {
    }

    public Agenda(Integer idAgenda) {
        this.idAgenda = idAgenda;
    }

    public Integer getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(Integer idAgenda) {
        this.idAgenda = idAgenda;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    @XmlTransient
    public List<Detalleactividad> getDetalleactividadList() {
        return detalleactividadList;
    }

    public void setDetalleactividadList(List<Detalleactividad> detalleactividadList) {
        this.detalleactividadList = detalleactividadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAgenda != null ? idAgenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agenda)) {
            return false;
        }
        Agenda other = (Agenda) object;
        if ((this.idAgenda == null && other.idAgenda != null) || (this.idAgenda != null && !this.idAgenda.equals(other.idAgenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dunia.Entidades.Agenda[ idAgenda=" + idAgenda + " ]";
    }
    
}
