<template>
<div class="container">
  <div class="desctitle"><span>选择合适的会员订阅计划</span></div>
  <div class="desc"><p class="descinfo">选择合适的会员订阅计划
    购买新套餐时，购买相同等级套餐：流量不会叠加，时间会叠加，如等级不同：流量和时间都不会叠加。
    </p>
    <p class="descinfo">年付会员流量为一次性到账，一年到期才会清零。</p>
    <p class="descinfo">如需更换套餐，请至首页点击【升级】按钮。</p>
  </div>
<div class="plangroup">
<div class="tancan" v-for="item in list" :key="item.id">
  <div class="taocan-title">
    <span class="title">{{item.name }}</span>
  </div>
   <div class="taocan-price">
    <span class="price">{{item.price }}</span><p class="yue">每月</p>
  </div>
  <div class="taocan-content">
    <div class="item">
      <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-tongguo"></use>
        </svg>
      <span class="item">{{item.bandwidth }}GB使用流量</span> 
    </div>
    <div class="item">
       <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-tongguo"></use>
        </svg>
      <span class="item"></span>{{item.connections}}个设备同时使用</div>
    <div class="item">
       <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-tongguo"></use>
        </svg>
      <span class="item"></span>不限制速率</div>
    <div class="item">
       <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-tongguo"></use>
        </svg>
      <span>Telegram客服技术支持</span></div>
 
    <div class="item">
      <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-tongguo"></use>
        </svg>
      <span>支持SSR、V2ray节点</span></div>
    <div class="item">
      <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-tongguo"></use>
        </svg>
      <span>国内中转节点</span></div>
    <div class="item">
      <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-tongguo"></use>
        </svg>
      <span>解锁流媒体</span></div>
    
    <div class="item" v-if="item.level0 == '1'">
      <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-tongguo"></use>
        </svg>
      <span>可用入门版节点</span></div>

      <div class="item" v-else >
        <svg class="icon" aria-hidden="true">
            <use xlink:href="#icon-cuowu"></use>
          </svg>
        <span>可用入门版节点</span></div>

   <div class="item" v-if="item.level1 == '1'">
      <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-tongguo"></use>
        </svg>
      <span>可用基础版节点</span></div>

      <div class="item" v-else >
      <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-cuowu"></use>
        </svg>
      <span>可用基础版节点</span></div>


    <div class="item" v-if="item.level2 == '1'">
      <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-tongguo"></use>
        </svg>
      <span>可用标准版节点</span></div>

      <div class="item" v-else >
      <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-cuowu"></use>
        </svg>
      <span>可用标准版节点</span></div>

    <div class="item" v-if="item.iplc == '1'">
      <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-tongguo"></use>
        </svg>
      <span>IPLC专线节点</span></div>

    <div class="item" v-else >
      <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-cuowu"></use>
        </svg>
      <span>IPLC专线节点</span></div>

    <div class="item" v-if="item.level3 == '1'">
      <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-tongguo"></use>
        </svg>
      <span>可用旗舰版节点</span></div>

    <div class="item" v-else >
      <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-cuowu"></use>
        </svg>
      <span>可用旗舰版节点</span></div>

    <div class="item" v-if="item.level4 == '1'">
      <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-tongguo"></use>
        </svg>
      <span class="item">可用旗舰版大流量节点</span></div>

      <div class="item" v-else >
      <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-cuowu"></use>
        </svg>
      <span>可用旗舰版大流量节点</span></div>

    <el-button class='submitbtn' style="margin-left: 10px;" type="success" @click="SubBtn(item.id,item.name,item.price,item.level)">
      订购
      </el-button>
  </div>
</div>

</div>

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
　   SubBtn:function(id,name,price,level){
              console.log(' id=====  '+id)
              this.$router.push({ path: "changeplan", query: {id:id,name:name,price:price,month:1,level:level}})
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

  .plangroup{
    /* display: flex;
    padding: 50px;
    flex: 1; */

     display: flex;
     flex-direction: row ;
     justify-content: flex-start;
     flex-wrap: wrap;
  }

  .tancan{
    position: relative;
    padding: 20px;
    border: 1px solid #cccc;
    /* display: flex;
    flex-direction: column; */
 
    }

    .taocan-title{
      top: px;
      align-content: center;
      position: relative;
      margin: 0px,100px;
    }

 .taocan-title .title{
    background-color: #6777ef;
    color: #fff;
    font-size: 10px;
    font-weight: 700;

    border-radius: 0 0 5px 5px;
     padding: 5px 25px;
    text-align: center;
  }

   .taocan-price{
     border: brown;
     padding-top: 20px;
     
     }

  .taocan-price .price {
    padding: 0px;
    font-weight: 600;
    font-size: 50px;
   
}

.taocan-price .price .yue{
     padding: 20px;
  }

.taocan-content {
  text-align: left;
  padding: 5px;
  display: inline-block;
  }

.item{
  padding: 5px;
  font-size: 16px;
  color: blue;
}

 .item .icon{
    width: 18px;
    height: 18px;
  }
  

.container{
    margin: 10px;
  }


  .descinfo{
    padding: 5px 20px;
    color: red;
    margin: 5px 20px;
    
  }


  .desctitle{
    padding: 10px 20px;
    color: #6777ef;
    font-size: 20px;
    margin: 10px 10px;
    font-weight:bold
  }

 </style>