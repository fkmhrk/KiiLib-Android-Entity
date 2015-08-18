package jp.fkmsoft.libs.kiilib.entities.android;

import android.os.Parcel;
import android.os.Parcelable;

import jp.fkmsoft.libs.kiilib.entities.BucketOwnable;
import jp.fkmsoft.libs.kiilib.entities.KiiTopic;

/**
 * Implementation
 */
public class AndroidKiiTopic implements KiiTopic, Parcelable {
    private static final BucketOwnable APP_SCOPE = new AndroidKiiApp();
    private final BucketOwnable mOwner;
    private final String mName;

    public AndroidKiiTopic(BucketOwnable owner, String name) {
        if (owner == null) {
            owner = APP_SCOPE;
        }
        mOwner = owner;
        mName = name;
    }

    AndroidKiiTopic(Parcel source) {
        mOwner = Utils.readBucketOwnalbe(source);
        mName = source.readString();
    }

    @Override
    public String getResourcePath() {
        return mOwner.getResourcePath() + "/topics/" + mName;
    }

    // region Parcelable

    public static Creator<AndroidKiiTopic> CREATOR = new Creator<AndroidKiiTopic>() {
        @Override
        public AndroidKiiTopic createFromParcel(Parcel source) {
            return new AndroidKiiTopic(source);
        }

        @Override
        public AndroidKiiTopic[] newArray(int size) {
            return new AndroidKiiTopic[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Utils.writeBucketOwnable(mOwner, dest, flags);
        dest.writeString(mName);
    }
}
