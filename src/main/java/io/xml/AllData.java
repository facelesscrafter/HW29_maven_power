package io.xml;

import model.Statistics;
import model.Student;
import model.University;
import utilities.StatUtil;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;
@XmlRootElement(name="root")
@XmlAccessorType(XmlAccessType.FIELD)

public class AllData {
    @XmlElement(name = "studentEntry")
    @XmlElementWrapper(name = "studentsInfo")
    private List<Student> students;
    @XmlElement(name = "universityEntry")
    @XmlElementWrapper(name = "universitiesInfo")
    private List<University>universities;
    @XmlElement(name = "statisticsEntry")
    @XmlElementWrapper(name = "statisticalInfo")
    private List<Statistics>statistics;
    @XmlElement(name = "processedAt")
//    @XmlTransient
    private Date processedAt;
    public AllData() {
    }
    public AllData(List<Student> students, List<University> universities) {
        this.students = students;
        this.universities = universities;
        this.statistics = StatUtil.getStatistics(students,universities);
        this.processedAt=new Date();

    }
    public AllData(List<Student> students, List<University> universities, List<Statistics> statistics) {
        this.students = students;
        this.universities = universities;
        this.statistics = statistics;
        this.processedAt=new Date();
    }

    public AllData(List<Student> students, List<University> universities, List<Statistics> statistics, Date processedAt) {
        this.students = students;
        this.universities = universities;
        this.statistics = statistics;
        this.processedAt = processedAt;
    }


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<University> getUniversities() {
        return universities;
    }

    public void setUniversities(List<University> universities) {
        this.universities = universities;
    }

    public List<Statistics> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<Statistics> statistics) {
        this.statistics = statistics;
    }

    public Date getProcessedAt() {
        return processedAt;
    }
    public void setProcessedAt(Date processedAt) {
        this.processedAt = processedAt;
    }
}
