/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 *
 * @author Pieter Pletinckx
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Bedrijfspersoon.findAll", query = "SELECT b FROM Bedrijfspersoon b"),
    @NamedQuery(name = "Bedrijfspersoon.findByBedrijfspersoonId", query = "SELECT b FROM Bedrijfspersoon b WHERE b.bedrijfspersoonId = :bedrijfspersoonId"),
    @NamedQuery(name = "Bedrijfspersoon.findByFamilienaam", query = "SELECT b FROM Bedrijfspersoon b WHERE b.familienaam = :familienaam"),
    @NamedQuery(name = "Bedrijfspersoon.findByVoornaam", query = "SELECT b FROM Bedrijfspersoon b WHERE b.voornaam = :voornaam"),
    @NamedQuery(name = "Bedrijfspersoon.findByFunctie", query = "SELECT b FROM Bedrijfspersoon b WHERE b.functie = :functie"),
    @NamedQuery(name = "Bedrijfspersoon.findByTelefoon", query = "SELECT b FROM Bedrijfspersoon b WHERE b.telefoon = :telefoon"),
    @NamedQuery(name = "Bedrijfspersoon.findByAfwezigheid", query = "SELECT b FROM Bedrijfspersoon b WHERE b.afwezigheid = :afwezigheid")})
public class Bedrijfspersoon implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer bedrijfspersoonId;
    @Basic(optional = false)
    private String familienaam;
    @Basic(optional = false)
    private String voornaam;
    @Basic(optional = false)
    private String functie;
    @Basic(optional = false)
    private int telefoon;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @Lob
    private String email;
    private String afwezigheid;
    @JoinColumn(name = "Bedrijf_BedrijfsId", referencedColumnName = "BedrijfsId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Bedrijf bedrijfBedrijfsId;
    @OneToMany(mappedBy = "contractondertekenaarBedrijfspersoonId", fetch = FetchType.EAGER)
    private List<Stage> stageList;
    @OneToMany(mappedBy = "stagementorBedrijfspersoonId", fetch = FetchType.EAGER)
    private List<Stage> stageList1;

    public Bedrijfspersoon() {
    }

    public Bedrijfspersoon(Integer bedrijfspersoonId) {
        this.bedrijfspersoonId = bedrijfspersoonId;
    }

    public Bedrijfspersoon(Integer bedrijfspersoonId, String familienaam, String voornaam, String functie, int telefoon, String email) {
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

    public int getTelefoon() {
        return telefoon;
    }

    public void setTelefoon(int telefoon) {
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

    public List<Stage> getStageList() {
        return stageList;
    }

    public void setStageList(List<Stage> stageList) {
        this.stageList = stageList;
    }

    public List<Stage> getStageList1() {
        return stageList1;
    }

    public void setStageList1(List<Stage> stageList1) {
        this.stageList1 = stageList1;
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
        return "Entity.Bedrijfspersoon[ bedrijfspersoonId=" + bedrijfspersoonId + " ]";
    }
    
}
