package co.com.bancolombia.certificacion.app.utilidades.xml;

import co.com.bancolombia.backend.utilidades.managers.ExcelManager;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;


public class UtilidadXml {
	
	ExcelManager excelManager;
	private static final Logger LOGGER = LogManager.getLogger(UtilidadXml.class.getName());
	
	/**
	 * <pre>
	 * DESCRIPCION: Metodo para extraer el Request de la plantilla de transacciones xml, para luego
	 * sera utilizado para enviarse a una peticion REST.
	 * 
	 * PRECONDICION: Tener el archivo de la plantilla de transacciones xml en la ruta parametrizada que se valla
	 * a utilizar, para poder ser leido y extrar el XMl a buscar. 
	 * 
	 * PARAMETROS DE ENTRADA:
	 * @param canal
	 * @param codigoTransaccion
	 * </pre>
	 * <pre>
	 * PARAMETROS DE SALIDA:
	 * @return: strRequest
	 * El retorna un String la cual es el Request de la transaccion.
	 * </pre>
	 */
	public String buscarXml(String canal, String codigoTransaccion) {
		String strRequest = "";
		this.excelManager =new ExcelManager();
		this.excelManager.strRutaArchivo("src/test/resources/templatesxml/Xml_Transacciones_Canales.xlsx");
		
		String strQuery = "SELECT * FROM CodTrn where Codigo ='replaceCodigo' and Canal = 'replaceCanal'";
		strQuery = strQuery.replace("replaceCodigo", codigoTransaccion);
		strQuery = strQuery.replace("replaceCanal", canal);
		this.excelManager.escribirExcel(strQuery);
		
		Recordset objRecord = this.excelManager.leerExcel(strQuery);

		try {
			while (true) {
				objRecord.moveNext();
				String strCodtrn = objRecord.getField("Codigo").trim();
				String strCanal = objRecord.getField("Canal").trim();
				if (strCanal.equals(canal) && strCodtrn.equals(codigoTransaccion)) {
					strRequest = objRecord.getField("Request").trim();
					break;
				}
			}
		} catch (FilloException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return strRequest;

	}
	
	/**
	 * DESCRIPCION: Metodo para recibir el Request del xml, para luego
	 * enviar la peticion REST y devuelve el response del xml.
	 * 
	 * PRECONDICION: Enviarle la Url del backend a donde este apuntando la prueba. 
	 * 
	 * PARAMETROS DE ENTRADA:
	 * @param urlXml
	 * @param request
	 * 
	 * PARAMETROS DE SALIDA:
	 * @return strResponse
	 * El retorna un String la cual es el Response de la transaccion.
	 */
	public static String enviarXml(String urlXml, String request) {
		String strResponse = "";
		try {
			System.setProperty ("https.protocols", "TLSv1, TLSv1.1, TLSv1.2");
			RestAssured.baseURI = urlXml;
			RestAssured.useRelaxedHTTPSValidation();
			RequestSpecification httpRequest = RestAssured.given()
					.contentType("application/x-www-form-urlencoded;charset=UTF-8")
					.body("msg=" + request);
			Response response = httpRequest.request(Method.POST);
			strResponse = response.getBody().asString();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return strResponse;
	}
	
	/**
	 * DESCRIPCION: Metodo para leer el Response del xml, para verificar
	 * los TAG enviados y devuelve un true si es correcto la verificacion.
	 * 
	 * PRECONDICION: Enviarle el response y la ruta relativa(xpath) a verificar. 
	 * 
	 * PARAMETROS DE ENTRADA:
	 * @param strResponse
	 * @param strRutaRelativa
	 * 
	 * PARAMETROS DE SALIDA:
	 * @return strResult
	 * El retorna un Boolean de la verificacion.
	 */
	public String leerXml(String strResponse, String strRutaRelativa){
		String strResult="";
		if (strResponse.contains("<TCFX>")) {
			DocumentBuilder documentBuilder = null;
			try {
				documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
				InputSource inputSource = new InputSource();
				inputSource.setCharacterStream(new StringReader(strResponse));
				Document xmlDocument = null;
				xmlDocument = documentBuilder.parse(inputSource);
				xmlDocument.getDocumentElement().normalize();
				XPath xPath = XPathFactory.newInstance().newXPath();
				strResult = xPath.compile(strRutaRelativa).evaluate(xmlDocument);
			} catch (Exception e) {
				LOGGER.error(e.getMessage(), e);
			}
		}else {LOGGER.info("No se recibi� respuesta de la Transacci�n");}
		return strResult;
		
	}
	
}
