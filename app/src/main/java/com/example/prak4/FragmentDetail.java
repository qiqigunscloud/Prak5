package com.example.prak4;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetail extends Fragment {

    ImageView ivPhoto;
    TextView tvName, tvDescrition;

    Hero heroes = new Hero();



    public FragmentDetail() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ivPhoto = view.findViewById(R.id.iv_photo);
        tvName = view.findViewById(R.id.tv_name);
        tvDescrition = view.findViewById(R.id.tv_description);

        Bundle bundle = this.getArguments();

        heroes = bundle.getParcelable("Data");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        tvName.setText(heroes.getNama());
        tvDescrition.setText(heroes.getDetail());
        Glide.with(getActivity())
                .load(heroes.getFoto())
                .apply(new RequestOptions().override(200, 200))
                .into(ivPhoto);

    }
}
