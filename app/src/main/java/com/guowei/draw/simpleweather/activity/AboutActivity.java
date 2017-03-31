package com.guowei.draw.simpleweather.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.guowei.draw.simpleweather.R;
import com.guowei.draw.simpleweather.utils.AdsDialogUtil;
import com.guowei.draw.simpleweather.utils.ResourcesUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.adView)
    AdView adView;
    @BindView(R.id.company_name)
    TextView companyName;
    @BindView(R.id.company_email)
    TextView companyEmail;
    @BindView(R.id.official_website)
    FrameLayout officialWebsite;
    @BindView(R.id.official_email)
    FrameLayout officialEmail;
    private String website;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        AdsDialogUtil.setBannerAds(adView);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        String official_website = ResourcesUtil.getString(R.string.official_website);
        website = ResourcesUtil.getString(R.string.website);
        SpannableStringBuilder webSpannable = new SpannableStringBuilder(official_website +" : "+ website);
        webSpannable.setSpan(new ForegroundColorSpan(ResourcesUtil.getColor(R.color.colorBlue)),
                (official_website+" : ").length(),
                webSpannable.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        String official_email = ResourcesUtil.getString(R.string.official_email);
        email = ResourcesUtil.getString(R.string.email);
        SpannableStringBuilder emailSpannable = new SpannableStringBuilder(official_email+" : "+ email);
        emailSpannable.setSpan(new ForegroundColorSpan(ResourcesUtil.getColor(R.color.colorBlue)),
                (official_email+"").length(),
                emailSpannable.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        companyEmail.setText(emailSpannable);
        companyName.setText(webSpannable);
        officialWebsite.setOnClickListener(this);
        officialEmail.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        switch (viewId){
            case R.id.official_website:
                Intent websiteIntent = new Intent();
                websiteIntent.setAction(Intent.ACTION_VIEW);
                Uri websiteUri = Uri.parse(website);
                websiteIntent.setData(websiteUri);
                startActivity(websiteIntent);
                break;
            case R.id.official_email:
                Intent emailIntent=new Intent();
                emailIntent.setAction(Intent.ACTION_SENDTO);
                Uri emailUri = Uri.parse("mailto:"+email);
                emailIntent.setData(emailUri);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(emailIntent);
                break;
        }
    }
}
