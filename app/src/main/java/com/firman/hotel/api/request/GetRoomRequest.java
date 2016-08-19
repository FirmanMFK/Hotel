package com.firman.hotel.api.request;

import com.firman.hotel.api.ApiService;
import com.firman.hotel.api.response.GetRoomResponse;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Firmanz on 8/17/2016.
 */
public class GetRoomRequest {
    AsyncHttpClient asyncHttpClient;
    private OnGetRoomRequestListener listener;

    public GetRoomRequest(){
        asyncHttpClient = new AsyncHttpClient();
    }

    public OnGetRoomRequestListener getListener() {
        return listener;
    }

    public void setListener(OnGetRoomRequestListener listener) {
        this.listener = listener;
    }

    public void callApi(){
        asyncHttpClient.get(ApiService.GET_ROOMS, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200){
                    String response = new String(responseBody);
                    Gson gson = new Gson();
                    GetRoomResponse getRoomResponse = gson.fromJson(response, GetRoomResponse.class);
                    getListener().onGetRoomRequestSuccess(getRoomResponse);
                } else {
                    getListener().onGetRoomRequestFailed("Invalid Response");

                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                getListener().onGetRoomRequestFailed(new String(responseBody));
            }
        });
    }

    public void cancel(){
        if (asyncHttpClient != null){
            asyncHttpClient.cancelAllRequests(true);
        }
    }

    public interface OnGetRoomRequestListener{
        void onGetRoomRequestSuccess(GetRoomResponse getRoomResponse);
        void onGetRoomRequestFailed(String errorMessage);
    }
}
