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
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByIdproducto", query = "SELECT p FROM Producto p WHERE p.idproducto = :idproducto"),
    @NamedQuery(name = "Producto.findByNomPro", query = "SELECT p FROM Producto p WHERE p.nomPro = :nomPro"),
    @NamedQuery(name = "Producto.findByUnidadMed", query = "SELECT p FROM Producto p WHERE p.unidadMed = :unidadMed"),
    @NamedQuery(name = "Producto.findByPrecio", query = "SELECT p FROM Producto p WHERE p.precio = :precio")})
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idproducto")
    private Integer idproducto;
    @Size(max = 45)
    @Column(name = "nom_pro")
    private String nomPro;
    @Size(max = 45)
    @Column(name = "unidad_med")
    private String unidadMed;
    @Column(name = "precio")
    private Long precio;
    @OneToMany(mappedBy = "productoIdproducto")
    private List<Comida> comidaList;

    public Producto() {
    }

    public Producto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getNomPro() {
        return nomPro;
    }

    public void setNomPro(String nomPro) {
        this.nomPro = nomPro;
    }

    public String getUnidadMed() {
        return unidadMed;
    }

    public void setUnidadMed(String unidadMed) {
        this.unidadMed = unidadMed;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    @XmlTransient
    public List<Comida> getComidaList() {
        return comidaList;
    }

    public void setComidaList(List<Comida> comidaList) {
        this.comidaList = comidaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproducto != null ? idproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idproducto == null && other.idproducto != null) || (this.idproducto != null && !this.idproducto.equals(other.idproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dunia.Entidades.Producto[ idproducto=" + idproducto + " ]";
    }
    
}
