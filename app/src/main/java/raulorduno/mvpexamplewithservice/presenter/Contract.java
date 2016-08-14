package raulorduno.mvpexamplewithservice.presenter;

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
		void updateListView(String data);
	}
}
