package homework29;

import comparators.student.StudentComparator;
import comparators.university.UniversityComparator;
import enums.StudentComparatorType;
import enums.UniversityComparatorType;
import io.excel.XlsReader;
import io.excel.XlsWriter;
import io.json.JsonWriter;
import io.xml.AllData;
import io.xml.XmlWriter;
import model.*;
import utilities.ComparatorUtil;
import utilities.StatUtil;

import java.io.FileInputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.nio.charset.Charset;


public class Main {
    private static final Logger LOGGER=Logger.getLogger(Main.class.getName());
    private static final String xlsForRead="src/main/resources/universityInfo.xlsx";
    private static final String xlsForWrite="src/main/resources/Stat.xlsx";
    private static final String logProperties="src/main/resources/logging.properties";
    //      private static final String xlsForRead="src/main/resources/universityInfo_old.xlsx"; //оригинальный файл
    public static void main(String[] args)  {

        try(FileInputStream ins = new FileInputStream(logProperties)){
            LogManager.getLogManager().readConfiguration(ins);
        }catch (Exception ignore){
            LOGGER.log(Level.SEVERE,"Не удалось загрузить файл конфигурации логгера, вывод только в консоль.");
        }
        LOGGER.log(Level.INFO, "Старт работы приложения");

        //читаем данные
        List<University> universities=XlsReader.readUniversities(xlsForRead);
        List<Student> students=XlsReader.readStudents(xlsForRead);
        //если не смогли прочитать файлы или прочитали, но данных в exel не было,
        //то дальнейшая работа приложения не имеет смысла
        if(universities.size()==0&&students.size()==0){
            LOGGER.log(Level.INFO, "Нечего обрабатывать, программа завершена");
            System.exit(0);
        }
        //компараторы
        UniversityComparator compareUniversitiesByID = ComparatorUtil.getUniversityComparatorType(
                UniversityComparatorType.UNIVERSITY_ID);
        universities.sort(compareUniversitiesByID);

        StudentComparator compareStudentsByFullName = ComparatorUtil.getStudentComparatorType(
                StudentComparatorType.FULL_NAME);
        students.sort(compareStudentsByFullName);

        List<Statistics> stat= StatUtil.getStatistics(students,universities);
        //пишем статистику
        XlsWriter.writeStatistics(stat,xlsForWrite);
        //пишем XML
        AllData allData=new AllData(students,universities,stat);
        XmlWriter.writeToXML(allData);
        //пишем JSON
        JsonWriter.writeAllToJSON(allData);
        LOGGER.log(Level.INFO, "Программа завершена");



       /* String s=JsonUtil.objectToJson(students.get(0));
        LOGGER.log(Level.INFO, s);
        Student w= (Student) JsonUtil.jsonToObject(s,Student.class);
        LOGGER.log(Level.INFO, w.toString());
        String studentsJson=JsonUtil.listToJson(students);
        LOGGER.log(Level.INFO, studentsJson);
        List<Student> studentsFromJson = (List<Student>) JsonUtil.jsonToList(
                studentsJson,new TypeToken<List<Student>>(){}.getType());
        // проверяем, что обратно коллекция воссоздаётся в таком же количестве элементов
        LOGGER.log(Level.INFO, String.valueOf(studentsFromJson.size()==students.size()));
*/
    }

}
