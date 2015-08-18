package jp.fkmsoft.libs.kiilib.entities.android;

import jp.fkmsoft.libs.kiilib.entities.BucketOwnable;
import jp.fkmsoft.libs.kiilib.entities.KiiTopicDTO;

/**
 * DTO for {@link AndroidKiiTopic}
 */
public class AndroidKiiTopicDTO implements KiiTopicDTO<AndroidKiiTopic> {

    private static AndroidKiiTopicDTO INSTANCE = new AndroidKiiTopicDTO();
    private AndroidKiiTopicDTO() {
        // singleton
    }

    public static AndroidKiiTopicDTO getInstance() {
        return INSTANCE;
    }

    @Override
    public AndroidKiiTopic fromJson(BucketOwnable owner, String name) {
        return new AndroidKiiTopic(owner, name);
    }
}
