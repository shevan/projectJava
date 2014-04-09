/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Pieter Pletinckx
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Stage.findAll", query = "SELECT s FROM Stage s"),
    @NamedQuery(name = "Stage.findByStageId", query = "SELECT s FROM Stage s WHERE s.stageId = :stageId"),
    @NamedQuery(name = "Stage.findByHardware", query = "SELECT s FROM Stage s WHERE s.hardware = :hardware"),
    @NamedQuery(name = "Stage.findByBeheersysteem", query = "SELECT s FROM Stage s WHERE s.beheersysteem = :beheersysteem"),
    @NamedQuery(name = "Stage.findByDbms", query = "SELECT s FROM Stage s WHERE s.dbms = :dbms"),
    @NamedQuery(name = "Stage.findByProgrammeertaal", query = "SELECT s FROM Stage s WHERE s.programmeertaal = :programmeertaal"),
    @NamedQuery(name = "Stage.findByNetwerkprotocol", query = "SELECT s FROM Stage s WHERE s.netwerkprotocol = :netwerkprotocol"),
    @NamedQuery(name = "Stage.findByAnalyse", query = "SELECT s FROM Stage s WHERE s.analyse = :analyse"),
    @NamedQuery(name = "Stage.findByCasetools", query = "SELECT s FROM Stage s WHERE s.casetools = :casetools"),
    @NamedQuery(name = "Stage.findByOntwikkelingstools", query = "SELECT s FROM Stage s WHERE s.ontwikkelingstools = :ontwikkelingstools"),
    @NamedQuery(name = "Stage.findByProjectTitel", query = "SELECT s FROM Stage s WHERE s.projectTitel = :projectTitel"),
    @NamedQuery(name = "Stage.findBySpecialisatie", query = "SELECT s FROM Stage s WHERE s.specialisatie = :specialisatie"),
    @NamedQuery(name = "Stage.findByProjectOmschrijving", query = "SELECT s FROM Stage s WHERE s.projectOmschrijving = :projectOmschrijving"),
    @NamedQuery(name = "Stage.findByAantalStudenten", query = "SELECT s FROM Stage s WHERE s.aantalStudenten = :aantalStudenten"),
    @NamedQuery(name = "Stage.findByContactpersoon", query = "SELECT s FROM Stage s WHERE s.contactpersoon = :contactpersoon"),
    @NamedQuery(name = "Stage.findByConfiguratiehardware", query = "SELECT s FROM Stage s WHERE s.configuratiehardware = :configuratiehardware"),
    @NamedQuery(name = "Stage.findByProgrammeerlogica", query = "SELECT s FROM Stage s WHERE s.programmeerlogica = :programmeerlogica"),
    @NamedQuery(name = "Stage.findByGl", query = "SELECT s FROM Stage s WHERE s.gl = :gl"),
    @NamedQuery(name = "Stage.findByPeriode", query = "SELECT s FROM Stage s WHERE s.periode = :periode"),
    @NamedQuery(name = "Stage.findByGoedgekeurd", query = "SELECT s FROM Stage s WHERE s.goedgekeurd = :goedgekeurd"),
    @NamedQuery(name = "Stage.findByAanmaakdatum", query = "SELECT s FROM Stage s WHERE s.aanmaakdatum = :aanmaakdatum"),
    @NamedQuery(name = "Stage.findByWijzigingsdatum", query = "SELECT s FROM Stage s WHERE s.wijzigingsdatum = :wijzigingsdatum"),
    @NamedQuery(name = "Stage.findByAantalBeschikbarePlaatsen", query = "SELECT s FROM Stage s WHERE s.aantalBeschikbarePlaatsen = :aantalBeschikbarePlaatsen")})
public class Stage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer stageId;
    @Basic(optional = false)

    private String hardware;
    @Basic(optional = false)
    private String beheersysteem;
    @Basic(optional = false)
    private String dbms;
    @Basic(optional = false)
    private String programmeertaal;
    @Basic(optional = false)
    private String netwerkprotocol;
    @Basic(optional = false)
    private String analyse;
    @Basic(optional = false)
    private String casetools;
    @Basic(optional = false)
    private String ontwikkelingstools;
    @Basic(optional = false)
    private String projectTitel;
    @Basic(optional = false)
    private String specialisatie;
    @Basic(optional = false)
    private String projectOmschrijving;
    @Basic(optional = false)
    private int aantalStudenten;
    private String contactpersoon;
    @Basic(optional = false)
    private String configuratiehardware;
    @Basic(optional = false)
    private String programmeerlogica;
    @Basic(optional = false)
    private String gl;
    @Basic(optional = false)
    private String periode;
    @Basic(optional = false)
    @Lob
    private String academiejaar;
    private Boolean goedgekeurd;
    @Temporal(TemporalType.TIMESTAMP)
    private Date aanmaakdatum;
    @Temporal(TemporalType.TIMESTAMP)
    private Date wijzigingsdatum;
    private Integer aantalBeschikbarePlaatsen;
    @OneToMany(mappedBy = "stageStageId", fetch = FetchType.EAGER)
    private List<Student> studentList;
    @JoinColumn(name = "Opleiding_OpleidingId", referencedColumnName = "OpleidingId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Opleiding opleidingOpleidingId;
    @JoinColumn(name = "Begeleider_BegeleiderId", referencedColumnName = "BegeleiderId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Begeleider begeleiderBegeleiderId;
    @JoinColumn(name = "Bedrijf_BedrijfsId", referencedColumnName = "BedrijfsId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Bedrijf bedrijfBedrijfsId;
    @JoinColumn(name = "Contractondertekenaar_BedrijfspersoonId", referencedColumnName = "BedrijfspersoonId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Bedrijfspersoon contractondertekenaarBedrijfspersoonId;
    @JoinColumn(name = "Stagementor_BedrijfspersoonId", referencedColumnName = "BedrijfspersoonId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Bedrijfspersoon stagementorBedrijfspersoonId;

    public Stage() {
    }

    public Stage(Integer stageId) {
        this.stageId = stageId;
    }

    public Stage(Integer stageId, String hardware, String beheersysteem, String dbms, String programmeertaal, String netwerkprotocol, String analyse, String casetools, String ontwikkelingstools, String projectTitel, String specialisatie, String projectOmschrijving, int aantalStudenten, String configuratiehardware, String programmeerlogica, String gl, String periode, String academiejaar) {
        this.stageId = stageId;
        this.hardware = hardware;
        this.beheersysteem = beheersysteem;
        this.dbms = dbms;
        this.programmeertaal = programmeertaal;
        this.netwerkprotocol = netwerkprotocol;
        this.analyse = analyse;
        this.casetools = casetools;
        this.ontwikkelingstools = ontwikkelingstools;
        this.projectTitel = projectTitel;
        this.specialisatie = specialisatie;
        this.projectOmschrijving = projectOmschrijving;
        this.aantalStudenten = aantalStudenten;
        this.configuratiehardware = configuratiehardware;
        this.programmeerlogica = programmeerlogica;
        this.gl = gl;
        this.periode = periode;
        this.academiejaar = academiejaar;
    }

    public Integer getStageId() {
        return stageId;
    }

    public void setStageId(Integer stageId) {
        this.stageId = stageId;
    }

    public String getHardware() {
        return hardware;
    }

    public void setHardware(String hardware) {
        this.hardware = hardware;
    }

    public String getBeheersysteem() {
        return beheersysteem;
    }

    public void setBeheersysteem(String beheersysteem) {
        this.beheersysteem = beheersysteem;
    }

    public String getDbms() {
        return dbms;
    }

    public void setDbms(String dbms) {
        this.dbms = dbms;
    }

    public String getProgrammeertaal() {
        return programmeertaal;
    }

    public void setProgrammeertaal(String programmeertaal) {
        this.programmeertaal = programmeertaal;
    }

    public String getNetwerkprotocol() {
        return netwerkprotocol;
    }

    public void setNetwerkprotocol(String netwerkprotocol) {
        this.netwerkprotocol = netwerkprotocol;
    }

    public String getAnalyse() {
        return analyse;
    }

    public void setAnalyse(String analyse) {
        this.analyse = analyse;
    }

    public String getCasetools() {
        return casetools;
    }

    public void setCasetools(String casetools) {
        this.casetools = casetools;
    }

    public String getOntwikkelingstools() {
        return ontwikkelingstools;
    }

    public void setOntwikkelingstools(String ontwikkelingstools) {
        this.ontwikkelingstools = ontwikkelingstools;
    }

    public String getProjectTitel() {
        return projectTitel;
    }

    public void setProjectTitel(String projectTitel) {
        this.projectTitel = projectTitel;
    }

    public String getSpecialisatie() {
        return specialisatie;
    }

    public void setSpecialisatie(String specialisatie) {
        this.specialisatie = specialisatie;
    }

    public String getProjectOmschrijving() {
        return projectOmschrijving;
    }

    public void setProjectOmschrijving(String projectOmschrijving) {
        this.projectOmschrijving = projectOmschrijving;
    }

    public int getAantalStudenten() {
        return aantalStudenten;
    }

    public void setAantalStudenten(int aantalStudenten) {
        this.aantalStudenten = aantalStudenten;
    }

    public String getContactpersoon() {
        return contactpersoon;
    }

    public void setContactpersoon(String contactpersoon) {
        this.contactpersoon = contactpersoon;
    }

    public String getConfiguratiehardware() {
        return configuratiehardware;
    }

    public void setConfiguratiehardware(String configuratiehardware) {
        this.configuratiehardware = configuratiehardware;
    }

    public String getProgrammeerlogica() {
        return programmeerlogica;
    }

    public void setProgrammeerlogica(String programmeerlogica) {
        this.programmeerlogica = programmeerlogica;
    }

    public String getGl() {
        return gl;
    }

    public void setGl(String gl) {
        this.gl = gl;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public String getAcademiejaar() {
        return academiejaar;
    }

    public void setAcademiejaar(String academiejaar) {
        this.academiejaar = academiejaar;
    }

    public Boolean getGoedgekeurd() {
        return goedgekeurd;
    }

    public void setGoedgekeurd(Boolean goedgekeurd) {
        this.goedgekeurd = goedgekeurd;
    }

    public Date getAanmaakdatum() {
        return aanmaakdatum;
    }

    public void setAanmaakdatum(Date aanmaakdatum) {
        this.aanmaakdatum = aanmaakdatum;
    }

    public Date getWijzigingsdatum() {
        return wijzigingsdatum;
    }

    public void setWijzigingsdatum(Date wijzigingsdatum) {
        this.wijzigingsdatum = wijzigingsdatum;
    }

    public Integer getAantalBeschikbarePlaatsen() {
        return aantalBeschikbarePlaatsen;
    }

    public void setAantalBeschikbarePlaatsen(Integer aantalBeschikbarePlaatsen) {
        this.aantalBeschikbarePlaatsen = aantalBeschikbarePlaatsen;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Opleiding getOpleidingOpleidingId() {
        return opleidingOpleidingId;
    }

    public void setOpleidingOpleidingId(Opleiding opleidingOpleidingId) {
        this.opleidingOpleidingId = opleidingOpleidingId;
    }

    public Begeleider getBegeleiderBegeleiderId() {
        return begeleiderBegeleiderId;
    }

    public void setBegeleiderBegeleiderId(Begeleider begeleiderBegeleiderId) {
        this.begeleiderBegeleiderId = begeleiderBegeleiderId;
    }

    public Bedrijf getBedrijfBedrijfsId() {
        return bedrijfBedrijfsId;
    }

    public void setBedrijfBedrijfsId(Bedrijf bedrijfBedrijfsId) {
        this.bedrijfBedrijfsId = bedrijfBedrijfsId;
    }

    public Bedrijfspersoon getContractondertekenaarBedrijfspersoonId() {
        return contractondertekenaarBedrijfspersoonId;
    }

    public void setContractondertekenaarBedrijfspersoonId(Bedrijfspersoon contractondertekenaarBedrijfspersoonId) {
        this.contractondertekenaarBedrijfspersoonId = contractondertekenaarBedrijfspersoonId;
    }

    public Bedrijfspersoon getStagementorBedrijfspersoonId() {
        return stagementorBedrijfspersoonId;
    }

    public void setStagementorBedrijfspersoonId(Bedrijfspersoon stagementorBedrijfspersoonId) {
        this.stagementorBedrijfspersoonId = stagementorBedrijfspersoonId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stageId != null ? stageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stage)) {
            return false;
        }
        Stage other = (Stage) object;
        if ((this.stageId == null && other.stageId != null) || (this.stageId != null && !this.stageId.equals(other.stageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Stage[ stageId=" + stageId + " ]";
    }
    
}
