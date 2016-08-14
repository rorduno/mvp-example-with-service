package raulorduno.mvpexamplewithservice.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import raulorduno.mvpexamplewithservice.R;

public class ListActivity extends AppCompatActivity {

	@BindView(R.id.data) TextView tvData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		ButterKnife.bind(this);
		// get data from main activity and update textview
		tvData.setText(getIntent().getStringExtra(MainActivity.KEY));
	}

}
