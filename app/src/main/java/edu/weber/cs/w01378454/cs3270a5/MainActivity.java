package edu.weber.cs.w01378454.cs3270a5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements ChangeButtons.onButtonListener
{

    private ChangeActions changeActions;
    private ChangeButtons changeButtons;
    private ChangeResults changeResults;

    private ChangeMaxAmountFragment changeMaxAmountFragment;

    private CorrectChangeDialogFragment correctChangeDialogFragment;
    private IncorrectChangeDialogFragment incorrectChangeDialogFragment;
    private TimeOutDialogFragment timeOutDialogFragment;

    public TextView TimeRemaining;
    private View root;
    private int count;
    double TotalAmount;
    double randomNumber;

    CountDownTimer countDownTimer;

    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                 //Main Fragments
                    .replace(R.id.ChangeResults, new ChangeResults(),"ChangeResults")
                    .replace(R.id.ChangeButtons, new ChangeButtons(),"ChangeButtons")
                    .replace(R.id.ChangeActions, new ChangeActions(),"ChangeActions")

                //Dialog Fragments
                     .replace(R.id.CorrectChangeDialogFragment, new CorrectChangeDialogFragment(), "CorrectChangeDialogFragment")
                     .replace(R.id.IncorrectChangeDialogFragment, new IncorrectChangeDialogFragment(), "IncorrectChangeDialogFragment")
                    .replace(R.id.TimeOutDialogFragment, new TimeOutDialogFragment(),"TimeOutDialogFragment")
                //User Input Fragment
                     .replace(R.id.ChangeMaxAmountFragment, new ChangeMaxAmountFragment(),"ChangeMaxAmountFragment")
                 .commit();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TimeRemaining = (TextView) findViewById(R.id.TimeRemaining);


        CountDownTimer countDownTimer = new CountDownTimer(31000,1000)
        {
            public void onTick(long millisUntilFinished)
            {
                do{
                TimeRemaining.setText(""+millisUntilFinished/1000);
                }while(TotalAmount <= randomNumber);


            }
            public void onFinish()
            {

                 if(randomNumber == TotalAmount)
                   {
                     TimeRemaining.setText("0");
                     CorrectChangeDialogFragment correctChange = new CorrectChangeDialogFragment();
                     correctChange.setCancelable(false);
                     correctChange.show(getSupportFragmentManager(), "CorrectChangeDialogFragment");
                     count++;
                   }
               if(TotalAmount > randomNumber)
                 {
                     TimeRemaining.setText("0");
                     IncorrectChangeDialogFragment incorrectChangeDialogFragment = new IncorrectChangeDialogFragment();
                     incorrectChangeDialogFragment.setCancelable(false);
                     incorrectChangeDialogFragment.show(getSupportFragmentManager(), "IncorrectCorrectChangeDialogFragment");
                 }
               if(TotalAmount < randomNumber)
               {
                    TimeRemaining.setText("0");
                    TimeOutDialogFragment timeout = new TimeOutDialogFragment();
                    timeout.setCancelable(false);
                    timeout.show(getSupportFragmentManager(), "TimeOutDialogFragment");
               }
            }
        }.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.gameoption,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
      /*  This method will be called anytime a user selects a menu item.
        it will pass a menu item of the thing the user has selected.*/

        switch(item.getItemId())
        {
            case R.id.ZeroCorrectAmount:
                ZeroCorrectAmount();
                return true;

            case R.id.ChangeAmountMaximum:
                ChangeAmountMaximum();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void ZeroCorrectAmount()
    {

    }

    private void ChangeAmountMaximum() {

            fragmentManager.replace(R.id.ChangeResults, new ChangeMaxAmountFragment());
            if(ChangeMaxAmountFragment.isAdded())
            {
                fragmentManager.hide(ChangeButtons);
                fragmentManager.hide(ChangeActions);
                fragmentManager.commit();

            }else{

            }

        fragmentManager.replace(R.id.ChangeMaxAmountFragment, new ChangeResults());

    }

    @Override
    public void changeButtonsPressed(double TotalAmount) {

        ChangeResults fragment = (ChangeResults) fragmentManager.findFragmentByTag("ChangeResults");
        if(fragment != null)
        {
            fragment.setChangeTotalSoFar(TotalAmount);
        }
    }

}
