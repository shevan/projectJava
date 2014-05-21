/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "bedrijf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bedrijf.findAll", query = "SELECT b FROM Bedrijf b"),
    @NamedQuery(name = "Bedrijf.findByBedrijfsId", query = "SELECT b FROM Bedrijf b WHERE b.bedrijfsId = :bedrijfsId"),
    @NamedQuery(name = "Bedrijf.findByBedrijfsNaam", query = "SELECT b FROM Bedrijf b WHERE b.bedrijfsNaam = :bedrijfsNaam"),
    @NamedQuery(name = "Bedrijf.findByStraat", query = "SELECT b FROM Bedrijf b WHERE b.straat = :straat"),
    @NamedQuery(name = "Bedrijf.findByGemeente", query = "SELECT b FROM Bedrijf b WHERE b.gemeente = :gemeente"),
    @NamedQuery(name = "Bedrijf.findByPostcode", query = "SELECT b FROM Bedrijf b WHERE b.postcode = :postcode"),
    @NamedQuery(name = "Bedrijf.findByAantalbedrijfsleden", query = "SELECT b FROM Bedrijf b WHERE b.aantalbedrijfsleden = :aantalbedrijfsleden"),
    @NamedQuery(name = "Bedrijf.findByBereikbaarheid", query = "SELECT b FROM Bedrijf b WHERE b.bereikbaarheid = :bereikbaarheid"),
    @NamedQuery(name = "Bedrijf.findByFax", query = "SELECT b FROM Bedrijf b WHERE b.fax = :fax")})
public class Bedrijf implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BedrijfsId")
    private Integer bedrijfsId;
    @Basic(optional = false)
    @Column(name = "BedrijfsNaam")
    private String bedrijfsNaam;
    @Basic(optional = false)
    @Lob
    @Column(name = "Telefoon")
    private String telefoon;
    @Basic(optional = false)
    @Column(name = "Straat")
    private String straat;
    @Basic(optional = false)
    @Column(name = "Gemeente")
    private String gemeente;
    @Basic(optional = false)
    @Column(name = "Postcode")
    private int postcode;
    @Column(name = "Aantalbedrijfsleden")
    private Integer aantalbedrijfsleden;
    @Column(name = "Bereikbaarheid")
    private String bereikbaarheid;
    @Lob
    @Column(name = "Website")
    private String website;
    @Column(name = "Fax")
    private Integer fax;
    @Lob
    @Column(name = "UserId")
    private String userId;
    @OneToMany(mappedBy = "bedrijfBedrijfsId")
    private Collection<Bedrijfspersoon> bedrijfspersoonCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bedrijfId")
    private Collection<Stages> stageCollection;

    public Bedrijf() {
    }

    public Bedrijf(Integer bedrijfsId) {
        this.bedrijfsId = bedrijfsId;
    }

    public Bedrijf(Integer bedrijfsId, String bedrijfsNaam, String telefoon, String straat, String gemeente, int postcode) {
        this.bedrijfsId = bedrijfsId;
        this.bedrijfsNaam = bedrijfsNaam;
        this.telefoon = telefoon;
        this.straat = straat;
        this.gemeente = gemeente;
        this.postcode = postcode;
    }

    public Integer getBedrijfsId() {
        return bedrijfsId;
    }

    public void setBedrijfsId(Integer bedrijfsId) {
        this.bedrijfsId = bedrijfsId;
    }

    public String getBedrijfsNaam() {
        return bedrijfsNaam;
    }

    public void setBedrijfsNaam(String bedrijfsNaam) {
        this.bedrijfsNaam = bedrijfsNaam;
    }

    public String getTelefoon() {
        return telefoon;
    }

    public void setTelefoon(String telefoon) {
        this.telefoon = telefoon;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getGemeente() {
        return gemeente;
    }

    public void setGemeente(String gemeente) {
        this.gemeente = gemeente;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public Integer getAantalbedrijfsleden() {
        return aantalbedrijfsleden;
    }

    public void setAantalbedrijfsleden(Integer aantalbedrijfsleden) {
        this.aantalbedrijfsleden = aantalbedrijfsleden;
    }

    public String getBereikbaarheid() {
        return bereikbaarheid;
    }

    public void setBereikbaarheid(String bereikbaarheid) {
        this.bereikbaarheid = bereikbaarheid;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Integer getFax() {
        return fax;
    }

    public void setFax(Integer fax) {
        this.fax = fax;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Collection<Bedrijfspersoon> getBedrijfspersoonCollection() {
        return bedrijfspersoonCollection;
    }

    public void setBedrijfspersoonCollection(Collection<Bedrijfspersoon> bedrijfspersoonCollection) {
        this.bedrijfspersoonCollection = bedrijfspersoonCollection;
    }

    @XmlTransient
    public Collection<Stages> getStageCollection() {
        return stageCollection;
    }

    public void setStageCollection(Collection<Stages> stageCollection) {
        this.stageCollection = stageCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bedrijfsId != null ? bedrijfsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bedrijf)) {
            return false;
        }
        Bedrijf other = (Bedrijf) object;
        if ((this.bedrijfsId == null && other.bedrijfsId != null) || (this.bedrijfsId != null && !this.bedrijfsId.equals(other.bedrijfsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "admin.model.Bedrijf[ bedrijfsId=" + bedrijfsId + " ]";
    }
    
}
