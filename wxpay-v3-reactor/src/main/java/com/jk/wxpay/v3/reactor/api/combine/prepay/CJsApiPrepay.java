package com.jk.wxpay.v3.reactor.api.combine.prepay;

import com.jk.sdk.commons.reactor.ApiContext;
import com.jk.wxpay.v3.commons.Constants;
import com.jk.wxpay.v3.commons.bean.combine.CPrepayOrder;
import com.jk.wxpay.v3.commons.bean.direct.result.PrepayResult;
import com.jk.wxpay.v3.reactor.api.Prepay;
import com.jk.wxpay.v3.reactor.api.SingleRequester;
import reactor.core.publisher.Mono;

import static com.jk.wxpay.v3.commons.util.RequestUtils.createHeadersWith;

public class CJsApiPrepay extends SingleRequester<CPrepayOrder, PrepayResult>
        implements Prepay<CPrepayOrder, PrepayResult> {

    /**
     * 构造方法。
     * @param apiContext
     */
    public CJsApiPrepay(ApiContext apiContext) {
        super(apiContext, Constants.PATH_COMBINE_JSAPI_PREPAY, CPrepayOrder.class, PrepayResult.class);
    }

    @Override
    public Mono<PrepayResult> prepay(CPrepayOrder prepayOrder) {
        return super.post(null, createHeadersWith(prepayOrder.getCombineMchId()), prepayOrder);
    }
}