/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pieter Pletinckx
 */
@Entity
@Table(name = "gegeven")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gegeven.findAll", query = "SELECT g FROM Gegeven g"),
    @NamedQuery(name = "Gegeven.findByGegevenId", query = "SELECT g FROM Gegeven g WHERE g.gegevenId = :gegevenId")})
public class Gegeven implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GegevenId")
    private Integer gegevenId;
    @Lob
    @Column(name = "Specialisatie")
    private String specialisatie;

    public Gegeven() {
    }

    public Gegeven(Integer gegevenId) {
        this.gegevenId = gegevenId;
    }

    public Integer getGegevenId() {
        return gegevenId;
    }

    public void setGegevenId(Integer gegevenId) {
        this.gegevenId = gegevenId;
    }

    public String getSpecialisatie() {
        return specialisatie;
    }

    public void setSpecialisatie(String specialisatie) {
        this.specialisatie = specialisatie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gegevenId != null ? gegevenId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gegeven)) {
            return false;
        }
        Gegeven other = (Gegeven) object;
        if ((this.gegevenId == null && other.gegevenId != null) || (this.gegevenId != null && !this.gegevenId.equals(other.gegevenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "admin.model.Gegeven[ gegevenId=" + gegevenId + " ]";
    }
    
}
