package android.joeamrhein.library;

import android.os.Parcel;


public class PlayStoreLink implements CVDetail {

    public final String iconUrl;
    public final String appName;
    public final String appPackage;


    public PlayStoreLink(String iconUrl, String appName, String appPackage) {
        this.iconUrl = iconUrl;
        this.appName = appName;
        this.appPackage = appPackage;
    }

    public PlayStoreLink(Parcel in) {
        iconUrl = in.readString();
        appName = in.readString();
        appPackage = in.readString();
    }


    public static final Creator<PlayStoreLink> CREATOR = new Creator<PlayStoreLink>() {
        @Override
        public PlayStoreLink createFromParcel(Parcel source) {
            return new PlayStoreLink(source);
        }


        @Override
        public PlayStoreLink[] newArray(int size) {
            return new PlayStoreLink[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(iconUrl);
        dest.writeString(appName);
        dest.writeString(appPackage);
    }
}
