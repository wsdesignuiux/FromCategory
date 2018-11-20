package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vaibhav.fromcategory.R;

import java.util.ArrayList;

import model.FRomCategoryModel;

/**
 * Created by wolfsoft4 on 22/8/18.
 */

public class FromCategoryAdapter extends RecyclerView.Adapter<FromCategoryAdapter.ViewHolder> {
    Context context;
    private ArrayList<FRomCategoryModel> fRomCategoryModelArrayList;
    boolean showingFirst=false;

    public FromCategoryAdapter(Context context, ArrayList<FRomCategoryModel> fRomCategoryModelArrayList) {
        this.context = context;
        this.fRomCategoryModelArrayList = fRomCategoryModelArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_from_category,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.img1.setImageResource(fRomCategoryModelArrayList.get(position).getImg1());
        holder.img2.setImageResource(fRomCategoryModelArrayList.get(position).getImg2());
        holder.offer.setText(fRomCategoryModelArrayList.get(position).getOffer());
        holder.price.setText(fRomCategoryModelArrayList.get(position).getPrice());
        holder.shoes.setText(fRomCategoryModelArrayList.get(position).getShoes());

        holder.img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (showingFirst == true) {
                    holder.img1.setBackgroundResource(R.drawable.ic_like_heart_outline);
                    showingFirst = false;
                } else {
                    holder.img1.setBackgroundResource(R.drawable.ic_like);
                    showingFirst = true;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return fRomCategoryModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img1,img2;
        TextView offer,price,shoes;

        public ViewHolder(View itemView) {
            super(itemView);


        img1=itemView.findViewById(R.id.img1);
        img2=itemView.findViewById(R.id.img2);

        offer=itemView.findViewById(R.id.offer);
        price=itemView.findViewById(R.id.price);
        shoes=itemView.findViewById(R.id.shoes);
        }
    }
}


