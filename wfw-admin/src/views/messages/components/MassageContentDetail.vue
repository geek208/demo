<template>
  <div class="createPost-container">
    <el-form ref="postForm" :model="postForm" :rules="rules" class="form-container" label-width="100px">

      <!-- <el-form-item label="key描述" prop="name">
        <el-input v-model="postForm.vname" />
      </el-form-item> -->

      <el-form-item label="标题" prop="title">
        <el-input v-model="postForm.title" />
      </el-form-item>

      <!-- <el-form-item label="内容" prop="messageContent">
        <el-input v-model="postForm.messageContent" />
      </el-form-item> -->

        <el-form-item label="内容" prop="messageContent">
        <el-input type="textarea" style="height：400px" v-model="postForm.messageContent" />
      </el-form-item>

    <el-form-item>
      <el-button v-loading="loading" style="margin-left: 10px;" type="success" @click="submitForm">
        提交
      </el-button>
      </el-form-item>

    </el-form>
  </div>
</template>

<script>
import { addMessage, getMessage, updateMessage } from '@/api/message'
const defaultForm = {
  vname: '',
  vkey: '',
  svalue: 'true',

}
const defaultRules = {
  title: { required: true, trigger: 'blur' },
  messageContent: { required: true, trigger: 'blur' },

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
      getMessage(id).then(response => {
        this.postForm = response.obj

      })
    },
    submitForm() {
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
