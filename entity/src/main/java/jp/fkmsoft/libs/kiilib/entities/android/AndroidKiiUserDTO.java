package jp.fkmsoft.libs.kiilib.entities.android;

import org.json.JSONObject;

import jp.fkmsoft.libs.kiilib.entities.KiiDTO;

/**
 * DTO for {@link AndroidKiiUser}
 */
public class AndroidKiiUserDTO implements KiiDTO<AndroidKiiUser> {
    private static final String FIELD_ID = "UserID";

    private static AndroidKiiUserDTO INSTANCE = new AndroidKiiUserDTO();
    private AndroidKiiUserDTO() {
        // singleton
    }

    public static AndroidKiiUserDTO getInstance() {
        return INSTANCE;
    }

    @Override
    public AndroidKiiUser fromJson(JSONObject json) {
        String userId = json.optString(FIELD_ID, "");
        return new AndroidKiiUser(userId, json);
    }
}
