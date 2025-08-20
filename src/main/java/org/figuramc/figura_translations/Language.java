package org.figuramc.figura_translations;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Call Language.getInstance(identifier) to get or create this language.
 */
public class Language {

    // Facilitate singletons
    public static final Map<String, Language> LANGUAGES_BY_NAME = new ConcurrentHashMap<>();
    public static Language getInstance(String identifier) {
        return LANGUAGES_BY_NAME.computeIfAbsent(identifier, Language::new);
    }

    // Just a name
    public final String name;
    private Language(String name) {
        this.name = name;
    }

    // Defaults to EN_US in many cases
    public static final Language EN_US = Language.getInstance("en_us");

}
