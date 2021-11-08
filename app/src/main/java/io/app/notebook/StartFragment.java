package io.app.notebook;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.app.notebook.databinding.FragmentStartFragementBinding;


public class StartFragment extends Fragment {

  private FragmentStartFragementBinding binding;


    public StartFragment() {
        // Required empty public constructor
    }



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding =FragmentStartFragementBinding.inflate(inflater,container,false);
        View view=binding.getRoot();

        binding.startSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,LoginFragment.class,null).addToBackStack("null").commit();
            }
        });

        binding.startSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,SignUpFragment.class,null).addToBackStack("null").commit();
            }
        });
        return view;
    }
}