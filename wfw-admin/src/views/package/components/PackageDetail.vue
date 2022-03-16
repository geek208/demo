<template>
  <div class="createPost-container">
    <el-form ref="postForm" :model="postForm" :rules="rules" class="form-container" label-width="100px">

      <el-form-item label="套餐名字" prop="name">
        <el-input v-model="postForm.name" />
      </el-form-item>

      <el-form-item label="套餐类型" prop="planType">
        <el-select v-model="postForm.planType">
          <el-option
            v-for="item in planTypeOptions"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          />
        </el-select>
        </el-form-item>
     
       <el-form-item label="等级" prop="level">
          <el-select v-model="postForm.level">
          <el-option
            v-for="item in levelOptions"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          />
        </el-select>
      </el-form-item>



      <el-form-item label="最大连接数" prop="connections">
        <el-input v-model="postForm.connections" />
      </el-form-item>

      <el-form-item label="价格" prop="price">
       <el-input v-model="postForm.price" />
      </el-form-item>

      <el-form-item label="带宽" prop="bandwidth">
          <el-select v-model="postForm.bandwidth">
          <el-option
            v-for="item in bandwidthOptions"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          />
        </el-select>
      </el-form-item>

      <el-form-item label="速度" prop="speed">
         <el-select v-model="postForm.speed">
          <el-option
            v-for="item in speedOptions"
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

       <el-form-item label="入门版本" prop="level0">
        <el-input type="textarea" v-model="postForm.level0" />
      </el-form-item>
      <el-form-item label="基础班" prop="level1">
        <el-input type="textarea" v-model="postForm.level1" />
      </el-form-item>

        <el-form-item label="标准班" prop="level2">
        <el-input type="textarea" v-model="postForm.level2" />
      </el-form-item>

       <el-form-item label="旗舰型" prop="level3">
        <el-input type="textarea" v-model="postForm.level3" />
      </el-form-item>
      
      <el-form-item label="旗舰大流量" prop="level4">
        <el-input type="textarea" v-model="postForm.level4" />
      </el-form-item>

      <el-form-item label="IPLC" prop="iplc">
        <el-input type="textarea" v-model="postForm.iplc" />
      </el-form-item>
      <el-form-item label="可用" prop="available">
        <el-input type="textarea" v-model="postForm.available" />
      </el-form-item>
      <el-form-item label="不可用" prop="disabled">
        <el-input type="textarea" v-model="postForm.disabled" />
      </el-form-item>
      


      <el-form-item label="描述" prop="description">
        <el-input type="textarea" v-model="postForm.description" />
      </el-form-item>

      <el-button v-loading="loading" style="margin-left: 10px;" type="success" @click="submitForm">
        提交
      </el-button>
    </el-form>
  </div>
</template>

<script>
import { addPackage,updatePackage,getPackage } from '@/api/package'

import md5 from 'js-md5'
const defaultForm = {
  bandwidth: '60',
  speed: '1',
  price:  '0',
  cycle: '1',
  status: '1',
  name:'',
  interval:'1',
  show:'1',
  available:'100GB使用流量，3个设备同时使用，最高60M速率，工单客服支持，支持SSR、V2ray节点，国内中转节点，解锁流媒体，可用入门版节点',
  disabled:'可用基础版节点，可用标准版节点，IPLC专线节点，可用旗舰版节点(可用所有节点)',
  description:'',
  connections:'5',
  planType:'1',
  level:'0'
}
const defaultRules = {
  bandwidth: { required: true, trigger: 'blur' },
  speed: { required: true,  trigger: 'blur' },
  price: { required: true, trigger: 'blur' },
  circle: { required: true, trigger: 'blur'}
}

export default {
  name: 'PackageDetail',
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
      levelOptions : [{ value: '0', label: '0级' }, { value: '1', label: '1级' },{ value: '2', label: '2级' },{ value: '3', label: '3级' },{ value: '4', label: '4级' }],
      planTypeOptions: [{ value: '0', label: '不可叠加' }, { value: '1', label: '可叠加' }],
      cycleOptions: [{ value: '0', label: '月' }, { value: '1', label: '年' }],
      bandwidthOptions: [{ value: '60', label: '60M' }, { value: '100', label: '100M' },{ value: '300', label: '300M' }],
      speedOptions: [{ value: '1', label: '流畅' }, { value: '2', label: '高速' },{ value: '3', label: '光速' }]
   //   circleOptions: [{ value: 'month', label: '月' }, { value: 'quarter', label: '季’ }，{ value: 'year', label: '年' }]
    }
  },
  computed: {

  },
  created() {
     if (this.isEdit) {
      const id = this.$route.params && this.$route.params.id
      this.fetchData(id)
    }
    // Why need to make a copy of this.$route here?
    // Because if you enter this page and quickly switch tag, may be in the execution of the setTagsViewTitle function, this.$route is no longer pointing to the current page
    // https://github.com/PanJiaChen/vue-element-admin/issues/1221
    this.tempRoute = Object.assign({}, this.$route)
  },
  methods: {
  fetchData(id) {
      console.log('package get id ' + id)
      getPackage(id).then(response => {
          this.postForm = response.obj

      })
    },
    submitForm() {
      console.log(this.postForm)
      this.$refs.postForm.validate(valid => {
        if (valid) {
          this.loading = true
          var req = this.isEdit ? updatePackage(this.postForm) : addPackage(this.postForm)
          req.then(response => {
           // console.log('addserver chenggong !' + response)
            this.$notify({
              title: '成功',
              message: '提交成功',
              type: 'success',
              duration: 2000
            })
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
    }
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