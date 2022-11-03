package gerumap.util;

import java.util.Locale;

/**
 * 
 * Enumeration of supported application languages.
 * 
 * @author Djordje Krejakovic
 * @since 1 November 2022
 */

public enum SupportedLanguage {

	/**
	 * Serbian (RS), latinic script
	 */
	SERBIAN_LATN(0, new Locale("sr", "RS", "Latn")),

	/**
	 * Serbian (RS), cyrillic script
	 */
	SERBIAN_CYRL(1, new Locale("sr", "RS", "Cyrl")),

	/**
	 * English (US)
	 */
	ENGLISH_US(2, new Locale("en", "US", ""));

	/**
	 * Finds the enumeration value by provided integer id.
	 * 
	 * @param id the int id of the enumeration to find.
	 * @return the SupportedLanguage enumeration from the provided id.
	 */
	public static SupportedLanguage byId(int id) {
		for (SupportedLanguage language : SupportedLanguage.values()) {
			if (language.getId() == id) {
				return language;
			}
		}
		throw new IllegalArgumentException(String.format("Unsupported id %d for the language enumeration.", id));
	}

	/**
	 * 
	 * @return all display names for each language.
	 */
	public static String[] allDisplayNames() {
		String[] result = new String[SupportedLanguage.values().length];
		int cntr = 0;
		for (SupportedLanguage language : SupportedLanguage.values()) {
			result[cntr++] = language.toString();
		}
		return result;
	}

	/**
	 * 
	 * @return localized name of the language.
	 */
	public String getDisplayName() {
		return UserPreferences.getLocalString(SupportedLanguage.class.getSimpleName() + "_" + this.name());
	}

	/**
	 * @return the int id of the supported language enumeration
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the Locale of the supported language enumeration
	 */
	public Locale getLocale() {
		return locale;
	}

	private final int id;

	private final Locale locale;

	private SupportedLanguage(int id, Locale locale) {
		this.id = id;
		this.locale = locale;
	}

}
