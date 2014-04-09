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
    private Integer begeleiderId;
    @Basic(optional = false)
    private String familienaam;
    @Basic(optional = false)
    private String voornaam;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @Lob
    private String email;
    @Basic(optional = false)
    private String password;
    @JoinColumn(name = "UserId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Aspnetusers userId;
    @OneToMany(mappedBy = "begeleiderBegeleiderId", fetch = FetchType.EAGER)
    private List<Stage> stageList;

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

    public Aspnetusers getUserId() {
        return userId;
    }

    public void setUserId(Aspnetusers userId) {
        this.userId = userId;
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
        return "Entity.Begeleider[ begeleiderId=" + begeleiderId + " ]";
    }
    
}
