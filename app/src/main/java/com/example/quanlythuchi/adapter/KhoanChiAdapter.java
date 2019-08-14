package com.example.quanlythuchi.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlythuchi.R;
import com.example.quanlythuchi.dao.KhoanChiDAO;
import com.example.quanlythuchi.dao.KhoanThuDAO;
import com.example.quanlythuchi.model.Note;
import com.example.quanlythuchi.model.Note2;

import java.util.List;

public class KhoanChiAdapter extends RecyclerView.Adapter<KhoanChiAdapter.ViewHolder> {
    Context context;
    List<Note2> noteList;
    KhoanChiDAO khoanThuDAO;
    String id="";

    public KhoanChiAdapter(Context context, List<Note2> noteList) {
        this.context = context;
        this.noteList = noteList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout,viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        viewHolder.tvName.setText(noteList.get(i).getNoteTitle2());
        viewHolder.tvPrice.setText(noteList.get(i).getNoteContent2()+" ");


        viewHolder.imgedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                final View view = LayoutInflater.from(context).inflate(R.layout.alert_edit_layout, null);

                final AlertDialog.Builder builder = new AlertDialog.Builder(context);


                builder.setView(view);
                builder.setCancelable(false);


                builder.setPositiveButton("Sửa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        EditText edtTen = (EditText) view.findViewById(R.id.edtTen);
                        EditText edtGia = (EditText) view.findViewById(R.id.edtGia);

                        khoanThuDAO = new KhoanChiDAO(context);


                        Note2 note = new Note2(id,viewHolder.tvName.getText().toString(),Double.parseDouble(viewHolder.tvPrice.getText().toString()));

                        if (khoanThuDAO.updateNote(note)==1){

                            Toast.makeText(context,"Sửa thành công",Toast.LENGTH_LONG).show();
                            viewHolder.tvName.setText(edtTen.getText().toString());
                            viewHolder.tvPrice.setText(edtGia.getText().toString());
                            notifyDataSetChanged();
                        }
                        else {
                            Toast.makeText(context, "Sửa không thành công", Toast.LENGTH_SHORT).show();
                        }
                        notifyDataSetChanged();



//                        String tv = editText.getText().toString().trim();
//                        final ClassThuChi thuChis = list.get(i);
//                        thuChis.setName(tv);
//                        notifyDataSetChanged();

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
        viewHolder.imgdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                khoanThuDAO = new KhoanChiDAO(context);
                khoanThuDAO.deleteNote(noteList.get(i));
                noteList.remove(i);
                notifyDataSetChanged();
            }
        });


    }


    @Override
    public int getItemCount() {
        if (noteList == null) return 0;
        else
            return noteList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvPrice;
        ImageView imgedit;
        ImageView imgdelete;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvPrice = (TextView) itemView.findViewById(R.id.tvPrice);
            imgedit = (ImageView) itemView.findViewById(R.id.imgedit);
            imgdelete = (ImageView) itemView.findViewById(R.id.imgdelete);


        }
    }
}
