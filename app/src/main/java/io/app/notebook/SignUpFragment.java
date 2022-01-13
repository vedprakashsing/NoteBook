package io.app.notebook;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.Arrays;
import java.util.regex.Pattern;

import io.app.notebook.data.Data;
import io.app.notebook.data.UserEntity;
import io.app.notebook.databinding.FragmentSignUpBinding;


public class SignUpFragment extends Fragment {

    private FragmentSignUpBinding binding;
    private String name;
    private String email;
    private String password;
    private String confirmPassword;
    private String phone;
    private String firstName;
    private byte[] encryptedPassword;


    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSignUpBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.signUpForwardBottonIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = binding.signUpEditTextUserName.getText().toString().trim();
                email = binding.signUpEditTextEmail.getText().toString().trim();
                phone = binding.signUpEditTextPhoneNumber.getText().toString().trim();
                password = binding.signUpEditTextPassword.getText().toString().trim();
                confirmPassword = binding.signUpEditTextConfirmPassword.getText().toString().trim();
                final Pattern EMAIL_PATTERN = Pattern.compile("^[_A-Za-z0-9-]{4,25}+(\\.[_A-Za-z0-9-]+)*@[[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})]{4,25}$");
                Log.d(TAG, "onClick: " + EMAIL_PATTERN.matcher(email).matches());

                if (name.length() < 3) {
                    Toast.makeText(getContext(), "Name length should be more than three", Toast.LENGTH_SHORT).show();
                } else if (name.isEmpty()) {
                    Toast.makeText(getContext(), "Name is empty", Toast.LENGTH_SHORT).show();
                } else if (email.isEmpty() || EMAIL_PATTERN.matcher(email).matches() == false) {
                    Toast.makeText(getContext(), "Enter valid email", Toast.LENGTH_SHORT).show();
                } else if (phone.isEmpty() == false && (phone.length() < 10 || phone.length() > 10)) {
                    Toast.makeText(getContext(), "Enter 10 digit number.", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty() || password.length() < 8 || password.length() > 15) {
                    Toast.makeText(getContext(), "Enter password(8<password<15)", Toast.LENGTH_SHORT).show();
                } else if (checkPassword() == false) {
                    Toast.makeText(getContext(), "Enter correct password.", Toast.LENGTH_SHORT).show();
                } else if (confirmPassword.isEmpty()) {
                    Toast.makeText(getContext(), "Enter confirm password.", Toast.LENGTH_SHORT).show();
                } else if (confirmPassword.isEmpty() == false && (password.equals(confirmPassword) == false)) {
                    Toast.makeText(getContext(), "Password does not matches.", Toast.LENGTH_SHORT).show();
                } else {
                    // String encryptedPassword = encrypted();
                    EncryptDecrypt encrypt = new EncryptDecrypt();
                    encryptedPassword = encrypt.encrypted(password);
                    Log.d(TAG, "onClick, Plaintext password: " + password + "; Encrypted password: " + Arrays.toString(encryptedPassword));
                    addNewUser(name, phone, email, encryptedPassword);
                }

            }
        });
        return view;
    }

    // Adds a new user to the database, and moves to the StartingFragment
    private void addNewUser(String name, String phone, String email, byte[] encryptedPassword) {
        // Use Room instance from Data singleton class
        Data.getInstance().db.userDAO().insertUser(
                new UserEntity(
                        0,
                        name,
                        phone,
                        encryptedPassword,
                        email
                )
        );
        Log.d(TAG, "addNewUser: user inserted in database");

        // Now move to StartingFragment
        getParentFragmentManager().popBackStack();
    }

    public boolean checkPassword() {
        int i = 0;
        while (!Character.isWhitespace(name.charAt(i))) {
            if (firstName != null)
                firstName = firstName + name.charAt(i);
            else
                firstName = "" + name.charAt(i);
            i++;
        }
        Log.d(TAG, "checkPassword: " + firstName);
        //Log.d(TAG, "checkPassword: "+isWordPresent(password,firstName));
        if ((password.toLowerCase()).contains(firstName.toLowerCase())) {
            Toast.makeText(getContext(), "Name is not allowed" + name, Toast.LENGTH_SHORT).show();
            Log.d(TAG, "checkPassword: " + "HogyaAA");
            firstName = null;
            return false;
        } else if (!count()) {
            Log.d(TAG, "checkPassword: " + "nahihua");
            firstName = null;
            return false;
        } else {
            Log.d(TAG, "checkPassword: " + "Ekahhua");
            firstName = null;
            return true;
        }
    }

    public boolean count() {
        int upper = 0, lower = 0, number = 0, special = 0;
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isWhitespace(password.charAt(i))) {
                if ('a' > password.charAt(0) || password.charAt(0) > 'z') {
                    Toast.makeText(getContext(), "Password start with lower case", Toast.LENGTH_SHORT).show();
                    return false;
                } else {
                    char ch = password.charAt(i);
                    if (ch >= 'A' && ch <= 'Z')
                        upper++;
                    else if (ch >= 'a' && ch <= 'z')
                        lower++;
                    else if (ch >= '0' && ch <= '9')
                        number++;
                    else
                        special++;
                }
            } else {
                Toast.makeText(getContext(), "Space Not Allowed", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        if (upper < 2) {
            Toast.makeText(getContext(), "At least two upper case", Toast.LENGTH_SHORT).show();
            return false;
        } else if (number < 2) {
            Toast.makeText(getContext(), "At least two digit ", Toast.LENGTH_SHORT).show();
            return false;
        } else if (special < 1) {
            Toast.makeText(getContext(), "At least one special number", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }


}