package android.joeamrhein.library;

import android.os.Parcel;


public class CompanyTitle implements CVDetail {

    public final String companyName;
    public final int startYear;
    public final int endYear;
    public final boolean isCurrentCompany;


    public CompanyTitle(String companyName, int startYear) {
        this.companyName = companyName;
        this.startYear = startYear;
        this.endYear = -1;
        this.isCurrentCompany = true;
    }


    public CompanyTitle(String companyName, int startYear, int endYear) {
        this.companyName = companyName;
        this.startYear = startYear;
        this.endYear = endYear;
        this.isCurrentCompany = false;
    }

    public CompanyTitle(Parcel in) {
        companyName = in.readString();
        startYear = in.readInt();
        endYear = in.readInt();
        isCurrentCompany = in.readInt() == 1;
    }


    public static final Creator<CompanyTitle> CREATOR = new Creator<CompanyTitle>() {
        @Override
        public CompanyTitle createFromParcel(Parcel source) {
            return new CompanyTitle(source);
        }


        @Override
        public CompanyTitle[] newArray(int size) {
            return new CompanyTitle[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(companyName);
        dest.writeInt(startYear);
        dest.writeInt(endYear);
        dest.writeInt(isCurrentCompany ? 1 : 0);
    }
}
