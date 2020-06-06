package jacektracz.designpatterns.oo.behavioral.strategy;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.SneakyThrows;

public interface ConfigProvider {
	Properties getProperties();
}

class ConfigFileProvider implements ConfigProvider {
	
	
	public Properties getProperties() {
		try {
		try (InputStream istr = ConfigFileProvider.class.getResourceAsStream("/application.properties")) {
			Properties properties = new Properties();
			properties.load(istr);
			return properties; 
		}
		}catch(Exception ex) {
			return null;
		}
	}
}

class ConfigDatabaseProvider implements ConfigProvider {

	public Properties getProperties() {
		// Real implem goes here
		Properties properties = new Properties();
		properties.setProperty("someProp", "from database");
		return properties; 
	}
	
}

