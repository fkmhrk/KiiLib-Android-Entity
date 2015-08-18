package jp.fkmsoft.libs.kiilib.entities.android;

import android.os.Parcel;
import android.test.AndroidTestCase;

import junit.framework.TestCase;

/**
 * Testcase
 */
public class AndroidKiiBucketTest extends AndroidTestCase {
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
        AndroidKiiBucket bucket = new AndroidKiiBucket(new AndroidKiiApp(), "myBucket");

        bucket.writeToParcel(mParcel, 0);

        mParcel.setDataPosition(0);

        AndroidKiiBucket bucket2 = AndroidKiiBucket.CREATOR.createFromParcel(mParcel);
        assertNotNull(bucket2);
        assertEquals("myBucket", bucket2.getName());
        assertTrue(bucket2.getOwner() instanceof AndroidKiiApp);
    }

    public void test_0001_Parcelable_Group() throws Exception {
        AndroidKiiUser groupOwner = new AndroidKiiUser("me", null);
        AndroidKiiGroup group = new AndroidKiiGroup("groupId", "myGroup", groupOwner);
        AndroidKiiBucket bucket = new AndroidKiiBucket(group, "groupBucket");

        bucket.writeToParcel(mParcel, 0);

        mParcel.setDataPosition(0);

        AndroidKiiBucket bucket2 = AndroidKiiBucket.CREATOR.createFromParcel(mParcel);
        assertNotNull(bucket2);
        assertEquals("groupBucket", bucket2.getName());
        assertTrue(bucket2.getOwner() instanceof AndroidKiiGroup);
        AndroidKiiGroup bucketOwner = (AndroidKiiGroup)bucket2.getOwner();
        assertEquals("groupId", bucketOwner.getId());
    }

    public void test_0002_Parcelable_User() throws Exception {
        AndroidKiiUser user = new AndroidKiiUser("me", null);
        AndroidKiiBucket bucket = new AndroidKiiBucket(user, "userBucket");

        bucket.writeToParcel(mParcel, 0);

        mParcel.setDataPosition(0);

        AndroidKiiBucket bucket2 = AndroidKiiBucket.CREATOR.createFromParcel(mParcel);
        assertNotNull(bucket2);
        assertEquals("userBucket", bucket2.getName());
        assertTrue(bucket2.getOwner() instanceof AndroidKiiUser);
        AndroidKiiUser bucketOwner = (AndroidKiiUser)bucket2.getOwner();
        assertEquals("me", bucketOwner.getId());
    }
}