package io.json;

import io.xml.AllData;
import utilities.JsonUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
В этом классе должен быть метод, принимающий на вход созданную в п.1 классовую структуру.
Затем этот метод выполняет сериализацию входных данных в JSON-строки и записывает в файлы .json.
Рекомендуется с помощью Java-кода создать директорию и в неё складывать генерируемые файлы.
Например, jsonReqs/req.json.
Наименование файла должно содержать дату, когда был собран объект из п.1, либо её long-представление.
При сериализации использовать ранее созданный утилитный класс JsonUtil.
 */
public class JsonWriter {
    private JsonWriter(){}
    private static final Logger LOGGER=Logger.getLogger(JsonWriter.class.getName());
    private static final String jsonDirectoryPath="src/main/resources/jsonReqs";
    public static void writeAllToJSON(AllData allData)  {
        LOGGER.log(Level.INFO,"Начата запись данных, преорбразованных в json-формат");

        //создаем директорию в resources
        File directoryWithJSON = new File(jsonDirectoryPath);
        if (directoryWithJSON.exists() && directoryWithJSON.isDirectory())
            LOGGER.log(Level.INFO, "Директория " + jsonDirectoryPath +" уже существует");
        else {
            directoryWithJSON.mkdir();
            if(!directoryWithJSON.exists() || !directoryWithJSON.isDirectory()){
                LOGGER.log(Level.SEVERE, "Не удалось создать директорию " + jsonDirectoryPath +
                        ". Запись данных в формате json не будет выполнен");
                return;
            }
            else LOGGER.log(Level.INFO, "Директория " + jsonDirectoryPath +" создана");
        }
        //пишем студентов:
        writeList(allData.getStudents(),"students",allData.getProcessedAt());
        //университеты
        writeList(allData.getUniversities(),"universities",allData.getProcessedAt());
        //статистика
        writeList(allData.getStatistics(),"statistics",allData.getProcessedAt());
    }
    public static void writeList(List<?>list,String jsonFileName,Date date){
        String listJson= JsonUtil.listToJson(list);
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-HH-mm-ss");
            FileOutputStream outputStream = new FileOutputStream(jsonDirectoryPath+"/"+jsonFileName+
                    formatter.format(date) +".json");
            outputStream.write(listJson.getBytes(StandardCharsets.UTF_8));
            LOGGER.log(Level.INFO, jsonFileName+": Данные успешно записаны," +
                    " находится в директории "+jsonDirectoryPath);
        }
        catch (IOException e){
            LOGGER.log(Level.SEVERE, jsonFileName+": Ошибка записи файла. Данные не были записаны");
        }
    }

}
