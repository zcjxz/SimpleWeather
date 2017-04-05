package com.guowei.draw.simpleweather.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.guowei.draw.simpleweather.R;
import com.guowei.draw.simpleweather.bean.CaiForecastBean;
import com.guowei.draw.simpleweather.utils.ResourcesUtil;
import com.guowei.draw.simpleweather.utils.TimeUtil;
import com.guowei.draw.simpleweather.utils.TransformUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.DailyHolder>{
    public CaiForecastBean.ResultBean.DailyBean dailyData;
    private Context context;

    public DailyAdapter(CaiForecastBean.ResultBean.DailyBean dailyBean){
        this.dailyData=dailyBean;
    }
    @Override
    public DailyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.item_daily, parent, false);
        return new DailyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DailyHolder holder, int position) {
        holder.forecastIcon.setImageResource(TransformUtils.transformIcon(dailyData.getSkycon().get(position).getValue()));
        if (position==0){
            holder.forecastDate.setText(ResourcesUtil.getString(R.string.today));
        }else if (position==1){
            holder.forecastDate.setText(ResourcesUtil.getString(R.string.tomorrow));
        }else{
            holder.forecastDate.setText(TimeUtil.getINSTANCE().getTimeFormat("yyyy-MM-dd","dd",dailyData.getSkycon().get(position).getDate())+ResourcesUtil.getString(R.string.day));
        }
        CaiForecastBean.ResultBean.DailyBean.TemperatureBeanX temperature = dailyData.getTemperature().get(position);
        double tempMax = temperature.getMax();
        double tempMin = temperature.getMin();
        holder.forecastTemp.setText(TransformUtils.transformTemp((int)Math.round(tempMax))+"-"+TransformUtils.transformTemp((int)Math.round(tempMin)));
        holder.forecastTxt.setText(
                ResourcesUtil.getString(R.string.air_quality)+" : "+TransformUtils.transformAQI(dailyData.getAqi().get(position).getAvg())+
                        "   "+TransformUtils.transformDirection(dailyData.getWind().get(position).getAvg().getDirection())+
                        " "+TransformUtils.transformSpeed(dailyData.getWind().get(position).getAvg().getSpeed())
        );
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class DailyHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.forecast_icon)
        ImageView forecastIcon;
        @BindView(R.id.forecast_date)
        TextView forecastDate;
        @BindView(R.id.forecast_temp)
        TextView forecastTemp;
        @BindView(R.id.forecast_txt)
        TextView forecastTxt;
        public DailyHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
