package co.com.bancolombia.certificacion.app.utilidades.administradores;

import co.com.bancolombia.backend.excepciones.BackEndExceptions;
import co.com.bancolombia.backend.utilidades.constant.ConstantManager;
import co.com.bancolombia.backend.utilidades.enums.CodigosExcepciones;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

/**
 * Clase para manejar un archivo de excel por medio de sentencias SQL como
 * SELECT, INSERT, UPDATE.
 *
 * @author david.c.gonzalez
 */
public class ExcelManager {

    /**
     * The str ruta archivo.
     */
    private String strRutaArchivo;

    /**
     * The obj connection.
     */
    private Connection objConnection;

    /**
     * The obj fillo.
     */
    private Fillo objFillo;

    /**
     * Instantiates a new excel manager.
     */
    public ExcelManager() {
        strRutaArchivo = ConstantManager.VACIO;
    }

    /**
     * Metodo para cambiar la ruta del archivo de excel con el que se quiere
     * interactuar.
     *
     * @param strRutaArchivo the str ruta archivo
     */
    public void strRutaArchivo(String strRutaArchivo) {
        this.strRutaArchivo = strRutaArchivo;
    }

    /**
     * Metodo que busca registros en una hoja de excel. De acuerdo a una sentencia
     * SELECT.
     *
     * @param strQuery Define la sentencia select que se quiere lanzar.
     * @return the recordset
     */
    public Recordset leerExcel(String strQuery) {
        Recordset objRecordset = null;
        try {
            Fillo excelMgr = new Fillo();
            objConnection = excelMgr.getConnection(strRutaArchivo);
            objRecordset = objConnection.executeQuery(strQuery);
        } catch (FilloException e) {
            throw new BackEndExceptions(CodigosExcepciones.FALLO_CONSULTA.getMsg(), e);
        } finally {
            objConnection.close();
        }
        return objRecordset;
    }

    /**
     * Metodo que escribe nuevos registros en una hoja de excel. De acuerdo a una
     * sentencia INSERT.
     *
     * @param strQuery Define la sentencia insert que se quiere lanzar.
     * @return true, if successful
     */
    public boolean escribirExcel(String strQuery) {
        objFillo = new Fillo();
        boolean result = false;
        try {
            objConnection = objFillo.getConnection(strRutaArchivo);
            objConnection.executeUpdate(strQuery);
            result = true;
        } catch (FilloException e) {
            throw new BackEndExceptions(CodigosExcepciones.FALLO_CONSULTA.getMsg(), e);
        } finally {
            objConnection.close();
        }
        return result;
    }

    /**
     * Metodo que modifica los registros en una hoja de excel. De acuerdo a una
     * sentencia UPDATE.
     *
     * @param strQuery the str query
     */
    public void modificarRegistrosExcel(String strQuery) {
        objFillo = new Fillo();
        try {
            objConnection = objFillo.getConnection(strRutaArchivo);
            objConnection.executeUpdate(strQuery);
        } catch (FilloException e) {
            throw new BackEndExceptions(CodigosExcepciones.FALLO_CONSULTA.getMsg(), e);
        } finally {
            objConnection.close();
            objConnection = null;
        }

    }

    /**
     * Metodo que crea la copia de algun archivo.
     *
     * @param strRutaOrigen    the str ruta origen
     * @param strRutaDestino   the str ruta destino
     * @param strNombreArchivo the str nombre archivo
     * @return String Devuelve la ruta completa del archivo.
     */
    public String crearCopiaExcel(String strRutaOrigen, String strRutaDestino, String strNombreArchivo) {
        FileSystem objSistema = FileSystems.getDefault();
        Path pathArchivo = objSistema.getPath(strRutaOrigen);
        String strRutaArchivoCopia = strRutaDestino + strNombreArchivo;
        Path objRutaArchivoCopia = objSistema.getPath(strRutaArchivoCopia);
        try {
            File file = new File(strRutaArchivoCopia);
            Path path = file.toPath();
            if (file.exists()) {
                Files.delete(path);
            }
            Files.copy(pathArchivo, objRutaArchivoCopia, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            throw new BackEndExceptions(ex);
        }
        return strRutaArchivoCopia;

    }

}

