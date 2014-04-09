/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Pieter Pletinckx
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Opleiding.findAll", query = "SELECT o FROM Opleiding o"),
    @NamedQuery(name = "Opleiding.findByOpleidingId", query = "SELECT o FROM Opleiding o WHERE o.opleidingId = :opleidingId"),
    @NamedQuery(name = "Opleiding.findByOnderwerp", query = "SELECT o FROM Opleiding o WHERE o.onderwerp = :onderwerp"),
    @NamedQuery(name = "Opleiding.findByBegindatum", query = "SELECT o FROM Opleiding o WHERE o.begindatum = :begindatum"),
    @NamedQuery(name = "Opleiding.findByEinddatum", query = "SELECT o FROM Opleiding o WHERE o.einddatum = :einddatum")})
public class Opleiding implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer opleidingId;
    private String onderwerp;
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date begindatum;
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date einddatum;
    @OneToMany(mappedBy = "opleidingOpleidingId", fetch = FetchType.EAGER)
    private List<Stage> stageList;

    public Opleiding() {
    }

    public Opleiding(Integer opleidingId) {
        this.opleidingId = opleidingId;
    }

    public Opleiding(Integer opleidingId, Date begindatum, Date einddatum) {
        this.opleidingId = opleidingId;
        this.begindatum = begindatum;
        this.einddatum = einddatum;
    }

    public Integer getOpleidingId() {
        return opleidingId;
    }

    public void setOpleidingId(Integer opleidingId) {
        this.opleidingId = opleidingId;
    }

    public String getOnderwerp() {
        return onderwerp;
    }

    public void setOnderwerp(String onderwerp) {
        this.onderwerp = onderwerp;
    }

    public Date getBegindatum() {
        return begindatum;
    }

    public void setBegindatum(Date begindatum) {
        this.begindatum = begindatum;
    }

    public Date getEinddatum() {
        return einddatum;
    }

    public void setEinddatum(Date einddatum) {
        this.einddatum = einddatum;
    }

    public List<Stage> getStageList() {
        return stageList;
    }

    public void setStageList(List<Stage> stageList) {
        this.stageList = stageList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (opleidingId != null ? opleidingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opleiding)) {
            return false;
        }
        Opleiding other = (Opleiding) object;
        if ((this.opleidingId == null && other.opleidingId != null) || (this.opleidingId != null && !this.opleidingId.equals(other.opleidingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Opleiding[ opleidingId=" + opleidingId + " ]";
    }
    
}
