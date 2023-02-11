package comparators.student;

import model.Student;
import org.apache.commons.lang3.StringUtils;
//сортируем по алфавиту
public class StudentFullNameComparator implements StudentComparator {
    @Override
    public int compare(Student s1, Student s2) {

        return StringUtils.compare(s1.getFullName(), s2.getFullName());
    }
}