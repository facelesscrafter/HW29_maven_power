package io.excel;

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
import java.util.logging.Level;
import java.util.logging.Logger;

public class XlsWriter {
    private XlsWriter() {
    }
    private static final Logger LOGGER=Logger.getLogger(XlsWriter.class.getName());
    public static void writeStatistics(List<Statistics> statList, String filePath)  {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Статистика");
        Font font= workbook.createFont();
        //Заголовки должны иметь настроенный стиль — как минимум, сделать всё жирным шрифтом и
        // с указанным размером шрифта
        font.setBold(true);
        font.setFontHeightInPoints((short)11);
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(font);

        int currentRowNumber = 0;
        Row currentRow = sheet.createRow(currentRowNumber++);
        Cell currentCell = currentRow.createCell(0);;
        //заголовок
        currentCell.setCellValue("Профиль обучения");
        currentCell.setCellStyle(headerStyle);

        currentCell = currentRow.createCell(1);
        currentCell.setCellValue("Средний балл за экзамен");
        currentCell.setCellStyle(headerStyle);

        currentCell = currentRow.createCell(2);
        currentCell.setCellValue("Количество студентов по профилю");
        currentCell.setCellStyle(headerStyle);

        currentCell = currentRow.createCell(3);
        currentCell.setCellValue("Количество университетов по профилю");
        currentCell.setCellStyle(headerStyle);

        currentCell = currentRow.createCell(4);
        currentCell.setCellValue("Названия университетов");
        currentCell.setCellStyle(headerStyle);
        //заполнение
        for (Statistics stat:statList){
            //mainProfile
            currentRow=sheet.createRow(currentRowNumber++);
            currentCell=currentRow.createCell(0);
            currentCell.setCellValue(stat.getMainProfile().getProfileName());
            //avgExamScore
            currentCell=currentRow.createCell(1);
            currentCell.setCellValue(stat.getAvgExamScore());
            //studentsCount
            currentCell=currentRow.createCell(2);
            currentCell.setCellValue(stat.getStudentsCount());
            //universitiesCount
            currentCell=currentRow.createCell(3);
            currentCell.setCellValue(stat.getUniversitiesCount());
            //universitiesNamesCell
            currentCell=currentRow.createCell(4);
            currentCell.setCellValue(stat.getUniversitiesNames());
        }
        //автоматическое выравнивание по ширине
        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(2);
        sheet.autoSizeColumn(3);
        sheet.autoSizeColumn(4);
        LOGGER.log(Level.INFO, "Сохранение статистики");
        //пишем файл, а точнее пытаемся
        try {
            FileOutputStream outputStream = new FileOutputStream(filePath);
            workbook.write(outputStream);
            LOGGER.log(Level.INFO, "Статистика успешно записана");
        }
        catch (IOException e){
            LOGGER.log(Level.SEVERE, "Ошибка записи файла. Статистика не сохранена");
        }

    }
}
