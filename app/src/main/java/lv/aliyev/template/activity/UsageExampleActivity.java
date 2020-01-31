package lv.aliyev.template.activity;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;

import lv.aliyev.template.R;

public class UsageExampleActivity extends NetworkActivity {
    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_activity);
         Button btn = findViewById(R.id.mButton);
    }

}
