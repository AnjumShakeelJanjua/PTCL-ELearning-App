package com.pga.ptcl.ptcl_videoplayapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProgrammingAdapter extends RecyclerView.Adapter<ProgrammingAdapter.ProgrammingViewHolder> {

    int row_index;
    Context context;
    private String[] data;
    private int[] images;

    public ProgrammingAdapter(String[] _data, int[] _image, Context _context) {
        this.data = _data;
        images = _image;
        context = _context;
    }

    @NonNull
    @Override
    public ProgrammingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_items_layout, parent, false);

        return new ProgrammingViewHolder(view, context, images, data);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgrammingViewHolder holder, final int position) {
        String title = data[position];
        int image_Id = images[position];

        holder.videoText.setText(title);
        holder.videoImage.setImageResource(image_Id);

//        holder.videoLinearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                row_index = position;
//                notifyDataSetChanged();
//            }
//        });
//
//        if (row_index == position) {
//            holder.videoLinearLayout.setBackgroundColor(Color.parseColor("#bdbdbd"));
//        } else
//            holder.videoLinearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ProgrammingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView videoImage;
        TextView videoText;
        LinearLayout videoLinearLayout;
        Context context;
        String[] imageTitles;
        int[] imagesWithIds;

        public ProgrammingViewHolder(View itemView, Context _context, int[] _images, String[] _imageTitles) {
            super(itemView);

            videoImage = itemView.findViewById(R.id.videoImageView);
            videoText = itemView.findViewById(R.id.videoTextView);
            videoLinearLayout = itemView.findViewById(R.id.linearLayoutId);

            itemView.setOnClickListener(this);

            context = _context;
            imageTitles = _imageTitles;
            imagesWithIds = _images;
        }

        @Override
        public void onClick(View v) {

            int adapPos = getAdapterPosition();
            if (row_index == 1 + adapPos) {
                this.videoLinearLayout.setBackgroundColor(Color.parseColor("#bdbdbd"));
            } else
                this.videoLinearLayout.setBackgroundColor(Color.parseColor("#ffffff"));

            Intent intent = new Intent(context, MainActivity.class);

            intent.putExtra("AdapterId", adapPos);
            intent.putExtra("VideoName", "ptclvideo" + String.valueOf(adapPos));

            context.startActivity(intent);
        }
    }
}