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
		try {
			INSTANCE.load(new FileInputStream(new File("resources/config.properties")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getProject(String id) {
		return getProperty("project." + id, "");
	}

	public String getTask(String id) {
		return getProperty("task." + id, "");
	}
}
