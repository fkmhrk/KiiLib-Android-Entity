package jp.fkmsoft.libs.kiilib.entities.android;

import android.os.Parcel;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

import jp.fkmsoft.libs.kiilib.entities.BucketOwnable;

/**
 * Utility class
 */
class Utils {
    static void copyJson(JSONObject source, JSONObject to) {
        if (source == null) {
            return;
        }
        Iterator keys = source.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            try {
                to.put(key, source.get(key));
            } catch (JSONException e) {
                // nop
            }
        }
    }

    static BucketOwnable readBucketOwnalbe(Parcel source) {
        int type = source.readInt();
        switch (type) {
        case BucketOwnable.TYPE_APP:
            return new AndroidKiiApp();
        case BucketOwnable.TYPE_GROUP:
            return new AndroidKiiGroup(source);
        case BucketOwnable.TYPE_USER:
            return new AndroidKiiUser(source);
        default:
            return new AndroidKiiApp();
        }
    }

    static void writeBucketOwnable(BucketOwnable owner, Parcel dest, int flags) {
        if (owner == null) {
            dest.writeInt(BucketOwnable.TYPE_APP);
            return;
        }
        int type = owner.getType();
        dest.writeInt(type);
        switch (type) {
        case BucketOwnable.TYPE_APP:
            break;
        case BucketOwnable.TYPE_GROUP:
            ((AndroidKiiGroup)owner).writeToParcel(dest, flags);
            break;
        case BucketOwnable.TYPE_USER:
            ((AndroidKiiUser)owner).writeToParcel(dest, flags);
            break;
        }
    }
}
