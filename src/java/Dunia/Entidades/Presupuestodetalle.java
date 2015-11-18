/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dunia.Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "presupuestodetalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Presupuestodetalle.findAll", query = "SELECT p FROM Presupuestodetalle p"),
    @NamedQuery(name = "Presupuestodetalle.findByCantidad", query = "SELECT p FROM Presupuestodetalle p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "Presupuestodetalle.findByIdusuario", query = "SELECT p FROM Presupuestodetalle p WHERE p.idusuario = :idusuario")})
public class Presupuestodetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private BigDecimal cantidad;
    @Size(max = 45)
    @Column(name = "idusuario")
    private String idusuario;
    @JoinColumn(name = "idPresupuesto", referencedColumnName = "idPresupuesto")
    @ManyToOne(optional = false)
    private Presupuesto idPresupuesto;
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
    @ManyToOne(optional = false)
    private Producto idproducto;

    public Presupuestodetalle() {
    }

    public Presupuestodetalle(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public Presupuesto getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(Presupuesto idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public Producto getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Producto idproducto) {
        this.idproducto = idproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cantidad != null ? cantidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Presupuestodetalle)) {
            return false;
        }
        Presupuestodetalle other = (Presupuestodetalle) object;
        if ((this.cantidad == null && other.cantidad != null) || (this.cantidad != null && !this.cantidad.equals(other.cantidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dunia.Entidades.Presupuestodetalle[ cantidad=" + cantidad + " ]";
    }
    
}
