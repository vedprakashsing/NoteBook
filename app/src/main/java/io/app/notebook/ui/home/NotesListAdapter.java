package io.app.notebook.ui.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.app.notebook.data.NoteEntity;
import io.app.notebook.databinding.ListOfNoteBinding;

public class NotesListAdapter extends RecyclerView.Adapter<NotesListAdapter.ViewHolder> {
    private List<NoteEntity> notes;

    public NotesListAdapter(List<NoteEntity> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public NotesListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Generate viwwholder with binding
        return new ViewHolder(ListOfNoteBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotesListAdapter.ViewHolder holder, int position) {
        NoteEntity note = notes.get(position);
        holder.binding.noteTitle.setText(note.getTitle());
        holder.binding.noteDescription.setText(note.getDescription());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ListOfNoteBinding binding;

        public ViewHolder(ListOfNoteBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
