package com.akash.dynamicsip.ui.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.akash.dynamicsip.R;
import com.akash.dynamicsip.data.network.model.ApiResponse;

import java.util.List;

public class MainActAdapter extends RecyclerView.Adapter<MainActAdapter.ViewHolder> {

    List<ApiResponse> apiResponseList;
    TextView pointTV, fixedValueMain, shareValueMain;
    ConstraintLayout constraintLayout;
    Context context;

    public int row_index = -1;

    public MainActAdapter(Context context, List<ApiResponse> apiResponseList, TextView fixedValueMain, TextView shareValueMain,
                          TextView pointTV, ConstraintLayout constraintLayout) {
        this.context = context;
        this.apiResponseList = apiResponseList;
        this.pointTV = pointTV;
        this.fixedValueMain = fixedValueMain;
        this.shareValueMain = shareValueMain;
        this.constraintLayout = constraintLayout;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_view_button, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        final ApiResponse apiResponse = apiResponseList.get(i);


        viewHolder.btnDate.setText(apiResponse.getDate());

        viewHolder.point = apiResponse.getPoint();
        viewHolder.shareValue = apiResponse.getEquity();

        viewHolder.btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index = i;
                int fixedVal = 100-Integer.parseInt(viewHolder.shareValue);
                String fix=fixedVal+"%", share = viewHolder.shareValue+"%";
                if (fixedVal<50){
                    constraintLayout.setBackgroundColor(context.getResources().getColor(R.color.orange));
                    viewHolder.btnDate.setBackgroundColor(context.getResources().getColor(R.color.blue));
                }else {
                    constraintLayout.setBackgroundColor(context.getResources().getColor(R.color.blue));
                    viewHolder.btnDate.setBackgroundColor(context.getResources().getColor(R.color.orange));
                }

                shareValueMain.setText(share);
                fixedValueMain.setText(fix);
                pointTV.setText(viewHolder.point);
                notifyDataSetChanged();
            }
        });

        if (!(row_index == i)){
            viewHolder.btnDate.setBackgroundColor(context.getResources().getColor(R.color.white));
        }
    }


    @Override
    public int getItemCount() {
        return apiResponseList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        String shareValue, point;
        Button btnDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            btnDate = itemView.findViewById(R.id.dateCV);

            btnDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });
        }
    }

}
