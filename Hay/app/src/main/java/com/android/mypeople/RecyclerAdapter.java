package com.android.mypeople;

import android.app.ListActivity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{
    String TAG = "RecyclerAdapter";
    String TAG2 = "RecyclerAdapter 체크";

    private ArrayList<Bean_friendslist> mDataset = null;
    ArrayList<Bean_friendslist> unFilteredlist = null;
    ArrayList<Bean_friendslist> filteredList = null;
    Context context;




//    @Override
//    public Filter getFilter() {
//        return new Filter() {
//            @Override
//            protected FilterResults performFiltering(CharSequence constraint) {
//                FilterResults results = new FilterResults();
//
////                String charString = constraint.toString();
////                if(constraint == null || constraint.length() == 0) {
////                    Log.v(TAG2," results-1 : " + constraint);
////                    mDataset = unFilteredlist;
//////                    results.values = listViewItemList ;
//////                    results.count = listViewItemList.size() ;
////                    Log.v(TAG2," results0 : ");
////                } else {
////                    ArrayList<Bean_friendslist> filteringList = new ArrayList<>();
////                    for(Bean_friendslist name : mDataset) {
////                        Log.v(TAG2," results99 : " + constraint);
////                        if(name.getfName().contains(charString)) {
////                            filteringList.add(name);
////                            Log.v(TAG2," results1 : " + name.getfName());
////                        }
////                    }
////                    mDataset = filteringList;
////                }
////                FilterResults filterResults = new FilterResults();
////                filterResults.values = mDataset;
//
//                if (constraint == null || constraint.length() == 0) {
//                    results.values = mDataset;
//                    results.count = mDataset.size();
//                } else {
//                    ArrayList<Bean_friendslist> itemList = new ArrayList<Bean_friendslist>();
//
//                    for (Bean_friendslist item : mDataset) {
//                        if (item.getfName().contains(constraint.toString()) ||
//                                item.getfComment().contains(constraint.toString())) {
//                            itemList.add(item);
//                        }
//                    }
//                    results.values = itemList;
//                    results.count = itemList.size();
//                }
//                return results;
//            }
//            @Override
//            protected void publishResults(CharSequence constraint, FilterResults results) {
//                filteredList = (ArrayList<Bean_friendslist>) results.values;
//                Log.v(TAG2," results2 : " + results);
//                Log.v(TAG2," results3 : " + (ArrayList<Bean_friendslist>) results.values);
//                notifyDataSetChanged();
//            }
//        };
//    }


    //------------------Click Event------------------
    public interface OnItemClickListener{
        void onItemClick(View v, int position);
    }

    private OnItemClickListener mListener = null;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
        Log.v(TAG2, "setOnItemClickListener2");
    }
    //------------------Click Event------------------


    public class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView tag_1;
        public ImageView tag_2;
        public ImageView tag_3;
        public CircleImageView photo;
        public TextView name;
        public TextView relation;
        public TextView comment;

        MyViewHolder(View v) {
            super(v);
            Log.v(TAG2, "MyViewHolder5");


            tag_1 = v.findViewById(R.id.main_ImgV_tag1);
            tag_2 = v.findViewById(R.id.main_ImgV_tag2);
            tag_3 = v.findViewById(R.id.main_ImgV_tag3);
            photo = v.findViewById(R.id.main_ImgV_Photo);
            name = v.findViewById(R.id.main_Text_Name);
            relation = v.findViewById(R.id.main_Text_Realtion);
            comment = v.findViewById(R.id.main_Text_Comment);


            //--------------------Click Event--------------------
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.v(TAG2, "MyViewHolder onClick");

                    int position=getAdapterPosition();//어뎁터 포지션값
                    // 뷰홀더에서 사라지면 NO_POSITION 을 리턴
                    if(position!=RecyclerView.NO_POSITION){
                        if(mListener !=null){
                            mListener.onItemClick(view,position);
                        }
                    }
                }
            });
            //---------------------Click Event---------------------

        }
    }

    // 메인 액티비티에서 받은 myDataset을 가져오
    public RecyclerAdapter(MainActivity mainActivity, int member, ArrayList<Bean_friendslist> myDataset) {
        mDataset = myDataset;
        this.filteredList = myDataset;
        this.unFilteredlist = myDataset;
        Log.v(TAG2, "RecyclerAdapter1");
//
    }

    public RecyclerAdapter(Context context, ArrayList<Bean_friendslist> list) {
        super();
        this.context = context;
        this.mDataset = list;
        this.filteredList = list;
        this.unFilteredlist = list;
    }


    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.v(TAG2, "onCreateViewHolder4");
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_recycler_items, parent, false);
        //     반복할 xml 파일
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // 표시하는 메소드
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Log.v(TAG2, "onBindViewHolder6");
        Log.v(TAG, "구간 1 -----------------");
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        //데이터를 받은걸 올리기

        int tagTot = 0;
        int choose1 = mDataset.get(position).getfTag1();
        int choose2 = mDataset.get(position).getfTag2();
        int choose3 = mDataset.get(position).getfTag3();
        int choose4 = mDataset.get(position).getfTag4();
        int choose5 = mDataset.get(position).getfTag5();
        ArrayList<Integer> temp = new ArrayList<Integer>();

        if(choose1 == 1){
            temp.add(1);
        }
        if(choose2 == 1){
            temp.add(2);
        }
        if(choose3 == 1){
            temp.add(3);
        }
        if(choose4 == 1){
            temp.add(4);
        }
        if(choose5 == 1){
            temp.add(5);
        }

        tagTot = temp.size();
        Log.v("Recycler", "초기 temp size : " + String.valueOf(tagTot));
        int switchNum = 0;
        switch (tagTot){ // 태그 개수에 따른 분류

            // 저장된 태그가 1개일 때-------------------------------------------------
            case 1:
                if(temp.get(0) == 1){
                    holder.tag_1.setImageResource(R.drawable.main_spinner_tag1);
                }
                if(temp.get(0) == 2){
                    holder.tag_1.setImageResource(R.drawable.main_spinner_tag2);
                }
                if(temp.get(0) == 3){
                    holder.tag_1.setImageResource(R.drawable.main_spinner_tag3);
                }
                if(temp.get(0) == 4){
                    holder.tag_1.setImageResource(R.drawable.main_spinner_tag4);
                }
                if(temp.get(0) == 5){
                    holder.tag_1.setImageResource(R.drawable.main_spinner_tag5);
                }

                break;

            // 저장된 태그가 2개일 때-------------------------------------------------
            case 2:
                Log.v("Recycler", "태그 2개일 때 >> 이름 : " + mDataset.get(position).getfName() + " Temp size : " + temp.size() + " Temp 최초값 : " + temp);
                if(temp.get(0) == 1){
                    holder.tag_1.setImageResource(R.drawable.main_spinner_tag1);
                    switchNum = 1;
                    temp.remove(0);
                    Log.v("Recycler", "Temp1 : " + temp);
                }else if(switchNum == 0){
                    if(temp.get(0) == 2){
                        holder.tag_1.setImageResource(R.drawable.main_spinner_tag2);
                        switchNum = 1;
                        temp.remove(0);
                        Log.v("Recycler", "Temp2 : " + temp);
                    }else{
                        if(temp.get(0) == 3){
                            Log.v("Recycler", "Temp3 before : " + temp);
                            holder.tag_1.setImageResource(R.drawable.main_spinner_tag3);
                            switchNum = 1;
                            temp.remove(0);
                            Log.v("Recycler", "Temp3 after : " + temp);
                        }else{
                            if(temp.get(0) == 4){
                                holder.tag_1.setImageResource(R.drawable.main_spinner_tag4);
                                switchNum = 1;
                                temp.remove(0);
                                Log.v("Recycler", "Temp4 : " + temp);
                            }else{
                                if(temp.get(0) == 5){
                                    holder.tag_1.setImageResource(R.drawable.main_spinner_tag5);
                                    switchNum = 1;
                                    temp.remove(0);
                                    Log.v("Recycler", "Temp5 : " + temp);
                                }
                            }
                        }
                    }
                }
                switchNum = 0;
                if(temp.get(0) == 1){
                    Log.v("Recycler", "2번째 Temp1 before : " + temp);
                    holder.tag_2.setImageResource(R.drawable.main_spinner_tag1);
                    switchNum = 1;
                    temp.remove(0);
                    Log.v("Recycler", "2번째 Temp1 after : " + temp);
                }else if(switchNum == 0){
                    if(temp.get(0) == 2){
                        Log.v("Recycler", "2번째 Temp2 before : " + temp);
                        holder.tag_2.setImageResource(R.drawable.main_spinner_tag2);
                        switchNum = 1;
                        temp.remove(0);
                        Log.v("Recycler", "2번째 Temp2 after : " + temp);
                    }else{
                        if(temp.get(0) == 3){
                            Log.v("Recycler", "2번째 Temp3 before : " + temp);
                            holder.tag_2.setImageResource(R.drawable.main_spinner_tag3);
                            switchNum = 1;
                            temp.remove(0);
                            Log.v("Recycler", "2번째 Temp3 after : " + temp);
                        }else{
                            if(temp.get(0) == 4){
                                Log.v("Recycler", "2번째 Temp4 before : " + temp);
                                holder.tag_2.setImageResource(R.drawable.main_spinner_tag4);
                                switchNum = 1;
                                temp.remove(0);
                                Log.v("Recycler", "2번째 Temp4 after : " + temp);
                            }else{
                                if(temp.get(0) == 5){
                                    Log.v("Recycler", "2번째 Temp5 before : " + temp);
                                    holder.tag_2.setImageResource(R.drawable.main_spinner_tag5);
                                    switchNum = 1;
                                    temp.remove(0);
                                    Log.v("Recycler", "2번째 Temp5 after : " + temp);
                                }
                            }
                        }
                    }
                }
                break;

            // 저장된 태그가 3개일 때-------------------------------------------------
            case 3:
                Log.v("Recycler", "태그 3개일 때 !! > 이름 : " + mDataset.get(position).getfName() + " Temp size : " + temp.size() + " Temp 최초값 : " + temp);
                if(temp.get(0) == 1){
                    holder.tag_1.setImageResource(R.drawable.main_spinner_tag1);
                    switchNum = 1;
                    temp.remove(0);
                    Log.v("Recycler", "Temp1 : " + temp);
                }else if(switchNum == 0){
                    if(temp.get(0) == 2){
                        holder.tag_1.setImageResource(R.drawable.main_spinner_tag2);
                        switchNum = 1;
                        temp.remove(0);
                        Log.v("Recycler", "Temp2 : " + temp);
                    }else{
                        if(temp.get(0) == 3){
                            Log.v("Recycler", "Temp3 before : " + temp);
                            holder.tag_1.setImageResource(R.drawable.main_spinner_tag3);
                            switchNum = 1;
                            temp.remove(0);
                            Log.v("Recycler", "Temp3 after : " + temp);
                        }else{
                            if(temp.get(0) == 4){
                                holder.tag_1.setImageResource(R.drawable.main_spinner_tag4);
                                switchNum = 1;
                                temp.remove(0);
                                Log.v("Recycler", "Temp4 : " + temp);
                            }else{
                                if(temp.get(0) == 5){
                                    holder.tag_1.setImageResource(R.drawable.main_spinner_tag5);
                                    switchNum = 1;
                                    temp.remove(0);
                                    Log.v("Recycler", "Temp5 : " + temp);
                                }
                            }
                        }
                    }
                }
                switchNum = 0;
                if(temp.get(0) == 1){
                    Log.v("Recycler", "2번째 Temp1 before : " + temp);
                    holder.tag_2.setImageResource(R.drawable.main_spinner_tag1);
                    switchNum = 1;
                    temp.remove(0);
                    Log.v("Recycler", "2번째 Temp1 after : " + temp);
                }else if(switchNum == 0){
                    if(temp.get(0) == 2){
                        Log.v("Recycler", "2번째 Temp2 before : " + temp);
                        holder.tag_2.setImageResource(R.drawable.main_spinner_tag2);
                        switchNum = 1;
                        temp.remove(0);
                        Log.v("Recycler", "2번째 Temp2 after : " + temp);
                    }else{
                        if(temp.get(0) == 3){
                            Log.v("Recycler", "2번째 Temp3 before : " + temp);
                            holder.tag_2.setImageResource(R.drawable.main_spinner_tag3);
                            switchNum = 1;
                            temp.remove(0);
                            Log.v("Recycler", "2번째 Temp3 after : " + temp);
                        }else{
                            if(temp.get(0) == 4){
                                Log.v("Recycler", "2번째 Temp4 before : " + temp);
                                holder.tag_2.setImageResource(R.drawable.main_spinner_tag4);
                                switchNum = 1;
                                temp.remove(0);
                                Log.v("Recycler", "2번째 Temp4 after : " + temp);
                            }else{
                                if(temp.get(0) == 5){
                                    Log.v("Recycler", "2번째 Temp5 before : " + temp);
                                    holder.tag_2.setImageResource(R.drawable.main_spinner_tag5);
                                    switchNum = 1;
                                    temp.remove(0);
                                    Log.v("Recycler", "2번째 Temp5 after : " + temp);
                                }
                            }
                        }
                    }
                }
                switchNum = 0;
                if(temp.get(0) == 1){
                    Log.v("Recycler", "3번째 Temp1 before : " + temp);
                    holder.tag_3.setImageResource(R.drawable.main_spinner_tag1);
                    switchNum = 1;
                    temp.remove(0);
                    Log.v("Recycler", "3번째 Temp1 after : " + temp);
                }else if(switchNum == 0){
                    if(temp.get(0) == 2){
                        Log.v("Recycler", "3번째 Temp2 before : " + temp);
                        holder.tag_3.setImageResource(R.drawable.main_spinner_tag2);
                        switchNum = 1;
                        temp.remove(0);
                        Log.v("Recycler", "3번째 Temp2 after : " + temp);
                    }else{
                        if(temp.get(0) == 3){
                            Log.v("Recycler", "3번째 Temp3 before : " + temp);
                            holder.tag_3.setImageResource(R.drawable.main_spinner_tag3);
                            switchNum = 1;
                            temp.remove(0);
                            Log.v("Recycler", "3번째 Temp3 after : " + temp);
                        }else{
                            if(temp.get(0) == 4){
                                Log.v("Recycler", "3번째 Temp4 before : " + temp);
                                holder.tag_3.setImageResource(R.drawable.main_spinner_tag4);
                                switchNum = 1;
                                temp.remove(0);
                                Log.v("Recycler", "3번째 Temp4 after : " + temp);
                            }else{
                                if(temp.get(0) == 5){
                                    Log.v("Recycler", "3번째 Temp5 before : " + temp);
                                    holder.tag_3.setImageResource(R.drawable.main_spinner_tag5);
                                    switchNum = 1;
                                    temp.remove(0);
                                    Log.v("Recycler", "3번째 Temp5 after : " + temp);
                                }
                            }
                        }
                    }
                }
                break;
        }
        Log.v("Recycler", "Temp end: " + temp);

        holder.photo.setImageResource(R.drawable.testimg);
        holder.name.setText(mDataset.get(position).getfName());
        holder.relation.setText(mDataset.get(position).getfRelation());
        holder.comment.setText(mDataset.get(position).getfComment());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        Log.v(TAG2, "getItemCount3");

//        if(mDataset == null){
//            return filteredList.size();
//        }

        return mDataset.size();
    }




}