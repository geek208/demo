<template>
<div id="main-page" class="main-content" style="min-height: 496px;">
        <section class="section">
          <div class="section-header">
            <h1>商店</h1>
                      </div>
          <div class="section-body">
            <h2 class="section-title">选择合适的会员订阅计划</h2>
            <p class="section-lead"></p><div class="bullet"></div>购买新套餐时，购买<div style="color:red; display:inline">相同等级套餐：流量不会叠加，时间会叠加，如等级不同：流量和时间都不会叠加。</div>
            <br><div class="bullet"></div>年付会员流量为一次性到账，一年到期才会清零。 <br><div class="bullet"></div>如需更换套餐，请至首页点击<div style="color:red; display:inline">【升级】</div>按钮。<p></p>


            <div class="row">
              
                              <div class="col-12 col-md-4 col-lg-4">
                  <div class="pricing pricing-highlight">
                    <div class="pricing-title">
                      入门版
                    </div>
                    <div class="pricing-padding">
                      <div class="pricing-price">
                        <div>￥9.9</div>
                        <div>每月</div>
                      </div>
                      <div class="pricing-details">
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">100GB使用流量</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">3个设备同时使用</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">最高60M速率</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">工单客服支持</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">支持SSR、V2ray节点</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">国内中转节点</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">解锁流媒体</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">可用入门版节点</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon bg-danger text-white"><i class="fas fa-times"></i></div>
                                                        <div class="pricing-item-label">可用基础版节点</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon bg-danger text-white"><i class="fas fa-times"></i></div>
                                                        <div class="pricing-item-label">可用标准版节点</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon bg-danger text-white"><i class="fas fa-times"></i></div>
                                                        <div class="pricing-item-label">IPLC专线节点</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon bg-danger text-white"><i class="fas fa-times"></i></div>
                                                        <div class="pricing-item-label">可用旗舰版节点(可用所有节点)</div>
                          </div>
                                              </div>
                    </div>
                    <div class="pricing-cta" onclick="subscribePlan('plan_1')">
                      <a href="https://suying555.net/user/shop#">订阅 <i class="fas fa-arrow-right"></i></a>
                    </div>
                  </div>
                </div>
                              <div class="col-12 col-md-4 col-lg-4">
                  <div class="pricing pricing-highlight">
                    <div class="pricing-title">
                      基础版
                    </div>
                    <div class="pricing-padding">
                      <div class="pricing-price">
                        <div>￥15.9</div>
                        <div>每月</div>
                      </div>
                      <div class="pricing-details">
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">200GB使用流量</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">5个设备同时使用</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">最高150M速率</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">工单客服支持</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">支持SSR、V2ray节点</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">国内中转节点</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">解锁流媒体</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">可用入门版节点</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">可用基础版节点</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon bg-danger text-white"><i class="fas fa-times"></i></div>
                                                        <div class="pricing-item-label">可用标准版节点</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon bg-danger text-white"><i class="fas fa-times"></i></div>
                                                        <div class="pricing-item-label">IPLC专线节点</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon bg-danger text-white"><i class="fas fa-times"></i></div>
                                                        <div class="pricing-item-label">可用旗舰版节点(可用所有节点)</div>
                          </div>
                                              </div>
                    </div>
                    <div class="pricing-cta" onclick="subscribePlan('plan_2')">
                      <a href="https://suying555.net/user/shop#">订阅 <i class="fas fa-arrow-right"></i></a>
                    </div>
                  </div>
                </div>
                              <div class="col-12 col-md-4 col-lg-4">
                  <div class="pricing pricing-highlight">
                    <div class="pricing-title">
                      标准版
                    </div>
                    <div class="pricing-padding">
                      <div class="pricing-price">
                        <div>￥25.9</div>
                        <div>每月</div>
                      </div>
                      <div class="pricing-details">
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">350GB使用流量</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">8个设备同时使用</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">最高300M速率</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">工单客服支持</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">支持SSR、V2ray节点</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">国内中转节点</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">解锁流媒体</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">可用入门版节点</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">可用基础版节点</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">可用标准版节点</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon bg-danger text-white"><i class="fas fa-times"></i></div>
                                                        <div class="pricing-item-label">IPLC专线节点</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon bg-danger text-white"><i class="fas fa-times"></i></div>
                                                        <div class="pricing-item-label">可用旗舰版节点(可用所有节点)</div>
                          </div>
                                              </div>
                    </div>
                    <div class="pricing-cta" onclick="subscribePlan('plan_3')">
                      <a href="https://suying555.net/user/shop#">订阅 <i class="fas fa-arrow-right"></i></a>
                    </div>
                  </div>
                </div>
                              <div class="col-12 col-md-4 col-lg-4">
                  <div class="pricing pricing-highlight">
                    <div class="pricing-title">
                      旗舰版
                    </div>
                    <div class="pricing-padding">
                      <div class="pricing-price">
                        <div>￥50</div>
                        <div>每月</div>
                      </div>
                      <div class="pricing-details">
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">600GB使用流量</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">16个设备同时使用</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">不限制速率</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">Telegram客服技术支持</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">支持SSR、V2ray节点</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">国内中转节点</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">解锁流媒体</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">可用入门版节点</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">可用基础版节点</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">可用标准版节点</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">IPLC专线节点</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">可用旗舰版节点(可用所有节点)</div>
                          </div>
                                              </div>
                    </div>
                    <div class="pricing-cta" onclick="subscribePlan('plan_4')">
                      <a href="https://suying555.net/user/shop#">订阅 <i class="fas fa-arrow-right"></i></a>
                    </div>
                  </div>
                </div>
                              <div class="col-12 col-md-4 col-lg-4">
                  <div class="pricing pricing-highlight">
                    <div class="pricing-title">
                      旗舰版大流量
                    </div>
                    <div class="pricing-padding">
                      <div class="pricing-price">
                        <div>￥88</div>
                        <div>每月</div>
                      </div>
                      <div class="pricing-details">
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">1200GB使用流量</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">16个设备同时使用</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">不限制速率</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">Telegram客服技术支持</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">支持SSR、V2ray节点</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">国内中转节点</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">解锁流媒体</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">可用入门版节点</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">可用基础版节点</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">可用标准版节点</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">IPLC专线节点</div>
                          </div>
                                                  <div class="pricing-item">
                                                          <div class="pricing-item-icon"><i class="fas fa-check"></i></div>
                                                        <div class="pricing-item-label">可用旗舰版节点(可用所有节点)</div>
                          </div>
                                              </div>
                    </div>
                    <div class="pricing-cta" onclick="subscribePlan('plan_5')">
                      <a href="https://suying555.net/user/shop#">订阅 <i class="fas fa-arrow-right"></i></a>
                    </div>
                  </div>
                </div>
                          </div>
          </div>
        </section>
</div>


</template>

<script lang="ts">
import Vue from 'vue'
export default Vue.extend({
    
})

</script>

<style  scoped>
@import "bootstrap.min.css";

@import "style-purple.css";
@import "shop.css";

@import "malio.css";

</style>