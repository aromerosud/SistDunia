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
@Table(name = "comidaproducto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comidaproducto.findAll", query = "SELECT c FROM Comidaproducto c"),
    @NamedQuery(name = "Comidaproducto.findById", query = "SELECT c FROM Comidaproducto c WHERE c.id = :id"),
    @NamedQuery(name = "Comidaproducto.findByIdusuario", query = "SELECT c FROM Comidaproducto c WHERE c.idusuario = :idusuario")})
public class Comidaproducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "idusuario")
    private String idusuario;
    @JoinColumn(name = "Comida_idcomida", referencedColumnName = "idcomida")
    @ManyToOne(optional = false)
    private Comida comidaidcomida;
    @JoinColumn(name = "Producto_idproducto", referencedColumnName = "idproducto")
    @ManyToOne(optional = false)
    private Producto productoidproducto;

    public Comidaproducto() {
    }

    public Comidaproducto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public Comida getComidaidcomida() {
        return comidaidcomida;
    }

    public void setComidaidcomida(Comida comidaidcomida) {
        this.comidaidcomida = comidaidcomida;
    }

    public Producto getProductoidproducto() {
        return productoidproducto;
    }

    public void setProductoidproducto(Producto productoidproducto) {
        this.productoidproducto = productoidproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comidaproducto)) {
            return false;
        }
        Comidaproducto other = (Comidaproducto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dunia.Entidades.Comidaproducto[ id=" + id + " ]";
    }
    
}
