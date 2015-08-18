package jp.fkmsoft.libs.kiilib.entities.android;

import android.os.Parcel;
import android.test.AndroidTestCase;

import junit.framework.TestCase;

/**
 * Testcase
 */
public class AndroidKiiAppTest extends AndroidTestCase {
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
        AndroidKiiApp app = new AndroidKiiApp();

        app.writeToParcel(mParcel, 0);

        mParcel.setDataPosition(0);
        AndroidKiiApp app2 = AndroidKiiApp.CREATOR.createFromParcel(mParcel);
        assertNotNull(app2);
    }
}