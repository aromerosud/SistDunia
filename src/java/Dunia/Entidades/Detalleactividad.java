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
@Table(name = "detalleactividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalleactividad.findAll", query = "SELECT d FROM Detalleactividad d"),
    @NamedQuery(name = "Detalleactividad.findByIddetalleactividad", query = "SELECT d FROM Detalleactividad d WHERE d.iddetalleactividad = :iddetalleactividad"),
    @NamedQuery(name = "Detalleactividad.findByIdusuario", query = "SELECT d FROM Detalleactividad d WHERE d.idusuario = :idusuario")})
public class Detalleactividad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddetalleactividad")
    private Integer iddetalleactividad;
    @Size(max = 45)
    @Column(name = "idusuario")
    private String idusuario;
    @JoinColumn(name = "Actividad_idActividad", referencedColumnName = "idActividad")
    @ManyToOne(optional = false)
    private Actividad actividadidActividad;
    @JoinColumn(name = "Agenda_idAgenda", referencedColumnName = "idAgenda")
    @ManyToOne(optional = false)
    private Agenda agendaidAgenda;

    public Detalleactividad() {
    }

    public Detalleactividad(Integer iddetalleactividad) {
        this.iddetalleactividad = iddetalleactividad;
    }

    public Integer getIddetalleactividad() {
        return iddetalleactividad;
    }

    public void setIddetalleactividad(Integer iddetalleactividad) {
        this.iddetalleactividad = iddetalleactividad;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public Actividad getActividadidActividad() {
        return actividadidActividad;
    }

    public void setActividadidActividad(Actividad actividadidActividad) {
        this.actividadidActividad = actividadidActividad;
    }

    public Agenda getAgendaidAgenda() {
        return agendaidAgenda;
    }

    public void setAgendaidAgenda(Agenda agendaidAgenda) {
        this.agendaidAgenda = agendaidAgenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetalleactividad != null ? iddetalleactividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalleactividad)) {
            return false;
        }
        Detalleactividad other = (Detalleactividad) object;
        if ((this.iddetalleactividad == null && other.iddetalleactividad != null) || (this.iddetalleactividad != null && !this.iddetalleactividad.equals(other.iddetalleactividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dunia.Entidades.Detalleactividad[ iddetalleactividad=" + iddetalleactividad + " ]";
    }
    
}
