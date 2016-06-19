package ir.apk.dm.ui;

import ir.apk.dm.ui.util.MessageUtil;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import java.io.Serializable;

/**
 * ‫کلاس والد برای Bean هایی است که معمولا به صفحات متصل می باشدلذا همه Bean ها باید از این Bean ارث بری کنند مگر برای Bean هایی که به صورت background فعالیت می کنند و با کاربر تعامل مستقیم خاصی ندارند.
 */
public abstract class BaseBean implements Serializable {

	public static void showMessage(String summary, String detail, FacesMessage.Severity severity) {
		MessageUtil.showMessage(summary, detail, severity);
	}

	public static String getMessage(String key, Object... params) {
		return MessageUtil.getMessage(key, params);
	}

	@PostConstruct
	protected abstract void init();

	}
