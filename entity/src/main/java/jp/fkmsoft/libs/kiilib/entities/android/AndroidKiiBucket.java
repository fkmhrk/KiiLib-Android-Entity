package jp.fkmsoft.libs.kiilib.entities.android;

import android.os.Parcel;
import android.os.Parcelable;

import jp.fkmsoft.libs.kiilib.entities.BucketOwnable;
import jp.fkmsoft.libs.kiilib.entities.KiiBucket;

/**
 * Implementation
 */
public class AndroidKiiBucket implements KiiBucket, Parcelable {
    private static final BucketOwnable APP_SCOPE = new AndroidKiiApp();
    private final BucketOwnable mOwner;
    private String mName;

    public AndroidKiiBucket(BucketOwnable owner, String name) {
        if (owner == null) {
            owner = APP_SCOPE;
        }
        mOwner = owner;
        mName = name;
    }

    AndroidKiiBucket(Parcel source) {
        mOwner = Utils.readBucketOwnalbe(source);
        mName = source.readString();
    }

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public BucketOwnable getOwner() {
        return mOwner;
    }

    @Override
    public String getResourcePath() {
        return mOwner.getResourcePath() + "/buckets/" + mName;
    }

    // region Parcelable

    public static Creator<AndroidKiiBucket> CREATOR = new Creator<AndroidKiiBucket>() {
        @Override
        public AndroidKiiBucket createFromParcel(Parcel source) {
            return new AndroidKiiBucket(source);
        }

        @Override
        public AndroidKiiBucket[] newArray(int size) {
            return new AndroidKiiBucket[size];
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
