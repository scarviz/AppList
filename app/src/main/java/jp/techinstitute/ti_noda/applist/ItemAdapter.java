package jp.techinstitute.ti_noda.applist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<AppItem> {
	private class ViewHolder {
		TextView title;
		ImageView icon;
	}

	private LayoutInflater inflater;

	public ItemAdapter(Context context, int resource, List<AppItem> objects) {
		super(context, resource, objects);
		inflater = LayoutInflater.from(context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(convertView == null) {
			convertView = inflater.inflate(R.layout.list_item, null, false);

			holder = new ViewHolder();
			holder.icon = (ImageView) convertView.findViewById(R.id.icon);
			holder.title = (TextView) convertView.findViewById(R.id.title);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder)convertView.getTag();
		}

		AppItem item = getItem(position);
		holder.icon.setImageDrawable(item.getIconImage());
		holder.title.setText(item.getTitle());

		return convertView;
	}
}
