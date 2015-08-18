package jp.fkmsoft.libs.kiilib.entities.android;

import jp.fkmsoft.libs.kiilib.entities.BucketOwnable;
import jp.fkmsoft.libs.kiilib.entities.KiiBucketDTO;

/**
 * DTO for {@link AndroidKiiBucket}
 */
public class AndroidKiiBucketDTO implements KiiBucketDTO<AndroidKiiBucket> {

    private static AndroidKiiBucketDTO INSTANCE = new AndroidKiiBucketDTO();
    private AndroidKiiBucketDTO() {
        // singleton
    }

    public static AndroidKiiBucketDTO getInstance() {
        return INSTANCE;
    }

    @Override
    public AndroidKiiBucket fromJson(BucketOwnable owner, String name) {
        return new AndroidKiiBucket(owner, name);
    }
}
