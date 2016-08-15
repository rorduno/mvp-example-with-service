package raulorduno.mvpexamplewithservice.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.joda.time.LocalDateTime;

import java.util.List;

import raulorduno.mvpexamplewithservice.R;
import raulorduno.mvpexamplewithservice.model.UserModel;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
	private List<UserModel> mDataset;

	// Provide a reference to the views for each data item
	// Complex data items may need more than one view per item, and
	// you provide access to all the views for a data item in a view holder
	public static class ViewHolder extends RecyclerView.ViewHolder {
		// each data item is just a string in this case

		public TextView tvName;
		public TextView tvEmail;
		public TextView tvTimeStamp;
		public ViewHolder(View v) {
			super(v);
			tvName = (TextView) v.findViewById(R.id.name);
			tvEmail =  (TextView) v.findViewById(R.id.email);
			tvTimeStamp = (TextView) v.findViewById(R.id.time_stamp);
		}
	}

	// Provide a suitable constructor (depends on the kind of dataset)
	public MyAdapter(List<UserModel> myDataset) {
		mDataset = myDataset;
	}

	// Create new views (invoked by the layout manager)
	@Override
	public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
	                                               int viewType) {
		// create a new view
		View v = LayoutInflater.from(parent.getContext())
			.inflate(R.layout.list_row, parent, false);
		// set the view's size, margins, paddings and layout parameters
		ViewHolder vh = new ViewHolder(v);
		return vh;
	}

	// Replace the contents of a view (invoked by the layout manager)
	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		// - get element from your dataset at this position
		// - replace the contents of the view with that element
		final LocalDateTime localDateTime = LocalDateTime.now();
		holder.tvName.setText(mDataset.get(position).getName());
		holder.tvEmail.setText(mDataset.get(position).getEmail());
		holder.tvTimeStamp.setText(localDateTime.toString());

	}

	// Return the size of your dataset (invoked by the layout manager)
	@Override
	public int getItemCount() {
		return mDataset.size();
	}
}



