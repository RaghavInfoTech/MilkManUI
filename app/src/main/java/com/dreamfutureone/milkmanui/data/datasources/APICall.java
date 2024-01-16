package com.dreamfutureone.milkmanui.data.datasources;

import com.dreamfutureone.milkmanui.data.model.api.CustomerAuthRequest;
import com.dreamfutureone.milkmanui.data.model.api.CustomerAuthResponse;
import com.dreamfutureone.milkmanui.utils.MilkManConstant;
import retrofit.*;

import java.io.IOException;

public class APICall {

    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(MilkManConstant.hostName)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

    static void loginCustomer(String userName, String pwd, Callback loginCallback) {

        Retrofit retrofit = getRetrofitInstance();
        APIService apiService = retrofit.create(APIService.class);

        CustomerAuthRequest authRequest = new CustomerAuthRequest();
        authRequest.setEmailIdOrPhone(userName);
        authRequest.setAuthPin(pwd);

        Call<CustomerAuthResponse> authResponseCall = apiService.login(authRequest);

        //Async call
        authResponseCall.enqueue(loginCallback);
    }
}
