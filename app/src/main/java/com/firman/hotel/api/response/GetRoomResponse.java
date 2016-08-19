package com.firman.hotel.api.response;

import android.os.Parcel;

import com.firman.hotel.model.Room;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Firmanz on 8/17/2016.
 */

public class GetRoomResponse extends BaseResponse {
    @SerializedName("data")
    private ArrayList<Room> listRoom = new ArrayList<>();

    public ArrayList<Room> getListRoom() {
        return listRoom;
    }

    public void setListRoom(ArrayList<Room> listRoom) {
        this.listRoom = listRoom;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeTypedList(this.listRoom);
    }

    public GetRoomResponse() {
    }

    protected GetRoomResponse(Parcel in) {
        super(in);
        this.listRoom = in.createTypedArrayList(Room.CREATOR);
    }

    public static final Creator<GetRoomResponse> CREATOR = new Creator<GetRoomResponse>() {
        @Override
        public GetRoomResponse createFromParcel(Parcel source) {
            return new GetRoomResponse(source);
        }

        @Override
        public GetRoomResponse[] newArray(int size) {
            return new GetRoomResponse[size];
        }
    };
}
