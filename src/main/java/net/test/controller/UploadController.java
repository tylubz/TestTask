package net.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.test.DBData;
import net.test.model.Product;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Handles requests for the application file upload requests
 */
@Controller
public class UploadController {

	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

	/**
	 * Upload single file using Spring Controller
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody ModelAndView uploadFileHandler(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");

				File dir = new File(rootPath + File.separator + "tmpFiles");

				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				logger.info("Server File Location=" + serverFile.getAbsolutePath());
				DBData dbdata = new DBData();
				dbdata.addDatatoDB(serverFile.getAbsolutePath());
				List<Product> myList = dbdata.getPersonsListFromDB();
				return new ModelAndView("tablePage", "myList", myList);
			} catch (Exception e) {
				return new ModelAndView("You failed to upload " + name + " => " + e.getMessage());
			}
		} else {
			return new ModelAndView("You failed to upload " + name + " because the file was empty.");
		}
	}
}
