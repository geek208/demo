<template>
  <div class="app-container">
    <el-table v-loading="listLoading" :data="list" border fit highlight-current-row style="width: 100%">

      <!-- <el-table-column width="100px" align="center" label="账号">
        <template slot-scope="scope">
          <span>{{ scope.row.accountId }}</span>
        </template>
      </el-table-column> -->

      <el-table-column width="100px" align="center" label="套餐">
        <template slot-scope="scope">
          <span>{{ scope.row.packageName }}</span>
        </template>
      </el-table-column>

        <!-- <el-table-column width="200px" align="center" label="周期">
        <template slot-scope="scope">
          <span>{{ scope.row.month}}</span>
         </template>
      </el-table-column> -->

      <el-table-column width="80px" align="center" label="价格">
        <template slot-scope="scope">
          <span>{{ scope.row.total}}</span>
         </template>
      </el-table-column>

      <!-- <el-table-column width="80px" align="center" label="状态">
        <template slot-scope="{row}">
          <el-tag>
            {{ row.status |statusFilter1 }}
          </el-tag>

        </template>
      </el-table-column> -->


      <el-table-column width="80px" align="center" label="支付状态">
        <template slot-scope="{row}">
          <el-tag>
            {{ row.payStatus |statusFilter4 }}
          </el-tag>

        </template>
      </el-table-column>

      <el-table-column align="center" label="Actions" width="80px">
        <template slot-scope="scope">
          <!-- <el-button type="danger" size="small" @click="updateStatus(scope.row.id,scope.row.status)">{{ scope.row.status | statusFilter3 }}</el-button>
          <el-button type="danger" size="small" @click="updateStatus(scope.row.id,scope.row.status)">{{ scope.row.status | statusFilter3 }}</el-button> -->
          <el-button type="primary" icon="el-icon-goods" size="small"  @click="pay(scope.row.id)"  v-if="scope.row.payStatus == '0'">支付</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.pageSize" @pagination="getList" />
  
  </div>

</template>

<script>
import { orderList, updateUserStatus, delUser,addremark,addOrder } from '@/api/order'
import Pagination from '@/components/Pagination' // Secondary package based on el-pagination

const switchStatus = function(status) {
  if (status === 1) return 0
  else if (status === 0) return 1
  else throw new Error('status错误')
}
export default {
  name: 'orderList',
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
    },
    statusFilter4(status) {
      const statusMap = {
        1: '已支付',
        0: '待支付'
      }
      return statusMap[status]
    },
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
    pay(id){
        this.$router.push({ path: "bill", query: {id:id}})
    },
    getList() {
      this.listLoading = true
      orderList(this.listQuery).then(response => {
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
