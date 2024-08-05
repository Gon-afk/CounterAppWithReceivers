package com.example.myapplication;

import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;

public class SecondActivity extends AppCompatActivity {
    ArrayList<DisplayRyclerView> DisplayRecyclerView = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        RecyclerView recyclerView = findViewById(R.id.mRecylerView);
        setUpDisplayRyclerView();

        RecyclerView_Adapter adapter = new RecyclerView_Adapter(this, DisplayRecyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        }
        private void setUpDisplayRyclerView()
        {
            String[] worldName = getResources().getStringArray(R.array.app_array);
            for (int i = 0; i < worldName.length; i++)
            {
                DisplayRecyclerView.add(new DisplayRyclerView(worldName[i]));
        }
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG)
//                != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CALL_LOG},
//                    PERMISSIONS_REQUEST_READ_CALL_LOG);
//        } else {
//            onScreenCall();
//        }

        Intent intent = getIntent();
        String username = intent.getStringExtra("name");

        TextView textViewUsername = findViewById(R.id.ShowName);
        textViewUsername.setText(username);
    }

    public void onScreenCall(Call.Details callDetails) {
        Log.i("Phone number", callDetails.getHandle().toString());
    }

    public void ThirdView(View view) {
        Uri.Builder builder = CalendarContract.CONTENT_URI.buildUpon();
        builder.appendPath("time");
        ContentUris.appendId(builder, Calendar.getInstance().getTimeInMillis());
        Intent intent = new Intent(Intent.ACTION_VIEW)
                .setData(builder.build());
        startActivity(intent);
    }
}

class DisplayRyclerView
{
    String name_array;

    public DisplayRyclerView(String name_array) {
        this.name_array = name_array;
    }

    public String getDisplayRyclerView() {
        return name_array;
    }
}
// pag 60 https://google-developer-training.github.io/android-developer-fundamentals-course-concepts/en/android-developer-fundamentals-course-concepts-en.pdf