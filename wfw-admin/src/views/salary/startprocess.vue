<template>
  <div class="app-container">
    <el-table  :data="list" border fit highlight-current-row style="width: 100%">
    
     <el-table-column width="100px" align="center" label="用户ID">
        <template slot-scope="scope">
          <span>{{ scope.row.userId }}</span>
        </template>
     </el-table-column>

    <el-table-column width="100px" align="center" label="模板id">
        <template slot-scope="scope">
          <span>{{ scope.row.id }}</span>
        </template>
     </el-table-column>

      <el-table-column width="100px" align="center" label="模板名称">
        <template slot-scope="scope">
          <span>{{ scope.row.fieldName }}</span>
        </template>
     </el-table-column>

      <el-table-column width="150px" align="center" label="字段值">
        <template slot-scope="scope">
          <span>{{ scope.row.fieldValue }}</span>
        </template>
      </el-table-column>

      <el-table-column width="150px" align="center" label="数据源">
        <template slot-scope="scope">
          <span>{{ scope.row.reffieldTable }}</span>
        </template>
      </el-table-column>

      <el-table-column width="150px" align="center" label="字段名">
        <template slot-scope="scope">
          <span>{{ scope.row.fieldName }}</span>
        </template>
      </el-table-column>
 
       

      <el-table-column width="150px" align="center" label="状态">
        <template slot-scope="scope">
          <span>{{ scope.row.status }}</span>
        </template>
      </el-table-column>

       <el-table-column align="center" label="Actions" width="550">
        <template slot-scope="scope">
         
          <router-link :to="'/template/startprocess/'+scope.row.id">
            <el-button type="primary" size="small" icon="el-icon-edit">
              导出
            </el-button>
          </router-link>

           <router-link :to="'/template/listitem/'+scope.row.id">
            <el-button type="primary" size="small" icon="el-icon-edit">
              查看薪资项
            </el-button>
          </router-link>
          <el-button type="danger" size="small" @click="handleDelete(scope.row.id)">Delete</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.pageSize" @pagination="getList" /> -->
  </div>
</template>

<script>
import { startprocess, deleteMessage,postfields } from '@/api/salary'
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
      pid:null,
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
    const id = this.$route.params && this.$route.params.id
    this.getList(id)
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
    getList(id) {
      //this.listLoading = true
      alert()
      startprocess(id).then(response => {
        alert(response.data)
       // console.info(response.obj.content)
        this.list = response.data
        this.pid  = response.data.pId 
        //this.total = response.obj.total
       // this.listLoading = false
      })
    },

    putList(){
            console.log(this.list)
            // alert(this.list)
            // jsonList 就是前端普通的实体类集合数据
            //alert(this.pid)
          var req =  postfields(this.list)
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
