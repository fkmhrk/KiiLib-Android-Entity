package jp.fkmsoft.libs.kiilib.entities.android;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

import jp.fkmsoft.libs.kiilib.entities.KiiBucket;
import jp.fkmsoft.libs.kiilib.entities.KiiObject;

/**
 * Implementation
 */
public class AndroidKiiObject extends JSONObject implements KiiObject, Parcelable {

    private final AndroidKiiBucket mBucket;
    private final String mId;
    private String mVersion;
    private long mModifiedTime;

    public AndroidKiiObject(AndroidKiiBucket bucket, String id, String version, JSONObject data) {
        mBucket = bucket;
        mId = id;
        mVersion = version;
        if (data != null) {
            Utils.copyJson(data, this);
        }
    }

    AndroidKiiObject(Parcel source) {
        mBucket = new AndroidKiiBucket(source);
        mId = source.readString();
        mVersion = source.readString();
        mModifiedTime = source.readLong();
        try {
            Utils.copyJson(new JSONObject(source.readString()), this);
        } catch (JSONException e) {
            // nop
        }
    }

    @Override
    public String getVersion() {
        return mVersion;
    }

    @Override
    public void setVersion(String version) {
        mVersion = version;
    }

    @Override
    public void updateFields(JSONObject json) {
        Utils.copyJson(json, this);
    }

    @Override
    public void setModifiedTime(long time) {
        mModifiedTime = time;
    }

    @Override
    public JSONObject toJson() {
        return this;
    }

    @Override
    public String getResourcePath() {
        return mBucket.getResourcePath() + "/objects/" + mId;
    }

    @Override
    public String getId() {
        return mId;
    }

    // region Parcelable

    public static Creator<AndroidKiiObject> CREATOR = new Creator<AndroidKiiObject>() {
        @Override
        public AndroidKiiObject createFromParcel(Parcel source) {
            return new AndroidKiiObject(source);
        }

        @Override
        public AndroidKiiObject[] newArray(int size) {
            return new AndroidKiiObject[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        mBucket.writeToParcel(dest, flags);
        dest.writeString(mId);
        dest.writeString(mVersion);
        dest.writeLong(mModifiedTime);
        dest.writeString(toString());
    }
}
