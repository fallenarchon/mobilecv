package android.joeamrhein.library;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hannesdorfmann.adapterdelegates.AbsAdapterDelegate;


public class CompanyTitleDelegate extends AbsAdapterDelegate<CVDetail[]> {

    private final LayoutInflater mInflater;


    public CompanyTitleDelegate(LayoutInflater inflater, int viewType) {
        super(viewType);
        mInflater = inflater;
    }


    @Override
    public boolean isForViewType(@NonNull CVDetail[] items, int position) {
        return items[position] instanceof CompanyTitle;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new CompanyTitleViewHolder(mInflater.inflate(R.layout.item_cv_company_title,
                parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull CVDetail[] items, int position,
            @NonNull ViewHolder holder) {
        CompanyTitle t = (CompanyTitle) items[position];
        CompanyTitleViewHolder vh = (CompanyTitleViewHolder) holder;

        vh.companyName.setText(t.companyName);
        vh.serviceDuration.setText("[" + t.startYear + " - " + (t.isCurrentCompany ? "Present" : t.endYear) + "]");
    }

    static class CompanyTitleViewHolder extends ViewHolder {

        public TextView companyName;
        public TextView serviceDuration;

        public CompanyTitleViewHolder(View itemView) {
            super(itemView);
            companyName= (TextView) itemView.findViewById(R.id.tv_company_title);
            serviceDuration = (TextView) itemView.findViewById(R.id.tv_service_duration);
        }
    }
}
