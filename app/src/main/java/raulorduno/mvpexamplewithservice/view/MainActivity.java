package raulorduno.mvpexamplewithservice.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.Serializable;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import raulorduno.mvpexamplewithservice.R;
import raulorduno.mvpexamplewithservice.model.UserModel;
import raulorduno.mvpexamplewithservice.presenter.Contract;
import raulorduno.mvpexamplewithservice.presenter.ContractPresenter;

// view - activity will implement the view from the "contract" or "presenter"
public class MainActivity extends AppCompatActivity implements Contract.View {
	public static final String KEY = "KEY";

	// declare presenter, this presenter will update the model (pass data) which will update view
	private Contract.Presenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

		// pass view reference to presenter
		presenter = new ContractPresenter(this);

	}
	@OnClick(R.id.btn_get_users)
	public void submit(View view) {
		presenter.onButtonClicked();
	}

	@Override
	public void updateListView(List<UserModel> users) {
		// change view, pass data to next activity, make Serializable
		Intent intent = new Intent(this, ListActivity.class);
		intent.putExtra(KEY,(Serializable) users);
		startActivity(intent);
	}
}
