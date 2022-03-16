<template>
  <div class="app-container">
  
    <el-table  :data="list" border fit highlight-current-row style="width: 100%">
    
    <el-table-column width="100px" align="center" label="字段id">
        <template slot-scope="scope">
          <span>{{ scope.row.id }}</span>
        </template>
     </el-table-column>

      <el-table-column width="100px" align="center" label="字段名称">
        <template slot-scope="scope">
          <span>{{ scope.row.name }}</span>
        </template>
     </el-table-column>

        <el-table-column width="150px" align="center" label="字段类型">
        <template slot-scope="scope">
          <span>{{ scope.row.fieldType }}</span>
        </template>
      </el-table-column>


      <el-table-column width="150px" align="center" label="所属流程">
        <template slot-scope="scope">
          <span>{{ scope.row.flowId }}</span>
        </template>
      </el-table-column>

      <el-table-column width="50px" align="center" label="状态">
        <template slot-scope="scope">
          <span>{{ scope.row.status }}</span>
        </template>
      </el-table-column>

    <!-- <el-form-item label="服务器等级" prop="status">
        <el-select v-model="scope.row.status">
          <el-option
            v-for="item in list"
            :key="item.id"
            :label="item.name"
            :value="item.id"
          />
        </el-select>
      </el-form-item> -->

       <el-table-column align="center" label="Actions" width="300">
        <template slot-scope="scope">
          <router-link :to="'/process/list/'+scope.row.id">
            <el-button type="primary" size="small" icon="el-icon-edit">
              编辑
            </el-button>
          </router-link>
        <!-- <router-link :to="'/process/list/'+scope.row.id">
            <el-button type="primary" size="small" icon="el-icon-edit">
              查看流程
            </el-button>
          </router-link> -->

          <!-- <router-link :to="'/flow/edit/'+scope.row.id">
            <el-button type="primary" size="small" icon="el-icon-edit">
              查看任务
            </el-button>
          </router-link> -->
          
          <el-button type="danger" size="small" @click="handleDelete(scope.row.id)">Delete</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.pageSize" @pagination="getList" /> -->
  </div>
</template>

<script>
import { listformfield, deleteMessage,} from '@/api/form'
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
      //alert(id)
      listformfield(id).then(response => {
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
