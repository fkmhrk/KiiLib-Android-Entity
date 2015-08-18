package jp.fkmsoft.libs.kiilib.entities.android;

import jp.fkmsoft.libs.kiilib.client.KiiHTTPClient;
import jp.fkmsoft.libs.kiilib.entities.KiiContext;

/**
 * Implementation
 */
abstract public class AndroidKiiContext implements KiiContext {
    private final String mAppId;
    private final String mAppKey;
    private final String mBaseUrl;
    private String mToken;

    public AndroidKiiContext(String appId, String appKey, String baseUrl) {
        mAppId = appId;
        mAppKey = appKey;
        mBaseUrl = baseUrl;
    }

    @Override
    public String getAppId() {
        return mAppId;
    }

    @Override
    public String getAppKey() {
        return mAppKey;
    }

    @Override
    public String getBaseUrl() {
        return mBaseUrl;
    }

    @Override
    public String getAccessToken() {
        return mToken;
    }

    @Override
    public void setAccessToken(String token) {
        mToken = token;
    }

    abstract public KiiHTTPClient getHttpClient();
}
