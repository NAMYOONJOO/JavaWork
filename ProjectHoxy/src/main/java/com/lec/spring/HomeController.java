package com.lec.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "thatsme";
	}

	@RequestMapping(value = "/project_next", method = RequestMethod.GET)
	public String project_next(Locale locale, Model model) {

		return "project_next";
	}
	
	@RequestMapping(value = "/flowChart", method = RequestMethod.GET)
	public String flowChart(Locale locale, Model model) {

		return "flowchart";
	}

	@RequestMapping(value = "/flowChart2", method = RequestMethod.GET)
	public String flowChart2(Locale locale, Model model) {

		return "flowchart2";
	}

	@RequestMapping(value = "/siteMap", method = RequestMethod.GET)
	public String siteMap(Locale locale, Model model) {

		return "sitemap";
	}

	@RequestMapping(value = "/siteMap2", method = RequestMethod.GET)
	public String siteMap2(Locale locale, Model model) {

		return "sitemap2";
	}

	@RequestMapping(value = "/dataBase", method = RequestMethod.GET)
	public String dataBase(Locale locale, Model model) {

		return "database";
	}
	
	@RequestMapping(value = "/dataBase2", method = RequestMethod.GET)
	public String dataBase2(Locale locale, Model model) {

		return "database2";
	}



	@RequestMapping(value = "/project_yourhome", method = RequestMethod.GET)
	public String project_yourhome(Locale locale, Model model) {

		return "project_yourhome";
	}
}
