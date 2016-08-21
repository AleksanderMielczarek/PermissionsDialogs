package com.github.aleksandermielczarek.permissionsdialogs;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.annotation.StringRes;
import android.support.v7.app.AlertDialog;

import permissions.dispatcher.PermissionRequest;

/**
 * Created by Aleksander Mielczarek on 25.06.2016.
 */
public class PermissionsDialogs {

    private PermissionsDialogs() {

    }

    public static void showRationaleDialog(Context context, final PermissionRequest request, @StringRes int text, @StringRes int ok, @StringRes int cancel) {
        new AlertDialog.Builder(context)
                .setMessage(text)
                .setPositiveButton(ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int button) {
                        request.proceed();
                    }
                })
                .setNegativeButton(cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int button) {
                        request.cancel();
                    }
                })
                .show();
    }

    public static void showNeverAskAgainDialog(final Context context, @StringRes int text, @StringRes int ok, @StringRes int cancel) {
        new AlertDialog.Builder(context)
                .setMessage(text)
                .setPositiveButton(ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int button) {
                        dialog.dismiss();
                        startAppSettings(context);
                    }
                })
                .setNegativeButton(cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int button) {
                        dialog.cancel();
                    }
                })
                .show();
    }

    public static void startAppSettings(Context context) {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", context.getPackageName(), null);
        intent.setData(uri);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }
}
