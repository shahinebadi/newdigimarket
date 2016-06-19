package ir.apk.dm.ui.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class MessageUtil {

	private static final ResourceBundle bundle = ResourceBundle.getBundle("messages", Locale.ENGLISH);

	public static String getMessage(String key, Object... params) {
		String value;
		try {
			value = bundle.getString(key);
		} catch (MissingResourceException e) {
			value = key;
		}
		if (params != null && params.length > 0) {
			MessageFormat mf = new MessageFormat(value, Locale.ENGLISH);
			value = mf.format(params, new StringBuffer(), null).toString();
		}
		return value;
	}

	public static void showMessage(String summary, String detail, FacesMessage.Severity severity) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
	}
}
