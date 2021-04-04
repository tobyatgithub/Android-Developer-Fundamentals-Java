package com.toby.fragmentexample;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ToolbarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ToolbarFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {

    private static int seekValue = 10;
    private static EditText editText;

    ToolbarListener activityCallBack;

    public interface ToolbarListener {
        void onButtonClick(int position, String text);
    }

    @Override public void onAttach(Context context) {
        super.onAttach(context);
        try {
            activityCallBack = (ToolbarListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
            + " must implement ToolbarListener");
        }
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ToolbarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ToolbarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ToolbarFragment newInstance(String param1, String param2) {
        ToolbarFragment fragment = new ToolbarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_toolbar, container, false);
        editText = view.findViewById(R.id.editText1);
        final SeekBar seekBar = view.findViewById(R.id.seekBar1);
        seekBar.setOnSeekBarChangeListener(this);
        final Button button = view.findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(v);
            }
        });
        return view;
    }

    public void buttonClicked(View view) {
        activityCallBack.onButtonClick(seekValue, editText.getText().toString());
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        seekValue = progress;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}