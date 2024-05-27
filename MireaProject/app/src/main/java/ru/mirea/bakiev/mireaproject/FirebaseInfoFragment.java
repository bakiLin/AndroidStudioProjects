package ru.mirea.bakiev.mireaproject;

import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Objects;

import ru.mirea.bakiev.mireaproject.databinding.FragmentFirebaseInfoBinding;
import ru.mirea.bakiev.mireaproject.databinding.FragmentProfileBinding;

public class FirebaseInfoFragment extends Fragment {
    private FirebaseAuth mAuth;
    private FragmentFirebaseInfoBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFirebaseInfoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        new DownloadPageTask().execute("https://ipinfo.io/json");

        binding.signOutFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent intent = new Intent(getActivity(), FirebaseActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    public class DownloadPageTask  extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            try {
                return downloadIpInfo(urls[0]);
            } catch (IOException e) {
                e.printStackTrace();
                return "error";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            try {
                JSONObject responseJson = new JSONObject(result);
                if (responseJson.has("current_weather")) {
                    JSONObject weatherJson = new JSONObject(responseJson.getString("current_weather"));
                    Objects.requireNonNull(binding.userIDtext).setText("Temperature: " + weatherJson.getString("temperature") + "\n"
                            + "Wind Speed: " + weatherJson.getString("windspeed") + "\n"
                            + "Wind Direction: " + weatherJson.getString("winddirection"));
                } else {
                    String latitude = responseJson.getString("loc").split(",")[0];
                    String longitude = responseJson.getString("loc").split(",")[1];
                    String path = String.format("https://api.open-meteo.com/v1/forecast?latitude=%s&longitude=%s&current_weather=true", latitude, longitude);
                    new DownloadPageTask().execute(path);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            super.onPostExecute(result);
        }

        private String downloadIpInfo(String address) throws IOException {
            InputStream inputStream = null;
            String data = "";
            try {
                URL url = new URL(address);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setReadTimeout(100000);
                connection.setConnectTimeout(100000);
                connection.setRequestMethod("GET");
                connection.setInstanceFollowRedirects(true);
                connection.setUseCaches(false);
                connection.setDoInput(true);
                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) { // 200 OK
                    inputStream = connection.getInputStream();
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    int read = 0;
                    while ((read = inputStream.read()) != -1) {
                        bos.write(read);
                    }
                    bos.close();
                    data = bos.toString();
                } else {
                    data = connection.getResponseMessage() + ". Error Code: " + responseCode;
                }
                connection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
            return data;
        }
    }
}