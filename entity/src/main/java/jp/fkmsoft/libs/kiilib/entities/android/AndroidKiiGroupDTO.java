package jp.fkmsoft.libs.kiilib.entities.android;

import org.json.JSONObject;

import jp.fkmsoft.libs.kiilib.entities.KiiDTO;

/**
 * DTO for {@link AndroidKiiGroup}
 */
public class AndroidKiiGroupDTO implements KiiDTO<AndroidKiiGroup> {
    private static final String FIELD_ID = "groupID";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_OWNER_ID = "owner";

    private static AndroidKiiGroupDTO INSTANCE = new AndroidKiiGroupDTO();
    private AndroidKiiGroupDTO() {
        // singleton
    }

    public static AndroidKiiGroupDTO getInstance() {
        return INSTANCE;
    }

    @Override
    public AndroidKiiGroup fromJson(JSONObject json) {
        String groupId = json.optString(FIELD_ID, "");
        String name = json.optString(FIELD_NAME, "");
        String ownerId = json.optString(FIELD_OWNER_ID, null);
        AndroidKiiUser owner = ownerId == null ? null : new AndroidKiiUser(ownerId, null);
        return new AndroidKiiGroup(groupId, name, owner);
    }
}
