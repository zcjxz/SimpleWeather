package com.guowei.draw.simpleweather.base;


import android.support.v4.app.Fragment;

public abstract class BaseFragment extends Fragment{
    protected boolean isVisible=false;
    protected boolean isPrepared=false;
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()){
            isVisible=true;
            onVisible();
        }else{
            isVisible=false;
            onInvisible();
        }
    }

    protected void onVisible(){
        if (isPrepared&&isVisible){
            lazyLoad();
        }
    }
    protected void onInvisible(){

    }

    /**
     * 懒加载数据
     * 使用说明：
     * 要重写onActivityCreate，把isPrepared设置为true
     */
    protected abstract void lazyLoad();
}
