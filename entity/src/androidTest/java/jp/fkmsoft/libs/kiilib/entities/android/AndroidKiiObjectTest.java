package jp.fkmsoft.libs.kiilib.entities.android;

import android.os.Parcel;
import android.test.AndroidTestCase;

import junit.framework.TestCase;

/**
 * Testcase
 */
public class AndroidKiiObjectTest extends AndroidTestCase {
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
        AndroidKiiBucket bucket = new AndroidKiiBucket(new AndroidKiiApp(), "myBucket");
        AndroidKiiObject obj = new AndroidKiiObject(bucket, "objId", "1", null);
        obj.put("strVal", "StringTestValue");
        obj.put("intVal", 2);
        obj.put("boolVal", true);

        obj.writeToParcel(mParcel, 0);
        mParcel.setDataPosition(0);

        AndroidKiiObject obj2 = AndroidKiiObject.CREATOR.createFromParcel(mParcel);
        assertNotNull(obj2);
        assertEquals("objId", obj2.getId());
        assertEquals("1", obj2.getVersion());
        assertEquals("/buckets/myBucket/objects/objId", obj2.getResourcePath());
        assertTrue(obj2.has("strVal"));
        assertTrue(obj2.has("intVal"));
        assertTrue(obj2.has("boolVal"));
        assertEquals("StringTestValue", obj2.getString("strVal"));
        assertEquals(2, obj2.getInt("intVal"));
        assertEquals(true, obj2.getBoolean("boolVal"));

    }
}