package ir.apk.dm.core.config;


public class LoginConfigInfo {

	private int invalidLoginBeforeCaptcha;
	private int invalidCaptcha;
	private long lockTimeSecs;

	public LoginConfigInfo(int invalidLoginBeforeCaptcha, int invalidCaptcha, long lockTimeSecs) {
		this.invalidLoginBeforeCaptcha = invalidLoginBeforeCaptcha;
		this.invalidCaptcha = invalidCaptcha;
		this.lockTimeSecs = lockTimeSecs;
	}

	public int getInvalidLoginBeforeCaptcha() {
		return invalidLoginBeforeCaptcha;
	}

	public void setInvalidLoginBeforeCaptcha(int invalidLoginBeforeCaptcha) {
		this.invalidLoginBeforeCaptcha = invalidLoginBeforeCaptcha;
	}

	public int getInvalidCaptcha() {
		return invalidCaptcha;
	}

	public void setInvalidCaptcha(int invalidCaptcha) {
		this.invalidCaptcha = invalidCaptcha;
	}

	public long getLockTimeSecs() {
		return lockTimeSecs;
	}

	public void setLockTimeSecs(long lockTimeSecs) {
		this.lockTimeSecs = lockTimeSecs;
	}
}
