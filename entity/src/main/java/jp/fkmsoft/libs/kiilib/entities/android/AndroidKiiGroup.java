package jp.fkmsoft.libs.kiilib.entities.android;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import jp.fkmsoft.libs.kiilib.entities.BucketOwnable;
import jp.fkmsoft.libs.kiilib.entities.KiiGroup;

/**
 * Implementation
 */
public class AndroidKiiGroup implements KiiGroup, Parcelable {
    private final String mId;
    private String mName;
    private AndroidKiiUser mOwner;
    private List<AndroidKiiUser> mMembers;

    public AndroidKiiGroup(String id, String name, AndroidKiiUser owner) {
        mId = id;
        mName = name;
        mOwner = owner;
        mMembers = new ArrayList<>();
    }

    AndroidKiiGroup(Parcel source) {
        mId = source.readString();
        mName = source.readString();
        int flag = source.readInt();
        if (flag == 1) {
            mOwner = new AndroidKiiUser(source);
        }
        int count = source.readInt();
        mMembers = new ArrayList<>(count);
        for (int i = 0 ; i < count ; ++i) {
            mMembers.add(new AndroidKiiUser(source));
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

    /**
     * Gets group name
     * @return Group name
     */
    public String getName() {
        return mName;
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
        dest.writeInt(mMembers.size());
        for (AndroidKiiUser member : mMembers) {
            member.writeToParcel(dest, flags);
        }
    }
}
