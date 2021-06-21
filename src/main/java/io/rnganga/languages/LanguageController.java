package io.rnganga.languages;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.rnganga.languages.models.Language;
import io.rnganga.languages.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService languageService;
	
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/languages")
	public String index(Model model) {
		List<Language> languages = languageService.findAll();
		model.addAttribute("languages", languages);
		model.addAttribute("language", new Language());
		return "/languages/index.jsp";
	}
	
	
	@RequestMapping(value="languages/{id}", method=RequestMethod.GET)
	public String show(@PathVariable("id") Long id, Model model) {
		Language lang = languageService.findOne(id);
		model.addAttribute("language", lang);
		return "/languages/show.jsp";
	}
	
	@RequestMapping("/languages/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Language lang = languageService.findOne(id);
		model.addAttribute("language", lang);
		return "/languages/edit.jsp";
	}
	
	@RequestMapping(value="/languages", method=RequestMethod.POST)
	public String add(@Valid @ModelAttribute("language")Language lang, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result);
			return "/languages/index.jsp";
		} else {
			languageService.createLanguage(lang);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
	public String update(@PathVariable("id") Long id, @RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version) {
		languageService.updateLanguage(id, name, creator, version);
		return "redirect:/languages";
	}
	
	@RequestMapping(value="languages/{id}", method=RequestMethod.DELETE)
	public String deleteOne(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
}
