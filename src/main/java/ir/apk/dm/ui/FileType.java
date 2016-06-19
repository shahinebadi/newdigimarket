package ir.apk.dm.ui;

/**
 * ‫یک enum برای پسوند فایل های مورداستفاده در برنامه
 */
public enum FileType {
	TXT(".txt"),
	SQL(".sql"),
	ZIP(".zip"),
	XML(".xml");

	private String extension;

	private FileType(String ext) {
		this.extension = ext;
	}

	@Override
	public String toString() {
		return extension;
	}
}
