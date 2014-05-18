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
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByStudentId", query = "SELECT s FROM Student s WHERE s.studentId = :studentId"),
    @NamedQuery(name = "Student.findByFamilienaam", query = "SELECT s FROM Student s WHERE s.familienaam = :familienaam"),
    @NamedQuery(name = "Student.findByVoornaam", query = "SELECT s FROM Student s WHERE s.voornaam = :voornaam"),
    @NamedQuery(name = "Student.findByStraat", query = "SELECT s FROM Student s WHERE s.straat = :straat"),
    @NamedQuery(name = "Student.findByGemeente", query = "SELECT s FROM Student s WHERE s.gemeente = :gemeente"),
    @NamedQuery(name = "Student.findByPostcode", query = "SELECT s FROM Student s WHERE s.postcode = :postcode")})
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "StudentId")
    private Integer studentId;
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
    @Column(name = "EmailPrive")
    private String emailPrive;
    @Basic(optional = false)
    @Lob
    @Column(name = "EmailHogent")
    private String emailHogent;
    @Basic(optional = false)
    @Lob
    @Column(name = "Telefoon")
    private String telefoon;
    @Lob
    @Column(name = "UserId")
    private String userId;
    @Lob
    @Column(name = "Foto")
    private String foto;
    @JoinColumn(name = "StageId", referencedColumnName = "StageId")
    @ManyToOne
    private Stage stageId;
    @JoinColumn(name = "Begeleider_BegeleiderId", referencedColumnName = "BegeleiderId")
    @ManyToOne
    private Begeleider begeleiderBegeleiderId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId")
    private Collection<Studentstage> studentstageCollection;

    public Student() {
    }

    public Student(Integer studentId) {
        this.studentId = studentId;
    }

    public Student(Integer studentId, String familienaam, String voornaam, String straat, String gemeente, int postcode, String emailPrive, String emailHogent, String telefoon) {
        this.studentId = studentId;
        this.familienaam = familienaam;
        this.voornaam = voornaam;
        this.straat = straat;
        this.gemeente = gemeente;
        this.postcode = postcode;
        this.emailPrive = emailPrive;
        this.emailHogent = emailHogent;
        this.telefoon = telefoon;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
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

    public String getEmailPrive() {
        return emailPrive;
    }

    public void setEmailPrive(String emailPrive) {
        this.emailPrive = emailPrive;
    }

    public String getEmailHogent() {
        return emailHogent;
    }

    public void setEmailHogent(String emailHogent) {
        this.emailHogent = emailHogent;
    }

    public String getTelefoon() {
        return telefoon;
    }

    public void setTelefoon(String telefoon) {
        this.telefoon = telefoon;
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

    public Stage getStageId() {
        return stageId;
    }

    public void setStageId(Stage stageId) {
        this.stageId = stageId;
    }

    public Begeleider getBegeleiderBegeleiderId() {
        return begeleiderBegeleiderId;
    }

    public void setBegeleiderBegeleiderId(Begeleider begeleiderBegeleiderId) {
        this.begeleiderBegeleiderId = begeleiderBegeleiderId;
    }

    @XmlTransient
    public Collection<Studentstage> getStudentstageCollection() {
        return studentstageCollection;
    }

    public void setStudentstageCollection(Collection<Studentstage> studentstageCollection) {
        this.studentstageCollection = studentstageCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentId != null ? studentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.studentId == null && other.studentId != null) || (this.studentId != null && !this.studentId.equals(other.studentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "admin.model.Student[ studentId=" + studentId + " ]";
    }
    
}
