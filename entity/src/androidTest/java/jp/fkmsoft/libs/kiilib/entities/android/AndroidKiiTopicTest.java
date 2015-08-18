package jp.fkmsoft.libs.kiilib.entities.android;

import android.os.Parcel;
import android.test.AndroidTestCase;

/**
 * Testcase
 */
public class AndroidKiiTopicTest extends AndroidTestCase {
    private Parcel mParcel;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mParcel = Parcel.obtain();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        mParcel.recycle();
    }

    public void test_0000_Parcelable_App() throws Exception {
        AndroidKiiTopic topic = new AndroidKiiTopic(new AndroidKiiApp(), "myTopic");

        topic.writeToParcel(mParcel, 0);

        mParcel.setDataPosition(0);

        AndroidKiiTopic topic2 = AndroidKiiTopic.CREATOR.createFromParcel(mParcel);
        assertNotNull(topic2);
        assertEquals("/topics/myTopic", topic2.getResourcePath());
    }

    public void test_0001_Parcelable_Group() throws Exception {
        AndroidKiiUser groupOwner = new AndroidKiiUser("me", null);
        AndroidKiiGroup group = new AndroidKiiGroup("groupId", "myGroup", groupOwner);
        AndroidKiiTopic topic = new AndroidKiiTopic(group, "groupTopic");

        topic.writeToParcel(mParcel, 0);

        mParcel.setDataPosition(0);

        AndroidKiiTopic topic2 = AndroidKiiTopic.CREATOR.createFromParcel(mParcel);
        assertNotNull(topic2);
        assertEquals("/groups/groupId/topics/groupTopic", topic2.getResourcePath());
    }

    public void test_0002_Parcelable_User() throws Exception {
        AndroidKiiUser user = new AndroidKiiUser("me", null);
        AndroidKiiTopic topic = new AndroidKiiTopic(user, "userTopics");

        topic.writeToParcel(mParcel, 0);

        mParcel.setDataPosition(0);

        AndroidKiiTopic topic2 = AndroidKiiTopic.CREATOR.createFromParcel(mParcel);
        assertNotNull(topic2);
        assertEquals("/users/me/topics/userTopics", topic2.getResourcePath());
    }
}