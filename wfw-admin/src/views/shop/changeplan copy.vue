<template>
<div class="container">
      
   <el-form ref="postForm" :v-model = "postForm" class="form-container" label-width="100px" >

            <input type="text hidden" hidden :v-model ="postForm.packageId" />
            <input type="text hidden" hidden :v-model ="postForm.packageName" />
            <input type="text hidden" hidden :v-model ="postForm.total" />
            <input type="text hidden" hidden :v-model ="postForm.level" />

            <div><p class="selectpan">选择会员计划</p></div>
            <div class="plangroup">
                <div @click="changeplan(1,'入门版')" :class="postForm.amount ==1?'planitem active':'planitem'">
                    <div class="planprice"><span>¥1</span><p>/月</p></div>
                    <div class="planname">入门版</div>
                </div>
                <div @click="changeplan(2,'基础版')" :class="postForm.amount ==2?'planitem active':'planitem'">
                      <div class="planprice"><span>¥15.9</span><p>/月</p></div>
                    <div class="planname">基础版</div>
                </div>
                <div @click="changeplan(3,'标准版')" :class="postForm.amount ==3?'planitem active':'planitem'">
                    <div class="planprice"><span>¥25.9</span><p>/月</p></div>
                    <div class="planname">标准版</div>
                </div>
                  <div @click="changeplan(50,'旗舰版')" :class="postForm.amount ==50?'planitem active':'planitem'">
                    <div class="planprice"><span>¥50</span><p>/月</p></div>
                    <div class="planname">旗舰版</div>
                </div>
                  <div @click="changeplan(88,'旗舰大流量版')" :class="postForm.amount ==88?'planitem active':'planitem'">
                    <div class="planprice"><span>¥88</span><p>/月</p></div>
                    <div class="planname">旗舰大流量版</div>
                </div>
            </div>

            <div><p class="selectpan">选择会员时长</p></div>

               <div class="monthgroup">
                <div @click="changemonth(1)" :class="postForm.month ==1?'monthitem active':'monthitem'">
                    <div class="monthprice"><span>1个月</span></div>
                </div>
                <div @click="changemonth(3)" :class="postForm.month ==3?'monthitem active':'monthitem'">
                      <div class="monthprice"><span>3个月</span></div>
                </div>
                <div @click="changemonth(6)" :class="postForm.month ==6?'monthitem active':'monthitem'">
                    <div class="monthprice"><span>6个月</span></div>
                </div>
                  <div @click="changemonth(12)" :class="postForm.month ==12?'monthitem active':'monthitem'">
                      <div class="monthprice"><span>12个月</span></div>
                </div>
                <div @click="changemonth(24)" :class="postForm.month ==24?'monthitem active':'monthitem'">
                    <div class="monthprice"><span>24个月</span></div>
                </div>
            </div>

            <div><p class="selectpan">支付方式</p></div>
              
               <div class="paygroup">
                <div @click="changepay('alipay')" :class="postForm.payType =='alipay'?'payitem active':'payitem'">
                    <div class="payname"> 
                                  <svg class="icon" aria-hidden="true">
                      <use xlink:href="#icon-xianxingzhifubaotubiao"></use>
                    </svg><span>支付宝</span></div>
                </div>
                <div @click="changepay('weichat')" :class="postForm.payType =='weichat'?'payitem active':'payitem'">
                      <div class="payname"> 
                        <svg class="icon" aria-hidden="true">
                        <use xlink:href="#icon-weixinzhifu"></use>
                      </svg><span>微信支付</span></div>
                </div>
                
            </div>
  


            <div><p class="selectpan">购买需知</p>
               购买会员计划即代表同意《服务条款》和《使用政策》。
            </div>
            <div class="jiesuan">
                <div><p class="selectpan">商品名称  :{{postForm.packageName}}</p></div>
                <!-- <div><p class="selectpan">优惠价格 0</p></div> -->
                <div><p class="selectpan">实际支付::{{postForm.total}}</p></div>
                <!-- <div><p class="selectpan">总价::  {{postForm.total}}</p></div> -->
                <!-- <div><p class="">民航局回应川航飞行员确诊新冠肺炎】12月16日，民航局召开例行新闻发布会。针对近日四川航空1名国际货运航班飞行员感染新冠肺炎病毒情况，民航局航安办主任熊杰表示，了解到有关情况后，民航局第一时间成立专门调查组，组织行业专家，依据民航运行特点，迅速开展流行病学调查。以高度负责的态度与各有关部门一道，尽快查明原因，特别是查找疫情防控过程中存在的风险点。下一步，民航局将进一步加大监督检查力度，督促运输航空公司、机场严格按《疫情防控技术指南》防疫要求，细化各项防控措施，加强人员管理，强化企业在疫情防控中的主体责任和个人的防护责任，坚决阻断疫情通过航空途径传播
                </p></div> -->
                 <!-- <input type="button" value="提交订单"> -->
                 <el-button v-loading ="loading" class='submitbtn' style="margin-left: 10px;" type="success" @click="submitForm">
                    提交订单
                </el-button>
            </div>

   </el-form>
</div>
      <!-- <div class="desc"><p>购买须知
 购买会员计划即代表同意《服务条款》和《使用政策》。</p></div> -->
      <!-- <div class="payselect"><p class="paytype">微信支付</p><p class="paytype">支付宝</p></div> -->
      <!-- <table class="taocan-table">
        <tr><td width='30%' class="title">账单详情</td><td></td></tr>
      <tr>
        <td width='30%' class="left">商品名称</td><td class="right total">入门版本</td>
      </tr>
      <tr>
        <td class="left">总价</td><td class="right total">123456789</td>
      </tr>
        <tr>
        <td width='30%' class="left">支付方式</td>
        <td class="right">
        <input type="radio" name="payType" id="" class="bluebtn" label="kkkjk'">微信支付</input><input type="radio" class="bluebtn" name="payType" id="">支付宝</input>
       </td>
      </tr>
    </table> -->
     
</template>
<script scoped>
import { addOrder } from '@/api/order'
//alert(this.$route.query.amount)
export default {
  data(){
    return{
          postForm:{
              amount:this.$route.query.amount,
              month: 1,
              total:this.$route.query.amount,
              payType: 'alipay',
              packageName:this.$route.query.packageName,
              packageId:this.$route.query.packageId,
              level:this.$route.query.level,
              accountId:null,
              attch:'留言'
          },
           loading: false,
         
    }
  },
 
  methods:{

    submitForm(){


       this.loading = true;
       const formData= Object.assign({},this.postForm )
        // const formData= Object.assign({},{this.amount, this.month+this.data})

         addOrder(formData).then(response => {

        //console.log("pay==="+response.obj.pay+"payNo ======"+response.obj.platformId)
        const obj =  response.obj;

        console.log(obj.amount+' =====  '+obj.accountId+'======='+obj.packageId)
        this.$router.push({ path: "bill", query: {amount:obj.amount,packageId:obj.packageId,name:obj.packageName,orderNo:obj.orderNo,accountId:obj.accountId,total:obj.total}})
        }).catch(err => {
          //  loading =true
            console.log(err)
        }).finally(() => {
            this.loading = false
        })
    },
    changeplan(amount,planname){
     // alert(index);

      //debugger
      this.postForm.amount = amount;
      this.postForm.packageName = planname;
     // if(amount )
      const v = this.postForm.month*amount;
      this.postForm.total = v.toFixed(2);
     // alert( ..tabamount);
      //console.log(this.amount);
     // console.log('this.total===================='+num.toFixed(this.total))
    },
    changemonth(month){
       // alert(index);
      this.postForm.month = month;
      const v  = this.postForm.amount*month;
      this.postForm.total = v.toFixed(2);
     // alert( this.tabindex);
      console.log(this.postForm.month);
    },
    changepay(paytype){
  // alert(index);
      this.postForm.payType = paytype;

      console.log(paytype);
    }
  }
}
</script>
<style scoped>

.icon {
  width: 2em;
  height: 2em;
  vertical-align: -0.15em;
  fill: currentColor;
  overflow: hidden;
}

.container{
  margin: 10px 20px;
  padding: 10px,10px;
}

.selectpan{
  margin: 15px;
  color: #6777ef;
  font-size: 16px;
  font-weight: 600;
  
}

.jiesuan{
  right: 0px;
  bottom: 10px;
  text-align: right;
  padding: 20px;
  margin: 10px;
}

/**套餐选择 */
.plangroup{
  display: flex;
}


.planitem{
  width: 150px;
  height: 120px;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
  border-bottom-left-radius: 10px;
  border-bottom-right-radius: 10px;
  margin: 10px 30px;
  text-align: center;
  border:1px solid #ccc;
  
}

.plangroup .active{
  background-color:  #6777ef;
  border:1px solid rgb(36, 126, 201);
  color:#fff
}

.planitem:hover{
  
  border:1px solid rgb(36, 126, 201);
}


.planprice{
  left: 0px;
  top: 0px;
  position: relative;
  display: flex;
  flex: 1;
}

.planprice  span{
  font-size: 30px;
  font-weight: 600;
  padding: 15px;
}

.planprice  p{
 padding: 10px;
 font-size: 14px;
}


.planname{
  background-color: white;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
  border-bottom-left-radius: 10px;
  border-bottom-right-radius: 10px;
  color: #6777ef;
  text-align: center;
  margin-left: 30px;
  width:40%;
}


.planname:hover{
    background-color:  #6777ef;
    color: #fff;
}


/** 月份选择 */

.monthgroup{
  display: flex;
  margin-left: 20px;
  align-items: center;
  text-align: center;
}


 .monthitem{
  width: 100px;
  height: 50px;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
  border-bottom-left-radius: 10px;
  border-bottom-right-radius: 10px;
  margin: 30px 10px;
  text-align: center;
  border:1px solid #ccc;
}

.monthgroup .active{
  background-color:  #6777ef;
  border:1px solid rgb(36, 126, 201);
  color: #fff;
}

.monthitem:hover{
  background-color: 2px solid #6777ef;
  border:1px solid rgb(36, 126, 201);
}


.monthprice{
  left: 0px;
  top: 0px;
  position: relative;
  display: flex;
  flex: 1;
}

.monthprice  span{
  font-size: 16px;
  font-weight: 600;
  padding: 15px;
  text-align: center;
}


/**支付方式 */

.paygroup{
  display: flex;
  margin-left: 20px;
  align-items: center;
  text-align: center;
}


 .payitem{
  width: 120px;
  height: 40px;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
  border-bottom-left-radius: 10px;
  border-bottom-right-radius: 10px;
  margin: 30px 10px;
  text-align: center;
  border:1px solid #ccc;
}

.paygroup .active{
  background-color:  #6777ef;
  border:1px solid rgb(36, 126, 201);
  color: #fff;
}

.payitem:hover{
  background-color: 1px solid #6777ef;
  border:1px solid rgb(36, 126, 201);
}


.payname{
  left: 0px;
  top: 0px;
  position: relative;
  display: flex;
  flex: 1;
}

.payname  span{
  font-size: 16px;
  font-weight: 400;
  padding: 5px;
  text-align: center;
}


</style>