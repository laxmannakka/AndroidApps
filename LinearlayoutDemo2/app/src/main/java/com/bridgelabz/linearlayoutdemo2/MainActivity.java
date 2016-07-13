package com.bridgelabz.linearlayoutdemo2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;

import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {
    int num1 = 0, num2 = 0;


    //Function For Get The Values
    public void getdata() {
        String string1, string2;

        EditText text1 = (EditText) findViewById(R.id.text1);
        EditText text2 = (EditText) findViewById(R.id.text2);
        string1 = text1.getText().toString();
        string2 = text2.getText().toString();


        try {
            num1 = Integer.parseInt(string1);
            num2 = Integer.parseInt(string2);
        } catch (NumberFormatException exception) {
            Toast.makeText(MainActivity.this, "Enter Number only", Toast.LENGTH_LONG).show();
        }
    }

    // Function and logic for Add
    public void add() {
        int sum = num1 + num2;
        Log.i("SUM_IS", "onClick: .................." + sum);
        Toast.makeText(MainActivity.this, "Sum is :" + sum, Toast.LENGTH_LONG).show();
    }

    //  Function and logic for subtraction
    public void sub() {
        int sub = num1 - num2;
        Log.i("SUM_IS", "onClick: .................." + sub);
        Toast.makeText(MainActivity.this, "SUb is :" + sub, Toast.LENGTH_LONG).show();
    }

    //  Function and logic for  Multiplication
    public void mul() {
        int mul = num1 * num2;
        Log.i("SUM_IS", "onClick: .................." + mul);
        Toast.makeText(MainActivity.this, "Multiplication is :" + mul, Toast.LENGTH_LONG).show();
    }

    //  Function and logic for  division
    public void div() {
        int div = num1 / num2;
        Log.i("SUM_IS", "onClick: .................." + div);
        Toast.makeText(MainActivity.this, "Division is :" + div, Toast.LENGTH_LONG).show();
    }

    public void toggle() {
        ToggleButton toggle = (ToggleButton) findViewById(R.id.switch_button);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                EditText text1 = (EditText) findViewById(R.id.text1);
                if (isChecked) {

                    text1.setText(" On click");
                } else {
                    // The toggle is disabled
                    text1.setText(" Off Click");
                }
            }
        });
    }

    public void OperationofPrograss() {
        final ProgressDialog prograss = new ProgressDialog(this);
        prograss.setMessage("Downloading");

        prograss.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        prograss.setIndeterminate(true);
        prograss.setProgress(0);
        prograss.setMax(100);
        prograss.show();
        final int totalProgressTime = 100;
        final Thread t = new Thread() {
            @Override
            public void run() {

                while (prograss.getProgress() < totalProgressTime) {
                    int n=0;
                    try {
                        sleep(200);
                        n=prograss.getProgress();
                        Log.d("Progress", "run: "+prograss.getProgress());
                        prograss.setProgress((prograss.getProgress()+1));
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                prograss.hide();
            }
        };
        t.start();
    }


    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hiding The Title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

         //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        toggle();
        Button sum = (Button) findViewById(R.id.sum);
        Button sub = (Button) findViewById(R.id.sub);
        Button mul = (Button) findViewById(R.id.mul);
        Button div = (Button) findViewById(R.id.div);
        if (sum != null)
            sum.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getdata();
                    add();


                }
            });
        if (sub != null)
            sub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getdata();
                    sub();
                }
            });

        if (mul != null)
            mul.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getdata();
                    mul();
                }
            });
        if (div != null)
            div.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getdata();
                    div();
                }
            });


        // For Implicit Intent
        Button button = (Button) findViewById(R.id.press);
        if (button != null)
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // Creating The Object of Intent
                    Intent second = new Intent(Intent.ACTION_VIEW);
                    second.setData(Uri.parse("http://www.gmail.com"));
                    startActivity(second);
                }
            });

        // For Explicit Intent it will Open The Explicit Intent Class show login details
        Button ebut = (Button) findViewById(R.id.Ebutton);
        ebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent explicit = new Intent(getApplicationContext(), ExplicitIntent.class);
                startActivity(explicit);
            }
        });


        // Sending Sms activity Open The IntentSecond Class
        Button sms = (Button) findViewById(R.id.smsbutton);
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sms = new Intent(getApplicationContext(), IntentSecond.class);
                startActivity(sms);
            }
        });

        // Passing The data From One Activity To Other Activity(third)
        Button email = (Button) findViewById(R.id.email);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  Toast.makeText(getApplicationContext(), "email button Pressed ", Toast.LENGTH_LONG).show();
                Intent email = new Intent(getApplicationContext(), AvtivityThird.class);*/
                String obj = "laxman@gmail.com";
                String cc = "subject";
                String msg = "Hello Bridgelabz";
                Intent intent = new Intent(getApplicationContext(), AvtivityThird.class);
                intent.putExtra("key", obj);
                intent.putExtra("CC", cc);
                intent.putExtra("MSG", msg);
                String key = "A";
                intent.putExtra("match", key);

                startActivity(intent);

            }
        });
        //
        Button bundle = (Button) findViewById(R.id.bundle);
        bundle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AvtivityThird.class);
                Bundle getdata = new Bundle();
                getdata.putString("key", "Hello@bridgelabz.com");
                getdata.putString("msg", "hai");
                getdata.putString("cc", " subject");
                getdata.putString("match", "B");
                i.putExtras(getdata);

                startActivity(i);
                finish();
            }
        });

        // for datePicker
        Button Date = (Button) findViewById(R.id.date);
        Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ActivityDate.class);
                startActivity(i);
            }
        });
        // Time picker Function
        Button time = (Button) findViewById(R.id.time_picker);
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intenttime = new Intent(MainActivity.this, ActivityDate.class);
                startActivity(Intenttime);
            }
        });

        // function for Progress Bar
        Button progress = (Button) findViewById(R.id.progress);
        progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OperationofPrograss();
            }
        });


        //When Press The Button StartActivityforResult function calls ActivityForResults Class
        Button activityResult = (Button) findViewById(R.id.activityResult);
        activityResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, ActivityForResult.class), 245);
            }
        });

        // Button for Spinner it will open The
        Button spinner = (Button)findViewById(R.id.spinner);
        spinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ActivitySpinner.class);
                startActivity(i);
            }
        });

    }

    // OnActivityResult getting the data from intent and Displaying the editText1
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == 245) {
            EditText text1 = (EditText) findViewById(R.id.text1);
            text1.setText("" + data.getStringExtra("MESSAGE"));
        }
    }


}



