package jp.fkmsoft.libs.kiilib.entities.android;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

import jp.fkmsoft.libs.kiilib.entities.BucketOwnable;
import jp.fkmsoft.libs.kiilib.entities.KiiUser;

/**
 * Implementation
 */
public class AndroidKiiUser extends JSONObject implements KiiUser, Parcelable {

    private String mId;

    public AndroidKiiUser(String id) {
        mId = id;
    }

    public AndroidKiiUser(String id, JSONObject data) {
        mId = id;
        Utils.copyJson(data, this);
    }

    AndroidKiiUser(Parcel source) {
        mId = source.readString();
        try {
            Utils.copyJson(new JSONObject(source.readString()), this);
        } catch (JSONException e) {
            // nop
        }
    }

    @Override
    public String getSubjectType() {
        return "UserID";
    }

    @Override
    public String getResourcePath() {
        return "/users/" + mId;
    }

    @Override
    public int getType() {
        return BucketOwnable.TYPE_USER;
    }

    @Override
    public String getId() {
        return mId;
    }

    // region Parcelabje
    public static Creator<AndroidKiiUser> CREATOR = new Creator<AndroidKiiUser>() {
        @Override
        public AndroidKiiUser createFromParcel(Parcel source) {
            return new AndroidKiiUser(source);
        }

        @Override
        public AndroidKiiUser[] newArray(int size) {
            return new AndroidKiiUser[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mId);
        dest.writeString(toString());
    }
}
