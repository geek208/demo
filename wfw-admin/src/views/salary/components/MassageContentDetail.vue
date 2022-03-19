<template>
  <div class="createPost-container">
    <el-form ref="postForm" :model="postForm" :rules="rules" class="form-container" label-width="100px">

      <!-- <el-form-item label="key描述" prop="name">
        <el-input v-model="postForm.vname" />
      </el-form-item> -->

      <el-form-item label="薪资ID" prop="id">
        <el-input v-model="postForm.id" />
      </el-form-item>

        <el-form-item label="名称" prop="fieldName">
        <el-input v-model="postForm.fieldName" />
      </el-form-item>

        <el-form-item label="模板ID" prop="tempId">
        <el-input v-model="postForm.tempId" />
      </el-form-item>

      <el-form-item label="父亲ID" prop="parentId">
        <el-input v-model="postForm.parentId" />
      </el-form-item>

      <el-form-item label="组ID" prop="groupId">
        <el-input v-model="postForm.groupId" />
      </el-form-item>

      <el-form-item label="字段类型" prop="fieldType">
        <el-input v-model="postForm.fieldType" />
      </el-form-item>

       <!-- <el-form-item label="数据源类型" prop="rulesType">
        <el-input v-model="postForm.rulesType" />
      </el-form-item> -->

      <el-form-item label="数据源类型" prop="rulesType">

            <el-select v-model="postForm.rulesType">
              <el-option
                v-for="item in rulesOptions"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              />
            </el-select>
          </el-form-item>

           <el-form-item label="数据源" prop="reffieldTable">

            <el-select v-model="postForm.reffieldTable">
              <el-option
                v-for="item in tableOptions"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              />
            </el-select>
          </el-form-item>
      
       <el-form-item label="规则" prop="rules">
        <el-input v-model="postForm.rules" />
      </el-form-item>

      <!-- <el-form-item label="数据源选择" prop="reffieldTable">
        <el-input v-model="postForm.reffieldTable" />
      </el-form-item>   -->

      <el-form-item label="数据字段" prop="reffieldColumn">
        <el-input v-model="postForm.reffieldColumn" />
      </el-form-item> 
    

      <!-- <input @input="changeUserName" type="text" class="text-input" v-model="query.user_name" placeholder="请输入您的账号" /> -->

    <el-form-item>
      <el-button v-loading="loading" style="margin-left: 10px;" type="success" @click="submitForm">
        提交
      </el-button>
      </el-form-item>

    </el-form>
  </div>
</template>

<script>
import { addMessage, getSalaryItem, updateSalaryItem } from '@/api/salary'
const defaultForm = {
  name: '',
  status: 'true',
}
const defaultRules = {
  name: { required: true, trigger: 'blur' },
  status: { required: true, trigger: 'blur' },

}

export default {
  name: 'MassageContentDetail',
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
      rulesOptions: [{ value: '0', label: '导入' }, { value: '1', label: '数据源引用' },{ value: '2', label: '自定义计算公式' }],
      tableOptions: [{ value: '0', label: '薪资档案' }, { value: '1', label: '考勤数据' },{ value: '2', label: '社保数据' },{ value: '3', label: '个税数据' },{ value: '4', label: '专项扣除数据' }]
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
      console.log('msg get id ' + id)
      getSalaryItem(id).then(response => {
        this.postForm = response.data

      })
    },

   
    submitForm() {
      console.log(this.postForm)
      this.$refs.postForm.validate(valid => {
        if (valid) {
          this.loading = true
          var req = this.isEdit ? updateSalaryItem(this.postForm) : addMessage(this.postForm)
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
