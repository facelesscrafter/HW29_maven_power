package comparators.university;

import model.University;
import org.apache.commons.lang3.StringUtils;
//будем запихивать NULL специализацию университета в конец списка, т.к. в ТЗ не указано обратное
public class UniversityMainProfileComparator  implements UniversityComparator {
    @Override
    public int compare(University u1, University u2) {
        if(null!= u1.getMainProfile()  && null != u2.getMainProfile()) {
            return StringUtils.compare(u1.getMainProfile().getProfileName(), u2.getMainProfile().getProfileName());
        }
        else
            if(u1.getMainProfile() == null && u2.getMainProfile() == null)return 0;
            else
                if(u1.getMainProfile() == null)return 1;
                else return -1;
    }
}
