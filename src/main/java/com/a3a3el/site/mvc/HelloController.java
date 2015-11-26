package com.a3a3el.site.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class HelloController {

	public HelloController() {
	}

	private final EntityManagerFactory factory;

	{
		factory = Persistence.createEntityManagerFactory("persistenceUnit");
	}

	@RequestMapping(value = "/{pagename}", method = RequestMethod.GET)
	public ModelAndView showPage(@PathVariable("pagename") String name,
								 HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("index");
		System.out.println("===========\nInput relative address: " + name + "\n" +
				"Page content from db: " + getPageByURL(name).getContent() + "\n" +
				"Source ip address: " + request.getRemoteAddr() + "\n========");
		modelAndView.addObject("page", getPageByURL(name));
		return modelAndView;
	}

	private Page getPageByURL(String name) {
		EntityManager manager = factory.createEntityManager();

		try {
			return manager.createNamedQuery("Page.findByUrl", Page.class).setParameter("url",
					name == null ? "index" : name).getSingleResult();
		} finally {
			manager.close();
		}

	}

}