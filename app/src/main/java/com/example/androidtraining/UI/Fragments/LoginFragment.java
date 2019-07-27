package com.example.androidtraining.UI.Fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.androidtraining.R;
import com.example.androidtraining.UI.Activities.MainActivity;
import com.google.android.material.textfield.TextInputLayout;

public class LoginFragment extends Fragment implements View.OnClickListener {
    public static final String CLASSTAG = LoginFragment.class.getSimpleName();

    private TextInputLayout mUserName;
    private TextInputLayout mPassword;

    private Button mBtnLogin;
    private Button mBtnSignUp;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Initialise all the members which are needed for the login screen
     *
     * @param view
     */
    private void initView(View view) {
        mUserName = view.findViewById(R.id.username);
        mPassword = view.findViewById(R.id.password);

        mBtnLogin = view.findViewById(R.id.btnLogin);
        mBtnSignUp = view.findViewById(R.id.btnSignUp);

        mBtnLogin.setOnClickListener(this);
        mBtnSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                onLoginButtonClick();
                break;

            case R.id.btnSignUp:
                onSignUpButtonClick();
                break;

            default:
                break;
        }
    }

    private void onSignUpButtonClick() {
        ((MainActivity) getActivity()).loadFragment(
                R.id.fragment_container,
                new RegistrationFragment(),
                RegistrationFragment.CLASSTAG,
                true
        );
    }

    private void onLoginButtonClick() {
        if (isValid()) {
            Toast.makeText(getActivity(), "Logged in successfully. Work in Progress", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isValid() {
        if (TextUtils.isEmpty(mUserName.getEditText().getText().toString())) {
            Toast.makeText(getActivity(), "Please provide  valid user name", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(mPassword.getEditText().getText().toString())) {
            Toast.makeText(getActivity(), "Please provide  valid Password", Toast.LENGTH_SHORT).show();
            return false;
        }


        return true;
    }
}
