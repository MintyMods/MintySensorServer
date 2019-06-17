package info.mintymods.mss.utils;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;

import info.mintymods.mss.Constants;

public class ConsoleBanner {

	private static final Logger log = LoggerFactory.getLogger(ConsoleBanner.class);

	public void writeBannerToLogs(ContextRefreshedEvent event) {
		StringBuilder banner = new StringBuilder();
		banner.append(Constants.LINE_SEPARATOR);
		try (Scanner scanner = new Scanner(MssFileUtils.getBannerAsciiArt())) {
			banner.append(Constants.LINE_SEPARATOR);
			banner.append(scanner.useDelimiter("\\Z").next());
			banner.append(Constants.LINE_SEPARATOR);
		} catch (FileNotFoundException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
		banner.append(Constants.LINE_SEPARATOR);
		banner.append("   ***   " + getName() + "   ***");
		banner.append(Constants.LINE_SEPARATOR);
		banner.append("MInty Sensor Server @NAME#" + getName()); // @todo sort out variable logging
		banner.append(Constants.LINE_SEPARATOR);
		banner.append(Constants.LINE_SEPARATOR);
		log.info(banner.toString());
	}

	private String getName() {
		return "MINTY SENSOR SERVER";
	}

}
