package raulorduno.mvpexamplewithservice.presenter;

import java.util.List;

import raulorduno.mvpexamplewithservice.model.UserModel;

/*
* The Contract is the glue that binds the participating components in MVP pattern together.
*
* */
public class Contract {

	// Presenter interface
	public interface Presenter {
		// input user interactions
		void onButtonClicked();
	}


	// View interface
	public interface View {
		// output user interactions
		void updateListView(List<UserModel> users);
	}
}
