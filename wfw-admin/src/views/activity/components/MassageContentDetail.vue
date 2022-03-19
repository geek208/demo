<template>
  <div class="createPost-container">
    <el-form ref="postForm" :model="postForm" :rules="rules" class="form-container" label-width="100px">

      <!-- <el-form-item label="key描述" prop="name">
        <el-input v-model="postForm.vname" />
      </el-form-item> -->

      <el-form-item label="名称" prop="name">
        <el-input v-model="postForm.name" />
      </el-form-item>

      <el-form-item label="状态" prop="status">
        <el-input v-model="postForm.status" />
      </el-form-item>

    <!-- <el-form-item label="用户类别" prop="userType">
        <el-select v-model="postForm.userType">
          <el-option
            v-for="item in userOptions"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          />
        </el-select>
      </el-form-item> -->

       <el-form-item label="部门" prop="userType">

        <el-select v-model="postForm.userType">
          <el-option
            v-for="item in userOptions"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          />
        </el-select>
      </el-form-item>

      <el-form-item label="审批方式" prop="approveType">
        <el-select v-model="postForm.approveType">
          <el-option
            v-for="item in approveOptions"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          />
        </el-select>
        <!-- <el-select  v-model="postForm.approveType" placeholder="请选择">
            <el-option 
              v-for="item in options_num"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value"
                    >
            </el-option>
        </el-select> -->
      </el-form-item>

    <el-form-item label="审批用户" prop="userId">
          <el-select  v-model="postForm.userId" placeholder="请选择">
            <el-option 
              v-for="item in options_num"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value"
                    >
            </el-option>
        </el-select>
      </el-form-item>

<el-form-item label="选择条件" prop="fieldId">
          <el-select  v-model="postForm.fieldId" placeholder="请选择">
            <el-option 
              v-for="item in options_rules"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value"
                    >
            </el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="规则" prop="rules">
        <el-input v-model="postForm.rules" />
      </el-form-item>

      <!-- <div id="app">
      <select v-model="selected">
          <option v-for="option in options" v-bind:value="option.value">
              {{ option.text }}
          </option>
        </select>
        <span>Selected: {{ selected }}</span>
        <br>
    </div>  -->

        <!-- <template slot-scope='scope'> -->
        <!-- <el-table-column label="姓名" prop="username">
        
          <template >
            <el-select v-model='username'>
              <el-option v-for='item in option' :key='item.id' :value='item.userName' :label='item.userName'></el-option>
            </el-select>
        </template>
        </el-table-column>

        <el-form-item label="内容" prop="status">
          <el-input type="textarea" style="height：400px" v-model="postForm.status" />
      </el-form-item> -->

    <el-form-item>
      <el-button v-loading="loading" style="margin-left: 10px;" type="success" @click="submitForm">
        提交
      </el-button>
      </el-form-item>

    </el-form>
  </div>
</template>

<script>
import { addMessage, getActivity, updateActivity,getUsers,getRoles,getOrgs,getfieldList} from '@/api/activity'
const defaultForm = {
  name: '',
  //password: '111111',
  status: ''
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
      userOptions: [{ value: 0, label: '用户' }, { value: 1, label: '角色' },{ value: 2, label: '部门' }],
      approveOptions: [{ value: 0, label: '或签' }, { value: 1, label: '会签' },{ value: 2, label: '依次审批' }],
      tempRoute: {},
      //selected:"A",
      options_num: [],
      options_rules: [],
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

    //getData(id)
     
     

    // Why need to make a copy of this.$route here?
    // Because if you enter this page and quickly switch tag, may be in the execution of the setTagsViewTitle function, this.$route is no longer pointing to the current page
    // https://github.com/PanJiaChen/vue-element-admin/issues/1221
    this.tempRoute = Object.assign({}, this.$route)
  },
  methods: {
    fetchData(id) {
      console.log('msg get id ' + id)
      getActivity(id).then(response => {
        this.postForm = response.data
        console.log(this.postForm )
        alert(response.data.userType)

        //渲染字段
        getfieldList(response.data.flowId).then(response => {
               let obj=  response.data //{'name':'programmer','age':'22','height':'180'};
                //alert(obj)
                for(let i in obj){
                      console.log(i,obj[i])
                      this.$set(this.options_rules, i, { value:  obj[i].id, label:  obj[i].name});
                  //alert(this.options_num[i].lable)
                  //this.$set(this.$levelOptions, i, parseInt(i) + 1);
                  //this.$forceUpdate()
                }
                    
        });

        if(response.data.userType == 0){
              getUsers(id).then(response => {
                          let obj=  response.data //{'name':'programmer','age':'22','height':'180'};
                          for(let i in obj){
                                console.log(i,obj[i])
                                this.$set(this.options_num, i, { value:  obj[i].id, label:  obj[i].userName});
                                //alert(this.options_num[i].lable)
                                //this.$set(this.$levelOptions, i, parseInt(i) + 1);
                                //this.$forceUpdate()
                          }
                    
                        })
        //
        } 
        if(response.data.userType == 1){
            //alert('角色')
            getRoles(id).then(response => {
                          //this.postForm = response.data
                          //alert(response.data)
                          let obj=  response.data //{'name':'programmer','age':'22','height':'180'};
                          for(let i in obj){
                                console.log(i,obj[i])
                                this.$set(this.options_num, i, { value:  obj[i].id, label:  obj[i].roleName});
                                //alert(this.options_num[i].lable)
                                //this.$set(this.$levelOptions, i, parseInt(i) + 1);
                                //this.$forceUpdate()
                          }
            })
        }else{
            //alert('部门')
            getOrgs(id).then(response => {
                          //this.postForm = response.data
                          //alert(response.data)
                          let obj=  response.data //{'name':'programmer','age':'22','height':'180'};
                          for(let i in obj){
                                console.log(i,obj[i])
                                this.$set(this.options_num, i, { value:  obj[i].id, label:  obj[i].orgName});
                                //alert(this.options_num[i].lable)
                                //this.$set(this.$levelOptions, i, parseInt(i) + 1);
                                //this.$forceUpdate()
                          }
            })
        }


      })

      
    },

    submitForm() {
      console.log(this.postForm)
      this.$refs.postForm.validate(valid => {
        if (valid) {
          this.loading = true
          var req = this.isEdit ? updateActivity(this.postForm) : addMessage(this.postForm)
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


  },
   
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
