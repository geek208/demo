<template>
    <div class="pay-content">
         <div class="iframe">
          <iframe    :src ="src" ref="iframe" id="mobsf" scrolling="no" frameborder="0" width="400px" height="500px" >
           </iframe>
         </div>
<!-- <iframe    v-bind:src ="ifra" ref="iframe" id="mobsf" scrolling="no" frameborder="0" ></iframe>  -->
 
       
         <!-- <p class="paying" v-loading="loading">支付中</p> -->
        <!-- <div class="info">
         <input type="text" hidden v-model="platformId">
         <input type="text" hidden v-model="payStatus">
         <el-button  style="margin-left: 10px;" type="success" @click="alert()">
             支付中.........
         </el-button>
         <p class="desc">支付中地址{{this.$route.query.url}}</p>
         <p class="desc">支付订单号{{this.$route.query.platformId}}</p>
         <p class="desc">支付状态{{this.payStatus}}</p>
         <p class="goback" @click="goback()">返回</p>

        </div> -->
   
       
    </div>

</template>

<script>
import { getPayStatus,goback,successNotice } from '@/api/order'


export default {
        data () {
            return {
            platformId:this.$route.query.platformId,
            payStatus:0,
            win: null,
            timer: null,
            iframeWin:{},
            src: this.$route.query.url //'https://zfm.nnt.ltd/pay?orderNo=1336540289233321984'
            }
        },
        created(){
            //console.log('============================='+this.$route.query.url)
            // Promise.all([]).then(()=>{
            //     console.log('等待支付结果。。。。。。。。。。。。。。。。。。')
            //    // this.$router.go(-1)
            // })
        },
        methods:{
        //      notiteship  (){
        //          console.log('更新为，已经支付');
        //          successNotice({'platformId':this.platformId,'state':'1'}).then(response => {

        //            console.log("payStatus==="+response.obj.payStatus+"payStatus ======"+response.obj.platformId)
        //     }).catch(err => {
        //         console.log(err)
        //     }).finally(() => {
        //         //this.loading = false
        //     })
        //    },
        //     goback(){
        //        console.log('goback      跳转到上页');
        //        this.$router.go(-1);
        //     },
        },
        computed:{
        //      computedTest() {
        //            console.log('computedTest。。。。。。。。。。。。。。。。。。')
        //         return this.message + '现在我用的是computed'
        //    }
        },

        mounted(){
            //设置内置页
            // console.log('调整窗口大小。。。。。。'+this.$refs.iframe)
            
            //  function paystatusAction(vplatformId){
            //      getPayStatus({'platformId':vplatformId}).then(response => {
            //             const payStatus  =response.obj.payStatus
            //             // debugger
            //              console.log("payStatus==="+response.obj.payStatus+"platformId ======"+response.obj.platformId)
                        
            //             if(response.obj.payStatus =='1'){
            //               ///  debugger
            //             //支付成功
            //              console.log('支付成功')
            //              console.log("location====="+window.location)

            //              window.location.href='/index'

            //              }

            //            }).catch(err => {
            //                 console.log(err)
            //             }).finally(() => {
            //                // this.loading = false
            //             })
            //             //跳回上商品页 
            //             //goback();
            // }

           /**
            * iframe-宽高自适应显示   
            */
            function changeMobsfIframe(){
                //console.log('12222222222222222==========================')
                // const mobsf = document.getElementById('mobsf');
                // const deviceWidth = document.body.clientWidth;
                // const deviceHeight = document.body.clientHeight;
                // mobsf.style.width = (Number(deviceWidth)-240) + 'px'; //数字是页面布局宽度差值
                // mobsf.style.height = (Number(deviceHeight)-64) + 'px'; //数字是页面布局高度差
            }


            changeMobsfIframe()

            // 改变窗口大小时
            // window.onresize = function () {
            // console.log('_this',_this);
            // }
            // this.window.onresize = function(){
            //     changeMobsfIframe()
            // }

    },
    destroyed () {
                 
       this.$refs.iframe = null;
                //   'beforedestroy' : function(o) {//close不会执行
                //     var frame = document.getElementById(frameId);
                //     frame.src = "abort:blank";//false
                //     frame.contentWindow.document.write('');//清空iframe的内容
                //     frame.contentWindow.document.clear();
                //     frame.contentWindow.close();//避免iframe内存泄漏
                //     //Ext.removeNode(frame);
                //     frame.parentNode.removeChild(frame);
                //     //frame.remove();//删除iframe
                //     frame=null;

                //     if (window.CollectGarbage)
                //             CollectGarbage();
    }
}
</script>

<style  scoped>

/* .iframe{
position:absolute;
    top:64px;
    left: 240px;
    right:0px;
    bottom:100px;
} */
/* 
.goback{
    color: blue;
    align-items: center;
    align-self: center;

} */

.pay-content{
    display: flex;
    flex-direction: row ;
    justify-content: flex-start;
    flex-wrap: wrap;
   /* position: relative;
   align-items: center;
   color: red; */
}

.info{
    background: rosybrown;
    align-items: center;
    align-content: center;
    align-self: center;
    margin-left: 0px;
}

</style>
