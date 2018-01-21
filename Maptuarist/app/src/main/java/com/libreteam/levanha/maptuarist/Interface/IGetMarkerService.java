package com.libreteam.levanha.maptuarist.Interface;

import com.libreteam.levanha.vietnamtouristmap.WebService.DataList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Admin on 2/7/2017.
 */

public interface IGetMarkerService {
    @GET("/api/4.2/{path}")
    Call<DataList> loadMarker(@Path("path") String path);


}
