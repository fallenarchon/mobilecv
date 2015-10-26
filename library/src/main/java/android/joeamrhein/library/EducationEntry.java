package android.joeamrhein.library;

import android.os.Parcel;


public class EducationEntry implements CVDetail {

    public final String accolade;
    public final String institution;
    public final int completionYear;


    public EducationEntry(String accolade, String institution, int completionYear) {
        this.accolade = accolade;
        this.institution = institution;
        this.completionYear = completionYear;
    }

    public EducationEntry(Parcel in) {
        accolade = in.readString();
        institution = in.readString();
        completionYear = in.readInt();
    }


    public static final Creator<EducationEntry> CREATOR = new Creator<EducationEntry>() {
        @Override
        public EducationEntry createFromParcel(Parcel source) {
            return new EducationEntry(source);
        }


        @Override
        public EducationEntry[] newArray(int size) {
            return new EducationEntry[size];
        }
    };
    

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(accolade);
        dest.writeString(institution);
        dest.writeInt(completionYear);
    }
}
