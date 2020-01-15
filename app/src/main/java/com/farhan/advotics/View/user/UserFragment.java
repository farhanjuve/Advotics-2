package com.farhan.advotics.View.user;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.farhan.advotics.R;
import com.farhan.advotics.View.login.SessionManager;
import com.farhan.advotics.model.mUser;

import java.util.HashMap;

import static android.content.ContentValues.TAG;

public class UserFragment extends Fragment {

    private UserViewModel userViewModel;
    Button btnLogout;
    SessionManager session;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        session = new SessionManager(this.getActivity().getApplicationContext());
        HashMap<String, String> user = session.getUserDetails();
        String name = user.get(SessionManager.KEY_NAME);
        String gender = user.get(SessionManager.KEY_GENDER);
        String number = user.get(SessionManager.KEY_NUMBER);
        Log.d(TAG, "BCD: " + name + gender + number);

        userViewModel =
                ViewModelProviders.of(this).get(UserViewModel.class);
        View root = inflater.inflate(R.layout.fragment_user, container, false);
        final TextView textView = root.findViewById(R.id.text_Nama);
        final TextView textView2 = root.findViewById(R.id.text_gender);
        final TextView textView3 = root.findViewById(R.id.text_phone);

        userViewModel.getUser().observe(this, mUser -> {
            textView.setText(mUser.getEmail());
            textView2.setText(mUser.getGender());
            textView3.setText(mUser.getPhone());
        });
        btnLogout = root.findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(arg0 -> session.logoutUser());

        try {
            userViewModel.setUser(name, gender, number);
        } catch (Exception e) {
            Log.e(TAG, "AAD", e);
            throw e;
        }
        return root;
    }
}