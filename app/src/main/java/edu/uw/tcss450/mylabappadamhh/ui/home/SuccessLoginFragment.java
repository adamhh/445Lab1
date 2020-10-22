package edu.uw.tcss450.mylabappadamhh.ui.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.uw.tcss450.mylabappadamhh.R;
import edu.uw.tcss450.mylabappadamhh.databinding.FragmentSuccessLoginBinding;
import edu.uw.tcss450.mylabappadamhh.model.UserInfoViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class SuccessLoginFragment extends Fragment {

    public SuccessLoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_success_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Local access to the ViewBinding object. No need to create as Instance Var as it is only
        //used here.
        FragmentSuccessLoginBinding binding = FragmentSuccessLoginBinding.bind(getView());

        //Note argument sent to the ViewModelProvider constructor. It is the Activity that
        //holds this fragment.
        UserInfoViewModel model = new ViewModelProvider(getActivity())
                .get(UserInfoViewModel.class);
        binding.successId.setText("Welcome " + model.getEmail() + "!");
    }
}
