package com.guowei.draw.simpleweather.adapter;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guowei.draw.simpleweather.R;
import com.guowei.draw.simpleweather.bean.CaiForecastBean;
import com.guowei.draw.simpleweather.utils.DensityUtil;
import com.guowei.draw.simpleweather.utils.TimeUtil;
import com.guowei.draw.simpleweather.utils.TransformUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HourlyAdapter extends RecyclerView.Adapter<HourlyAdapter.HourlyHolder>{
    public CaiForecastBean.ResultBean.HourlyBean hourlyData;
    private Context context;
    private Resources resources;

    public HourlyAdapter(CaiForecastBean.ResultBean.HourlyBean hourlyData){
        this.hourlyData=hourlyData;
    }

    @Override
    public HourlyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.item_hourly, parent, false);
        return new HourlyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HourlyHolder holder, int position) {
        resources = context.getResources();
        int drawableWidth = DensityUtil.dip2px(20);
        Drawable timeDrawable = resources.getDrawable(R.drawable.icon_time);
        timeDrawable.setBounds(0,0, drawableWidth,drawableWidth);
        Drawable tempDrawable = resources.getDrawable(R.drawable.icon_temp);
        tempDrawable.setBounds(0,0, drawableWidth,drawableWidth);
        Drawable windDrawable = resources.getDrawable(R.drawable.wind);
        windDrawable.setBounds(0,0, drawableWidth,drawableWidth);
        String skyconString = hourlyData.getSkycon().get(position).getValue();
        int skyconId = TransformUtils.transformIcon(skyconString);
        Drawable skyconDrawable = resources.getDrawable(skyconId);
        skyconDrawable.setBounds(0,0,drawableWidth,drawableWidth);
        holder.time.setText(TimeUtil.getINSTANCE().getTime(hourlyData.getSkycon().get(position).getDatetime()));
        holder.time.setCompoundDrawables(timeDrawable,null,null,null);
        holder.template.setText(TransformUtils.transformTemp(
                (int) Math.round(
                        hourlyData.getTemperature().get(position).getValue()
                    )
                )
        );
        holder.template.setCompoundDrawables(tempDrawable,null,null,null);
        holder.skycon.setText(TransformUtils.transformSkycon(skyconString));
        holder.skycon.setCompoundDrawables(skyconDrawable,null,null,null);
        holder.wind.setText(TransformUtils.transformSpeed(hourlyData.getWind().get(position).getSpeed()));
        holder.wind.setCompoundDrawables(windDrawable,null,null,null);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class HourlyHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.hourly_time)
        TextView time;
        @BindView(R.id.hourly_template)
        TextView template;
        @BindView(R.id.hourly_skycon)
        TextView skycon;
        @BindView(R.id.hourly_wind)
        TextView wind;

        public HourlyHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
