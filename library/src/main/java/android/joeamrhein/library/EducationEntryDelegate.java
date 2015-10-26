package android.joeamrhein.library;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hannesdorfmann.adapterdelegates.AbsAdapterDelegate;


public class EducationEntryDelegate extends AbsAdapterDelegate<CVDetail[]> {

    private final LayoutInflater mInflater;


    public EducationEntryDelegate(LayoutInflater inflater, int viewType) {
        super(viewType);
        mInflater = inflater;
    }


    @Override
    public boolean isForViewType(@NonNull CVDetail[] items, int position) {
        return items[position] instanceof EducationEntry;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new EducationEntryViewHolder(mInflater.inflate(R.layout.item_cv_education_entry, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull CVDetail[] items, int position,
            @NonNull ViewHolder holder) {
        EducationEntry t = (EducationEntry) items[position];
        EducationEntryViewHolder vh = (EducationEntryViewHolder) holder;

        vh.accolade.setText(t.accolade);
        vh.institution.setText(t.institution);
        vh.completionYear.setText("[" + t.completionYear + "]");
    }

    static class EducationEntryViewHolder extends ViewHolder {

        public TextView accolade;
        public TextView institution;
        public TextView completionYear;

        public EducationEntryViewHolder(View itemView) {
            super(itemView);
            accolade = (TextView) itemView.findViewById(R.id.tv_accolade);
            institution = (TextView) itemView.findViewById(R.id.tv_education_institution);
            completionYear = (TextView) itemView.findViewById(R.id.tv_completion_year);
        }
    }
}
