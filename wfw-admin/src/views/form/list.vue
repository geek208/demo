<template>
  <div class="app-container">
    <el-form ref="postForm"  class="form-container" label-width="100px">
      <!-- <el-form-item label="名称" prop="name">
        <el-input v-model="postForm.name" />
      </el-form-item> -->
      <div class="app-container" v-for="item in list">
        <!-- <div>{{item.title}}<i v-if="item.isRequired===1">*</i></div> -->
      <span>{{ item.name }}</span>
      <div class="app-container" v-bind="item.id">
          <input type="text" :placeholder="'请输入'+item.name" v-model="item.fieldvalue">
        </div>
      </div>

    
    <!-- <el-table v-loading="listLoading" :data="list" border fit highlight-current-row style="width: 100%">
    
      <el-table-column width="100px" align="center" label="字段名">
        <template slot-scope="scope">
          <span>{{ scope.row.name }}</span>
        </template>
      </el-table-column>

      <el-table-column width="150px" align="center" label="表单号">
        <template slot-scope="scope">
          <span>{{ scope.row.formId }}</span>
        </template>
      </el-table-column>
      
      <el-table-column width="150px" align="center" label="字段值">
        <template slot-scope="scope">
           <el-input v-model="postForm.name" />
          <span>{{ scope.row.formId }}</span>
        </template>
      </el-table-column>


      <el-table-column width="150px" align="center" label="进程号">
        <template slot-scope="scope">
          <span>{{ scope.row.formId }}</span>
        </template>
      </el-table-column>


      <el-table-column width="150px" align="center" label="状态">
        <template slot-scope="scope">
          <span>{{ scope.row.status }}</span>
        </template>
      </el-table-column> -->

      

      <!-- <el-table-column align="center" label="Actions" width="241">
        <template slot-scope="scope">
          <router-link :to="'/messages/edit/'+scope.row.id">
            <el-button type="primary" size="small" icon="el-icon-edit">
              Edit
            </el-button>
          </router-link>
          <el-button type="danger" size="small" @click="handleDelete(scope.row.id)">Delete</el-button>
        </template>
      </el-table-column>
    </el-table> -->

    <el-form-item>
      <el-button  style="margin-left: 10px;" type="success" @click="putList">
        提交
      </el-button>
      </el-form-item>

    </el-form>
    <!-- <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.pageSize" @pagination="getList" /> -->
  </div>
</template>

<script>
import { listMessage, deleteMessage,addMessage } from '@/api/message'
// import Pagination from '@/components/Pagination' // Secondary package based on el-pagination
const defaultForm = {
  name: '111111',
  fieldvalue: '111111111'
}
export default {
  name: 'MessageList',
  // components: { Pagination },
  filters: {  
  },
  data() {
    return {
      list: null,
      postForm: Object.assign({}, defaultForm),
      // total: 0,
      // listLoading: true,
      // listQuery: {
      //   page: 1,
      //   pageSize: 10
      // }
    }
  },
  created() {
    //alert()
    this.getList()
  },
  methods: {
    handleDelete(id) {
      this.$confirm('此操作将永久删除, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteMessage(id).then(() => {
          this.$message({
            type: 'success',
            message: '删除成功!'
          })
          this.getList()
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          })
        })
      })
    },
    getList() {
      //this.listLoading = true
      //alert()
      listMessage(this.listQuery).then(response => {
        alert(response.data)
       // console.info(response.obj.content)
        this.list = response.data
        //this.total = response.obj.total
       // this.listLoading = false
      })
    },
    submitForm() {
      console.log(this.postForm)
      this.$refs.postForm.validate(valid => {
        if (valid) {
         // this.loading = true
          var req =  addMessage(this.postForm)
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
            //this.loading = false
          })
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    putList(){
            console.log(this.list)
             alert(this.list)
            // jsonList 就是前端普通的实体类集合数据
          var req =  addMessage(this.list)
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
            //this.loading = false
          })

            // this.$axios.post("/wfwactivity/postFormFields", this.list)
            //     .then(response => {
            //         const data = response.data;
                    
            //         if (data.code === 200) {
            //             alert("提交成功")
                        
            //         }else{
            //             console.log(data.msg)
            //             return;
            //         }
                   
            //     })
            //     .catch(failResponse => {})
        }


  }
}
</script>

<style scoped>
.edit-input {
  padding-right: 100px;
}
.cancel-btn {
  position: absolute;
  right: 15px;
  top: 10px;
}
</style>
