package info.mintymods.mss.webapp.controller.admin;

// import java.io.File;
// import java.util.ArrayList;
// import java.util.Collection;
// import java.util.List;
// import java.util.Map;
//
// import org.apache.commons.io.FileUtils;
// import org.apache.commons.io.FilenameUtils;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
//
// import info.mintymods.utils.MintyFileUtils;
//
// @Controller
// public class DebugController {
//
// @GetMapping({"/debug/{page}"})
// public String debug(Map<String, Object> model, @PathVariable("page") String page) {
// model.put("page", page);
// model.put("title", "Debug : " + page);
// String[] names = extractPageNames(FileUtils.listFiles(MintyFileUtils.getFileFromClassPath("templates/debug"),
// new String[]{"hbs"}, false));
// model.put("names", names);
// return "debug/" + page;
// }
//
// private String[] extractPageNames(Collection files) {
// @SuppressWarnings("unchecked")
// List<File> pages = new ArrayList<File>(files);
// List<String> names = new ArrayList<String>();
// for (File file : pages) {
// names.add(FilenameUtils.removeExtension(file.getName()));
// }
// return names.toArray(new String[]{});
// }
//
// }
