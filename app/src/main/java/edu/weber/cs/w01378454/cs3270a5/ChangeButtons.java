package edu.weber.cs.w01378454.cs3270a5;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.math.BigDecimal;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChangeButtons#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChangeButtons extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private View root;

    double penny = .01;
    double nickel = .05;
    double dime = .10;
    double quarter = .25;
    double halfdollar = .50;
    double onedollar = 1.00;
    double fivedollar = 5.00;
    double tendollar = 10.00;
    double twentydollar = 20.00;
    double fiftydollar = 50.00;

    double TotalAmount = 0;

    private onButtonListener mCallback;



    BigDecimal newTotalAmount = new BigDecimal(TotalAmount);

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public interface onButtonListener
    {
        void changeButtonsPressed(double TotalAmount);
    }

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);

        try{
            mCallback = (onButtonListener) activity;
        }catch(ClassCastException e){
            throw new ClassCastException(activity.toString() + " Must implement onButtonListener");
        }


    }

    public ChangeButtons() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChangeButtons.
     */
    // TODO: Rename and change types and number of parameters
    public static ChangeButtons newInstance(String param1, String param2) {
        ChangeButtons fragment = new ChangeButtons();
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
        return root = inflater.inflate(R.layout.fragment_change_buttons, container, false);

    }

    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    public void onStart() {
        super.onStart();

        Button btnpenny = root.findViewById(R.id.OneCent);
        btnpenny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TotalAmount = TotalAmount + penny;
                mCallback.changeButtonsPressed(TotalAmount);

            }
        });

        Button btnnickle = root.findViewById(R.id.FiveCents);
        btnnickle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TotalAmount = TotalAmount + nickel;
                mCallback.changeButtonsPressed(TotalAmount);

            }
        });

        Button btndime = root.findViewById(R.id.TenCents);
        btndime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TotalAmount = TotalAmount + dime;
                mCallback.changeButtonsPressed(TotalAmount);

            }
        });

        Button btnquarter = root.findViewById(R.id.TwentyFiveCents);
        btnquarter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TotalAmount = TotalAmount + quarter;
                mCallback.changeButtonsPressed(TotalAmount);
            }
        });
        Button btnfiftycents = root.findViewById(R.id.FiftyCents);
        btnfiftycents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TotalAmount = TotalAmount + halfdollar;
                mCallback.changeButtonsPressed(TotalAmount);
            }
        });
        Button btnonedollar = root.findViewById(R.id.OneDollar);
        btnonedollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    TotalAmount = TotalAmount + onedollar;
                mCallback.changeButtonsPressed(TotalAmount);
            }
        });
        Button btnfivedollar = root.findViewById(R.id.FiveDollars);
        btnfivedollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    TotalAmount = TotalAmount + fivedollar;
                mCallback.changeButtonsPressed(TotalAmount);
            }
        });
        Button btntendollar = root.findViewById(R.id.TenDollars);
        btntendollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TotalAmount = TotalAmount + tendollar;
                mCallback.changeButtonsPressed(TotalAmount);
            }
        });
        Button btntwentydollar = root.findViewById(R.id.TwentyDollars);
        btntwentydollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    TotalAmount = TotalAmount + twentydollar;
                mCallback.changeButtonsPressed(TotalAmount);
            }
        });
        Button btnfiftydollar = root.findViewById(R.id.FiftyDollars);
        btnfiftydollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TotalAmount = TotalAmount + fiftydollar;
                mCallback.changeButtonsPressed(TotalAmount);
            }
        });



    }



}