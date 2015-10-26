package android.joeamrhein.library;

import android.os.Parcel;


public class SectionTitle implements CVDetail {

    public final String sectionTitle;


    public SectionTitle(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }


    public SectionTitle(Parcel in) {
        sectionTitle = in.readString();
    }


    public static final Creator<SectionTitle> CREATOR = new Creator<SectionTitle>() {
        @Override
        public SectionTitle createFromParcel(Parcel source) {
            return new SectionTitle(source);
        }


        @Override
        public SectionTitle[] newArray(int size) {
            return new SectionTitle[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sectionTitle);
    }
}
