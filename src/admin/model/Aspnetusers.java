/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 *
 * @author Pieter Pletinckx
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Aspnetusers.findAll", query = "SELECT a FROM Aspnetusers a"),
    @NamedQuery(name = "Aspnetusers.findById", query = "SELECT a FROM Aspnetusers a WHERE a.id = :id"),
    @NamedQuery(name = "Aspnetusers.findByDiscriminator", query = "SELECT a FROM Aspnetusers a WHERE a.discriminator = :discriminator")})
public class Aspnetusers implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String userName;
    private String passwordHash;
    private String securityStamp;
    private String discriminator;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.EAGER)
    private List<Bedrijf> bedrijfList;
    @OneToMany(mappedBy = "userId", fetch = FetchType.EAGER)
    private List<Student> studentList;
    @OneToMany(mappedBy = "userId", fetch = FetchType.EAGER)
    private List<Begeleider> begeleiderList;

    public Aspnetusers() {
    }

    public Aspnetusers(String id) {
        this.id = id;
    }

    public Aspnetusers(String id, String userName, String discriminator) {
        this.id = id;
        this.userName = userName;
        this.discriminator = discriminator;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getSecurityStamp() {
        return securityStamp;
    }

    public void setSecurityStamp(String securityStamp) {
        this.securityStamp = securityStamp;
    }

    public String getDiscriminator() {
        return discriminator;
    }

    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }

    public List<Bedrijf> getBedrijfList() {
        return bedrijfList;
    }

    public void setBedrijfList(List<Bedrijf> bedrijfList) {
        this.bedrijfList = bedrijfList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Begeleider> getBegeleiderList() {
        return begeleiderList;
    }

    public void setBegeleiderList(List<Begeleider> begeleiderList) {
        this.begeleiderList = begeleiderList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aspnetusers)) {
            return false;
        }
        Aspnetusers other = (Aspnetusers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Aspnetusers[ id=" + id + " ]";
    }
    
}
