/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pieter Pletinckx
 */
@Entity
@Table(name = "bedrijfspersoon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bedrijfspersoon.findAll", query = "SELECT b FROM Bedrijfspersoon b"),
    @NamedQuery(name = "Bedrijfspersoon.findByBedrijfspersoonId", query = "SELECT b FROM Bedrijfspersoon b WHERE b.bedrijfspersoonId = :bedrijfspersoonId"),
    @NamedQuery(name = "Bedrijfspersoon.findByFamilienaam", query = "SELECT b FROM Bedrijfspersoon b WHERE b.familienaam = :familienaam"),
    @NamedQuery(name = "Bedrijfspersoon.findByVoornaam", query = "SELECT b FROM Bedrijfspersoon b WHERE b.voornaam = :voornaam"),
    @NamedQuery(name = "Bedrijfspersoon.findByFunctie", query = "SELECT b FROM Bedrijfspersoon b WHERE b.functie = :functie"),
    @NamedQuery(name = "Bedrijfspersoon.findByAfwezigheid", query = "SELECT b FROM Bedrijfspersoon b WHERE b.afwezigheid = :afwezigheid")})
public class Bedrijfspersoon implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BedrijfspersoonId")
    private Integer bedrijfspersoonId;
    @Basic(optional = false)
    @Column(name = "Familienaam")
    private String familienaam;
    @Basic(optional = false)
    @Column(name = "Voornaam")
    private String voornaam;
    @Basic(optional = false)
    @Column(name = "Functie")
    private String functie;
    @Basic(optional = false)
    @Lob
    @Column(name = "Telefoon")
    private String telefoon;
    @Basic(optional = false)
    @Lob
    @Column(name = "Email")
    private String email;
    @Column(name = "Afwezigheid")
    private String afwezigheid;
    @JoinColumn(name = "Bedrijf_BedrijfsId", referencedColumnName = "BedrijfsId")
    @ManyToOne
    private Bedrijf bedrijfBedrijfsId;
    @OneToMany(mappedBy = "stagementorId")
    private Collection<Stage> stageCollection;
    @OneToMany(mappedBy = "contractondertekenaarId")
    private Collection<Stage> stageCollection1;

    public Bedrijfspersoon() {
    }

    public Bedrijfspersoon(Integer bedrijfspersoonId) {
        this.bedrijfspersoonId = bedrijfspersoonId;
    }

    public Bedrijfspersoon(Integer bedrijfspersoonId, String familienaam, String voornaam, String functie, String telefoon, String email) {
        this.bedrijfspersoonId = bedrijfspersoonId;
        this.familienaam = familienaam;
        this.voornaam = voornaam;
        this.functie = functie;
        this.telefoon = telefoon;
        this.email = email;
    }

    public Integer getBedrijfspersoonId() {
        return bedrijfspersoonId;
    }

    public void setBedrijfspersoonId(Integer bedrijfspersoonId) {
        this.bedrijfspersoonId = bedrijfspersoonId;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public void setFamilienaam(String familienaam) {
        this.familienaam = familienaam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getFunctie() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }

    public String getTelefoon() {
        return telefoon;
    }

    public void setTelefoon(String telefoon) {
        this.telefoon = telefoon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAfwezigheid() {
        return afwezigheid;
    }

    public void setAfwezigheid(String afwezigheid) {
        this.afwezigheid = afwezigheid;
    }

    public Bedrijf getBedrijfBedrijfsId() {
        return bedrijfBedrijfsId;
    }

    public void setBedrijfBedrijfsId(Bedrijf bedrijfBedrijfsId) {
        this.bedrijfBedrijfsId = bedrijfBedrijfsId;
    }

    @XmlTransient
    public Collection<Stage> getStageCollection() {
        return stageCollection;
    }

    public void setStageCollection(Collection<Stage> stageCollection) {
        this.stageCollection = stageCollection;
    }

    @XmlTransient
    public Collection<Stage> getStageCollection1() {
        return stageCollection1;
    }

    public void setStageCollection1(Collection<Stage> stageCollection1) {
        this.stageCollection1 = stageCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bedrijfspersoonId != null ? bedrijfspersoonId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bedrijfspersoon)) {
            return false;
        }
        Bedrijfspersoon other = (Bedrijfspersoon) object;
        if ((this.bedrijfspersoonId == null && other.bedrijfspersoonId != null) || (this.bedrijfspersoonId != null && !this.bedrijfspersoonId.equals(other.bedrijfspersoonId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "admin.model.Bedrijfspersoon[ bedrijfspersoonId=" + bedrijfspersoonId + " ]";
    }
    
}
