package gerumap.util;

import java.awt.Font;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

import javax.swing.UIManager;

/**
 * Singleton to handle User's preferences
 * 
 * @author Djordje Krejakovic
 * @since 1 November 2022
 *
 */
public class UserPreferences {

	/**
	 * Returns the singleton UserPreferences instance to get and put user's
	 * preferences of the current user.
	 *
	 * @return the UserPreferences instance of the current user.
	 */
	public static UserPreferences get() {
		if (userPreferences == null) {
			userPreferences = new UserPreferences();
		}
		return userPreferences;
	}

	/**
	 * Returns the localized String from the GUI resource bundle, by provided
	 * resource key value, according to the UI language (locale) for the current
	 * user.
	 *
	 * @param value the String key to return the property from the GUI resource
	 *              bundle.
	 * @return the String that is localized representation of the resource property.
	 */
	public static String getLocalString(String value) {
		ResourceBundle resourceGui = ResourceBundle.getBundle("GUI", get().getLanguage().getLocale());
		if (resourceGui.containsKey(value)) {
			return resourceGui.getString(value);
		}
		return value;
	}

	private static UserPreferences userPreferences;
	private static final String LANGUAGE = "language";
	private static final String FONT_NAME = "font_name";
	private static final String FONT_SIZE = "font_size";
	private static final String ICON_SIZE = "icon_size";
	private static final String LOOK_AND_FEEL_KEY = "look_and_feel_key";

	private final Preferences preferences;

	private UserPreferences() {
		preferences = Preferences.userRoot().node(UserPreferences.class.getCanonicalName());
	}

	/**
	 * Returns the default Font.
	 *
	 * @return the Font to be used as default, using {@code getFontName()},
	 *         {@code getFontSize()} and PLAIN style.
	 */
	public Font getFont() {
		return new Font(getFontName(), Font.PLAIN, getFontSize());
	}

	/**
	 * Returns the default BOLD Font.
	 *
	 * @return the Font to be used as default BOLD, using {@code getFontName()},
	 *         {@code getFontSize()} and BOLD style.
	 */
	public Font getFontBold() {
		return getFont().deriveFont(Font.BOLD);
	}

	/**
	 * Returns the default ITALIC Font.
	 *
	 * @return the Font to be used as default ITALIC, using {@code getFontName()},
	 *         {@code getFontSize()} and ITALIC style.
	 */
	public Font getFontItalic() {
		return getFont().deriveFont(Font.ITALIC);
	}

	/**
	 * Returns the default BOLD-ITALIC Font.
	 *
	 * @return the Font to be used as default BOLD-ITALIC, using
	 *         {@code getFontName()}, {@code getFontSize()} and BOLD | ITALIC style.
	 */
	public Font getFontBoldItalic() {
		return getFont().deriveFont(Font.BOLD | Font.ITALIC);
	}

	/**
	 * Returns the default Font Family Name.
	 *
	 * @return the String name of the default Font Family.
	 */
	public String getFontName() {
		return preferences.get(FONT_NAME, "Verdana");
	}

	/**
	 * Saves the provided {@code name} of the Font Family.
	 *
	 * @param name the String to be saved as Font Family Name.
	 */
	public void putFontName(String name) {
		preferences.put(FONT_NAME, name);
	}

	/**
	 * Returns the size of the default Font in points.
	 *
	 * @return the int size of the Font in points.
	 */
	public int getFontSize() {
		return preferences.getInt(FONT_SIZE, 11);
	}

	/**
	 * Saves the size of the default Font in points.
	 *
	 * @param size the int size of the Font to save.
	 */
	public void putFontSize(int size) {
		preferences.putInt(FONT_SIZE, size);
	}

	/**
	 * Returns the size of the application toolbar Icons in points, as string.
	 *
	 * @return the string representing the size of the application toolbar Icons in points.
	 */
	public String getIconSize() {
		return preferences.get(ICON_SIZE, "16");
	}

	/**
	 * Saves the size of the application toolbar Icons in points.
	 *
	 * @param sizeDescription the string description of the size of the application toolbar Icons to save.
	 */
	public void putIconSize(String sizeDescription) {
		preferences.put(ICON_SIZE, sizeDescription);
	}

	/**
	 * Returns the UI language of the application.
	 *
	 * @return the SupportedLanguage enumeration that represents the UI language of
	 *         the application.
	 */
	public SupportedLanguage getLanguage() {
		return SupportedLanguage.byId(preferences.getInt(LANGUAGE, 0));
	}

	/**
	 * Saves the UI language of the application.
	 *
	 * @param language the SupportedLanguage enumeration to save.
	 */
	public void putLanguage(SupportedLanguage language) {
		preferences.putInt(LANGUAGE, language.getId());
	}

	/**
	 * Returns the {@code LookAndFeel} class name to use in the application.
	 *
	 * @return the String that represents the class name of the {@code LookAndFeel}.
	 */
	public String getLookAndFeelClassName() {
		return preferences.get(LOOK_AND_FEEL_KEY, UIManager.getSystemLookAndFeelClassName());
	}

	/**
	 * Saves the {@code LookAndFeel} class name to use in the application.
	 *
	 * @param name the String to save as the class name of the {@code LookAndFeel}.
	 */
	public void putLookAndFeelClassName(String name) {
		preferences.put(LOOK_AND_FEEL_KEY, name);
	}

}
