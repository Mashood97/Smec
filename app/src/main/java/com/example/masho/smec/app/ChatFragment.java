package com.example.masho.smec.app;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.masho.smec.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment {

    private EditText user,email,contactno;
    private Spinner comp;
    private Button Submitbtn;
    DatabaseReference databaseReference;
    public final static String MESSAGE_KEY ="okcomputers.smec18.message_key";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_chats, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_chat) {
            Toast.makeText(getActivity(), "Clicked on " + item.getTitle(), Toast.LENGTH_SHORT)
                    .show();
        }
        return true;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar( toolbar);
        user = (EditText)view.findViewById(R.id.CompuserName);
        email = (EditText)view.findViewById(R.id.CompEmail);
        contactno = (EditText)view.findViewById(R.id.CompContactNo);
        comp = (Spinner)view.findViewById(R.id.CompSpinner);
        Submitbtn = (Button)view.findViewById(R.id.CompSubmitBtn);

        Submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
            }
        });
    }
    private void addUser()
    {
        String name = user.getText().toString();
        String Email = email.getText().toString();
        String No = contactno.getText().toString();
        String Comp = comp.getSelectedItem().toString();
        if(!TextUtils.isEmpty(name))
        {
            databaseReference = FirebaseDatabase.getInstance().getReference("Competitions").child(Comp);
            databaseReference.child("Name").setValue(name);
            databaseReference.child("Email").setValue(Email);
            databaseReference.child("No").setValue(No);
            databaseReference.child("Comp").setValue(Comp);
            Toast.makeText(getContext(), "Data Added Successfully", Toast.LENGTH_LONG).show();
        }

        else
        {
            Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
        }
    }
}