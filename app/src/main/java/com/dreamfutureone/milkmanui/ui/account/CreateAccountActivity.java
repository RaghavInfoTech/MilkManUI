package com.dreamfutureone.milkmanui.ui.account;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.dreamfutureone.milkmanui.R;
import com.dreamfutureone.milkmanui.databinding.ActivityCreateAccountBinding;

public class CreateAccountActivity extends AppCompatActivity {

    private ActivityCreateAccountBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_create_account);
        binding = ActivityCreateAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}