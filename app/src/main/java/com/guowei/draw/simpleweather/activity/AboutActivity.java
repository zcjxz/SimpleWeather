package com.guowei.draw.simpleweather.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.widget.TextView;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.guowei.draw.simpleweather.R;
import com.guowei.draw.simpleweather.utils.AdsDialogUtil;
import com.guowei.draw.simpleweather.utils.ResourcesUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutActivity extends AppCompatActivity {
    @BindView(R.id.adView)
    AdView adView;
    @BindView(R.id.company_name)
    TextView companyName;
    @BindView(R.id.company_email)
    TextView companyEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        AdsDialogUtil.setBannerAds(adView);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);

        SpannableStringBuilder webSpannable = new SpannableStringBuilder("官方网站：www.guowei.com");
        webSpannable.setSpan(new ForegroundColorSpan(ResourcesUtil.getColor(R.color.colorBlue)),
                "官方网站：".length(),
                "官方网站：www.guowei.com".length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        SpannableStringBuilder emailSpannable = new SpannableStringBuilder("官方网站：www.guowei.com");
        emailSpannable.setSpan(new ForegroundColorSpan(ResourcesUtil.getColor(R.color.colorBlue)),
                "官方网站：".length(),
                "官方网站：www.guowei.com".length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        companyEmail.setText(webSpannable);
        companyName.setText(emailSpannable);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
