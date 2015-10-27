package android.joeamrhein.library;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;

import java.util.List;


public class PlayStoreUtil {

    /**
     * Courtesy of http://stackoverflow.com/a/28090925
     *
     * @param context
     * @param targetAppPackage fully qualified package name of app
     */
    public static void openAppPageInPlayStore(Context context, String targetAppPackage) {
        Intent playStoreIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("market://details?id=" + targetAppPackage));

        // find all applications able to handle our rateIntent
        final List<ResolveInfo> otherApps = context.getPackageManager().queryIntentActivities(
                playStoreIntent, 0);

        for (ResolveInfo otherApp : otherApps) {
            // look for Google Play application
            if (otherApp.activityInfo.applicationInfo.packageName.equals("com.android.vending")) {

                ActivityInfo otherAppActivity = otherApp.activityInfo;
                ComponentName componentName = new ComponentName(
                        otherAppActivity.applicationInfo.packageName, otherAppActivity.name);
                playStoreIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                playStoreIntent.setComponent(componentName);
                context.startActivity(playStoreIntent);
                return;
            }
        }

        // if Google Play not present on device, open web browser
        Intent webIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://play.google.com/store/apps/details?id=" + targetAppPackage));
        context.startActivity(webIntent);

    }

}
