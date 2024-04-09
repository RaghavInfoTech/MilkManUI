package com.dreamfutureone.milkmanui.data.datasources;

import com.dreamfutureone.milkmanui.data.model.api.*;
import com.dreamfutureone.milkmanui.utils.MilkManConstant;
import retrofit.*;

import java.io.IOException;
import java.util.List;

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

        APIService apiService = getRetrofitInstance().create(APIService.class);

        CustomerAuthRequest authRequest = new CustomerAuthRequest();
        authRequest.setEmailIdOrPhone(userName);
        authRequest.setAuthPin(pwd);

        Call<CustomerAuthResponse> authResponseCall = apiService.login(authRequest);

        //Async call
        authResponseCall.enqueue(loginCallback);
    }

    static void registerCustomer(CustomerRegRequest custRegister, Callback custRegCallback) {
        APIService apiService = getRetrofitInstance().create(APIService.class);

        Call<CustomerRegResponse> customerRegResponseCall = apiService.registerCustomer(custRegister);

        //Async call
        customerRegResponseCall.enqueue(custRegCallback);
    }

    static void getProducts(Callback productsCallback) {
        APIService apiService = getRetrofitInstance().create(APIService.class);

        //Async call
        apiService.getProducts().enqueue(productsCallback);
    }
}
