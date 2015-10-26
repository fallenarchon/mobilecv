package android.joeamrhein.library;

import android.content.Context;
import android.view.LayoutInflater;

import com.hannesdorfmann.adapterdelegates.AbsDelegationAdapter;


public class CVDetailAdapter extends AbsDelegationAdapter<CVDetail[]> {

    public static final int SECTION_TITLE_VIEW_TYPE = 0;
    public static final int COMPANY_TITLE_VIEW_TYPE = 1;
    public static final int WORK_HIGHLIGHT_ENTRY_VIEW_TYPE = 2;
    public static final int EDUCATION_ENTRY_VIEW_TYPE = 3;


    public CVDetailAdapter(Context context, CVDetail[] items) {
        super();
        this.items = items;
        LayoutInflater inflater = LayoutInflater.from(context);
        delegatesManager.addDelegate(new SectionTitleDelegate(inflater, SECTION_TITLE_VIEW_TYPE));
        delegatesManager.addDelegate(new CompanyTitleDelegate(inflater, COMPANY_TITLE_VIEW_TYPE));
        delegatesManager.addDelegate(new WorkHighlightEntryDelegate(inflater, WORK_HIGHLIGHT_ENTRY_VIEW_TYPE));
        delegatesManager.addDelegate(new EducationEntryDelegate(inflater, EDUCATION_ENTRY_VIEW_TYPE));
    }


    @Override
    public int getItemCount() {
        return items == null ? 0 : items.length;
    }
}
