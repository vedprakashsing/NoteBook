package io.app.notebook.ui.addnotes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import io.app.notebook.data.Data;
import io.app.notebook.data.NoteEntity;
import io.app.notebook.databinding.FragmentAddNoteBinding;

public class AddNoteFragment extends Fragment {
    private FragmentAddNoteBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddNoteBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // On button click, add new note to the db
        binding.fabAddNote.setOnClickListener(v -> {
            // TODO add checking
            String title = binding.editTextTitle.getText().toString();
            String description = binding.editTextDescription.getText().toString();

            Data.getInstance().db.noteDAO()
                    .insertNote(new NoteEntity(
                            title,
                            description,
                            Data.getInstance().uid,
                            0
                    ));

            Toast.makeText(getContext(), "Note added!", Toast.LENGTH_SHORT).show();
            // Now that the note is added, move back to home
            getParentFragmentManager().popBackStack();
        });
    }
}