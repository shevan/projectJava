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
 * @author shevan
 */
@Entity
@Table(name = "studentstagesollicitatie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Studentstagesollicitatie.findAll", query = "SELECT s FROM Studentstagesollicitatie s"),
    @NamedQuery(name = "Studentstagesollicitatie.findByStudentStageSollicitatieId", query = "SELECT s FROM Studentstagesollicitatie s WHERE s.studentStageSollicitatieId = :studentStageSollicitatieId")})
public class Studentstagesollicitatie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "StudentStageSollicitatieId")
    private Integer studentStageSollicitatieId;
    @JoinColumn(name = "Stage_StageId", referencedColumnName = "StageId")
    @ManyToOne
    private Stage stageStageId;
    @JoinColumn(name = "Student_StudentId", referencedColumnName = "StudentId")
    @ManyToOne
    private Student studentStudentId;

    public Studentstagesollicitatie() {
    }

    public Studentstagesollicitatie(Integer studentStageSollicitatieId) {
        this.studentStageSollicitatieId = studentStageSollicitatieId;
    }

    public Integer getStudentStageSollicitatieId() {
        return studentStageSollicitatieId;
    }

    public void setStudentStageSollicitatieId(Integer studentStageSollicitatieId) {
        this.studentStageSollicitatieId = studentStageSollicitatieId;
    }

    public Stage getStageStageId() {
        return stageStageId;
    }

    public void setStageStageId(Stage stageStageId) {
        this.stageStageId = stageStageId;
    }

    public Student getStudentStudentId() {
        return studentStudentId;
    }

    public void setStudentStudentId(Student studentStudentId) {
        this.studentStudentId = studentStudentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentStageSollicitatieId != null ? studentStageSollicitatieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studentstagesollicitatie)) {
            return false;
        }
        Studentstagesollicitatie other = (Studentstagesollicitatie) object;
        if ((this.studentStageSollicitatieId == null && other.studentStageSollicitatieId != null) || (this.studentStageSollicitatieId != null && !this.studentStageSollicitatieId.equals(other.studentStageSollicitatieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "admin.model.Studentstagesollicitatie[ studentStageSollicitatieId=" + studentStageSollicitatieId + " ]";
    }
    
}
