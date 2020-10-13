package edu.uw.tcss450.mylabappadamhh.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.uw.tcss450.mylabappadamhh.R;
import edu.uw.tcss450.mylabappadamhh.databinding.FragmentSignInBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment implements View.OnClickListener {
    private FragmentSignInBinding binding;
    private static final CharSequence REGISTER_ERROR = "Register error";
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentSignInBinding.inflate(inflater, container, false);
        textView = binding.signinErrorId;
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick (View view) {
        //binding.registerId.setOnClickListener(this::handleRegister);

    }

    public void handleRegister(View view) {
        this.processRegister();
    }

    public void processRegister() {
        SignInFragmentDirections.ActionSignInFragmentToRegisterFragment directions =
                SignInFragmentDirections.actionSignInFragmentToRegisterFragment();
        Navigation.findNavController(getView()).navigate(directions);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding.buttonId.setOnClickListener(this::handleSignIn);
        binding.registerId.setOnClickListener(this::handleRegister);
    }

    public void handleSignIn(View view) {
        String email = binding.signinEmailId.getText().toString();
        String password = binding.passwordId.getText().toString();
        if (email.isEmpty()) {
            textView.setError(REGISTER_ERROR);
            textView.setText("Email field cannot be empty ");
        } else if (password.isEmpty()) {
            textView.setError(REGISTER_ERROR);
            textView.setText("Password field cannot be empty ");
        } else if (!email.contains("@")) {
            textView.setError(REGISTER_ERROR);
            textView.setText("Email must contain @ symbol ");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Hello ");
            sb.append(email);
            this.processSignIn(sb.toString());
        }
    }

    public void processSignIn (String emailGreeting) {
        Log.d("Signin", "email  -> " + emailGreeting);

        SignInFragmentDirections.ActionSignInFragmentToSuccessFragment directions =
                SignInFragmentDirections.actionSignInFragmentToSuccessFragment(emailGreeting);
        //Use the navigate method to perform the navigation.
        Navigation.findNavController(getView()).navigate(directions);
    }

}