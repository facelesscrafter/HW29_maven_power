package homework27;

import ioExcel.*;
import model.*;
import utilities.JsonUtil;
import utilities.StatUtil;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        final String filePath="src/main/resources/universityInfo.xlsx";
  //      final String filePath="src/main/resources/universityInfo_old.xlsx"; //оригинальный файл
        List<University> universities=ReaderExcel.readUniversities(filePath);
        List<Student> students=ReaderExcel.readStudents(filePath);
/*
        StudentComparator studentComparatorFullName= ComparatorU.getStudentComparatorType(StudentComparatorType.FULL_NAME);
        UniversityComparator universityComparatorID = ComparatorU.getUniversityComparatorType(UniversityComparatorType.UNIVERSITY_ID);
*/
        //ДЗ Практическая неделя
        //4. В методе main выполнить сериализацию коллекций, вывести получившиеся JSON-строки в консоль.
        String studentsJson = JsonUtil.studentsToJson(students);
        String univerJson = JsonUtil.universitiesToJson(universities);
        System.out.println(studentsJson);
        System.out.println("\n######################################\n");
        System.out.println(univerJson);
        //5. В методе main выполнить десериализацию полученных строк, сохранить результаты в новые коллекции.
        List<University> universitiesFromJson=JsonUtil.jsonToUniversities(univerJson);
        List<Student> studentsFromJson=JsonUtil.jsonToStudens(studentsJson);
        //6. Сравнить количество элементов в исходной и в десериализованной коллекциях, чтобы убедиться, что десериализация выполняется корректно.
        System.out.format("Количество элементов в исходной students %d" +
                "\nКоличество элементов в десериализованной students %d"+
                "\nКоличество элементов в исходной universities %d"+
                "\nКоличество элементов в десериализованной universities %d\n",
                students.size(),
                studentsFromJson.size(),
                universities.size(),
                universitiesFromJson.size()
                );

        System.out.println("\n##############\nСериализация отдельных элементов\n##############\n");
        //7. С помощью Java Stream API выполнить для исходных коллекций сериализацию отдельных элементов.
        //8.Там же внутри стрима выводить получающиеся JSON-строки.
        //9.Там же внутри стрима десериализовывать объекты из полученных JSON-строк.
        //10.Там же внутри стрима выводить десериализованные объекты на печать, чтобы убедиться в корректности операции.
        students.stream().forEach(student -> {
            String s=JsonUtil.studentToJson(student);
            System.out.println("JSON: "+s);
            System.out.println("deserialized: "+JsonUtil.jsonToStudent(s));
        });

        universities.stream().forEach(university -> {
            String u=JsonUtil.universityToJson(university);
            System.out.println("JSON: "+u);
            System.out.println("deserialized: "+JsonUtil.jsonToUniversity(u));
        });

        List<Statistics> stat= StatUtil.getStatistics(students,universities);
        XlsWriter.writeStatistics(stat,"src/main/resources/Stat.xlsx");
        System.out.println("\n\n##################\nСтатистика успешно записана");


    }

}
