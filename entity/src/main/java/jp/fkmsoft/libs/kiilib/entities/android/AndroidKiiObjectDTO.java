package jp.fkmsoft.libs.kiilib.entities.android;

import org.json.JSONObject;

import jp.fkmsoft.libs.kiilib.entities.KiiBucket;
import jp.fkmsoft.libs.kiilib.entities.KiiObjectDTO;

/**
 * DTO for {@link AndroidKiiObject}
 */
public class AndroidKiiObjectDTO implements KiiObjectDTO<AndroidKiiObject> {
    private static final String FIELD_ID = "_id";
    private static final String FIELD_VERSION = "_version";

    private static AndroidKiiObjectDTO INSTANCE = new AndroidKiiObjectDTO();
    private AndroidKiiObjectDTO() {
        // singleton
    }

    public static AndroidKiiObjectDTO getInstance() {
        return INSTANCE;
    }

    @Override
    public AndroidKiiObject fromJson(KiiBucket bucket, JSONObject json) {
        String id = json.optString(FIELD_ID, null);
        String version = json.optString(FIELD_VERSION, "");
        return new AndroidKiiObject((AndroidKiiBucket)bucket, id, version, json);
    }
}
