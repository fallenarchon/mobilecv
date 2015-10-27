package android.joeamrhein.library;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hannesdorfmann.adapterdelegates.AbsAdapterDelegate;
import com.squareup.picasso.Picasso;


public class PlayStoreLinkDelegate extends AbsAdapterDelegate<CVDetail[]> {

    private final Context mContext;
    private final LayoutInflater mInflater;


    public PlayStoreLinkDelegate(Context context, int viewType) {
        super(viewType);
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public boolean isForViewType(@NonNull CVDetail[] items, int position) {
        return items[position] instanceof PlayStoreLink;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new PlayStoreLinkViewHolder(
                mInflater.inflate(R.layout.item_cv_play_store_link, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull CVDetail[] items, int position,
            @NonNull ViewHolder holder) {
        PlayStoreLink t = (PlayStoreLink) items[position];
        PlayStoreLinkViewHolder vh = (PlayStoreLinkViewHolder) holder;

        Picasso.with(mContext).load(t.iconUrl).into(vh.appIcon);
        vh.appName.setText(t.appName);
        vh.itemView.setTag(t.appPackage);

        vh.itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String appPackage = (String) v.getTag();
                if (appPackage == null) {
                    return;
                }

                PlayStoreUtil.openAppPageInPlayStore(mContext, appPackage);
            }
        });
    }


    static class PlayStoreLinkViewHolder extends ViewHolder {

        public ImageView appIcon;
        public TextView appName;


        public PlayStoreLinkViewHolder(View itemView) {
            super(itemView);
            appIcon = (ImageView) itemView.findViewById(R.id.iv_app_icon);
            appName = (TextView) itemView.findViewById(R.id.tv_app_name);
        }
    }
}
