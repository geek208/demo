<template>
<!-- <div class="body"> -->

  <div class="createPost-container">
    
   <div class="selectpan"><p class="">选择会员计划</p></div>
    <el-form ref="postForm" :model="postForm" :rules="rules" class="form-container" label-width="100px">
      <el-form-item label="套餐" prop="packageId">
       <el-select v-model="postForm.packageId">
          <el-option
            v-for="item in packageIdOptions"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="价格" prop="amount">

        <el-select v-model="postForm.amount">
          <el-option
            v-for="item in amountOptions"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          />
        </el-select>
      </el-form-item>

   <div class="selectpan"><p class="">选择购买时长</p></div>
      <el-form-item label="支付方式" prop="payType">

        <el-select v-model="postForm.payType">
          <el-option
            v-for="item in payTypeOptions"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          />
        </el-select>
      </el-form-item>

      <el-form-item label="周期" prop="cycle">


     <input name="circle" type="radio" class="circle">一个月</input>
     <input name="circle" type="radio" class="circle">三个月</input>
     <input name="circle" type="radio" class="circle">6个月</input>
     <input name="circle" type="radio"  class="circle">12个月</input>
     <input name="circle"  type="radio"  class="circle">24个月</input>

        <el-select v-model="postForm.cycle">
          <el-option
            v-for="item in cycleOptions"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          />
        </el-select>
      </el-form-item>



        <!-- <div id="alipay" class="color col-12 col-md-2 col-lg-2" onclick="selectItem('payment','alipay')">
                          <i class="fab fa-alipay" style="font-size: 1.1rem;vertical-align: -1px;margin-right: 2px;"></i> 支付宝
                        </div> -->

       <el-button v-loading="loading" class='submitbtn' style="margin-left: 10px;" type="success" @click="submitForm">
             立即支付
      </el-button>

    </el-form>
  </div>
<!-- </div> -->

</template>

<script>
import { pay } from '@/api/order'
//debugger
//const packageId = this.$route.params.name

import md5 from 'js-md5'
const defaultForm = {
  amount:  '',
  packageId: '',
  status: '0',
  payType: 'alipay',
  attch: '留言',
}
const defaultRules = {
  amount: { required: true, trigger: 'blur' },
  payType: { required: true, trigger: 'blur' },
}

export default {
  name: 'jiesuan',
  props: {
    isEdit: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      postForm: Object.assign({}, defaultForm),
      loading: false,
      rules: Object.assign({}, defaultRules),
      
      tempRoute: {},
      amountOptions: [{ value: '1', label: '1' }, { value: '15', label: '15' }],
      payTypeOptions: [{ value: 'alipay', label: '支付宝' }, { value: 'weichat', label: '微信支付' }],
      cycleOptions: [{ value: '1', label: '月' }, { value: '2', label: '年' }],
      packageIdOptions: [{ value: '1', label: '入门型' }, { value: '2', label: '基础版' }],
   //   circleOptions: [{ value: 'month', label: '月' }, { value: 'quarter', label: '季’ }，{ value: 'year', label: '年' }]
    }
  },
  computed: {

  },
  created() {
    // Why need to make a copy of this.$route here?
    // Because if you enter this page and quickly switch tag, may be in the execution of the setTagsViewTitle function, this.$route is no longer pointing to the current page
    // https://github.com/PanJiaChen/vue-element-admin/issues/1221
    this.tempRoute = Object.assign({}, this.$route)
  },
  methods: {
    submitForm() {
      console.log(this.postForm)
      this.$refs.postForm.validate(valid => {

        if (valid) {

          this.loading = true
          const formData= Object.assign({},this.postForm )
           //formData.speed=md5(formData.speed)
           //debugger
          pay(formData).then(response => {
            
            //订单入库
            console.log("订单入库=="+JSON.stringify(response.obj))
            console.log("data====="+JSON.stringify(response.obj.data))
            console.log("id====================================="+ JSON.stringify(response.obj.data.id))
            console.log("payUrl=================================="+ JSON.stringify(response.obj.data.payUrl))
            
            //window.location.href = 'https://zfm.nnt.ltd/pay?orderNo=1336540289233321984'
            //弹出付款码
            console.log("开始路由付款码==")
            
            const vurl  = response.obj.data.payUrl;
            const platformId  = response.obj.data.id;

           // alert(vurl +"         "+platformId);
            //{path: '/transport/dispatch', query: {paicheNo: obj.paicheNo}
            //this.$router.push({path: 'pay'});
            //<router-link :to="{name:'generate', query:{ couponId: record.id }}">生成优惠码</router-link>
            
            //this.$router.push({ name: 'news', params: { userId: 123 }});
            //this.$router.push({ name: 'pay', params: { url: JSON.stringify(response.obj.data.payUrl),orderNo:JSON.stringify(response.obj.data.id) }})
            //this.$router.push({path: 'pay', params: {orderNo: JSON.stringify(response.obj.data.id),url:JSON.stringify(response.obj.data.payUrl)}});
            this.$router.push({ name: 'pay', params: { url: vurl,platformId:platformId}})
           //  this.$router.push({path: 'pay', query: {orderNo: JSON.stringify(response.obj.data.id),url:JSON.stringify(response.obj.data.payUrl)}});
            //  this.$r/      path: 'pay',
            //               params: {
            //                   url: "http://baidu.com"                          }
            //         });
            //this.$store.state.iframesrc=this.$router.meta.link;
           // payredirect(response);
            //JSON.
            //if(response.data.)
            //支付
            //pay();

        
        /*
            this.$notify({
              title: '成功',
              message: '提交成功',
              type: 'success',
              duration: 2000
            })
           */

          }).catch(err => {
            console.log(err)
          }).finally(() => {
            this.loading = false
          })
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },

  
  }
}

</script>

<style lang="scss" scoped>


.circle{
  height: 50px;
  width: 50px;
  font-size: 80px;
  font-weight: 600;
    
}

.submitbtn{
  text-align: center;
  border-radius: 10px;
  padding: 10px;
}

.taocan-table{
   margin: 20px;
   border: 2px;
   width: 75%; 
   min-height: 25px; 
   line-height: 25px; 
   text-align: right; 
   border-collapse: collapse;

}


.left{
  text-align: right;
  background-color: rgb(38, 0, 255);
  font-size: 16px;
  padding: 20px;
}



.right{
  text-align: left;
  background-color: rgb(0, 255, 98);
  font-size: 16px;
  padding: 20px;
}

.title{
  text-align: left;
  color: #6777ef;
  font-size: 20px;
  background-color: #bfcbd9;
}

.title{
  padding: 20px;
}

.paytype{
  display: flex;
  position: fixed;
  line-height: 50px;
  background-color: aqua;
  width: 80px;
  height: 100px;
  border-radius: 10px;
  text-align: center;
  color: azure;
  border: 1px solid red;
}


@import "~@/styles/mixin.scss";

// @import '../../assets/css/style-purple.css';
// @import '../../assets/css/components.css';
// @import '../../assets/css/malio.css';

.createPost-container {
  position: relative;

  .createPost-main-container {
    padding: 40px 45px 20px 50px;

    .postInfo-container {
      position: relative;
      @include clearfix;
      margin-bottom: 10px;
      text-align: center;

      .postInfo-container-item {
        float: left;
      }
    }
  }

  .word-counter {
    width: 40px;
    position: absolute;
    right: 10px;
    top: 0px;
  }
}

  .bluebtn{
    font-size: 25px;
    margin: 20px;
    background-color: #6777ef;
    color: #fff;
  }

.article-textarea /deep/ {
  textarea {
    padding-right: 40px;
    resize: none;
    border: none;
    border-radius: 0px;
    border-bottom: 1px solid #bfcbd9;
  }
}





</style>