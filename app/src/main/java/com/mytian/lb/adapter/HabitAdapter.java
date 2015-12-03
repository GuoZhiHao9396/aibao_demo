package com.mytian.lb.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.core.util.CommonUtil;
import com.mytian.lb.R;
import com.mytian.lb.bean.AgreementBean;
import com.mytian.lb.enums.ItemButton;
import com.mytian.lb.helper.AnimationHelper;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HabitAdapter extends BaseAdapter {

    private LayoutInflater mInflater;

    private ArrayList<AgreementBean> list;

    private Context mContext;

    public HabitAdapter(Context context, ArrayList<AgreementBean> _list) {
        this.list = _list;
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        /**
         * 因为listview header 在adapter count <= 0 时是跟随listview一起隐藏的 ，
         * 为让 header 一直保持显示设置 1 个空占位。
         */
        return null == list ? 1 : list.size() + 1;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public void refresh(ArrayList<AgreementBean> _list) {
        list = _list;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_habit, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        /**
         * 为让 header 一直保持显示设置 1 个空占位。
         * 所以 position 需要 减掉 1 。
         */
        if (getCount()==1) {
            convertView.setVisibility(View.GONE);
            return convertView;
        }else{
            position = position -1;
            if(position<0){
                position = 0;
            }
        }

        AgreementBean bean = list.get(position);
        Glide.with(mContext).load(bean.getIcon()).asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.ALL).into(viewHolder.head);
        viewHolder.name.setText(bean.getTitle());

        int record = bean.getRecord();
        if (record == AgreementBean.GREAT) {
            setIconInfo(viewHolder.like, ItemButton.RECORD_LIKE, true);
            setIconInfo(viewHolder.dislike, ItemButton.RECORD_DISLIKE, false);
        } else if (record == AgreementBean.BAD) {
            setIconInfo(viewHolder.like, ItemButton.RECORD_LIKE, false);
            setIconInfo(viewHolder.dislike, ItemButton.RECORD_DISLIKE, true);
        } else {
            setIconInfo(viewHolder.like, ItemButton.RECORD_LIKE, false);
            setIconInfo(viewHolder.dislike, ItemButton.RECORD_DISLIKE, false);
        }
        viewHolder.like.setTag(R.id.item_habit_index, position);
        viewHolder.like.setTag(R.id.item_habit_view, viewHolder.dislike);
        viewHolder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationHelper.getInstance().viewAnimationScal(v);
                CommonUtil.showToast("记录成功");
                int index = (int) v.getTag(R.id.item_habit_index);
                ImageView dislike = (ImageView) v.getTag(R.id.item_habit_view);
                list.get(index).setRecord(AgreementBean.GREAT);
                setIconInfo((ImageView) v, ItemButton.RECORD_LIKE, true);
                setIconInfo(dislike, ItemButton.RECORD_DISLIKE, false);
            }
        });
        viewHolder.dislike.setTag(R.id.item_habit_index, position);
        viewHolder.dislike.setTag(R.id.item_habit_view, viewHolder.like);
        viewHolder.dislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationHelper.getInstance().viewAnimationScal(v);
                CommonUtil.showToast("记录成功");
                int index = (int) v.getTag(R.id.item_habit_index);
                ImageView like = (ImageView) v.getTag(R.id.item_habit_view);
                list.get(index).setRecord(AgreementBean.BAD);
                setIconInfo((ImageView) v, ItemButton.RECORD_DISLIKE, true);
                setIconInfo(like, ItemButton.RECORD_LIKE, false);
            }
        });

        return convertView;
    }

    private void setIconInfo(ImageView imageView, ItemButton menu, boolean is) {
        if (is) {
            imageView.setImageResource(menu.getResid_press());
        } else {
            imageView.setImageResource(menu.getResid_normal());
        }
    }


    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'item_habit.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
     */
    static class ViewHolder {
        @Bind(R.id.head)
        ImageView head;
        @Bind(R.id.name)
        TextView name;
        @Bind(R.id.like)
        ImageView like;
        @Bind(R.id.dislike)
        ImageView dislike;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}