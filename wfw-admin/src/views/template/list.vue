<template>
  <div class="app-container">
  
    <el-table  :data="list" border fit highlight-current-row style="width: 100%">
    
    <el-table-column width="100px" align="center" label="模板id">
        <template slot-scope="scope">
          <span>{{ scope.row.id }}</span>
        </template>
     </el-table-column>

      <el-table-column width="100px" align="center" label="模板名称">
        <template slot-scope="scope">
          <span>{{ scope.row.tempalteName }}</span>
        </template>
     </el-table-column>

        <el-table-column width="150px" align="center" label="企业ID">
        <template slot-scope="scope">
          <span>{{ scope.row.cpyId }}</span>
        </template>
      </el-table-column>

      <el-table-column width="150px" align="center" label="计薪周期">
        <template slot-scope="scope">
          <span>{{ scope.row.circle }}</span>
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
              薪资计算
            </el-button>
          </router-link>

           <router-link :to="'/template/listitem/'+scope.row.id">
            <el-button type="primary" size="small" icon="el-icon-edit">
              查看薪资项
            </el-button>
          </router-link>

        <!-- <router-link :to="'/process/list/'+scope.row.id">
            <el-button type="primary" size="small" icon="el-icon-edit">
              查看流程
            </el-button>
          </router-link> -->

          <router-link :to="'/activity/list/'+scope.row.id">
            <el-button type="primary" size="small" icon="el-icon-edit">
              添加算薪人员
            </el-button>
          </router-link>

          <router-link :to="'/form/listformfield/'+scope.row.id">
            <el-button type="primary" size="small" icon="el-icon-edit">
              查看表单
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
import { listFlow, deleteMessage,addMessage } from '@/api/template'
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
      listFlow(this.listQuery).then(response => {
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
