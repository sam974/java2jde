package devstudio.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config extends Properties {

	private static final long serialVersionUID = 1L;

	public final static Config INSTANCE;

	static {
		INSTANCE = new Config();
		try (FileInputStream in = new FileInputStream(new File("resources/config.properties"))) {
			INSTANCE.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getProject(String id) {
		String out = getProperty("project." + id, "");
		assert out != null;
		return out;
	}

	public String getTask(String id) {
		String out = getProperty("task." + id, "");
		assert out != null;
		return out;
	}
}
