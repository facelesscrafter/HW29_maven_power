package ioExcel;

import model.Statistics;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XlsWriter {
    private XlsWriter() {
    }
    public static void writeStatistics(List<Statistics> statList, String filePath) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Статистика");
        Font font= workbook.createFont();
        //Заголовки должны иметь настроенный стиль — как минимум, сделать всё жирным шрифтом и
        // с указанным размером шрифта
        font.setBold(true);
        font.setFontHeightInPoints((short)11);
        font.setColor(Font.COLOR_RED);
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(font);

        int currentRowNumber = 0;
        Row currentRow = sheet.createRow(currentRowNumber++);

        Cell mainProfileCell = currentRow.createCell(0);
        mainProfileCell.setCellValue("Профиль обучения");
        mainProfileCell.setCellStyle(headerStyle);

        Cell avgExamScoreCell = currentRow.createCell(1);
        avgExamScoreCell.setCellValue("Средний балл за экзамен");
        avgExamScoreCell.setCellStyle(headerStyle);

        Cell studentsCountCell = currentRow.createCell(2);
        studentsCountCell.setCellValue("Количество студентов по профилю");
        studentsCountCell.setCellStyle(headerStyle);

        Cell universitiesCountCell = currentRow.createCell(3);
        universitiesCountCell.setCellValue("Количество университетов по профилю");
        universitiesCountCell.setCellStyle(headerStyle);

        Cell universitiesNamesCell = currentRow.createCell(4);
        universitiesNamesCell.setCellValue("Названия университетов");
        universitiesNamesCell.setCellStyle(headerStyle);
        //заполнение
        for (Statistics stat:statList){
            currentRow=sheet.createRow(currentRowNumber++);
            mainProfileCell=currentRow.createCell(0);
            mainProfileCell.setCellValue(stat.getMainProfile().getProfileName());
            avgExamScoreCell=currentRow.createCell(1);
            avgExamScoreCell.setCellValue(stat.getAvgExamScore());
            studentsCountCell=currentRow.createCell(2);
            studentsCountCell.setCellValue(stat.getStudentsCount());
            universitiesCountCell=currentRow.createCell(3);
            universitiesCountCell.setCellValue(stat.getUniversitiesCount());
            universitiesNamesCell=currentRow.createCell(4);
            universitiesNamesCell.setCellValue(stat.getUniversitiesNames());
        }
        //пишем файл
        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
        }
    }
}
