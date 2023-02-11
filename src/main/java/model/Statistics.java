package model;

import enums.StudyProfile;

public class Statistics {
    private StudyProfile mainProfile;
    private float avgExamScore;
    private int studentsCount;
    private int universitiesCount;
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
