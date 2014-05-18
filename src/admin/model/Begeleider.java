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
@Table(name = "begeleider")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Begeleider.findAll", query = "SELECT b FROM Begeleider b"),
    @NamedQuery(name = "Begeleider.findByBegeleiderId", query = "SELECT b FROM Begeleider b WHERE b.begeleiderId = :begeleiderId"),
    @NamedQuery(name = "Begeleider.findByFamilienaam", query = "SELECT b FROM Begeleider b WHERE b.familienaam = :familienaam"),
    @NamedQuery(name = "Begeleider.findByVoornaam", query = "SELECT b FROM Begeleider b WHERE b.voornaam = :voornaam"),
    @NamedQuery(name = "Begeleider.findByStraat", query = "SELECT b FROM Begeleider b WHERE b.straat = :straat"),
    @NamedQuery(name = "Begeleider.findByGemeente", query = "SELECT b FROM Begeleider b WHERE b.gemeente = :gemeente"),
    @NamedQuery(name = "Begeleider.findByPostcode", query = "SELECT b FROM Begeleider b WHERE b.postcode = :postcode")})
public class Begeleider implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BegeleiderId")
    private Integer begeleiderId;
    @Basic(optional = false)
    @Column(name = "Familienaam")
    private String familienaam;
    @Basic(optional = false)
    @Column(name = "Voornaam")
    private String voornaam;
    @Basic(optional = false)
    @Column(name = "Straat")
    private String straat;
    @Basic(optional = false)
    @Column(name = "Gemeente")
    private String gemeente;
    @Basic(optional = false)
    @Column(name = "Postcode")
    private int postcode;
    @Basic(optional = false)
    @Lob
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @Lob
    @Column(name = "Telefoon")
    private String telefoon;
    @Basic(optional = false)
    @Lob
    @Column(name = "Gsm")
    private String gsm;
    @Lob
    @Column(name = "UserId")
    private String userId;
    @Lob
    @Column(name = "Foto")
    private String foto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "begeleiderId")
    private Collection<Begeleiderstageaanvraag> begeleiderstageaanvraagCollection;
    @OneToMany(mappedBy = "begeleiderBegeleiderId")
    private Collection<Student> studentCollection;
    @OneToMany(mappedBy = "begeleiderBegeleiderId")
    private Collection<Stage> stageCollection;

    public Begeleider() {
    }

    public Begeleider(Integer begeleiderId) {
        this.begeleiderId = begeleiderId;
    }

    public Begeleider(Integer begeleiderId, String familienaam, String voornaam, String straat, String gemeente, int postcode, String email, String telefoon, String gsm) {
        this.begeleiderId = begeleiderId;
        this.familienaam = familienaam;
        this.voornaam = voornaam;
        this.straat = straat;
        this.gemeente = gemeente;
        this.postcode = postcode;
        this.email = email;
        this.telefoon = telefoon;
        this.gsm = gsm;
    }

    public Integer getBegeleiderId() {
        return begeleiderId;
    }

    public void setBegeleiderId(Integer begeleiderId) {
        this.begeleiderId = begeleiderId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefoon() {
        return telefoon;
    }

    public void setTelefoon(String telefoon) {
        this.telefoon = telefoon;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @XmlTransient
    public Collection<Begeleiderstageaanvraag> getBegeleiderstageaanvraagCollection() {
        return begeleiderstageaanvraagCollection;
    }

    public void setBegeleiderstageaanvraagCollection(Collection<Begeleiderstageaanvraag> begeleiderstageaanvraagCollection) {
        this.begeleiderstageaanvraagCollection = begeleiderstageaanvraagCollection;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @XmlTransient
    public Collection<Stage> getStageCollection() {
        return stageCollection;
    }

    public void setStageCollection(Collection<Stage> stageCollection) {
        this.stageCollection = stageCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (begeleiderId != null ? begeleiderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Begeleider)) {
            return false;
        }
        Begeleider other = (Begeleider) object;
        if ((this.begeleiderId == null && other.begeleiderId != null) || (this.begeleiderId != null && !this.begeleiderId.equals(other.begeleiderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "admin.model.Begeleider[ begeleiderId=" + begeleiderId + " ]";
    }
    
}
