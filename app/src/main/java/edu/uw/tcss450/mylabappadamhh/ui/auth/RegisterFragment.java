package edu.uw.tcss450.mylabappadamhh.ui.auth;

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
import edu.uw.tcss450.mylabappadamhh.databinding.FragmentSignInBinding;
import edu.uw.tcss450.mylabappadamhh.ui.auth.RegisterFragmentDirections;

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

        //On button click, process registration info
        binding.registerButtonId.setOnClickListener(this::handleNewRegister);


    }

    public void handleNewRegister(View view) {
        FragmentRegisterBinding binding = FragmentRegisterBinding.bind(getView());
        String email = binding.registerEmailId.getText().toString();
        String password = binding.registerPasswordId.getText().toString();
        String passwordConfirmation = binding.registerRetypeId.getText().toString();
        String firstName = binding.registerFirstId.getText().toString();
        String lastName = binding.registerLastId.getText().toString();
        if (email.isEmpty()) {
            textView.setError(REGISTER_ERROR);
            textView.setText("Email field cannot be empty ");
        } else if (firstName.isEmpty()) {
            textView.setError(REGISTER_ERROR);
            textView.setText("First name field cannot be empty" );
        } else if (lastName.isEmpty()) {
            textView.setError(REGISTER_ERROR);
            textView.setText("Last name field cannot be empty ");
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
            Navigation.findNavController(getView()).navigate(
                    RegisterFragmentDirections
                            .actionRegisterFragmentToMainActivity(
                                    binding.registerEmailId.getText().toString(), "Blank For now"

                            ));
            //This tells the containing Activity that we are done with it.
            //It will not be added to backstack.
            getActivity().finish();


        }
    }

    public void processNewRegister() {
//        FragmentRegisterBinding binding = FragmentRegisterBinding.bind(getView());
//
//        //On button click, navigate to MainActivity
//        binding.registerButtonId.setOnClickListener(button -> {
//            Navigation.findNavController(getView()).navigate(
//                    RegisterFragmentDirections
//                            .actionRegisterFragmentToMainActivity(
//                                    binding.registerEmailId.getText().toString(), "Blank For now"
//
//                            ));
//            //This tells the containing Activity that we are done with it.
//            //It will not be added to backstack.
//            getActivity().finish();
//
//        });
    }
}