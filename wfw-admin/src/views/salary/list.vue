<template>
  <div class="app-container">
  
    <el-table  :data="list" border fit highlight-current-row style="width: 100%">
    
    <el-table-column width="50px" align="center" label="薪资项id">
        <template slot-scope="scope">
          <span>{{ scope.row.id }}</span>
        </template>
     </el-table-column>

     <el-table-column width="50px" align="center" label="分组id">
        <template slot-scope="scope">
          <span>{{ scope.row.groupId }}</span>
        </template>
     </el-table-column>

      <el-table-column width="100px" align="center" label="字段名称">
        <template slot-scope="scope">
          <span>{{ scope.row.fieldName }}</span>
        </template>
     </el-table-column>

        <el-table-column width="50px" align="center" label="字段类型">
            <template slot-scope="scope">
              <span>{{ scope.row.fieldType }}</span>
            </template>
          </el-table-column>
     
      <el-table-column width="100px" align="center" label="字段值">
        <template slot-scope="scope">
          <span>{{ scope.row.fieldValue }}</span>
        </template>
     </el-table-column>

        <el-table-column width="50px" align="center" label="模板ID">
        <template slot-scope="scope">
          <span>{{ scope.row.tempId }}</span>
        </template>
      </el-table-column>
     <el-table-column width="50px" align="center" label="数据源类型">
        <template slot-scope="scope">
          <span>{{ scope.row.rulesType }}</span>
        </template>
      </el-table-column>

     <el-table-column width="50px" align="center" label="引用表">
        <template slot-scope="scope">
          <span>{{ scope.row.reffieldTable }}</span>
        </template>
      </el-table-column>

    <el-table-column width="150px" align="center" label="薪资规则">
        <template slot-scope="scope">
          <span>{{ scope.row.rules }}</span>
        </template>
      </el-table-column>
      <el-table-column width="50px" align="center" label="状态">
        <template slot-scope="scope">
          <span>{{ scope.row.status }}</span>
        </template>
      </el-table-column>

       <el-table-column align="center" label="Actions" width="300">
        <template slot-scope="scope">
          <router-link :to="'/template/edititem/'+scope.row.id">
            <el-button type="primary" size="small" icon="el-icon-edit">
              设置薪资规则
            </el-button>
          </router-link>
        <!-- <router-link :to="'/process/list/'+scope.row.id">
            <el-button type="primary" size="small" icon="el-icon-edit">
              查看流程
            </el-button>
          </router-link> -->

          <router-link :to="'/flow/edit/'+scope.row.id">
            <el-button type="primary" size="small" icon="el-icon-edit">
              薪资计算
            </el-button>
          </router-link>
          
          <!-- <el-button type="danger" size="small" @click="handleDelete(scope.row.id)">Delete</el-button> -->
        </template>
      </el-table-column>
    </el-table>
    <!-- <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.pageSize" @pagination="getList" /> -->
  </div>
</template>

<script>
import { getSalaryItemList, deleteMessage,addMessage } from '@/api/salary'
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
    
    const id = this.$route.params && this.$route.params.id
    //alert(id)
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
          this.getList(id)
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
      //alert()
      getSalaryItemList(id).then(response => {
        //alert(response.data)
        console.info(response.data)
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
