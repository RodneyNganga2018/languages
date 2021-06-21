package io.rnganga.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.rnganga.languages.models.Language;
import io.rnganga.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepository;
	
	public LanguageService (LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	public List<Language> findAll() {
		return languageRepository.findAll();
	}
	
	public Language findOne (Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}
	
	public Language createLanguage(Language l) {
		return languageRepository.save(l);
	}
	
	public void deleteLanguage (Long id) {
		languageRepository.deleteById(id);
	}
	
	public Language updateLanguage(Long id, String name, String creator, String version) {
		if (languageRepository.findById(id).isPresent()) {
			Language lang = languageRepository.findById(id).get();
			lang.setName(name);
			lang.setCreator(creator);
			lang.setVersion(version);
			return languageRepository.save(lang);
		} else {
			return null;
		}
	}
}
