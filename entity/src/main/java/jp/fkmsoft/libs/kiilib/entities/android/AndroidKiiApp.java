package jp.fkmsoft.libs.kiilib.entities.android;

import android.os.Parcel;
import android.os.Parcelable;

import jp.fkmsoft.libs.kiilib.entities.BucketOwnable;
import jp.fkmsoft.libs.kiilib.entities.KiiApp;

/**
 * Implementation
 */
public class AndroidKiiApp implements KiiApp, Parcelable {
    @Override
    public String getResourcePath() {
        return "";
    }

    @Override
    public int getType() {
        return BucketOwnable.TYPE_APP;
    }

    // region parcelable
    public static Creator<AndroidKiiApp> CREATOR = new Creator<AndroidKiiApp>() {
        @Override
        public AndroidKiiApp createFromParcel(Parcel source) {
            return new AndroidKiiApp();
        }

        @Override
        public AndroidKiiApp[] newArray(int size) {
            return new AndroidKiiApp[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
