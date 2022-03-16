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
<div class="tancan">
  <div class="taocan-title">
    <span class="title">入门版</span>
  </div>
   <div class="taocan-price">
    <span class="price">¥1</span><p class="yue">每月</p>
  </div>
  <div class="taocan-content">
    <div class="item">
      <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-tongguo"></use>
        </svg>
      <span class="item">600GB使用流量</span> 
    </div>
    <div class="item">
       <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-tongguo"></use>
        </svg>
      <span class="item"></span>16个设备同时使用</div>
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
    <div class="item">
      <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-tongguo"></use>
        </svg>
      <span>可用入门版节点</span></div>
    <div class="item">
      <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-cuowu"></use>
        </svg>
      <span>可用基础版节点</span></div>
    <div class="item">
      <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-cuowu"></use>
        </svg>
      <span>可用标准版节点</span></div>
    <div class="item">
      <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-cuowu"></use>
        </svg>
      <span>IPLC专线节点</span></div>
    <div class="item">
      <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-cuowu"></use>
        </svg>
      <span class="item">可用旗舰版节点(可用所有节点)</span></div>
    <el-button class='submitbtn' style="margin-left: 10px;" type="success" @click="SubBtn(1,1,'入门版')">
      订购
      </el-button>
  </div>
</div>

<div class="tancan">
  <div class="taocan-title">
    <span class="title">基础版</span>
  </div>
   <div class="taocan-price">
    <span class="price">¥15.9</span><p class="yue">每月</p>
  </div>
  <div class="taocan-content">
    <div class="item">
      <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-tongguo"></use>
        </svg>
      <span class="item">600GB使用流量</span> 
    </div>
    <div class="item">
       <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-tongguo"></use>
        </svg>
      <span class="item"></span>16个设备同时使用</div>
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
    <div class="item">
      <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-tongguo"></use>
        </svg>
      <span>可用入门版节点</span></div>
    <div class="item">
      <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-cuowu"></use>
        </svg>
      <span>可用基础版节点</span></div>
    <div class="item">
      <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-cuowu"></use>
        </svg>
      <span>可用标准版节点</span></div>
    <div class="item">
      <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-cuowu"></use>
        </svg>
      <span>IPLC专线节点</span></div>
    <div class="item">
      <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-cuowu"></use>
        </svg>
      <span class="item">可用旗舰版节点(可用所有节点)</span></div>
   <el-button  class='submitbtn' style="margin-left: 10px;" type="success" @click="SubBtn(2,1,'基础版')">
      订购
      </el-button>
  </div>
</div>

<div class="tancan">
  <div class="taocan-title">
    <span class="title">标准版</span>
  </div>
   <div class="taocan-price">
    <span class="price">25.9</span><p class="yue">每月</p>
  </div>
  <div class="taocan-content">
    <div class="item">
      <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-tongguo"></use>
        </svg>
      <span class="item">600GB使用流量</span> 
    </div>
    <div class="item">
       <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-tongguo"></use>
        </svg>
      <span class="item"></span>16个设备同时使用</div>
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
    <div class="item">
      <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-tongguo"></use>
        </svg>
      <span>可用入门版节点</span></div>
    <div class="item">
      <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-cuowu"></use>
        </svg>
      <span>可用基础版节点</span></div>
    <div class="item">
      <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-cuowu"></use>
        </svg>
      <span>可用标准版节点</span></div>
    <div class="item">
      <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-cuowu"></use>
        </svg>
      <span>IPLC专线节点</span></div>
    <div class="item">
      <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-cuowu"></use>
        </svg>
      <span class="item">可用旗舰版节点(可用所有节点)</span></div>
      <el-button  class='submitbtn' style="margin-left: 10px;" type="success" @click="SubBtn(3,1,'基础版')">
      订购
      </el-button>
  </div>
</div>

</div>
</div>
</template>

<script>
const defaultForm = {
  amount:  '1',
  packageId: '1',
  name: '入门型',
}
const defaultRules = {
  amount: { required: true, trigger: 'blur' },
  packageId: { required: true, trigger: 'blur' },
  name: { required: true, trigger: 'blur'}
}


export default{
   
    data(){
        return{
                postForm: Object.assign({}, defaultForm),
                rules: Object.assign({}, defaultRules),
         }
    },
    computed:{
 
    },
    methods:{

    　　SubBtn:function(vamount,vid,vname){
              console.log(vamount+' =====  '+vid+'======='+vname)
              this.$router.push({ path: "changeplan", query: {amount:vamount,packageId:vid,packageName:vname}})
              }
        }
 
    }
    

</script>

<style scoped>

  .plangroup{
    display: flex;
    padding: 50px;
    flex: 1;
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
