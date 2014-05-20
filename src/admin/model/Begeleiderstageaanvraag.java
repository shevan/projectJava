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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pieter Pletinckx
 */
@Entity
@Table(name = "begeleiderstageaanvraag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Begeleiderstageaanvraag.findAll", query = "SELECT b FROM Begeleiderstageaanvraag b"),
    @NamedQuery(name = "Begeleiderstageaanvraag.findByBegeleiderStageAanvraagId", query = "SELECT b FROM Begeleiderstageaanvraag b WHERE b.begeleiderStageAanvraagId = :begeleiderStageAanvraagId"),
    @NamedQuery(name = "Begeleiderstageaanvraag.findByGoedgekeurd", query = "SELECT b FROM Begeleiderstageaanvraag b WHERE b.goedgekeurd = :goedgekeurd"),
    @NamedQuery(name = "Begeleiderstageaanvraag.findByNogNietBeslist", query = "SELECT b FROM Begeleiderstageaanvraag b WHERE b.goedgekeurd IS NULL")})
public class Begeleiderstageaanvraag implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BegeleiderStageAanvraagId")
    private Integer begeleiderStageAanvraagId;
    @Column(name = "Goedgekeurd")
    private Boolean goedgekeurd;
    @JoinColumn(name = "BegeleiderId", referencedColumnName = "BegeleiderId")
    @ManyToOne(optional = false)
    private Begeleider begeleiderId;
    @JoinColumn(name = "StageId", referencedColumnName = "StageId")
    @ManyToOne(optional = false)
    private Stage stageId;

    public Begeleiderstageaanvraag() {
    }

    public Begeleiderstageaanvraag(Integer begeleiderStageAanvraagId) {
        this.begeleiderStageAanvraagId = begeleiderStageAanvraagId;
    }

    public Integer getBegeleiderStageAanvraagId() {
        return begeleiderStageAanvraagId;
    }

    public void setBegeleiderStageAanvraagId(Integer begeleiderStageAanvraagId) {
        this.begeleiderStageAanvraagId = begeleiderStageAanvraagId;
    }

    public Boolean getGoedgekeurd() {
        return goedgekeurd;
    }

    public void setGoedgekeurd(Boolean goedgekeurd) {
        this.goedgekeurd = goedgekeurd;
    }

    public Begeleider getBegeleiderId() {
        return begeleiderId;
    }

    public void setBegeleiderId(Begeleider begeleiderId) {
        this.begeleiderId = begeleiderId;
    }

    public Stage getStageId() {
        return stageId;
    }

    public void setStageId(Stage stageId) {
        this.stageId = stageId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (begeleiderStageAanvraagId != null ? begeleiderStageAanvraagId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Begeleiderstageaanvraag)) {
            return false;
        }
        Begeleiderstageaanvraag other = (Begeleiderstageaanvraag) object;
        if ((this.begeleiderStageAanvraagId == null && other.begeleiderStageAanvraagId != null) || (this.begeleiderStageAanvraagId != null && !this.begeleiderStageAanvraagId.equals(other.begeleiderStageAanvraagId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "admin.model.Begeleiderstageaanvraag[ begeleiderStageAanvraagId=" + begeleiderStageAanvraagId + " ]";
    }
    
}
