package cromosomas;
import java.io.BufferedReader;
import java.io.FileReader;

public class Archivos {

	public static Integer[] cargarConfiguraciones(String archivo) {
		BufferedReader br = null;
		FileReader fr = null;
		String linea = null, datos[] = null;
		Integer configuraciones[] = new Integer[3];
		try {
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			if ((linea = br.readLine()) != null)
				datos = linea.split(";");
			configuraciones[0] = new Integer(datos[0]);
			configuraciones[1] = new Integer(datos[1]);
			configuraciones[2] = new Integer(datos[2]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (br != null)
				br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return configuraciones;
	}

}