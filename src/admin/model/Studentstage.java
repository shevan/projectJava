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
 * @author Pieter Pletinckx
 */
@Entity
@Table(name = "studentstage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Studentstage.findAll", query = "SELECT s FROM Studentstage s"),
    @NamedQuery(name = "Studentstage.findByStudentStageId", query = "SELECT s FROM Studentstage s WHERE s.studentStageId = :studentStageId"),
    @NamedQuery(name = "Studentstage.findByGoedgekeurd", query = "SELECT s FROM Studentstage s WHERE s.goedgekeurd = :goedgekeurd"),
    @NamedQuery(name = "Studentstage.findByFavoriet", query = "SELECT s FROM Studentstage s WHERE s.favoriet = :favoriet"),
    @NamedQuery(name = "Studentstage.findByGesolliciteerd", query = "SELECT s FROM Studentstage s WHERE s.gesolliciteerd = :gesolliciteerd")})
public class Studentstage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "StudentStageId")
    private Integer studentStageId;
    @Column(name = "Goedgekeurd")
    private Boolean goedgekeurd;
    @Column(name = "Favoriet")
    private Boolean favoriet;
    @Column(name = "Gesolliciteerd")
    private Boolean gesolliciteerd;
    @JoinColumn(name = "StageId", referencedColumnName = "StageId")
    @ManyToOne(optional = false)
    private Stage stageId;
    @JoinColumn(name = "StudentId", referencedColumnName = "StudentId")
    @ManyToOne(optional = false)
    private Student studentId;

    public Studentstage() {
    }

    public Studentstage(Integer studentStageId) {
        this.studentStageId = studentStageId;
    }

    public Integer getStudentStageId() {
        return studentStageId;
    }

    public void setStudentStageId(Integer studentStageId) {
        this.studentStageId = studentStageId;
    }

    public Boolean getGoedgekeurd() {
        return goedgekeurd;
    }

    public void setGoedgekeurd(Boolean goedgekeurd) {
        this.goedgekeurd = goedgekeurd;
    }

    public Boolean getFavoriet() {
        return favoriet;
    }

    public void setFavoriet(Boolean favoriet) {
        this.favoriet = favoriet;
    }

    public Boolean getGesolliciteerd() {
        return gesolliciteerd;
    }

    public void setGesolliciteerd(Boolean gesolliciteerd) {
        this.gesolliciteerd = gesolliciteerd;
    }

    public Stage getStageId() {
        return stageId;
    }

    public void setStageId(Stage stageId) {
        this.stageId = stageId;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentStageId != null ? studentStageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studentstage)) {
            return false;
        }
        Studentstage other = (Studentstage) object;
        if ((this.studentStageId == null && other.studentStageId != null) || (this.studentStageId != null && !this.studentStageId.equals(other.studentStageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "admin.model.Studentstage[ studentStageId=" + studentStageId + " ]";
    }
    
}
