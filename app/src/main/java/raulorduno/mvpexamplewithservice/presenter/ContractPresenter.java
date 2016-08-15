package raulorduno.mvpexamplewithservice.presenter;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import raulorduno.mvpexamplewithservice.constants.Constants;
import raulorduno.mvpexamplewithservice.model.Users;

/*
Presenter is the core of the architecture
 - layer that provides View with data from Model
 - presenter also handles background tasks
 - listens to user action and model updates
 - updates model and view
*/
public class ContractPresenter implements Contract.Presenter {
	// service and json
	private final OkHttpClient client = new OkHttpClient();
	private final Gson gson = new Gson();
	// connect view with model
	private Contract.View view;
	private Users users;

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
						users = gson.fromJson(response.body().charStream(), Users.class);
						// update view with list users from service
						view.updateListView(users.getUserModels());
						System.out.println(response.body().string());
					}
				}
			});
		}
	}
}
