package utilities;

import enums.StudyProfile;
import model.Statistics;
import model.Student;
import model.University;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class StatUtil {
    private StatUtil(){}
    public static List<Statistics> getStatistics(List<Student> students, List<University> universities){
        List<Statistics>statList=new ArrayList<>();
        //создаем список уникальных значений профилей обучения, которые были в Excel
        List<StudyProfile>studyProfiles=universities.stream().map(u->u.getMainProfile()).distinct()
                .collect(Collectors.toList());
        //и проходимся по каждому из них
        studyProfiles.forEach(profile->{
            //ищем университеты с данным профилем, а ещё нам понадобятся id шники, чтобы потом отыскать студентов
            //убиваем двух зайцев - подсчитываем кол-во универов по данному профилю, и грепаем ID
            //универов для нового поиска
            List<String>universitiesIdWithThisStudyProfile=universities.stream().
                    filter(u -> u.getMainProfile().equals(profile)).map(u -> u.getId()).collect(Collectors.toList());
            //забираем имена
            String[] fullNamesArray = universities.stream().filter(u -> u.getMainProfile().equals(profile)).
                    map(u -> u.getFullName()).toArray(String[]::new);
            //ищем студентов для каждого ID, а вернее их оценки
            List<Double> studentsExamScoreForThisStudyProfile=students.stream().
                    filter(s -> universitiesIdWithThisStudyProfile.contains(s.getUniversityId()) ).
                    map(s-> Double.valueOf(s.getAvgExamScore())).collect(Collectors.toList());
            double finalAvgScore=0;
            //можно и без OptionDouble обойтись
            if(studentsExamScoreForThisStudyProfile.size()!=0) {
                finalAvgScore = studentsExamScoreForThisStudyProfile.stream().mapToDouble(avg -> avg).sum();
                finalAvgScore = finalAvgScore/studentsExamScoreForThisStudyProfile.size();
            }
            Statistics statForThisProfile=new Statistics(
                    profile,
                    //округление математическое - если отбрасываемая цифра равна 5, то число увеличиваем на 1
                    //короче HALF_UP
                    BigDecimal.valueOf(finalAvgScore).setScale(2, RoundingMode.HALF_UP).floatValue(),
                    studentsExamScoreForThisStudyProfile.size(),
                    universitiesIdWithThisStudyProfile.size(),
                    Arrays.toString(fullNamesArray));
            statList.add(statForThisProfile);

        });
        return statList;
    }
}
