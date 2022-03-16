<template>
  <div id="bang">
  <!-- <p>
    <label>名称：
      <input type="text" v-model="name"/>
      <p>{{name}}</p>
    </label>
    <label>id：
      <input type="text" v-model="packageId"/>
    </label>
    <label>名称：
      <input type="text" v-model="amount"/>
    </label>
  </p>
  <p v-if="name">
    你好，{{name}}；
  </p> -->
      <div id="buy-page" class="main-content" style="min-height: 517px;">
        <section class="section">
          <div class="section-header">
            <div class="section-header-back">
              <a href="" onclick="backToShop()" class="btn btn-icon"><i class="fas fa-arrow-left"></i></a>
            </div>
            <h1>购买会员计划</h1>
          </div>
          <div class="section-body">
            <div class="invoice">
              <div class="invoice-print">

                <div class="row" id="plan-selection">
                  <div class="col-md-12">
                    <div class="section-title" style="margin-top: 0;">选择会员计划</div>
                    <div class="colors">
                                                                      <div id="plan_1" class="color col-12 col-md-2 col-lg-2 active" onclick="selectItem(&#39;plan&#39;,&#39;plan_1&#39;)">
                          <span class="pricing-inside"><span class="pricing-super">¥</span>9<span class="pricing-super">.9</span><span class="per-month">/月</span></span>
                          <span class="badge badge-primary">入门版</span>
                        </div>
                                                                      <div id="plan_2" class="color col-12 col-md-2 col-lg-2" onclick="selectItem(&#39;plan&#39;,&#39;plan_2&#39;)">
                          <span class="pricing-inside"><span class="pricing-super">¥</span>15<span class="pricing-super">.9</span><span class="per-month">/月</span></span>
                          <span class="badge badge-primary">基础版</span>
                        </div>
                                                                      <div id="plan_3" class="color col-12 col-md-2 col-lg-2" onclick="selectItem(&#39;plan&#39;,&#39;plan_3&#39;)">
                          <span class="pricing-inside"><span class="pricing-super">¥</span>25<span class="pricing-super">.9</span><span class="per-month">/月</span></span>
                          <span class="badge badge-primary">标准版</span>
                        </div>
                                                                      <div id="plan_4" class="color col-12 col-md-2 col-lg-2" onclick="selectItem(&#39;plan&#39;,&#39;plan_4&#39;)">
                          <span class="pricing-inside"><span class="pricing-super">¥</span>50<span class="pricing-super">.0</span><span class="per-month">/月</span></span>
                          <span class="badge badge-primary">旗舰版</span>
                        </div>
                                                                      <div id="plan_5" class="color col-12 col-md-2 col-lg-2" onclick="selectItem(&#39;plan&#39;,&#39;plan_5&#39;)">
                          <span class="pricing-inside"><span class="pricing-super">¥</span>88<span class="pricing-super">.0</span><span class="per-month">/月</span></span>
                          <span class="badge badge-primary">旗舰版大流量</span>
                        </div>
                                          </div>
                  </div>
                </div>

                <div class="row mt-4" id="time-selection">
                  <div class="col-12">
                    <div class="section-title">选择会员时长</div>
                    <div class="colors">
                      <div id="1month" class="color col-12 col-md-2 col-lg-2 active" onclick="selectItem(&#39;time&#39;,&#39;1month&#39;)">
                        1个月
                      </div>
                      <div id="3month" class="color col-12 col-md-2 col-lg-2" onclick="selectItem(&#39;time&#39;,&#39;3month&#39;)">
                        3个月
                      </div>
                      <div id="6month" class="color col-12 col-md-2 col-lg-2" onclick="selectItem(&#39;time&#39;,&#39;6month&#39;)">
                        6个月
                      </div>
                      <div id="12month" class="color col-12 col-md-2 col-lg-2" onclick="selectItem(&#39;time&#39;,&#39;12month&#39;)">
                        12个月
                      </div>
                      <div id="24month" class="color col-12 col-md-2 col-lg-2" onclick="selectItem(&#39;time&#39;,&#39;24month&#39;)">
                        24个月
                      </div>
                    </div>
                  </div>
                </div>

                
                <div class="row mt-4" id="payment-selection">
                  <div class="col-12">
                    <div class="section-title">支付方式</div>
                    <div class="colors row">
                                              <div id="alipay" class="color col-12 col-md-2 col-lg-2 active" onclick="selectItem(&#39;payment&#39;,&#39;alipay&#39;)">
                          <i class="fab fa-alipay" style="font-size: 1.1rem;vertical-align: -1px;margin-right: 2px;"></i> 支付宝
                        </div>
                                                  <div id="wechat" class="color col-12 col-md-2 col-lg-2" onclick="selectItem(&#39;payment&#39;,&#39;wechat&#39;)">
                            <i class="malio-wechat-pay" style="font-size: 1.1rem;vertical-align: -1px;"></i> 微信支付
                          </div>
                                                                                                                  </div>
                    <p class="text-muted">* 默认抵扣账户余额</p>
                  </div>
                </div>

                <div class="row mt-4">
                  <div class="col-lg-8">
                    <div class="section-title">购买须知</div>
                    <p class="text-muted">
                      
        </p><div class="bullet"></div> 购买会员计划即代表同意《服务条款》和《使用政策》。
    
                                                                <p></p>
                  </div>
                  <div class="col-lg-4 text-right">
                    <div class="invoice-detail-item">
                      <div class="invoice-detail-name">商品名称</div>
                      <div id="shop-name" class="invoice-detail-value">入门版（30天）</div>
                    </div>
                    <div class="invoice-detail-item">
                      <div class="invoice-detail-name">总价</div>
                      <div id="total" class="invoice-detail-value">¥ 9.90</div>
                    </div>
                    <div id="coupon-row" class="invoice-detail-item" style="display: none">
                      <div class="invoice-detail-name">优惠</div>
                      <div id="coupon-money" class="invoice-detail-value">Null</div>
                    </div>
                    <div class="invoice-detail-item">
                      <div class="invoice-detail-name">余额支付</div>
                      <div id="account-money" class="invoice-detail-value">¥ -0.00</div>
                    </div>
                    <hr class="mt-2 mb-2">
                    <div class="invoice-detail-item">
                      <div class="invoice-detail-name">还需要支付</div>
                      <div id="pay-amount" class="invoice-detail-value invoice-detail-value-lg">¥ 9.90</div>
                    </div>
                  </div>
                </div>

                <hr class="mt-2">
                <div class="text-md-right">
                  <div class="float-lg-left mb-lg-0 mb-3">
                    <button id="coupon-btn" class="btn btn-primary btn-icon icon-left" data-toggle="modal" data-target="#coupon-modal"><i class="fas fa-tag"></i> 使用优惠码</button>
                  </div>
                  <button id="pay-confirm1" class="btn btn-warning btn-icon icon-left"><i class="fas fa-check"></i> 立即支付</button>
                </div>

              </div>
            </div>
          </div>
      </section></div>

      </div>
  
</template>
<script scoped>



 export default{
     data() {
      return {
        name: this.$route.params.name,
        packageId: this.$route.params.packageId,
        amount: this.$route.params.amount
      }
    }

 }

 //debugger
//console.log(this.$route.params.name);


</script>

<style scoped>

    [type=reset], [type=submit], button, html [type=button] {
      -webkit-appearance: none;
    }
    .colors .active {
      background-color: #6777ef !important;
      color: white !important;
      box-shadow: 0 2px 6px #acb5f6;
      border: 2px solid #6777ef !important;
    }

    .colors .color:hover {
      border: 2px solid #6777ef;
      transition: 0.3s ease;
    }

    .colors .color {
      color: #282B43;
      background-color: transparent;
      background-image: none;
      cursor: pointer;
      border: 2px solid #f1f2f5;
      border-radius: 4px;
      font-size: 1rem;
      font-weight: 500;
      -webkit-touch-callout: none;
      -webkit-user-select: none;
      -khtml-user-select: none;
      -moz-user-select: none;
      -ms-user-select: none;
      user-select: none;
    }

    #payment-selection #alipay {
      color: #029de3;
      border: 2px solid #f1f2f5;
      transition: 0.3s ease;
    }

    #payment-selection #wechat {
      color: #00b235;
      border: 2px solid #f1f2f5;
    }

    #payment-selection #qqpay {
      color: #11b7f5;
      border: 2px solid #f1f2f5;
    }

    #payment-selection #crypto {
      color: #ffa425;
      border: 2px solid #f1f2f5;
    }

    #payment-selection #unionpay i {
      font-size: 1.2rem;
      vertical-align: -3px;
    }

    #payment-selection #alipay:hover {
      color: #029de3;
      border: 2px solid #029de3;
    }

    #payment-selection #wechat:hover {
      color: #00b235;
      border: 2px solid #00b235;
    }

    #payment-selection #qqpay:hover {
      color: #11b7f5;
      border: 2px solid #11b7f5;
    }

    #payment-selection #crypto:hover {
      color: #ffa425;
      border: 2px solid #ffa425;
    }

    #payment-selection #alipay[class*="active"] {
      background: #029de3 !important;
      box-shadow: 0 2px 6px #029ce370;
      border: 2px solid #029de3 !important;
    }

    #payment-selection #wechat[class*="active"] {
      background: #00b235 !important;
      box-shadow: 0 2px 6px #00b23570;
      border: 2px solid #00b235 !important;
    }

    #payment-selection #qqpay[class*="active"] {
      background: #11b7f5 !important;
      box-shadow: 0 2px 6px #11b8f570;
      border: 2px solid #11b7f5 !important;
    }

    #payment-selection #crypto[class*="active"] {
      background: #ffa425 !important;
      box-shadow: 0 2px 6px #ffa42580;
      border: 2px solid #ffa425 !important;
    }

    #payment-selection .fas,
    .far,
    .fab,
    .fal {
      font-size: 1rem;
    }

    .colors .color {
      height: auto !important;
    }

    .color .pricing-inside {
      display: block;
      font-weight: bold;
      font-size: 2.8em;
    }

    .color .pricing-super {
      vertical-align: super;
      padding-right: 3px;
      font-size: 0.5em;
      margin-left: 6px;
      margin-right: 0px;
      font-weight: 500;
    }

    .color .per-month {
      position: relative;
      color: #B1C1CA;
      font-weight: 500;
      font-size: 0.2em;
      top: -0.1em;
      left: -1.6em;
    }

    #plan-selection .color[class*="active"] .badge {
      background: #fff;
      color: #6777ef;
    }

    .main-content{
      padding-left: 5px;
      padding-top: 5px;
      display: flex;
      position: relative;
      left: 0px;
      top: 0px;
    }
  </style>