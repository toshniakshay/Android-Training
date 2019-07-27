package com.example.androidtraining.UI.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.androidtraining.Models.User;
import com.example.androidtraining.R;
import com.example.androidtraining.UI.Activities.MainActivity;

public class RegistrationFragment extends Fragment implements
        View.OnClickListener,
        AdapterView.OnItemSelectedListener,
        RadioGroup.OnCheckedChangeListener {

    public static final String CLASSTAG = LoginFragment.class.getSimpleName();

    private EditText mFirstName;
    private EditText mLastName;
    private EditText mEmailAddress;
    private EditText mPhoneNumber;
    private EditText mChoosePassword;
    private EditText mConfirmPassword;

    private RadioGroup mRadioGroup;
    private RadioButton mGenderRadioButton;

    private Spinner mSpinCountry;
    private Spinner mSpinState;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.registration_screen, container, false);
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


    private void initView(View view) {
        mFirstName = view.findViewById(R.id.first_name);
        mLastName = view.findViewById(R.id.last_name);
        mEmailAddress = view.findViewById(R.id.email_address);
        mPhoneNumber = view.findViewById(R.id.phone_number);
        mChoosePassword = view.findViewById(R.id.choose_password);
        mConfirmPassword = view.findViewById(R.id.confirm_password);

        mRadioGroup = view.findViewById(R.id.radioGroup);

        mSpinCountry = view.findViewById(R.id.country_spinner);
        mSpinState = view.findViewById(R.id.state_spinner);

        bindCountries();
        bindStates();

        Button mBtnSignUp = view.findViewById(R.id.signup_btn);

        mBtnSignUp.setOnClickListener(this);
        mSpinCountry.setOnItemSelectedListener(this);
        mSpinState.setOnItemSelectedListener(this);
        mRadioGroup.setOnCheckedChangeListener(this);
    }

    private void bindCountries(){
        String[] countries=getResources().getStringArray(R.array.countries_array);
        ArrayAdapter<String> adapterCountry = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, countries);
        adapterCountry.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mSpinCountry.setAdapter(adapterCountry);
    }

    private void bindStates(){
        String[] states=getResources().getStringArray(R.array.states_array);
        ArrayAdapter<String> adapterStates = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, states);
        adapterStates.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mSpinState.setAdapter(adapterStates);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.signup_btn) {
            onSignUpButtonClick();
        }
    }

    private void onSignUpButtonClick(){
        if(isValid()){
            // TODO :: Update Navigation and land user to Home Screen
            ((MainActivity) getActivity()).loadFragment(
                    R.id.fragment_container,
                    new LoginFragment(),
                    LoginFragment.CLASSTAG,
                    false
            );
        }
    }

    private User getUser() {
        User user = new User();

        user.setFirstName(mFirstName.getText().toString());
        user.setLastName(mLastName.getText().toString());
        user.setCountry((String) mSpinCountry.getSelectedItem());
        user.setState((String) mSpinState.getSelectedItem());
        user.setGender(1);
        user.setEmailAddress(mEmailAddress.getText().toString());
        user.setPhoneNumber(mPhoneNumber.getText().toString());

        return user;
    }

    @SuppressLint("ResourceType")
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    /**
     * check if all the data is field
     * @return boolean
     */
    private boolean isValid() {
        if (TextUtils.isEmpty(mFirstName.getText().toString())) {
            Toast.makeText(getActivity(), "Please provide  valid First name",Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(mLastName.getText().toString())) {
            Toast.makeText(getActivity(), "Please provide  valid Last name",Toast.LENGTH_SHORT).show();
            return false;
        }

        if(mRadioGroup.getCheckedRadioButtonId() == -1){
            Toast.makeText(getActivity(), "Please provide  valid Gender response",Toast.LENGTH_SHORT).show();
            return false;
        }

        if(mSpinCountry.getSelectedItem().equals("---Select---")){
            Toast.makeText(getActivity(), "Please provide  valid Country name",Toast.LENGTH_SHORT).show();
            return false;
        }

        if(mSpinState.getSelectedItem().equals("---Select---")){
            Toast.makeText(getActivity(), "Please provide  valid State name",Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(mEmailAddress.getText().toString())) {
            Toast.makeText(getActivity(), "Please provide  valid Email Address",Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(mPhoneNumber.getText().toString())) {
            Toast.makeText(getActivity(), "Please provide  valid Phone number",Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(mConfirmPassword.getText().toString())) {
            Toast.makeText(getActivity(), "Please provide  valid Choose Password",Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(mConfirmPassword.getText().toString())) {
            Toast.makeText(getActivity(), "Please provide  valid Confirm Password",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}