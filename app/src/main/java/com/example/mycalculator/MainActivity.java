package com.example.mycalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText etNumber1, etNumber2;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber1 = findViewById(R.id.etNumber1);
        etNumber2 = findViewById(R.id.etNumber2);
        tvResult = findViewById(R.id.tvResult);
    }

    private Double[] getInputs() {
        String s1 = etNumber1.getText().toString().trim();
        String s2 = etNumber2.getText().toString().trim();
        if (s1.isEmpty() || s2.isEmpty()) {
            Toast.makeText(this, "لطفا عدد را وارد کنید.", Toast.LENGTH_SHORT).show();
            return null;
        }
        try {
            double n1 = Double.parseDouble(s1);
            double n2 = Double.parseDouble(s2);
            return new Double[]{n1, n2};
        } catch (NumberFormatException e) {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            return null;
        }
    }

        public void onAddclicked(View view){
        Double[] nums = getInputs();
        if (nums==null) return;
        double res = nums[0] + nums[1];
        tvResult.setText(String.valueOf(res));
        }
    public void onSubclicked(View view){
        Double[] nums = getInputs();
        if (nums==null) return;
        double res = nums[0] - nums[1];
        tvResult.setText(String.valueOf(res));
    }
    public void onMulclicked(View view){
        Double[] nums = getInputs();
        if (nums==null) return;
        double res = nums[0] * nums[1];
        tvResult.setText(String.valueOf(res));
    }
    public void onDivclicked(View view){
        Double[] nums = getInputs();
        if (nums==null) return;
        if (nums[1] == 0.0){
            Toast.makeText(this,"تقسیم بر صفر ممکن نیست",Toast.LENGTH_SHORT).show();
            tvResult.setText("خطا");
            return;
        }
        double res = nums[0]/nums[1];
        tvResult.setText(String.valueOf(res));
    }
    public void onModclicked(View view){
        Double[] nums = getInputs();
        if (nums==null) return;
        if (nums[1] == 0.0){
            Toast.makeText(this,"عملگر باقیمانده با تقسیم بر صفر تعریف نشده",Toast.LENGTH_SHORT).show();
            tvResult.setText("خطا");
            return;
        }
        double res = nums[0]%nums[1];
        tvResult.setText(String.valueOf(res));
    }
    public void onClearclicked(View view){
      etNumber1.setText("");
      etNumber2.setText("");
        tvResult.setText("_");
    }


    }


