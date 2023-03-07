package utilities;

import comparators.student.*;
import comparators.university.*;
import enums.StudentComparatorType;
import enums.UniversityComparatorType;


public class ComparatorUtil {

    private ComparatorUtil() {
    }
    public static StudentComparator getStudentComparatorType(StudentComparatorType type){
        switch (type){
            case FULL_NAME: return new StudentFullNameComparator();
            case UNIVERSITY_ID: return new StudentUniversityIdComparator();
            case AVG_EXAM_SCORE: return new StudentAvgExamScoreComparator();
            default: return new StudentCurrentCourseNumberComparator();//CURRENT_COURSE_NUMBER
        }
    }
    public static UniversityComparator getUniversityComparatorType(UniversityComparatorType type){
        switch (type){
            case UNIVERSITY_ID:return new UniversityIdComparator();
            case FULL_NAME: return new UniversityFullNameComparator();
            case SHORT_NAME:return new UniversityShortNameComparator();
            case MAIN_PROFILE:return new UniversityMainProfileComparator();
            default:return new UniversityYearOfFoundationComparator(); //case YEAR_OF_FOUNDATION:
        }
    }
}
