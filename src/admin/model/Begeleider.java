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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author shevan
 */
@Entity
@Table(name = "begeleider")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Begeleider.findAll", query = "SELECT b FROM Begeleider b"),
    @NamedQuery(name = "Begeleider.findByBegeleiderId", query = "SELECT b FROM Begeleider b WHERE b.begeleiderId = :begeleiderId"),
    @NamedQuery(name = "Begeleider.findByFamilienaam", query = "SELECT b FROM Begeleider b WHERE b.familienaam = :familienaam"),
    @NamedQuery(name = "Begeleider.findByVoornaam", query = "SELECT b FROM Begeleider b WHERE b.voornaam = :voornaam"),
    @NamedQuery(name = "Begeleider.findByPassword", query = "SELECT b FROM Begeleider b WHERE b.password = :password")})
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
    @Lob
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
    @Lob
    @Column(name = "UserId")
    private String userId;
    @OneToMany(mappedBy = "begeleiderBegeleiderId")
    private Collection<Begeleiderstageaanvraag> begeleiderstageaanvraagCollection;
    @OneToMany(mappedBy = "begeleiderBegeleiderId")
    private Collection<Stage> stageCollection;

    public Begeleider() {
    }

    public Begeleider(Integer begeleiderId) {
        this.begeleiderId = begeleiderId;
    }

    public Begeleider(Integer begeleiderId, String familienaam, String voornaam, String email, String password) {
        this.begeleiderId = begeleiderId;
        this.familienaam = familienaam;
        this.voornaam = voornaam;
        this.email = email;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Collection<Begeleiderstageaanvraag> getBegeleiderstageaanvraagCollection() {
        return begeleiderstageaanvraagCollection;
    }

    public void setBegeleiderstageaanvraagCollection(Collection<Begeleiderstageaanvraag> begeleiderstageaanvraagCollection) {
        this.begeleiderstageaanvraagCollection = begeleiderstageaanvraagCollection;
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
        return "ch.makery.address.model.Begeleider[ begeleiderId=" + begeleiderId + " ]";
    }
    
}
