<template>
  <div class="app-container">
    <el-table v-loading="listLoading" :data="list" border fit highlight-current-row style="width: 100%">

      <el-table-column width="100px" align="center" label="套餐名字">
        <template slot-scope="scope">
          <span>{{ scope.row.name }}</span>
        </template>
      </el-table-column>

      <el-table-column width="50px" align="center" label="带宽">
        <template slot-scope="scope">
          <span>{{ scope.row.bandwidth ||statusFilter2 }}</span>
        </template>
      </el-table-column>

      <el-table-column width="50px" align="center" label="最大连接数">
        <template slot-scope="scope">
          <span>{{ scope.row.connections }}</span>
        </template>
      </el-table-column>

      <el-table-column width="50px" align="center" label="速度">
        <template slot-scope="scope">
         <span>{{ scope.row.speed }}</span>
        </template>
      </el-table-column>

      <el-table-column width="50px" align="center" label="周期">
        <template slot-scope="scope">
           <span>{{ scope.row.cycle }}</span>
        </template>
      </el-table-column>

      <el-table-column width="200px" align="center" label="可用">
        <template slot-scope="scope">
          <span>{{ scope.row.available}}</span>
        </template>
      </el-table-column>

        <el-table-column width="200px" align="center" label="不可用">
        <template slot-scope="scope">
          <span>{{ scope.row.disabled}}</span>
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
            <router-link :to="'/package/edit/'+scope.row.id">
            <el-button type="primary" size="small" icon="el-icon-edit">
              Edit
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
import { packageList, deletePackage } from '@/api/package'
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
        '60': '60M',
        '100': '100M',
        '300': '300M',
        '500': '500M',
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
    updateStatus(id, status) {
      var toStatus = switchStatus(status)
      var PackageDetail = {}
      PackageDetail.id = id
      PackageDetail.status = toStatus
      updatePackageStatus(PackageDetail).then(
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
        deletePackage(id).then(() => {
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
      this.listLoading = true
      //debugger
      packageList(this.listQuery).then(response => {
        this.list = response.obj.content
        this.total = response.obj.total
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
