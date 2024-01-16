package com.dreamfutureone.milkmanui.data.datasources;

import com.dreamfutureone.milkmanui.data.model.api.CustomerAuthRequest;
import com.dreamfutureone.milkmanui.data.model.api.CustomerAuthResponse;
import com.dreamfutureone.milkmanui.data.model.api.CustomerRegRequest;
import com.dreamfutureone.milkmanui.data.model.api.CustomerRegResponse;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;

public interface APIService {


    @POST("/milkman/customer/authenticate")
    Call<CustomerAuthResponse> login(@Body CustomerAuthRequest request);

    @POST("/milkman/customer/register")
    Call<CustomerRegResponse> registerCustomer(@Body CustomerRegRequest custReg);
}
