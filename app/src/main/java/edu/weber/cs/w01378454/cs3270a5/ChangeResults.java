package edu.weber.cs.w01378454.cs3270a5;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChangeResults#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChangeResults extends Fragment {



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View root;

    public BigDecimal TotalAmount;
    public double max=250;

    public TextView ChangeTotalSoFar;
    public TextView ChangeToMake;
    public TextView TimeRemaining;


    public ChangeResults() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChangeResults.
     */
    // TODO: Rename and change types and number of parameters
    public static ChangeResults newInstance(String param1, String param2) {
        ChangeResults fragment = new ChangeResults();
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
        return root = inflater.inflate(R.layout.fragment_change_results, container, false);
    }

    @Override
    public void onPause() {
        super.onPause();

        SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = prefs.edit();

    //    prefsEditor.putInt("ChangeToMake", randomNumber.intValue());
        prefsEditor.putInt("ChangeTotalSoFar", TotalAmount.intValue());
        prefsEditor.commit();
    }

    @Override
    public void onResume() {
        super.onResume();

        ChangeTotalSoFar = root.findViewById(R.id.ChangeTotalSoFar);
        ChangeToMake = root.findViewById(R.id.ChangeToMake);
        TimeRemaining = root.findViewById(R.id.TimeRemaining);
        randomNumberGenerator(max);

        SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
      //  int value = prefs.getInt("ChangeToMake", randomNumber);
      //  int value2 = prefs.getInt("ChangeTotalSoFar",TotalAmount);
     //   ChangeToMake.setText(value);
     //   ChangeTotalSoFar.setText(value2);


    }

    public void setChangeTotalSoFar(double TotalAmount)
    {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
        ChangeTotalSoFar.setText(numberFormat.format(TotalAmount));
    }

    public void randomNumberGenerator(double max)
    {
        double randomNumber = ThreadLocalRandom.current().nextDouble(0, max);


        if(randomNumber <= max)
        {
            NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
            ChangeToMake.setText(numberFormat.format(randomNumber));
        }else{
            randomNumberGenerator(max);
        }

    }


}