package com.example.c1907e_android;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AsyncCheckIP extends AsyncTask<String, Void, String> {
    TextView ipTextView;
    ProgressDialog progressDialog;
    Context context;

    public AsyncCheckIP(Context context, TextView ipTextView) {
        this.ipTextView = ipTextView;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Kiểm tra IP");
        progressDialog.setMessage("Đang check...");
        progressDialog.show();
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            StringBuilder sb;
            URL url = new URL("https://icanhazip.com/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(reader);

                sb = new StringBuilder();
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line).append("\n");
                }

                bufferedReader.close();
                reader.close();
                inputStream.close();
                return sb.toString();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return "";
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        ipTextView.append(s);
        progressDialog.dismiss();
    }
}
