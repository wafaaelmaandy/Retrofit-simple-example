package com.wafaaelm3andy.retrofit;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceInterface {
    String baseURL ="https://api.github.com/users/" ;

    @GET ("wafaaelmaandy/repos")
    //took respone that return from api  take aparemter of type response
    Call<ArrayList <Response> >methed();

}
