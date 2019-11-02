package co.com.bancolombia.certificacion.app.utilidades.datosexcel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Ingresa los datos obtenidos del archivo de Excel al archivo feature del cual se está llamando
 *
 * @author bgaona
 * @since 27/11/2017
 */
public class DataToFeature {

    protected static String data;
    protected static boolean foundHashTag = false;
    protected static boolean featureData = false;

    protected static String sheetName;
    protected static String excelFilePath;
    protected static String caso;


    private DataToFeature() {
    }

    private static List<String> setExcelDataToFeature(File featureFile) throws IOException {
        List<String> fileData = new ArrayList<>();
        try (BufferedReader buffReader = new BufferedReader(
                new InputStreamReader(new BufferedInputStream(new FileInputStream(featureFile)), "UTF-8"))) {
            foundHashTag = false;
            featureData = false;

            while ((data = buffReader.readLine()) != null) {
                sheetName = null;
                excelFilePath = null;

                if (data.trim().contains("##@externaldata")) {
                    foundHashTag = true;
                    fileData = getDataExcel(fileData);
                }
                if (foundHashTag) {
                    foundHashTag = false;
                    featureData = true;
                } else {
                    if ((data.startsWith("|") || data.endsWith("|")) && featureData) {
                        continue;
                    }
                    featureData = false;
                    fileData.add(data);
                }
            }
        }
        return fileData;
    }

    /**
     * Lista de todos los features con sus respectivos archivo de excel que se usarán en la prueba
     *
     * @param folder Carpeta donde estarán los archivo .feature
     * @return
     * @author bgaona
     * @since 27/11/2017
     */
    private static List<File> listOfFeatureFiles(File folder) {
        List<File> featureFiles = new ArrayList<>();
        if (folder.getName().endsWith(".feature")) {
            featureFiles.add(folder);
        } else {

            for (File fileEntry : folder.listFiles()) {
                if (fileEntry.isDirectory()) {
                    featureFiles.addAll(listOfFeatureFiles(fileEntry));
                } else {
                    if (fileEntry.isFile() && fileEntry.getName().endsWith(".feature")) {
                        featureFiles.add(fileEntry);
                    }
                }
            }
        }
        return featureFiles;
    }

    /**
     * Hace una lista con todos los features dependiendo de la ruta asignada
     *
     * @param featuresDirectoryPath Ruta donde se encuentran los features que tendrán las tablas
     * @throws IOException
     * @throws InvalidFormatException
     * @author bgaona
     * @since 27/11/2017
     */
    public static void overrideFeatureFiles(String featuresDirectoryPath) throws IOException {
        List<File> listOfFeatureFiles = listOfFeatureFiles(new File(featuresDirectoryPath));
        for (File featureFile : listOfFeatureFiles) {
            List<String> featureWithExcelData = setExcelDataToFeature(featureFile);
            try (BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(featureFile), "UTF-8"));) {
                for (String string : featureWithExcelData) {
                    writer.write(string);
                    writer.write("\n");
                }
            }
        }
    }

    private static List<String> getDataExcel(List<String> fileData) {
        List<Map<String, String>> excelData = null;
        String[] dataVector = null;
        dataVector = data.trim().split("@");
        excelFilePath = dataVector[2];
        sheetName = dataVector[3];
        caso = dataVector[4];
        fileData.add(data);
        excelData = new LectorExcel().getData( excelFilePath, sheetName);
        for (int rowNumber = Integer.parseInt(caso)-1; rowNumber < Integer.parseInt(caso); rowNumber++) {
            StringBuilder cellData = new StringBuilder();
            cellData.append("      ");
            for (Entry<String, String> mapData : excelData.get(rowNumber).entrySet()) {
                cellData.append("|" + mapData.getValue());
            }
            cellData.append("|");
            fileData.add(cellData.toString());
        }
        return fileData;
    }
}
