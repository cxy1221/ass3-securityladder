package com.cxy.demo;

import com.cxy.demo.Wordladder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcome() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Welcome - Spring Security");
		model.addObject("message", "This is welcome page!");
		model.setViewName("hello");
		return model;
	}

	@RequestMapping(value = "/wordladder", method = RequestMethod.GET)
	public ModelAndView myadmin(String fn, String word1, String word2) {
		ModelAndView model = new ModelAndView();
		Wordladder w = new Wordladder();
        w.filename=fn;
        w.words[0]=word1;
        w.words[1]=word2;
        System.out.printf("%s, %s\n", w.words[0], w.words[1]);
		model.addObject("wordladder", w.start());
		model.addObject("filename", fn);
		model.addObject("word1", word1);
		model.addObject("word2", word2);
		model.setViewName("wordladder");
		return model;

	}


	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView admin() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Admin - Spring Security Hello World");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");
		return model;

	}

}
