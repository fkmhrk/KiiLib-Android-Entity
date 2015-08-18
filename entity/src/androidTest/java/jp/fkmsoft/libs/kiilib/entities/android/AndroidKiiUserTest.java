package jp.fkmsoft.libs.kiilib.entities.android;

import android.os.Parcel;
import android.test.AndroidTestCase;

import junit.framework.TestCase;

/**
 * Testcase
 */
public class AndroidKiiUserTest extends AndroidTestCase {
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
        AndroidKiiUser user = new AndroidKiiUser("me", null);
        user.put("strVal", "StringTestValue");
        user.put("intVal", 1);
        user.put("boolVal", true);

        user.writeToParcel(mParcel, 0);

        mParcel.setDataPosition(0);
        AndroidKiiUser user2 = AndroidKiiUser.CREATOR.createFromParcel(mParcel);
        assertNotNull(user2);
        assertEquals("me", user2.getId());
        assertTrue(user2.has("strVal"));
        assertTrue(user2.has("intVal"));
        assertTrue(user2.has("boolVal"));
        assertEquals("StringTestValue", user2.getString("strVal"));
        assertEquals(1, user2.getInt("intVal"));
        assertEquals(true, user2.getBoolean("boolVal"));
    }
}