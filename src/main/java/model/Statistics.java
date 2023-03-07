package model;

import com.google.gson.annotations.SerializedName;
import enums.StudyProfile;

import javax.xml.bind.annotation.*;

@XmlType(name = "statisticsEntry")
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlRootElement
public class Statistics {
    @SerializedName("mainProfile")
    @XmlElement(name = "universityProfile")
    private StudyProfile mainProfile;
    @SerializedName("avgExamScore")
    @XmlElement(name = "avgScore")
    private float avgExamScore;
    @SerializedName("studentsCount")
    @XmlTransient
    private int studentsCount;
    @SerializedName("universitiesCount")
    @XmlTransient
    private int universitiesCount;
    @SerializedName("universitiesNames")
    @XmlTransient
    private String universitiesNames;

    public Statistics(StudyProfile mainProfile, float avgExamScore, int studentsCount, int universitiesCount, String universitiesNames) {
        this.mainProfile = mainProfile;
        this.avgExamScore = avgExamScore;
        this.studentsCount = studentsCount;
        this.universitiesCount = universitiesCount;
        this.universitiesNames = universitiesNames;
    }
    public Statistics(){}

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public int getUniversitiesCount() {
        return universitiesCount;
    }

    public String getUniversitiesNames() {
        return universitiesNames;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public void setStudentsCount(int studentsCount) {
        this.studentsCount = studentsCount;
    }

    public void setUniversitiesCount(int universitiesCount) {
        this.universitiesCount = universitiesCount;
    }

    public void setUniversitiesNames(String universitiesNames) {
        this.universitiesNames = universitiesNames;
    }
}
