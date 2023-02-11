package comparators.university;

import model.University;
import org.apache.commons.lang3.StringUtils;
//сортируем по умолчанию
public class UniversityIdComparator implements UniversityComparator {
    @Override
    public int compare(University u1, University u2) {
        return StringUtils.compare(u1.getId(), u2.getId());
    }
}