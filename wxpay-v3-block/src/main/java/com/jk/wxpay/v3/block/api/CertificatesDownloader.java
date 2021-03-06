package com.jk.wxpay.v3.block.api;

import com.jk.sdk.commons.block.ApiContext;
import com.jk.wxpay.v3.commons.Constants;
import com.jk.wxpay.v3.commons.bean.cert.EncryptCertificateEntity;
import com.jk.wxpay.v3.commons.util.RequestUtils;

/**
 * 证书下载器，下载证书。
 * 这个对象用来下载微信端的证书，不需要验签微信端返回的数据。
 */
public class CertificatesDownloader extends SingleRequester<Void, EncryptCertificateEntity> {

    /**
     * 构造方法。
     *
     * @param apiContext
     */
    public CertificatesDownloader(ApiContext apiContext) {
        super(apiContext, Constants.PATH_CERTIFICATES, Void.class, EncryptCertificateEntity.class);
    }

    /**
     * 获取证书实体。
     * @param mchId
     * @return
     */
    public EncryptCertificateEntity getCertificates(String mchId) {
        return super.get(null, RequestUtils.createHeadersWith(mchId));
    }
}
