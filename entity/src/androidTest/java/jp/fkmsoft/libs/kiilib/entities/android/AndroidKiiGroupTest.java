package jp.fkmsoft.libs.kiilib.entities.android;

import android.os.Parcel;
import android.test.AndroidTestCase;

import junit.framework.TestCase;

/**
 * Testcase
 */
public class AndroidKiiGroupTest extends AndroidTestCase {
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

    public void test_0000_Parcelable() throws Exception {
        AndroidKiiUser owner = new AndroidKiiUser("me", null);
        AndroidKiiGroup group = new AndroidKiiGroup("groupId", "myGroup", owner);

        group.writeToParcel(mParcel, 0);

        mParcel.setDataPosition(0);

        AndroidKiiGroup group2 = AndroidKiiGroup.CREATOR.createFromParcel(mParcel);
        assertNotNull(group2);
        assertEquals("groupId", group2.getId());
    }
 }