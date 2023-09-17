package com.example.barcodescanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.List;


import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpHelper {

    private static final OkHttpClient client = new OkHttpClient();



    public static String getBarcodeInfo (String id) throws IOException {
        Request request = new Request.Builder()
                .url("https://mybarcodeapi.azurewebsites.net/api/barcode/" + id + "/")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected response code: " + response);
            }
            String responseBody = response.body().string();
            return responseBody;
        }
    }


}
