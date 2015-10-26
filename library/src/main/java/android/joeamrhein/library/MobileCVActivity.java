package android.joeamrhein.library;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class MobileCVActivity extends AppCompatActivity {


    private static final String EXTRA_NAME = "android.joeamrhein.library.MobileCVActivity.name";
    private static final String EXTRA_HERO_IMG_URL = "android.joeamrhein.library.MobileCVActivity.heroImgUrl";
    private static final String EXTRA_CV_DETAILS = "android.joeamrhein.library.MobileCVActivity.cvDetails";


    public static Intent createIntent(Context context, String name, String heroImageUrl,
            ArrayList<CVDetail> details) {
        Intent i = new Intent(context, MobileCVActivity.class);

        i.putExtra(EXTRA_NAME, name);
        i.putExtra(EXTRA_HERO_IMG_URL, heroImageUrl);
        i.putParcelableArrayListExtra(EXTRA_CV_DETAILS, details);

        return i;
    }


    private static final String TAG = MobileCVActivity.class.getSimpleName();

    private CollapsingToolbarLayout mCollapsingToolbarLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivityTransitions();
        setContentView(R.layout.activity_mobile_cv);

        ViewCompat.setTransitionName(findViewById(R.id.app_bar_layout), EXTRA_NAME);
        supportPostponeEnterTransition();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = null;

        if (getIntent() != null) {
            extras = getIntent().getExtras();
        }


        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        if (extras != null) {
            mCollapsingToolbarLayout.setTitle(extras.getString(EXTRA_NAME, ""));
            mCollapsingToolbarLayout
                    .setExpandedTitleColor(getResources().getColor(android.R.color.transparent));


            final ImageView image = (ImageView) findViewById(R.id.image);
            Picasso.with(this).load(extras.getString(EXTRA_HERO_IMG_URL, ""))
                    .into(image, new Callback() {
                        @Override
                        public void onSuccess() {
                            Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
                            Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                                public void onGenerated(Palette palette) {
                                    applyPalette(palette);
                                }
                            });
                        }


                        @Override
                        public void onError() {
                            Log.d(TAG, "error fetching hero image");
                        }
                    });

            RecyclerView rv = (RecyclerView) findViewById(R.id.rv_cv);
            rv.setLayoutManager(new LinearLayoutManager(this));
            ArrayList<CVDetail> details = extras.getParcelableArrayList(EXTRA_CV_DETAILS);

            if (details != null) {
                CVDetail[] detailArray = new CVDetail[details.size()];
                details.toArray(detailArray);
                rv.setAdapter(new CVDetailAdapter(this, detailArray));
            }

        }
    }


    private void initActivityTransitions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide transition = new Slide();
            transition.excludeTarget(android.R.id.statusBarBackground, true);
            getWindow().setEnterTransition(transition);
            getWindow().setReturnTransition(transition);
        }
    }


    private void applyPalette(Palette palette) {
        Resources resources = getResources();
        int primaryDark = resources.getColor(android.R.color.black);
        int primary = resources.getColor(android.R.color.darker_gray);
        mCollapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(primary));
        mCollapsingToolbarLayout.setStatusBarScrimColor(palette.getDarkMutedColor(primaryDark));
        supportStartPostponedEnterTransition();
    }
}
