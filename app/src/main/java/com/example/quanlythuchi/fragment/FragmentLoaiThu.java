package com.example.quanlythuchi.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quanlythuchi.R;
import com.example.quanlythuchi.adapter.LoaiThuAdapter;
import com.example.quanlythuchi.adapter.LoaiThuAdapter;
import com.example.quanlythuchi.dao.LoaiThuDAO;
import com.example.quanlythuchi.dao.LoaiThuDAO;
import com.example.quanlythuchi.model.Note3;

import java.util.List;

public class FragmentLoaiThu extends Fragment {

    protected RecyclerView ryView;
    LoaiThuAdapter loaiThuAdapter;
    List<Note3> Note3List;
    LoaiThuDAO loaiThuDAO;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.khoanthu, container, false);

        ryView = view.findViewById(R.id.rvThuChi);
        FloatingActionButton fab = view.findViewById(R.id.fab);

        loaiThuDAO = new LoaiThuDAO(getActivity());

//
//        Note3List.add(new Note3("Lãi ngân hàng",10.000));
//        Note3List.add(new Note3("Lương",10.000));
//        Note3List.add(new Note3("Bán hàng Online",10.000));
//        Note3List.add(new Note3("Đòi nợ thuê",10.000));
//        Note3List.add(new Note3("Bố mẹ cho",10.000));
//        Note3List.add(new Note3("Đánh lô đề",10.000));

        Note3List = loaiThuDAO.getAllNote();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        ryView.setLayoutManager(layoutManager);
        loaiThuAdapter = new LoaiThuAdapter(getActivity(), Note3List);
        ryView.setAdapter(loaiThuAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

                LayoutInflater inflater = getLayoutInflater();
                final View view = inflater.inflate(R.layout.alert_layout, null);
                builder.setView(view);
                builder.setCancelable(false);



                builder.setPositiveButton("Thêm", new DialogInterface.OnClickListener() {

                    EditText edtThem = (EditText) view.findViewById(R.id.edtThem);
                    EditText  edtGia = (EditText) view.findViewById(R.id.edtGia);

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Note3 Note3 = new Note3(null,edtThem.getText().toString(),Double.parseDouble(edtGia.getText().toString()));
                        if (loaiThuDAO.insertNote(Note3)==1){
                            Toast.makeText(getActivity(), "Thêm thành công", Toast.LENGTH_SHORT).show();

                            Note3List = loaiThuDAO.getAllNote();

                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                            ryView.setLayoutManager(layoutManager);
                            loaiThuAdapter = new LoaiThuAdapter(getActivity(), Note3List);
                            ryView.setAdapter(loaiThuAdapter);
                        }
                        else {
                            Toast.makeText(getActivity(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
                        }

                        loaiThuAdapter.notifyDataSetChanged();
                    }
                });

                builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });


                builder.show();


            }
        });


        return view;


    }
}
