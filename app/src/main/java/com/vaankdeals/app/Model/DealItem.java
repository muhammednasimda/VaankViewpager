package com.vaankdeals.app.Model;

public class DealItem {
private String mDealTitle;
    private String mDealImage;
public DealItem (){

    }

    public String getmDealTitle() {
        return mDealTitle;
    }

    public void setmDealTitle(String mDealTitle) {
        this.mDealTitle = mDealTitle;
    }

    public String getmDealImage() {
        return mDealImage;
    }

    public void setmDealImage(String mDealImage) {
        this.mDealImage = mDealImage;
    }

    public DealItem(String dealtitle, String dealimage)
{
    mDealTitle =dealtitle;
    mDealImage =dealimage;
}


}
