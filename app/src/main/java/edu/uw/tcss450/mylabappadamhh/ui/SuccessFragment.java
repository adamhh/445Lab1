package edu.uw.tcss450.mylabappadamhh.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

import edu.uw.tcss450.mylabappadamhh.R;
import edu.uw.tcss450.mylabappadamhh.databinding.FragmentSuccessBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class SuccessFragment extends Fragment {
    private FragmentSuccessBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSuccessBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Get a reference to the SafeArgs object
        SuccessFragmentArgs args = SuccessFragmentArgs.fromBundle(getArguments());

        //Set the text of the label. NOTE no need to cast
        Objects.requireNonNull(binding.successId).setText(args.getEmail());

    }

}