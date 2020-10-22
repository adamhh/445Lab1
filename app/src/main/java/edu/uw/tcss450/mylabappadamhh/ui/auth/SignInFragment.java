package edu.uw.tcss450.mylabappadamhh.ui.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import edu.uw.tcss450.mylabappadamhh.R;
import edu.uw.tcss450.mylabappadamhh.databinding.FragmentSignInBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment {

    public SignInFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Local access to the ViewBinding object. No need to create as Instance Var as it is only
        //used here.
        FragmentSignInBinding binding = FragmentSignInBinding.bind(getView());

        //On button click, navigate to MainActivity
        binding.buttonId.setOnClickListener(button -> {
            Navigation.findNavController(getView()).navigate(
                    SignInFragmentDirections
                            .actionSignInFragmentToMainActivity(
                                    binding.signinEmailId.getText().toString(), "Blank For now"

                            ));
            //This tells the containing Activity that we are done with it.
            //It will not be added to backstack.
            getActivity().finish();

        });

        binding.signinRegId.setOnClickListener(this::handleRegister);
    }

    private void handleRegister(View view) {
        SignInFragmentDirections.ActionSignInFragmentToRegisterFragment directions =
                SignInFragmentDirections.actionSignInFragmentToRegisterFragment();
        Navigation.findNavController(getView()).navigate(directions);
    }
}
