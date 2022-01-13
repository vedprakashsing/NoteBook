package io.app.notebook;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import io.app.notebook.data.Data;
import io.app.notebook.databinding.FragmentLoginBinding;
import io.app.notebook.home.HomeScreenFragment;

public class LoginFragment extends Fragment {
    private static final String TAG = "LoginFragment";
    private FragmentLoginBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Handling only for email now
        // Also, no error handling
        binding.forwardBottonIcon.setOnClickListener(v -> {
            String email = binding.editTextUser.getText().toString();
            String password = binding.editPassword.getText().toString();

            // Now let's get encrypted password
            byte[] encryptedPassword = new EncryptDecrypt().encrypted(password);

            // Fetch user id from room
            int uid = Data.getInstance().db.userDAO().getCurrentUserIdFromEmail(email, encryptedPassword);
            Log.d(TAG, "onViewCreated, user email: " + email + "; plaintext password: " + password);
            Log.d(TAG, "onViewCreated: obtained user id: " + uid);

            // Will return 0 only if there's no user record
            // IDs start autogenerating from 1
            if (uid == 0) {
                Toast.makeText(getContext(), "Wrong email/password", Toast.LENGTH_SHORT).show();
            } else {
                // Store uid in Data singleton for later use
                Data.getInstance().uid = uid;
                // Now navigate to Home, no need to add this screen to the back stack
                getParentFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, HomeScreenFragment.class, null).commit();
            }
        });
    }
}