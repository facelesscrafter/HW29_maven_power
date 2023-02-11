package ioExcel;

import enums.StudyProfile;
import model.Student;
import model.University;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReaderExcel {
    private ReaderExcel() {
    }
    public static List<University> readUniversities(String filePath) throws IOException {
        List<University> universities = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("Университеты");



        Iterator<Row> rows = sheet.iterator();
        rows.next();
        while (rows.hasNext()) {
            Row currentRow = rows.next();
            String id="NONE_ID";
            String fullName="Неизвестный университет";
            String shortName="НУ";
            int yearOfFoundation=0;
            StudyProfile mainProfile=StudyProfile.NONEVALUE; //если ячейка в таблице пуста
            //проверка на пустые яйчейки
            if(currentRow.getCell(0)!=null)id=currentRow.getCell(0).getStringCellValue();
            if(currentRow.getCell(1)!=null)fullName=currentRow.getCell(1).getStringCellValue();
            if(currentRow.getCell(2)!=null)shortName = currentRow.getCell(2).getStringCellValue();
            if(currentRow.getCell(3)!=null)yearOfFoundation=(int)currentRow.getCell(3).getNumericCellValue();
            if(currentRow.getCell(4)!=null)
                try{
                    mainProfile = StudyProfile.valueOf(StudyProfile.class, currentRow.getCell(4).getStringCellValue());
                }
                catch (IllegalArgumentException e){
                    //такого значения нет в нашем enum, чтобы не оставлять пустым:
                    mainProfile = StudyProfile.UNKNOWN;

                }

            University university = new University(id,fullName,shortName,yearOfFoundation,mainProfile);
            universities.add(university);
        }
        return universities;
    }
    public static List<Student> readStudents(String filePath) throws IOException {
        List<Student> students = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("Студенты");



        Iterator<Row> rows = sheet.iterator();
        rows.next();
        while (rows.hasNext()) {
            Row currentRow = rows.next();
            String fullName="Неизвестный студент";
            String universityId="NONE_ID";
            int currentCourseNumber=0;
            float avgExamScore=0;

            if(currentRow.getCell(1)!=null)fullName=currentRow.getCell(1).getStringCellValue();
            if(currentRow.getCell(0)!=null)universityId=currentRow.getCell(0).getStringCellValue();
            if(currentRow.getCell(2)!=null)currentCourseNumber=(int)currentRow.getCell(2).getNumericCellValue();
            if(currentRow.getCell(3)!=null)avgExamScore=(float) currentRow.getCell(3).getNumericCellValue();
            Student student = new Student(fullName,universityId,currentCourseNumber,avgExamScore);
            students.add(student);
        }
        return students;
    }
}
