package android.joeamrhein.library;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hannesdorfmann.adapterdelegates.AbsAdapterDelegate;


public class SectionTitleDelegate extends AbsAdapterDelegate<CVDetail[]> {

    private final LayoutInflater mInflater;


    public SectionTitleDelegate(LayoutInflater inflater, int viewType) {
        super(viewType);
        mInflater = inflater;
    }


    @Override
    public boolean isForViewType(@NonNull CVDetail[] items, int position) {
        return items[position] instanceof SectionTitle;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new SectionTitleViewHolder(mInflater.inflate(R.layout.item_cv_section_title, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull CVDetail[] items, int position,
            @NonNull ViewHolder holder) {
        SectionTitle t = (SectionTitle) items[position];
        SectionTitleViewHolder vh = (SectionTitleViewHolder) holder;

        vh.sectionTitle.setText(t.sectionTitle);
    }

    static class SectionTitleViewHolder extends ViewHolder {

        public TextView sectionTitle;

        public SectionTitleViewHolder(View itemView) {
            super(itemView);
            sectionTitle = (TextView) itemView;
        }
    }
}
