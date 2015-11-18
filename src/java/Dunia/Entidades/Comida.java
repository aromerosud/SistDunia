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
@Table(name = "comida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comida.findAll", query = "SELECT c FROM Comida c"),
    @NamedQuery(name = "Comida.findByIdcomida", query = "SELECT c FROM Comida c WHERE c.idcomida = :idcomida"),
    @NamedQuery(name = "Comida.findByTipo", query = "SELECT c FROM Comida c WHERE c.tipo = :tipo"),
    @NamedQuery(name = "Comida.findByDescripcion", query = "SELECT c FROM Comida c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Comida.findByIdusuario", query = "SELECT c FROM Comida c WHERE c.idusuario = :idusuario")})
public class Comida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcomida")
    private Integer idcomida;
    @Size(max = 45)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 45)
    @Column(name = "idusuario")
    private String idusuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comidaidcomida")
    private List<Comidaproducto> comidaproductoList;

    public Comida() {
    }

    public Comida(Integer idcomida) {
        this.idcomida = idcomida;
    }

    public Integer getIdcomida() {
        return idcomida;
    }

    public void setIdcomida(Integer idcomida) {
        this.idcomida = idcomida;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    @XmlTransient
    public List<Comidaproducto> getComidaproductoList() {
        return comidaproductoList;
    }

    public void setComidaproductoList(List<Comidaproducto> comidaproductoList) {
        this.comidaproductoList = comidaproductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcomida != null ? idcomida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comida)) {
            return false;
        }
        Comida other = (Comida) object;
        if ((this.idcomida == null && other.idcomida != null) || (this.idcomida != null && !this.idcomida.equals(other.idcomida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dunia.Entidades.Comida[ idcomida=" + idcomida + " ]";
    }
    
}
