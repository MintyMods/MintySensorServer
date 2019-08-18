package info.mintymods.mss.webapp.controller.admin;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import info.mintymods.utils.MintyFileUtils;

@Controller
public class DebugController {

	@Autowired
	private RequestMappingHandlerMapping requestMappingHandlerMapping;

	@GetMapping({"/debug/endPoints"})
	public String getEndPointsInView(final Model model) {
		model.addAttribute("endPoints", requestMappingHandlerMapping.getHandlerMethods().keySet());
		return model.toString();
	}

	@GetMapping({"/debug/{page}"})
	public String debug(final Map<String, Object> model, @PathVariable("page") final String page) {
		model.put("page", page);
		model.put("title", "Debug : " + page);
		final String[] names = extractPageNames(FileUtils.listFiles(MintyFileUtils.getFileFromClassPath("templates/debug"),
				new String[]{"hbs"}, false));
		model.put("names", names);
		return "debug/" + page;
	}

	private String[] extractPageNames(final Collection files) {
		@SuppressWarnings("unchecked")
		final List<File> pages = new ArrayList<File>(files);
		final List<String> names = new ArrayList<>();
		for (final File file : pages) {
			names.add(FilenameUtils.removeExtension(file.getName()));
		}
		return names.toArray(new String[]{});
	}
}
