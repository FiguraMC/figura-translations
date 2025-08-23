package org.figuramc.figura_translations;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The central point for collecting translations.
 * Provide a name (e.g. "en_us"), and we'll return a Map<Translatable, String>.
 */
public class FiguraTranslations {

    public static final Map<Language, HashMap<Translatable<?>, String>> TRANSLATION_MAPS_BY_LANGUAGE = new ConcurrentHashMap<>();
    public static final List<String> TRANSLATION_RESOURCE_PATHS = new ArrayList<>();

    /**
     * Fetch (or compute if not yet populated) the translation map for the given language.
     */
    public static HashMap<Translatable<?>, String> getTranslationMap(Language language) {
        return TRANSLATION_MAPS_BY_LANGUAGE.computeIfAbsent(language, FiguraTranslations::parseLanguageMap);
    }

    /**
     * Force eventual recalculation of translations by clearing the cache.
     */
    public static void clearTranslationCache() {
        TRANSLATION_MAPS_BY_LANGUAGE.clear();
    }

    /**
     * The path should be a path inside src/main/resources pointing to a folder with language resources.
     * For example, in the figura-molang project, we would pass "org/figuramc/figura_molang/translations/",
     * because in that project, we have a file "org/figuramc/figura_molang/translations/en_us.jsonc".
     */
    public static void registerTranslationResources(String path) {
        synchronized (TRANSLATION_RESOURCE_PATHS) {
            if (!path.endsWith("/")) path += "/"; // Put slash at the end
            TRANSLATION_RESOURCE_PATHS.add(path);
        }
        clearTranslationCache(); // Clear translation cache, since we've added a new path
    }


    // Parse language resources and create the map
    private static HashMap<Translatable<?>, String> parseLanguageMap(Language language) {
        // Dot-separated strings -> translations for the language
        Map<String, String> translations = new HashMap<>();

        synchronized (TRANSLATION_RESOURCE_PATHS) {
            for (String path : TRANSLATION_RESOURCE_PATHS) {
                String resourcePath = path + language.name + ".jsonc";

                // Find the resource, or skip if could not find
                URL resource = FiguraTranslations.class.getClassLoader().getResource(resourcePath);
                if (resource == null) {
                    if (language != Language.EN_US) {
                        System.out.println("[FiguraTranslations] Warning: No translation file found at \"" + resourcePath + "\". Defaulting to en_us.");
                        resourcePath = path + Language.EN_US.name + ".jsonc";
                        resource = FiguraTranslations.class.getClassLoader().getResource(resourcePath);
                    }
                    if (resource == null) {
                        System.out.println("[FiguraTranslations] Warning: No translation file found at \"" + resourcePath + "\". Skipping.");
                        continue;
                    }
                }

                // Open resource stream
                try(InputStream stream = resource.openStream()) {
                    // Parse json object
                    JsonObject obj = new Gson().fromJson(new InputStreamReader(stream), JsonObject.class);
                    // Add all its entries to the translations
                    for (var entry : obj.entrySet()) {
                        translations.put(entry.getKey(), entry.getValue().getAsString());
                    }
                } catch (Exception e) {
                    throw new RuntimeException("Failed to parse translation file at \"" + resourcePath + "\"", e);
                }
            }
        }

        // Now assign those dot-separated strings with the Translatable objects and return

        HashMap<Translatable<?>, String> result = new HashMap<>();
        Translatable.ALL_TRANSLATABLES.forEach((dotSeparated, translatable) -> {
            String translation = translations.get(dotSeparated);
            if (translation == null) {
                System.out.println("[FiguraTranslations] Warning: No translation found in language \"" + language.name + "\" for string \"" + dotSeparated + "\". Skipping.");
                translation = dotSeparated;
            }
            result.put(translatable, translation);
        });
        return result;
    }

    // Helpers for generating boilerplate.

//    private static String generateItems(int max) {
//        StringBuilder res = new StringBuilder();
//        for (int i = 1; i <= max; i++) {
//            res.append("    ");
//            res.append("record Items").append(i).append("<");
//            for (int j = 0; j < i; j++) {
//                res.append((char) ('A' + j));
//                if (j != i - 1)
//                    res.append(", ");
//            }
//            res.append(">(");
//            for (int j = 0; j < i; j++) {
//                res.append((char) ('A' + j)).append(" ").append((char) ('a' + j));
//                if (j != i - 1)
//                    res.append(", ");
//            }
//            res.append(") implements TranslatableItems { @Override public Object[] toArray() { return new Object[] { ");
//            for (int j = 0; j < i; j++) {
//                res.append((char) ('a' + j));
//                if (j != i - 1)
//                    res.append(", ");
//            }
//            res.append(" }; } }\n");
//        }
//        return res.toString();
//    }
//
//    private static String generateTranslateMethods(int max) {
//        StringBuilder res = new StringBuilder();
//        for (int i = 1; i <= max; i++) {
//            res.append("    ");
//            res.append("public static <");
//            for (int j = 0; j < i; j++) {
//                res.append((char) ('A' + j));
//                if (j != i - 1)
//                    res.append(", ");
//            }
//            res.append("> String translate(Language language, Translatable<TranslatableItems.Items").append(i).append("<");
//            for (int j = 0; j < i; j++) {
//                res.append((char) ('A' + j));
//                if (j != i - 1)
//                    res.append(", ");
//            }
//            res.append(">> translatable, ");
//            for (int j = 0; j < i; j++) {
//                res.append((char) ('A' + j));
//                res.append(" arg").append(j + 1);
//                if (j != i - 1)
//                    res.append(", ");
//            }
//            res.append(") { return translatable.translate(language, new TranslatableItems.Items").append(i).append("<>(");
//            for (int j = 0; j < i; j++) {
//                res.append("arg").append(j + 1);
//                if (j != i - 1)
//                    res.append(", ");
//            }
//            res.append(")); }\n");
//        }
//        return res.toString();
//    }
//
//    private static String generateCreateMethods(int max) {
//        StringBuilder res = new StringBuilder();
//        for (int i = 1; i <= max; i++) {
//            res.append("    ");
//            res.append("public static <");
//            for (int j = 0; j < i; j++) {
//                res.append((char) ('A' + j));
//                if (j != i - 1)
//                    res.append(", ");
//            }
//            res.append("> Translatable<TranslatableItems.Items").append(i).append("<");
//            for (int j = 0; j < i; j++) {
//                res.append((char) ('A' + j));
//                if (j != i - 1)
//                    res.append(", ");
//            }
//            res.append(">> create(String dotSeparated, ");
//            for (int j = 0; j < i; j++) {
//                res.append("Class<").append((char) ('A' + j)).append(">");
//                res.append(" arg").append(j + 1);
//                if (j != i - 1)
//                    res.append(", ");
//            }
//            res.append(") { return new Translatable<>(dotSeparated); }\n");
//        }
//        return res.toString();
//    }
//
//    public static void main(String[] args) {
//        int max = 16;
//        System.out.println(generateItems(max));
//        System.out.println("---------------------");
//        System.out.println(generateTranslateMethods(max));
//        System.out.println("---------------------");
//        System.out.println(generateCreateMethods(max));
//    }

}