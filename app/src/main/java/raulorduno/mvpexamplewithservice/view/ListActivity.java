package raulorduno.mvpexamplewithservice.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import raulorduno.mvpexamplewithservice.R;
import raulorduno.mvpexamplewithservice.model.UserModel;

public class ListActivity extends AppCompatActivity {

	private RecyclerView mRecyclerView;
	private RecyclerView.Adapter mAdapter;
	private RecyclerView.LayoutManager mLayoutManager;
	private List<UserModel> users;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		// get data from main activity and update view
			users = (List<UserModel>) getIntent().getSerializableExtra(MainActivity.KEY);

		mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

		// use this setting to improve performance if you know that changes
		// in content do not change the layout size of the RecyclerView
		mRecyclerView.setHasFixedSize(true);

		// use a linear layout manager
		mLayoutManager = new LinearLayoutManager(this);
		mRecyclerView.setLayoutManager(mLayoutManager);

		mAdapter = new MyAdapter(users);
		mRecyclerView.setAdapter(mAdapter);
	}

	// TODO : lifecycles, caching and next view

}
