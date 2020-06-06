package jacektracz.designpatterns.oo.creational.singleton;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import jacektracz.designpatterns.oo.stuff.JtLogger;
import jacektracz.designpatterns.oo.stuff.ThreadUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class CountryRepo {
	@Autowired
	JtLogger log;

	public Map<String, String> loadCountryNamesAsMap(Locale locale) {
		// connect to database, get data. fake some latency
		log.debug("Loading country names for language: ");
		ThreadUtils.sleep(2000);
		log.debug("done");

		Map<String, String> map = new HashMap<>();
		switch (locale.getLanguage()) {
		case "en":
			map.put("RO", "Romania");
			map.put("ES", "Spain");
			break;
		case "fr":
			map.put("RO", "Roumanie");
			map.put("ES", "Espagne");
			break;
		default: throw new IllegalArgumentException("best practice");
		}
		return map; 
	}


}