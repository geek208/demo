<template>
<div class="info">
    <div class="title">
        <h2>订单详情</h2>
    </div>
<el-form ref="postForm" :v-model = "postForm" class="form-container" label-width="100px" >
            <input type="text hidden" hidden :v-model ="postForm.packageId" />
            <input type="text hidden" hidden :v-model ="postForm.accountId" />
            <input type="text hidden" hidden :v-model ="postForm.packageName" />
            <input type="text hidden" hidden :v-model ="postForm.payType" />
            <input type="text hidden" hidden :v-model ="postForm.orderNo" />
            <input type="text hidden" hidden :v-model ="postForm.total" />

<div class="container">
            <div class="jiesuan">
                <div><p class="selectpan">订单号 :{{postForm.orderNo}}</p></div>
                <!-- <div><p class="selectpan">套餐号 :{{postForm.packageId}}</p></div>
                <div><p class="selectpan">账号 :{{postForm.accountId}}</p></div> -->
                <!-- <div><p class="selectpan">付款方式 :{{postForm.payType}}</p></div> -->
                <div><p class="selectpan">商品名称 :{{postForm.packageName}}</p></div>
                <!-- <div><p class="selectpan">优惠价格 0</p></div> -->
                <div><p class="selectpan">实际支付:{{postForm.total}}</p></div>
                <!-- <div><p class="selectpan">总价::  {{postForm.total}}</p></div> -->
                <!-- <div><p class="selectpan">留言::  {{postForm.total}}</p></div> -->
                <!-- <div><p class="">民航局回应川航飞行员确诊新冠肺炎】12月16日，民航局召开例行新闻发布会。针对近日四川航空1名国际货运航班飞行员感染新冠肺炎病毒情况，民航局航安办主任熊杰表示，了解到有关情况后，民航局第一时间成立专门调查组，组织行业专家，依据民航运行特点，迅速开展流行病学调查。以高度负责的态度与各有关部门一道，尽快查明原因，特别是查找疫情防控过程中存在的风险点。下一步，民航局将进一步加大监督检查力度，督促运输航空公司、机场严格按《疫情防控技术指南》防疫要求，细化各项防控措施，加强人员管理，强化企业在疫情防控中的主体责任和个人的防护责任，坚决阻断疫情通过航空途径传播
                </p></div> -->
                 <el-button v-loading="loading" class='submitbtn' style="margin-left: 10px;" type="success" @click="submitForm">
                    立即支付
                </el-button>
            </div>

</div>

</el-form>
</div>


</template>
<script>
import { pay,getOrder} from '@/api/order'


export default {
  data(){
    return{
       postForm:{
              amount: this.$route.query.amount,
              payType: 'alipay',
              packageName: this.$route.query.name,
              packageId: this.$route.query.packageId,
              total: this.$route.query.total,
              orderNo:this.$route.query.orderNo,
              accountId:this.$route.query.accountId,
          },
           loading: false,
    }
  },
created() {
    this.getOrder(this.$route.query.id)
  },
  methods:{
    getOrder(id){
      //this.listLoading = true
      //debugger
      getOrder(id).then(response => {

        this.postForm = response.obj
        //this.total = response.obj.total
        //this.listLoading = false
      })
    },
    submitForm(){
       this.loading = true;
       const formData= Object.assign({},this.postForm )
           pay(formData).then(response => {
            
            //if(response.code)
            //订单入库
            //debugger
            //alert(response)
            //console.log("response"+response);
           // console.log("订单入库=="+JSON.stringify(response.obj));
           // console.log("data====="+JSON.stringify(response.obj.data));

            console.log("开始路由付款码==" +response.obj.data.payUrl);
            const vurl  = response.obj.data.payUrl;
            const platformId  = response.obj.data.id;

            this.$router.push({ path: 'pay', query: { url: vurl,platformId:platformId}})
            }).catch(err => {
                this.loading =true
                console.log(err)
            }).finally(() => {
                this.loading = false
            })
    }
  }
}
</script>

<style scoped>

.info{
      font-size: 18px;
    color: #34395e;
    font-weight: 700;
  padding: 10px 20px;
  margin:  10px 20px;

}
.container{
    margin: 20px;
    padding: 10px;
    text-align: center;
    border: 1px solid #ccc;
    color: #303fb3;
    font-size: 18;

    
}

</style>