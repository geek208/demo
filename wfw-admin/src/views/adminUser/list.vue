<template>
  <div class="app-container">
    <el-table v-loading="listLoading" :data="list" border fit highlight-current-row style="width: 100%">

      <el-table-column width="150px" align="center" label="email">
        <template slot-scope="scope">
          <span>{{ scope.row.email }}</span>
        </template>
      </el-table-column>

      <el-table-column width="50px" align="center" label="角色id">
        <template slot-scope="scope">
          <span>{{ scope.row.roleId }}</span>
        </template>
      </el-table-column>

       <el-table-column width="50px" align="center" label="部门id">
        <template slot-scope="scope">
          <span>{{ scope.row.orgId }}</span>
        </template>
      </el-table-column>


        <el-table-column width="50px" align="center" label="岗位id">
        <template slot-scope="scope">
          <span>{{ scope.row.positionId }}</span>
        </template>
      </el-table-column>


      <el-table-column width="50px" align="center" label="职位id">
        <template slot-scope="scope">
          <span>{{ scope.row.jobId }}</span>
        </template>
      </el-table-column>

       <el-table-column width="50px" align="center" label="职级id">
        <template slot-scope="scope">
          <span>{{ scope.row.levelId }}</span>
        </template>
      </el-table-column>

      <el-table-column width="100px" align="center" label="备注">
        <template slot-scope="scope">
          <span>{{ scope.row.remark}}</span>
          <span ><el-button type="text" @click="addRemark(scope.row.email,scope.row.id)">修改备注</el-button></span>
        </template>
      </el-table-column>

      <el-table-column width="80px" align="center" label="状态">
        <template slot-scope="{row}">
          <el-tag>
            {{ row.status |statusFilter1 }}
          </el-tag>

        </template>
      </el-table-column>

      <el-table-column align="center" label="Actions" width="241">
        <template slot-scope="scope">
           <router-link :to="'/adminUser/edit/'+scope.row.id">
            <el-button type="primary" size="small" icon="el-icon-edit">
              修改
            </el-button>
          </router-link>
          <el-button type="danger" size="small" @click="updateStatus(scope.row.id,scope.row.status)">{{ scope.row.status | statusFilter3 }}</el-button>
          <el-button type="danger" size="small" @click="handleDelete(scope.row.id)">Delete</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.pageSize" @pagination="getList" />
  
  </div>

</template>

<script>
import { userList, updateUserStatus, delUser,addremark } from '@/api/user'
import Pagination from '@/components/Pagination' // Secondary package based on el-pagination

const switchStatus = function(status) {
  if (status === 1) return 0
  else if (status === 0) return 1
  else throw new Error('status错误')
}
export default {
  name: 'ServerList',
  components: { Pagination },
  filters: {
    statusFilter1(status) {
      const statusMap = {
        1: '正常',
        0: '禁用'
      }
      return statusMap[status]
    },
    statusFilter2(status) {
      const statusMap = {
        'admin': '管理员',
        'vip': '会员'
      }
      return statusMap[status]
    },
    statusFilter3(status) {
      const statusMap = {
        1: '禁用',
        0: '启用'
      }
      return statusMap[status]
    }
  },
  data() {
    return {
      list: null,
      total: 0,
      listLoading: true,
      listQuery: {
        page: 1,
        pageSize: 10
      }
      ,
    }
  },
  created() {
    this.getList()
  },
  methods: {
   addRemark(email,userId) {
        this.$prompt('请输入'+email+'的备注', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
         
        }).then(({ value }) => {

          addremark({'id':userId,'remark':value}).then(()=>{
          this.$message({
            type: 'success',
            message: '修改备注为: ' + value + '成功'
          });
          this.getList()
          })
         
        }).catch(() => {
                
        });
      },
    updateStatus(id, status) {
      var toStatus = switchStatus(status)
      var user = {}
      user.id = id
      user.status = toStatus
      updateUserStatus(user).then(
        () => {
          this.$message({
            type: 'success',
            message: '修改成功!'
          })
          this.getList()
        })
      // .catch(() => {
      //     this.$message({
      //       type: 'error',
      //       message: '修改失败'
      //     });
      //   });
    },
    handleDelete(id) {
      this.$confirm('此操作将永久删除, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        delUser(id).then(() => {
          this.$message({
            type: 'success',
            message: '删除成功!'
          })
          this.getList()
        })
        //   .catch(() => {
        //   this.$message({
        //     type: 'info',
        //     message: '已取消删除'
        //   });
        // });
      })
    },
    getList() {
      this.listLoading = true
      userList(this.listQuery).then(response => {
        this.list = response.data
        //this.total = response.obj.total
        this.listLoading = false
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
