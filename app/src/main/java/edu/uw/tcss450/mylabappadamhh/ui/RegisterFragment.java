package edu.uw.tcss450.mylabappadamhh.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.uw.tcss450.mylabappadamhh.R;
import edu.uw.tcss450.mylabappadamhh.databinding.FragmentRegisterBinding;
import edu.uw.tcss450.mylabappadamhh.databinding.FragmentSuccessBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {
    private FragmentRegisterBinding binding;
    private static final CharSequence REGISTER_ERROR = "Register error";
    private TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false);
        textView = binding.registerErrorId;
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.registerButtonId.setOnClickListener(this::handleNewRegister);
        //Get a reference to the SafeArgs object
        //RegisterFragmentArgs args = RegisterFragmentArgs.fromBundle(getArguments());

        //Set the text color of the label. NOTE no need to cast


    }

    public void handleNewRegister(View view) {
        String email = binding.registerEmailId.getText().toString();
        String password = binding.registerPasswordId.getText().toString();
        String passwordConfirmation = binding.registerRetypeId.getText().toString();
        String firstName = binding.registerFirstId.getText().toString();
        String lastName = binding.registerLastId.getText().toString();
        if (email.isEmpty()) {
            textView.setError(REGISTER_ERROR);
            textView.setText("Email field cannot be empty ");
        } else if (password.isEmpty() || passwordConfirmation.isEmpty()) {
            textView.setError(REGISTER_ERROR);
            textView.setText("Password fields cannot be empty ");
        } else if (!password.equals(passwordConfirmation)) {
            textView.setError(REGISTER_ERROR);
            textView.setText("Passwords do not match ");
        } else if (!email.contains("@")) {
            textView.setError(REGISTER_ERROR);
            textView.setText("Email must contain an @ symbol ");
        }  else if (password.length() < 6) {
            textView.setError(REGISTER_ERROR);
            textView.setText("Password must be at least 6 characters");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Hello ");
            sb.append(binding.registerEmailId.getText());
            this.processNewRegister(sb.toString());
        }
    }

    public void processNewRegister(String emailGreeting) {
        RegisterFragmentDirections.ActionRegisterFragmentToSuccessFragment directions =
                RegisterFragmentDirections.actionRegisterFragmentToSuccessFragment(emailGreeting);
        Navigation.findNavController(getView()).navigate(directions);
    }

}