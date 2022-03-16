<template>
  <div class="createPost-container">
    <el-form ref="postForm" :model="postForm" :rules="rules" class="form-container" label-width="100px">

         <el-form-item label="用户名" prop="userName">
        <el-input v-model="postForm.userName" />
      </el-form-item>
      <el-form-item label="email" prop="email">
        <el-input v-model="postForm.email" />
      </el-form-item>

      <el-form-item label="密码" prop="password">
        <el-input v-model="postForm.password" />
      </el-form-item>

      <el-form-item label="角色" prop="roleId">

        <el-select v-model="postForm.roleId">
          <el-option
            v-for="item in roleOptions"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          />
        </el-select>
      </el-form-item>


       <el-form-item label="部门" prop="orgId">

        <el-select v-model="postForm.orgId">
          <el-option
            v-for="item in orgOptions"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          />
        </el-select>
      </el-form-item>

        <el-form-item label="职位" prop="jobId">

        <el-select v-model="postForm.jobId">
          <el-option
            v-for="item in jobOptions"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          />
        </el-select>
      </el-form-item>

        <el-form-item label="岗位" prop="positionId">

        <el-select v-model="postForm.positionId">
          <el-option
            v-for="item in positionOptions"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          />
        </el-select>
      </el-form-item>

        <el-form-item label="职级" prop="levelId">

        <el-select v-model="postForm.levelId">
          <el-option
            v-for="item in levelOptions"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          />
        </el-select>
      </el-form-item>


      <el-button v-loading="loading" style="margin-left: 10px;" type="success" @click="submitForm">
        提交
      </el-button>
    </el-form>
  </div>
</template>

<script>
import { addUser,getUser } from '@/api/user'
import md5 from 'js-md5'
const defaultForm = {
  email: '',
  //password: '111111',
  role: 'admin'
}
const defaultRules = {
  email: { required: true, trigger: 'blur' },
  password: { required: true, min: 6, trigger: 'blur' },
  role: { required: true, trigger: 'blur' }

}

export default {
  name: 'ServerDetail',
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
      //proleOptions: [{ value: 'vip', label: '会员' }, { value: 'admin', label: '超级管理员' }],
      roleOptions: [{ value: '12', label: '财务' }, { value: '13', label: '人事' }],
      orgOptions: [{ value: '14', label: '销售部' }, { value: '15', label: '技术部' }],
      levelOptions: [{ value: 'p1', label: '工程师' }, { value: 'p2', label: '高级工程师' }],
      positionOptions: [{ value: '1', label: '互联网工程师' }, { value: '2', label: '产品经理' }],
      jobOptions: [{ value: '1', label: '设计师' }, { value: '2', label: '工程师' }]
    }
  },
  computed: {

  },
  created() {
    
    if (this.isEdit) {
      const id = this.$route.params && this.$route.params.id
      //alert(id)
      this.fetchData(id)
    }
    // Why need to make a copy of this.$route here?
    // Because if you enter this page and quickly switch tag, may be in the execution of the setTagsViewTitle function, this.$route is no longer pointing to the current page
    // https://github.com/PanJiaChen/vue-element-admin/issues/1221
    this.tempRoute = Object.assign({}, this.$route)
  },
  methods: {
      fetchData(id) {
      console.log('msg get id ' + id)
      getUser(id).then(response => {
        this.postForm = response.data

      })
    },
    submitEdit() {
      console.log(this.postForm)
      this.$refs.postForm.validate(valid => {
        if (valid) {
          this.loading = true
          var req = this.isEdit ? updateMessage(this.postForm) : addMessage(this.postForm)
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
    },

    submitForm() {
      console.log(this.postForm)
      this.$refs.postForm.validate(valid => {
        if (valid) {
          this.loading = true
          //alert(this.postForm)
          console.log(this.postForm)
           const formData= Object.assign({},this.postForm )
           formData.password=md5(formData.password)
           //alert(formData.password)

           console.log(this.formData)

          addUser(this.postForm).then(response => {
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
