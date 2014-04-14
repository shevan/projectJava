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
    @NamedQuery(name = "Bedrijf.findAll", query = "SELECT b FROM Bedrijf b"),
    @NamedQuery(name = "Bedrijf.findByBedrijfsId", query = "SELECT b FROM Bedrijf b WHERE b.bedrijfsId = :bedrijfsId"),
    @NamedQuery(name = "Bedrijf.findByBedrijfsNaam", query = "SELECT b FROM Bedrijf b WHERE b.bedrijfsNaam = :bedrijfsNaam"),
    @NamedQuery(name = "Bedrijf.findByTelefoon", query = "SELECT b FROM Bedrijf b WHERE b.telefoon = :telefoon"),
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
    private Integer bedrijfsId;
    
    private String bedrijfsNaam;
    private String email;
    private int telefoon;
    private String straat;
    private String gemeente;
    private int postcode;
    private int aantalbedrijfsleden;
    private String bereikbaarheid;
    private String website;
    private Integer fax;
    @JoinColumn(name = "UserId", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Aspnetusers userId;
    @OneToMany(mappedBy = "bedrijfBedrijfsId", fetch = FetchType.EAGER)
    private List<Bedrijfspersoon> bedrijfspersoonList;
    @OneToMany(mappedBy = "bedrijfBedrijfsId", fetch = FetchType.EAGER)
    private List<Stage> stageList;

    public Bedrijf() {
    }

    public Bedrijf(Integer bedrijfsId) {
        this.bedrijfsId = bedrijfsId;
    }

    public Bedrijf(Integer bedrijfsId, String bedrijfsNaam, String email, int telefoon, String straat, String gemeente, int postcode, int aantalbedrijfsleden) {
        this.bedrijfsId = bedrijfsId;
        this.bedrijfsNaam = bedrijfsNaam;
        this.email = email;
        this.telefoon = telefoon;
        this.straat = straat;
        this.gemeente = gemeente;
        this.postcode = postcode;
        this.aantalbedrijfsleden = aantalbedrijfsleden;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefoon() {
        return telefoon;
    }

    public void setTelefoon(int telefoon) {
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

    public int getAantalbedrijfsleden() {
        return aantalbedrijfsleden;
    }

    public void setAantalbedrijfsleden(int aantalbedrijfsleden) {
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

    public Aspnetusers getUserId() {
        return userId;
    }

    public void setUserId(Aspnetusers userId) {
        this.userId = userId;
    }

    public List<Bedrijfspersoon> getBedrijfspersoonList() {
        return bedrijfspersoonList;
    }

    public void setBedrijfspersoonList(List<Bedrijfspersoon> bedrijfspersoonList) {
        this.bedrijfspersoonList = bedrijfspersoonList;
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
        return "Entity.Bedrijf[ bedrijfsId=" + bedrijfsId + " ]";
    }
    
}
