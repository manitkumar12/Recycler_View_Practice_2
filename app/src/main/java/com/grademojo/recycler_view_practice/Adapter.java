package com.grademojo.recycler_view_practice;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;



public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


    private List<Recycler_view_getter_setter> values;




    public class ViewHolder extends RecyclerView.ViewHolder{

        

        public TextView text_Roll_no , text_Leave ,text_Name ,text_Present ,text_Absent;


        public View layout;



        public ViewHolder(View itemView) {

            super(itemView);

            layout = itemView;
            text_Roll_no = (TextView) itemView.findViewById(R.id.roll_no_text);
            text_Leave = (TextView) itemView.findViewById(R.id.leave_text);
            text_Name = (TextView) itemView.findViewById(R.id.name_text);
            text_Absent = (TextView) itemView.findViewById(R.id.absent_text);
            text_Present = (TextView) itemView.findViewById(R.id.present_text);



            text_Absent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    text_Present.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
                    text_Absent.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                    text_Leave.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);



                    text_Absent.setTextColor(ContextCompat.getColor(v.getContext(), R.color.red));
                    text_Leave.setTextColor(ContextCompat.getColor(v.getContext(), R.color.black));
                    text_Present.setTextColor(ContextCompat.getColor(v.getContext(), R.color.black));



                    values.get( getAdapterPosition() ).setClick_option(
                            Recycler_view_getter_setter.ABSENT_CLICKED
                    );


                }
            });

            text_Present.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    text_Present.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                    text_Absent.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
                    text_Leave.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
                    text_Present.setTextColor(ContextCompat.getColor(v.getContext(),R.color.green));
                    text_Leave.setTextColor(ContextCompat.getColor(v.getContext(),R.color.black));
                    text_Absent.setTextColor(ContextCompat.getColor(v.getContext(),R.color.black));


                    values.get( getAdapterPosition() ).setClick_option(
                            Recycler_view_getter_setter.PRESENT_CLICKED
                    );

                }
            });

            text_Leave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    text_Present.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
                    text_Absent.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
                    text_Leave.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);

                    text_Present.setTextColor(ContextCompat.getColor(v.getContext(),R.color.black));
                    text_Leave.setTextColor(ContextCompat.getColor(v.getContext(),R.color.yellow));
                    text_Absent.setTextColor(ContextCompat.getColor(v.getContext(),R.color.black));


                    values.get( getAdapterPosition() ).setClick_option(
                            Recycler_view_getter_setter.LEAVE_CLICKED
                    );

                }
            });



//            text_Present.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    remove(getAdapterPosition());
//                }
//            });
        }
    }




    public Adapter(List<Recycler_view_getter_setter > mydataset){

        values = mydataset;
    }


    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.relative_background,parent,false);

        Adapter.ViewHolder viewHolder = new Adapter.ViewHolder(view);

        return viewHolder;
    }


    public void onBindViewHolder(ViewHolder holder, final int position) {


        Recycler_view_getter_setter item = values.get(position);
        Context context = holder.layout.getContext();


        switch (item.getClick_option()){
            case Recycler_view_getter_setter.PRESENT_CLICKED:

                holder.text_Present.setTextColor(ContextCompat.getColor(context,R.color.green));
                holder.text_Absent.setTextColor(ContextCompat.getColor(context,R.color.black));
                holder.text_Leave.setTextColor(ContextCompat.getColor(context,R.color.black));

                break;

            case Recycler_view_getter_setter.LEAVE_CLICKED:

                holder.text_Leave.setTextColor(ContextCompat.getColor(context,R.color.yellow));
                holder.text_Absent.setTextColor(ContextCompat.getColor(context,R.color.black));
                holder.text_Present.setTextColor(ContextCompat.getColor(context,R.color.black));

                break;

            default:

                holder.text_Absent.setTextColor(ContextCompat.getColor(context,R.color.red));
                holder.text_Present.setTextColor(ContextCompat.getColor(context,R.color.black));
                holder.text_Leave.setTextColor(ContextCompat.getColor(context,R.color.black));


        }




        // Information current=data.get(position);
        //   holder.title.setText(current.title);

        // holder.title.setText(current.title);


        //Integer.parseInt(view.getTag().toString())



        holder.text_Roll_no.setText("" + item.getRoll_no());
        holder.text_Name.setText("" + item.getName());



    }


    public int getItemCount() {

        return values.size();
    }





//    public void remove(int position){
//
//        values.remove(position);
//        notifyItemRemoved(position);
//
//    }
}

