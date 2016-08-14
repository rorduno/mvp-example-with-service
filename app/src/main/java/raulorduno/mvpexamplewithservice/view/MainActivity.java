package raulorduno.mvpexamplewithservice.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import raulorduno.mvpexamplewithservice.R;
import raulorduno.mvpexamplewithservice.presenter.Contract;
import raulorduno.mvpexamplewithservice.presenter.ContractPresenter;

// View - Activity will implement the View from the "Contract" or "Presenter"
public class MainActivity extends AppCompatActivity implements Contract.View {
	public static final String KEY = "KEY";

	// Declare presenter, this presenter will update the Model (pass data)
	// which will then update view
	private Contract.Presenter presenter;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

		// pass View reference to presenter
		presenter = new ContractPresenter(this);

	}
	@OnClick(R.id.btn_get_users)
	public void submit(View view) {
		presenter.onButtonClicked();
	}

	@Override
	public void updateListView(String data) {
		// change view, pass data to next activity
		Intent intent = new Intent(this, ListActivity.class);
		intent.putExtra(KEY, data);
		startActivity(intent);
	}
}
