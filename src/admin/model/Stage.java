/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author shevan
 */
@Entity
@Table(name = "stage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stage.findAll", query = "SELECT s FROM Stage s"),
    @NamedQuery(name = "Stage.findByStageId", query = "SELECT s FROM Stage s WHERE s.stageId = :stageId"),
    @NamedQuery(name = "Stage.findByHardware", query = "SELECT s FROM Stage s WHERE s.hardware = :hardware"),
    @NamedQuery(name = "Stage.findByBeheersysteem", query = "SELECT s FROM Stage s WHERE s.beheersysteem = :beheersysteem"),
    @NamedQuery(name = "Stage.findByProgrammeertaal", query = "SELECT s FROM Stage s WHERE s.programmeertaal = :programmeertaal"),
    @NamedQuery(name = "Stage.findByAnalyse", query = "SELECT s FROM Stage s WHERE s.analyse = :analyse"),
    @NamedQuery(name = "Stage.findByOntwikkelingstools", query = "SELECT s FROM Stage s WHERE s.ontwikkelingstools = :ontwikkelingstools"),
    @NamedQuery(name = "Stage.findByProjectTitel", query = "SELECT s FROM Stage s WHERE s.projectTitel = :projectTitel"),
    @NamedQuery(name = "Stage.findBySpecialisatie", query = "SELECT s FROM Stage s WHERE s.specialisatie = :specialisatie"),
    @NamedQuery(name = "Stage.findByProjectOmschrijving", query = "SELECT s FROM Stage s WHERE s.projectOmschrijving = :projectOmschrijving"),
    @NamedQuery(name = "Stage.findByAantalStudenten", query = "SELECT s FROM Stage s WHERE s.aantalStudenten = :aantalStudenten"),
    @NamedQuery(name = "Stage.findByConfiguratiehardware", query = "SELECT s FROM Stage s WHERE s.configuratiehardware = :configuratiehardware"),
    @NamedQuery(name = "Stage.findByPeriode", query = "SELECT s FROM Stage s WHERE s.periode = :periode"),
    @NamedQuery(name = "Stage.findByOpleidingsOnderwerp", query = "SELECT s FROM Stage s WHERE s.opleidingsOnderwerp = :opleidingsOnderwerp"),
    @NamedQuery(name = "Stage.findByOpleidingBegindatum", query = "SELECT s FROM Stage s WHERE s.opleidingBegindatum = :opleidingBegindatum"),
    @NamedQuery(name = "Stage.findByOpleidingEinddatum", query = "SELECT s FROM Stage s WHERE s.opleidingEinddatum = :opleidingEinddatum"),
    @NamedQuery(name = "Stage.findByStageBegindatum", query = "SELECT s FROM Stage s WHERE s.stageBegindatum = :stageBegindatum"),
    @NamedQuery(name = "Stage.findByStageEindatum", query = "SELECT s FROM Stage s WHERE s.stageEindatum = :stageEindatum"),
    @NamedQuery(name = "Stage.findByGoedkeurStatus", query = "SELECT s FROM Stage s WHERE s.goedkeurStatus = :goedkeurStatus"),
    @NamedQuery(name = "Stage.findByStagecontractOpgesteld", query = "SELECT s FROM Stage s WHERE s.stagecontractOpgesteld = :stagecontractOpgesteld"),
    @NamedQuery(name = "Stage.findByGetekendeStagecontract", query = "SELECT s FROM Stage s WHERE s.getekendeStagecontract = :getekendeStagecontract"),
    @NamedQuery(name = "Stage.findByAanmaakdatum", query = "SELECT s FROM Stage s WHERE s.aanmaakdatum = :aanmaakdatum"),
    @NamedQuery(name = "Stage.findByWijzigingsdatum", query = "SELECT s FROM Stage s WHERE s.wijzigingsdatum = :wijzigingsdatum"),
    @NamedQuery(name = "Stage.findByAantalBeschikbarePlaatsen", query = "SELECT s FROM Stage s WHERE s.aantalBeschikbarePlaatsen = :aantalBeschikbarePlaatsen")})
public class Stage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "StageId")
    private Integer stageId;
    @Column(name = "Hardware")
    private String hardware;
    @Column(name = "Beheersysteem")
    private String beheersysteem;
    @Column(name = "Programmeertaal")
    private String programmeertaal;
    @Column(name = "Analyse")
    private String analyse;
    @Column(name = "Ontwikkelingstools")
    private String ontwikkelingstools;
    @Basic(optional = false)
    @Column(name = "ProjectTitel")
    private String projectTitel;
    @Column(name = "Specialisatie")
    private String specialisatie;
    @Basic(optional = false)
    @Column(name = "ProjectOmschrijving")
    private String projectOmschrijving;
    @Basic(optional = false)
    @Column(name = "AantalStudenten")
    private int aantalStudenten;
    @Column(name = "Configuratiehardware")
    private String configuratiehardware;
    @Basic(optional = false)
    @Column(name = "Periode")
    private String periode;
    @Column(name = "OpleidingsOnderwerp")
    private String opleidingsOnderwerp;
    @Column(name = "OpleidingBegindatum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date opleidingBegindatum;
    @Column(name = "OpleidingEinddatum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date opleidingEinddatum;
    @Column(name = "StageBegindatum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stageBegindatum;
    @Column(name = "StageEindatum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stageEindatum;
    @Column(name = "GoedkeurStatus")
    private Integer goedkeurStatus;
    @Column(name = "StagecontractOpgesteld")
    private Boolean stagecontractOpgesteld;
    @Column(name = "GetekendeStagecontract")
    private Boolean getekendeStagecontract;
    @Column(name = "Aanmaakdatum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date aanmaakdatum;
    @Column(name = "Wijzigingsdatum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date wijzigingsdatum;
    @Column(name = "AantalBeschikbarePlaatsen")
    private Integer aantalBeschikbarePlaatsen;
    @OneToMany(mappedBy = "stageStageId")
    private Collection<Begeleiderstageaanvraag> begeleiderstageaanvraagCollection;
    @OneToMany(mappedBy = "stageStageId")
    private Collection<Student> studentCollection;
    @OneToMany(mappedBy = "stageStageId")
    private Collection<Studentstagesollicitatie> studentstagesollicitatieCollection;
    @JoinColumn(name = "Begeleider_BegeleiderId", referencedColumnName = "BegeleiderId")
    @ManyToOne
    private Begeleider begeleiderBegeleiderId;
    @JoinColumn(name = "BedrijfId", referencedColumnName = "BedrijfsId")
    @ManyToOne(optional = false)
    private Bedrijf bedrijfId;
    @JoinColumn(name = "StagementorId", referencedColumnName = "BedrijfspersoonId")
    @ManyToOne
    private Bedrijfspersoon stagementorId;
    @JoinColumn(name = "ContractondertekenaarId", referencedColumnName = "BedrijfspersoonId")
    @ManyToOne
    private Bedrijfspersoon contractondertekenaarId;

    public Stage() {
    }

    public Stage(Integer stageId) {
        this.stageId = stageId;
    }

    public Stage(Integer stageId, String projectTitel, String projectOmschrijving, int aantalStudenten, String periode) {
        this.stageId = stageId;
        this.projectTitel = projectTitel;
        this.projectOmschrijving = projectOmschrijving;
        this.aantalStudenten = aantalStudenten;
        this.periode = periode;
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

    public String getProgrammeertaal() {
        return programmeertaal;
    }

    public void setProgrammeertaal(String programmeertaal) {
        this.programmeertaal = programmeertaal;
    }

    public String getAnalyse() {
        return analyse;
    }

    public void setAnalyse(String analyse) {
        this.analyse = analyse;
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

    public String getConfiguratiehardware() {
        return configuratiehardware;
    }

    public void setConfiguratiehardware(String configuratiehardware) {
        this.configuratiehardware = configuratiehardware;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public String getOpleidingsOnderwerp() {
        return opleidingsOnderwerp;
    }

    public void setOpleidingsOnderwerp(String opleidingsOnderwerp) {
        this.opleidingsOnderwerp = opleidingsOnderwerp;
    }

    public Date getOpleidingBegindatum() {
        return opleidingBegindatum;
    }

    public void setOpleidingBegindatum(Date opleidingBegindatum) {
        this.opleidingBegindatum = opleidingBegindatum;
    }

    public Date getOpleidingEinddatum() {
        return opleidingEinddatum;
    }

    public void setOpleidingEinddatum(Date opleidingEinddatum) {
        this.opleidingEinddatum = opleidingEinddatum;
    }

    public Date getStageBegindatum() {
        return stageBegindatum;
    }

    public void setStageBegindatum(Date stageBegindatum) {
        this.stageBegindatum = stageBegindatum;
    }

    public Date getStageEindatum() {
        return stageEindatum;
    }

    public void setStageEindatum(Date stageEindatum) {
        this.stageEindatum = stageEindatum;
    }

    public Integer getGoedkeurStatus() {
        return goedkeurStatus;
    }

    public void setGoedkeurStatus(Integer goedkeurStatus) {
        this.goedkeurStatus = goedkeurStatus;
    }

    public Boolean getStagecontractOpgesteld() {
        return stagecontractOpgesteld;
    }

    public void setStagecontractOpgesteld(Boolean stagecontractOpgesteld) {
        this.stagecontractOpgesteld = stagecontractOpgesteld;
    }

    public Boolean getGetekendeStagecontract() {
        return getekendeStagecontract;
    }

    public void setGetekendeStagecontract(Boolean getekendeStagecontract) {
        this.getekendeStagecontract = getekendeStagecontract;
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
    public Collection<Studentstagesollicitatie> getStudentstagesollicitatieCollection() {
        return studentstagesollicitatieCollection;
    }

    public void setStudentstagesollicitatieCollection(Collection<Studentstagesollicitatie> studentstagesollicitatieCollection) {
        this.studentstagesollicitatieCollection = studentstagesollicitatieCollection;
    }

    public Begeleider getBegeleiderBegeleiderId() {
        return begeleiderBegeleiderId;
    }

    public void setBegeleiderBegeleiderId(Begeleider begeleiderBegeleiderId) {
        this.begeleiderBegeleiderId = begeleiderBegeleiderId;
    }

    public Bedrijf getBedrijfId() {
        return bedrijfId;
    }

    public void setBedrijfId(Bedrijf bedrijfId) {
        this.bedrijfId = bedrijfId;
    }

    public Bedrijfspersoon getStagementorId() {
        return stagementorId;
    }

    public void setStagementorId(Bedrijfspersoon stagementorId) {
        this.stagementorId = stagementorId;
    }

    public Bedrijfspersoon getContractondertekenaarId() {
        return contractondertekenaarId;
    }

    public void setContractondertekenaarId(Bedrijfspersoon contractondertekenaarId) {
        this.contractondertekenaarId = contractondertekenaarId;
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
        return "admin.model.Stage[ stageId=" + stageId + " ]";
    }
    
}
