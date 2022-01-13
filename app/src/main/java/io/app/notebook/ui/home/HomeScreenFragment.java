package io.app.notebook.ui.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.app.notebook.R;
import io.app.notebook.databinding.FragmentHomeScreenBinding;
import io.app.notebook.ui.addnotes.AddNoteFragment;

public class HomeScreenFragment extends Fragment {
    private FragmentHomeScreenBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeScreenBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.homeAddButton.setOnClickListener(v -> {
            // Move to AddFragment
            getParentFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, AddNoteFragment.class, null).addToBackStack("home").commit();
        });
    }
}