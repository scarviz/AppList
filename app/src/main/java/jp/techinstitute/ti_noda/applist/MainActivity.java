package jp.techinstitute.ti_noda.applist;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
	private List<AppItem> itemList;
	private ItemAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		itemList = new ArrayList<AppItem>();
		adapter = new ItemAdapter(getApplicationContext(), 0, itemList);

		ListView listView = (ListView) findViewById(R.id.listview);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(listener);

		setList();
	}

	private void setList() {
		PackageManager pm = this.getPackageManager();
		final List<ApplicationInfo> appInfoList = pm.getInstalledApplications(BIND_AUTO_CREATE);

		for (ApplicationInfo ai : appInfoList) {
			Drawable icon = null;
			String title = null;
			String packageName = ai.packageName;

			if (ai.loadLabel(pm).toString() != null) {
				title = ai.loadLabel(pm).toString();
			}

			try {
				icon = pm.getApplicationIcon(packageName);
			} catch (PackageManager.NameNotFoundException ex) {
				ex.printStackTrace();
			}

			AppItem appItem = new AppItem(icon, title, packageName);
			itemList.add(appItem);
		}
	}

	private AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			AppItem item = (AppItem) parent.getItemAtPosition(position);

			PackageManager pm = getPackageManager();
			Intent intent = pm.getLaunchIntentForPackage(item.getPackageName());

			try {
				startActivity(intent);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	};
}
