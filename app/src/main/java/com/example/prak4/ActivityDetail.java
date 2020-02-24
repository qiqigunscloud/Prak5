package com.example.prak4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.Objects;

public class ActivityDetail extends AppCompatActivity {
    ImageView ivPhoto;
    TextView tvName, tvDescrition;

    Hero heroes = new Hero();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivPhoto = findViewById(R.id.iv_photo);
        tvName = findViewById(R.id.tv_name);
        tvDescrition = findViewById(R.id.tv_description);

        heroes = Objects.requireNonNull(getIntent().getExtras()).getParcelable("Data");

        tvName.setText(heroes.getNama());
        tvDescrition.setText(heroes.getDetail());
        Glide.with(getApplicationContext())
                .load(heroes.getFoto())
                .apply(new RequestOptions().override(200, 200))
                .into(ivPhoto);

    }
}
