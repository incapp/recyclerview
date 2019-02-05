package com.incapp.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    public interface ClickListener {
        void onClicked(StudentModel studentModel);
    }

    private ClickListener clickListener;

    private List<StudentModel> list;

    public MyAdapter(List<StudentModel> list, ClickListener clickListener) {
        this.clickListener = clickListener;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_for_student_recyclerview, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        StudentModel studentModel = list.get(i);

        myViewHolder.textViewName.setText(studentModel.getName());
        myViewHolder.textViewNumber.setText(studentModel.getNumber());

        myViewHolder.itemView.setTag(studentModel);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewName, textViewNumber;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textView_name);
            textViewNumber = itemView.findViewById(R.id.textView_number);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            StudentModel studentModel = (StudentModel) itemView.getTag();
            clickListener.onClicked(studentModel);
        }
    }
}
