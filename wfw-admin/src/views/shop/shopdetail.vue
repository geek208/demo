<template>
  <div class="createPost-container">
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

        <el-select v-model="postForm.cycle">
          <el-option
            v-for="item in cycleOptions"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          />
        </el-select>
      </el-form-item>

      <el-button v-loading="loading" style="margin-left: 10px;" type="success" @click="submitForm">
             结算
      </el-button>
    </el-form>
  </div>
</template>

<script>
import { addOrder,pay } from '@/api/order'

import md5 from 'js-md5'
const defaultForm = {
  amount:  '1',
  packageId: '1',
  status: '0',
  payType: 'alipay',
  attch: '留言',
}

const defaultRules = {

  amount: { required: true, trigger: 'blur' },
  payType: { required: true, trigger: 'blur' },
  circle: { required: true, trigger: 'blur'}
}

export default {
  name: 'PackegeDetail',
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

          this.$router.push({ name: 'jiesuan', params: { }})
          // addOrder(formData).then(response => {
            
          //   //订单入库
          //   console.log("订单入库=="+JSON.stringify(response.obj))
     
          //   console.log("开始弹出结算页==")
            
          //   const vurl  = response.obj.accountId;
          //   const platformId  = response.obj.orderNo;

           // alert(vurl +"         "+platformId);
            //{path: '/transport/dispatch', query: {paicheNo: obj.paicheNo}
            //this.$router.push({path: 'pay'});
            //<router-link :to="{name:'generate', query:{ couponId: record.id }}">生成优惠码</router-link>
            
            //this.$router.push({ name: 'news', params: { userId: 123 }});
            //this.$router.push({ name: 'pay', params: { url: JSON.stringify(response.obj.data.payUrl),orderNo:JSON.stringify(response.obj.data.id) }})
            //this.$router.push({path: 'pay', params: {orderNo: JSON.stringify(response.obj.data.id),url:JSON.stringify(response.obj.data.payUrl)}});
            //this.$router.push({ name: 'jiesuan', params: { accountId: accountId,orderNo:orderNo}})
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

          // }).catch(err => {
          //   console.log(err)
          // }).finally(() => {
          //   this.loading = false
          // })


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
@import "~@/styles/mixin.scss";

.createPost-container {
  position: relative;

  .createPost-main-container {
    padding: 40px 45px 20px 50px;

    .postInfo-container {
      position: relative;
      @include clearfix;
      margin-bottom: 10px;

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