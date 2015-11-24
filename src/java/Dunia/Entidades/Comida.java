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
    @NamedQuery(name = "Comida.findByNomCom", query = "SELECT c FROM Comida c WHERE c.nomCom = :nomCom"),
    @NamedQuery(name = "Comida.findByTipoCom", query = "SELECT c FROM Comida c WHERE c.tipoCom = :tipoCom")})
public class Comida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcomida")
    private Integer idcomida;
    @Size(max = 45)
    @Column(name = "nom_com")
    private String nomCom;
    @Size(max = 45)
    @Column(name = "tipo_com")
    private String tipoCom;
    @OneToMany(mappedBy = "comidaIdcomida")
    private List<Menu> menuList;
    @JoinColumn(name = "producto_idproducto", referencedColumnName = "idproducto")
    @ManyToOne
    private Producto productoIdproducto;

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

    public String getNomCom() {
        return nomCom;
    }

    public void setNomCom(String nomCom) {
        this.nomCom = nomCom;
    }

    public String getTipoCom() {
        return tipoCom;
    }

    public void setTipoCom(String tipoCom) {
        this.tipoCom = tipoCom;
    }

    @XmlTransient
    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public Producto getProductoIdproducto() {
        return productoIdproducto;
    }

    public void setProductoIdproducto(Producto productoIdproducto) {
        this.productoIdproducto = productoIdproducto;
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
