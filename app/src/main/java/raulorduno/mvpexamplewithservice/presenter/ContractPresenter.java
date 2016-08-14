package raulorduno.mvpexamplewithservice.presenter;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import raulorduno.mvpexamplewithservice.constants.Constants;

/*
Presenter is the core of the architecture
 - layer that provides View with data from Model
 - presenter also handles background tasks
 - listens to user action and model updates
 - updates model and view
*/
public class ContractPresenter implements Contract.Presenter {

	// connect view with model
	private Contract.View view;

	// service
	private final OkHttpClient client = new OkHttpClient();

	public ContractPresenter(Contract.View view) {
		this.view = view;
	}

	@Override
	public void onButtonClicked() {
		if (view != null) {
			final Request request = new Request.Builder()
				.url(Constants.DUMMY_DATA_ENDPOINT)
				.build();

			client.newCall(request).enqueue(new Callback() {
				@Override public void onFailure(Call call, IOException e) {
					e.printStackTrace();
				}
				@Override public void onResponse(Call call, Response response) throws IOException {
					if (!response.isSuccessful())
						throw new IOException("Unexpected code " + response);
					else {
						view.updateListView(response.body().string());
						System.out.println(response.body().string());
					}
				}
			});
		}
	}
}
