package model;

import com.google.gson.annotations.SerializedName;
import enums.StudyProfile;

import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlRootElement
public class University {
    @SerializedName("id")
    @XmlElement(name = "universityId")
    private String id;
    @SerializedName("fullName")
    @XmlElement(name = "universityName")
    private String fullName;
    @SerializedName("shortName")
    @XmlTransient
    private String shortName;
    @SerializedName("yearOfFoundation")
    @XmlTransient
    private int yearOfFoundation;
    @SerializedName("mainProfile")
    @XmlElement(name = "universityProfile")
    private StudyProfile mainProfile;
    public University(){}
    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }
    @Override
    public String toString(){
        if(this.mainProfile != null) return "#############" +
                "\nID университета: " + this.id +
                "\nПолное наименование университета: "+ this.fullName +
                "\nАббревиатура: " + this.shortName +
                "\nГод основания: " + this.yearOfFoundation +
                "\nОсновное направление: " + this.mainProfile.getProfileName();
        else return "#############" +
                "\nID университета: " + this.id +
                "\nПолное наименование университета: "+ this.fullName +
                "\nАббревиатура: " + this.shortName +
                "\nГод основания: " + this.yearOfFoundation +
                "\nОсновное направление: Не определено";
    }
}
