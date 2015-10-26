package android.joeamrhein.library;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hannesdorfmann.adapterdelegates.AbsAdapterDelegate;


public class WorkHighlightEntryDelegate extends AbsAdapterDelegate<CVDetail[]> {

    private final LayoutInflater mInflater;


    public WorkHighlightEntryDelegate(LayoutInflater inflater, int viewType) {
        super(viewType);
        mInflater = inflater;
    }


    @Override
    public boolean isForViewType(@NonNull CVDetail[] items, int position) {
        return items[position] instanceof WorkHighlightEntry;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new WorkHighlightEntryViewHolder(mInflater.inflate(R.layout.item_cv_work_highlight_entry, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull CVDetail[] items, int position,
            @NonNull ViewHolder holder) {
        WorkHighlightEntry t = (WorkHighlightEntry) items[position];
        WorkHighlightEntryViewHolder vh = (WorkHighlightEntryViewHolder) holder;

        vh.workHighlightEntry.setText(t.workHighlightEntry);
    }

    static class WorkHighlightEntryViewHolder extends ViewHolder {

        public TextView workHighlightEntry;

        public WorkHighlightEntryViewHolder(View itemView) {
            super(itemView);
            workHighlightEntry = (TextView) itemView;
        }
    }
}
