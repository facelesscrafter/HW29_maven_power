package model;

import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
//@XmlRootElement
public class Student {
    @SerializedName("fullName")
    @XmlElement(name = "studentName")
    private String fullName;
    @SerializedName("universityId")
    @XmlElement(name = "universityId")

   private String universityId;
    @SerializedName("currentCourseNumber")
    @XmlTransient
    private int currentCourseNumber;
    @SerializedName("avgExamScore")
    @XmlElement(name = "avgScore")
    private float avgExamScore;
    public Student(){}
    public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public void setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }
    @Override
    public String toString(){
        return "#############" +
                "\nИмя студента: " + this.fullName +
                "\nИдентификатор университета: "+ this.universityId +
                "\nНомер курса: " + this.currentCourseNumber +
                "\nСредний балл: " + this.avgExamScore;
    }
}
