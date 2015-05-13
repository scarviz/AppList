package jp.techinstitute.ti_noda.applist;

import android.graphics.drawable.Drawable;

public class AppItem {
	private Drawable mIconImage;
	private String mTitle;
	private String mPackageName;

	public AppItem(Drawable iconImg, String title, String packageName) {
		setIconImage(iconImg);
		setTitle(title);
		setPackageName(packageName);
	}

	public void setIconImage(Drawable iconImg) {
		mIconImage = iconImg;
	}

	public Drawable getIconImage() {
		return mIconImage;
	}

	public void setTitle(String title) {
		mTitle = title;
	}

	public String getTitle() {
		return mTitle;
	}

	public void setPackageName(String packageName) {
		mPackageName = packageName;
	}

	public String getPackageName() {
		return mPackageName;
	}
}
