package attendeelist.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SystemUtils {

	public static Properties readSystemProperties() throws IOException {
		InputStream inputStream = ClassLoader.getSystemResourceAsStream("config.properties");
		Properties props = new Properties();
		props.load(inputStream);
		return props;
	}

	public static BufferedReader readCsvFile(String fileName) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(fileName + ".csv"));
		return br;
	}

	public static void writeResultFile(File file, String result) {

		try (FileWriter fw = new FileWriter(file)) {
			fw.write(result);
			fw.flush();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
