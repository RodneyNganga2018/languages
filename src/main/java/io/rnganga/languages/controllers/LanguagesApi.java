package io.rnganga.languages.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.rnganga.languages.models.Language;
import io.rnganga.languages.services.LanguageService;

@RestController
public class LanguagesApi {
	private final LanguageService languageService;
	
	public LanguagesApi(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/api/languages")
	public List<Language> index() {
		return languageService.findAll();
	}
	
	@RequestMapping(value="/api/languages", method=RequestMethod.POST)
	public Language create(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version) {
		Language lang = new Language(name,creator,version);
		return languageService.createLanguage(lang);
	}
	
	@RequestMapping("/api/languages/{id}")
	public Language show(@PathVariable("id") Long id) {
		Language lang = languageService.findOne(id);
		return lang;
	}
	
	@RequestMapping(value="/api/languages/{id}", method=RequestMethod.PUT)
	public Language update(@PathVariable("id") Long id, @RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version) {
		Language lang = languageService.updateLanguage(id, name, creator, version);
		return lang;
	}
	
	@RequestMapping(value="/api/languages/{id}", method=RequestMethod.DELETE)
	public void destroy(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
	}
}
