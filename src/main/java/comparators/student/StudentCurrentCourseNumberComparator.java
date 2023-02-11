package comparators.student;

import model.Student;
//про сортировку курса не было ничего сказано, поэтому по возрастанию
public class StudentCurrentCourseNumberComparator implements StudentComparator {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getCurrentCourseNumber(), s2.getCurrentCourseNumber());
    }
}
