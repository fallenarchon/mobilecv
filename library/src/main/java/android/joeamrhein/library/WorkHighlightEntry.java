package android.joeamrhein.library;

import android.os.Parcel;


public class WorkHighlightEntry implements CVDetail {

    public final String workHighlightEntry;


    public WorkHighlightEntry(String workHighlightEntry) {
        this.workHighlightEntry = workHighlightEntry;
    }


    public WorkHighlightEntry(Parcel in) {
        workHighlightEntry = in.readString();
    }


    public static final Creator<WorkHighlightEntry> CREATOR = new Creator<WorkHighlightEntry>() {
        @Override
        public WorkHighlightEntry createFromParcel(Parcel source) {
            return new WorkHighlightEntry(source);
        }


        @Override
        public WorkHighlightEntry[] newArray(int size) {
            return new WorkHighlightEntry[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(workHighlightEntry);
    }
}
