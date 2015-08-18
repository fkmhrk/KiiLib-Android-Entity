package jp.fkmsoft.libs.kiilib.entities.android;

import android.os.Parcel;
import android.os.Parcelable;

import jp.fkmsoft.libs.kiilib.entities.BucketOwnable;
import jp.fkmsoft.libs.kiilib.entities.KiiGroup;
import jp.fkmsoft.libs.kiilib.entities.KiiUser;

/**
 * Implementation
 */
public class AndroidKiiGroup implements KiiGroup, Parcelable {
    private final String mId;
    private String mName;
    private AndroidKiiUser mOwner;

    public AndroidKiiGroup(String id, String name, AndroidKiiUser owner) {
        mId = id;
        mName = name;
        mOwner = owner;
    }

    AndroidKiiGroup(Parcel source) {
        mId = source.readString();
        mName = source.readString();
        int flag = source.readInt();
        if (flag == 1) {
            mOwner = new AndroidKiiUser(source);
        }
    }

    @Override
    public String getSubjectType() {
        return "GroupID";
    }

    @Override
    public String getResourcePath() {
        return "/groups/" + mId;
    }

    @Override
    public int getType() {
        return BucketOwnable.TYPE_GROUP;
    }

    @Override
    public String getId() {
        return mId;
    }

    // region Parcelable

    public static Creator<AndroidKiiGroup> CREATOR = new Creator<AndroidKiiGroup>() {
        @Override
        public AndroidKiiGroup createFromParcel(Parcel source) {
            return new AndroidKiiGroup(source);
        }

        @Override
        public AndroidKiiGroup[] newArray(int size) {
            return new AndroidKiiGroup[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mId);
        dest.writeString(mName);
        if (mOwner == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            mOwner.writeToParcel(dest, flags);
        }
    }
}
