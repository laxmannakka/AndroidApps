package com.bridgelabz.indeanpremierleage.utility;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bridgelabz.indeanpremierleage.R;
import com.bridgelabz.indeanpremierleage.model.TeamMembarsInfo;

import org.w3c.dom.Text;

import java.util.List;

import static com.bridgelabz.indeanpremierleage.utility.RecylerviewAdapter.*;

/**
 * Created by bridgelabz1 on 6/7/16.
 */

public class DisplayMembersRecycleadapter extends RecyclerView.Adapter<DisplayMembersRecycleadapter.Myviewholder> {

    List<TeamMembarsInfo> list;

    public DisplayMembersRecycleadapter(List<TeamMembarsInfo> list) {
        this.list = list;
    }

    Context mcontex;

    public DisplayMembersRecycleadapter(List<TeamMembarsInfo> list, Context mcontex) {
        this.list = list;
        this.mcontex = mcontex;
    }

    @Override
    public Myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View viewlist = LayoutInflater.from(mcontex).inflate(R.layout.playerinfo, parent, false);

        return new Myviewholder(viewlist);
    }

    @Override
    public void onBindViewHolder(Myviewholder holder, int position) {
        TeamMembarsInfo obj = list.get(position);
        holder.name.setText(obj.getPlayername());
        holder.role.setText(obj.getRole());
        holder.photo.setImageBitmap(obj.getPlayerphoto());
        holder.nationality.setText(obj.getNationality());
        holder.batstyle.setText(obj.getBattingStyle());
        holder.bowlstyle.setText(obj.getBowlingStyle());
        holder.dob.setText(obj.getDob());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder {

        TextView name, role, batstyle, bowlstyle, nationality, dob;
        ImageView photo;

        public Myviewholder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.setnameTextview);
            role = (TextView) itemView.findViewById(R.id.setplayrole);
            batstyle = (TextView) itemView.findViewById(R.id.setbattingstyle);
            bowlstyle = (TextView) itemView.findViewById(R.id.setbowl);
            nationality = (TextView) itemView.findViewById(R.id.setnatonality);
            dob = (TextView) itemView.findViewById(R.id.setdob);
            photo = (ImageView) itemView.findViewById(R.id.imageview1);

        }
    }
}

