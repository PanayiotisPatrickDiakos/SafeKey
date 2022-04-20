package au.edu.unsw.infs3634.gamifiedlearning;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment {

    public SettingsFragment(){

    }

    Button optionA;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_settings, container, false);

        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        //set onlcicklistener here

        optionA = view.findViewById(R.id.subscriptionOptionA);
        optionA.requestFocusFromTouch();
        optionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Option A selected",
                        Toast.LENGTH_LONG).show();
            }
        });

                return view;
    }

}
