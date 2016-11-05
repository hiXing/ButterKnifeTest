package com.hizhx.butterknifetest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * TODO
 * Created by hiXing on 2016/11/5.
 */

public class MyListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private LayoutInflater mInflater;
    private List<String> mDatas;

    private boolean mShowFooter = true;

    public MyListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }
    public void setListData(List<String> datas){
        this.mDatas = datas;
        this.notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==0){
            View view = mInflater.inflate(R.layout.list_item,parent,false);

            return new ItemViewHolder(view);
        }else {
            View view = mInflater.inflate(R.layout.list_footer,null);

            return new FooterViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ItemViewHolder){
            ItemViewHolder viewHolder = (ItemViewHolder) holder;
            viewHolder.textView.setText(mDatas.get(position));
        }
    }

    @Override
    public int getItemCount() {
        int begin = mShowFooter?1:0;
        if(mDatas == null) {
            return begin;
        }
        return mDatas.size() + begin;
    }

    @Override
    public int getItemViewType(int position) {
        if(!mShowFooter){
            return 0;
        }
        if(position+1 ==getItemCount()){
            return 22;
        }else
        return 0;
//        return super.getItemViewType(position);
    }
    void isShowFooter(boolean isShow){
        this.mShowFooter = isShow;
    }
    boolean isShowFooter(){
        return this.mShowFooter;
    }

    private static class ItemViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.item_imageView)
        ImageView imageView;
        @BindView(R.id.item_textView)
        TextView textView;
        ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    private static class FooterViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.footer_textView)
        TextView footerTv;
        @BindView(R.id.footer_progressBar)
        ProgressBar footerPb;
        public FooterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
