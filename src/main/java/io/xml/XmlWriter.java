package io.xml;
/*
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
*/
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;


public class XmlWriter {
    private XmlWriter() {}
    private static final Logger LOGGER=Logger.getLogger(XmlWriter.class.getName());
    private static final String xmlDirectoryPath="src/main/resources/xmlReqs";
    //private static final String xmlDirectoryPath="src/main/resources1/xmlReqs";
    private static final String xmlFileName="req";
    public static void writeToXML(AllData allData)  {
        LOGGER.log(Level.INFO,"Начат маршаллинг входных параметров");

        //создаем директорию в resources
        File directoryWithXML = new File(xmlDirectoryPath);
        if (directoryWithXML.exists() && directoryWithXML.isDirectory())
            LOGGER.log(Level.INFO, "Директория " + xmlDirectoryPath +" уже существует");
        else {
            directoryWithXML.mkdir();
            if(!directoryWithXML.exists() || !directoryWithXML.isDirectory()){
                LOGGER.log(Level.SEVERE, "Не удалось создать директорию " + xmlDirectoryPath +
                        ". Маршаллинг не будет выполнен");
                return;
            }
            else LOGGER.log(Level.INFO, "Директория " + xmlDirectoryPath +" создана");
        }

        try {
            //создание объекта Marshaller, который выполняет сериализацию
            JAXBContext context = JAXBContext.newInstance(AllData.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Наименование файла должно содержать дату, когда был собрал объект из п.1, либо её long-представление: OK
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-HH-mm-ss");
            File xmlFile = new File(xmlDirectoryPath+"/"+xmlFileName+
                    formatter.format(allData.getProcessedAt()) +".xml");
            // сама сериализация
            marshaller.marshal(allData, xmlFile);
            LOGGER.log(Level.INFO, "XML сформирован. Находится в директории "+xmlDirectoryPath);
        }
        catch (JAXBException e){
            LOGGER.log(Level.SEVERE, "Маршаллинг входных параметров не выполнен:\n"+e);
        }
    }

}