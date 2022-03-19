<template>
  <div class="app-container">
  
    <el-table  :data="list" border fit highlight-current-row style="width: 100%">
     
     <el-table-column width="100px" align="center" label="任务id">
        <template slot-scope="scope">
          <span>{{ scope.row.id }}</span>
        </template>
     </el-table-column>

      <el-table-column width="100px" align="center" label="任务名称">
        <template slot-scope="scope">
          <span>{{ scope.row.taskName }}</span>
        </template>
     </el-table-column>

    <el-table-column width="100px" align="center" label="创建时间">
        <template slot-scope="scope">
          <span>{{ scope.row.createDate }}</span>
        </template>
     </el-table-column>


        <el-table-column width="50px" align="center" label="流程名称">
        <template slot-scope="scope">
          <span>{{ scope.row.flowId }}</span>
        </template>
      </el-table-column>


        <el-table-column width="100px" align="center" label="进程名">
        <template slot-scope="scope">
          <span>{{ scope.row.pid }}</span>
        </template>
      </el-table-column>

      <el-table-column width="100px" align="center" label="状态">
        <template slot-scope="scope">
          <span>{{ scope.row.status }}</span>
        </template>
      </el-table-column>

       <el-table-column align="center" label="Actions" width="241">
        <template slot-scope="scope">
          
          <router-link :to="'/task/edit/'+scope.row.id">
            <el-button type="primary" size="small" icon="el-icon-edit">
              审批
            </el-button>
          </router-link>

        <!-- <router-link :to="'/process/list/'+scope.row.id">
            <el-button type="primary" size="small" icon="el-icon-edit">
              查看流程
            </el-button>
          </router-link> -->
          <!-- <el-button type="primary" size="small" @click="dotask(scope.row.id)">同意</el-button> -->

          <!-- <router-link :to="'/flow/edit/'+scope.row.id">
            <el-button type="primary" size="small" icon="el-icon-edit"  @click="dotask(scope.row.id)">
              拒绝
            </el-button>
          </router-link> -->
          
          <!-- <el-button type="primary" size="small" @click="dotask(scope.row.id)">同意</el-button> -->
        </template>
      </el-table-column>
    </el-table>
    <!-- <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.pageSize" @pagination="getList" /> -->
  </div>
</template>

<script>
import { listTodoTask, dotask} from '@/api/task'
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
      // postForm: Object.assign({}, defaultForm),
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
    // handleDelete(id) {
    //   this.$confirm('审批, 是否继续?', '提示', {
    //     confirmButtonText: '确定',
    //     cancelButtonText: '取消',
    //     type: 'warning'
    //   }).then(() => {
    //     dotask(id).then(() => {
    //       this.$message({
    //         type: 'success',
    //         message: '删除成功!'
    //       })
    //       this.getList()
    //     }).catch(() => {
    //       this.$message({
    //         type: 'info',
    //         message: '已取消删除'
    //       })
    //     })
    //   })
    // },

    dotask(id) {
      
      this.$confirm('审批, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        //alert(id)
        dotask(id).then(() => {
          this.$message({
            type: 'success',
            message: '审批成功!'
          })
          this.getList()
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消'
          })
        })
      })
    },
    getList() {
      //this.listLoading = true
      //alert()
      listTodoTask(this.listQuery).then(response => {
        //alert(response.data)
       // console.info(response.obj.content)
        this.list = response.data
        //this.total = response.obj.total
       // this.listLoading = false
      })
    },
 
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
