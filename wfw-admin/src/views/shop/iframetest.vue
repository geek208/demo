<template>
    <div class="pay-content">
         
<!-- <iframe    v-bind:src ="ifra" ref="iframe" id="mobsf" scrolling="no" frameborder="0" ></iframe>  -->
        <iframe    :src ="src" ref="iframe" id="mobsf" scrolling="no" frameborder="0" >
            
        </iframe>
       
         <!-- <p class="paying" v-loading="loading">支付中</p> -->
        <div class="info">
         <input type="text" hidden v-model="platformId">
         <el-button v-loading="loading" style="margin-left: 10px;" type="success" @click="paystatus('')">
             支付中.........
         </el-button>
         <p class="desc">支付中地址{{this.$route.query.url}}</p>
         <p class="desc">支付订单号{{this.$route.query.platformId}}</p>
         <p class="goback" @click="goback()">返回</p>

        </div>
   
       
    </div>

</template>

<script>
import { getPayStatus,goback,successNotice } from '@/api/order'
//import dialogpay from './dialogpay.vue'
 //alert(this.$route.query.url);


 window.parent.postMessage({
     cmd:'returnHeight',
     query:{
         success:true,
         data:document.body.scrollHeight+'px'
         }
 },'*');

 window.addEventListener('message',function(event){
     var data = event.data
     switch(data.cmd){
         case 'getFromJson' :
             break
     }
 })

export default {
        data () {
            return {
            loading: false,
            platformId:this.$route.query.platformId,
            iframeWin:{},
            src: this.$route.query.url //'https://zfm.nnt.ltd/pay?orderNo=1336540289233321984'
            }
        },
      
        created(){
            //console.log('============================='+this.$route.query.url)
            Promise.all([this.paystatus(this.platformId)]).then(()=>{
                console.log('等待支付结果。。。。。。。。。。。。。。。。。。')
               // this.$router.go(-1)
            })
        },
     
        methods:{

            initList () {
                this.myInterval = window.setInterval(() => {
                    setTimeout(() => {
                    this.polling() //调用接口的方法
                    }, 1)
                }, 5000);
                },

            sendMessage(){
                  this.iframeWin.postMessage({
                      cmd:'getFormJson',
                      query:{}
                  },'*')
            },

            paystatus(vplatformId){
                 getPayStatus({'platformId':vplatformId}).then(response => {

                         console.log("pay==="+response.obj.pay+"payNo ======"+response.obj.platformId)
                        
                        if(response.obj.pay =='1'){
                          ///  debugger
                        //支付成功
                         console.log('支付成功')
                         this.loading = true
                          //代发货
                        // console.log('状态待发货，通知发货')

                         //this.$router.go(-1);

                        }

                       }).catch(err => {
                            console.log(err)
                        }).finally(() => {
                            this.loading = false
                        })
                        //跳回上商品页 
                        //goback();
            },
             notiteship  (){
                 console.log('更新为，已经支付');
                 successNotice({'platformId':this.platformId,'state':'1'}).then(response => {

                console.log("pay==="+response.obj.pay+"payNo ======"+response.obj.platformId)
            }).catch(err => {
                console.log(err)
            }).finally(() => {
                this.loading = false
            })
           },
            goback(){
               console.log('goback      跳转到上页');
               this.$router.go(-1);
               //this.$router.push({path: '/account'});
            },
          
            

        },
        computed:{
             computedTest() {
                   console.log('computedTest。。。。。。。。。。。。。。。。。。')
                return this.message + '现在我用的是computed'
           }
        },

        mounted(){
            //设置内置页
            //this.url =  this.$route.query.url
            //this.iframeWin = this.$refs.iframe.contentWindow
            debugger
            console.log('调整窗口大小。。。。。。'+this.$refs.iframe)

            window.addEventListener('message',this.handleMessage)
            this.iframeWin = this.$refs.iframe.contentWindow

            //alert(this.iframeWin.a)

            //Indicator.open()


           /**
            * iframe-宽高自适应显示   
            */
            function changeMobsfIframe(){
                //console.log('12222222222222222==========================')
                const mobsf = document.getElementById('mobsf');
                const deviceWidth = document.body.clientWidth;
                const deviceHeight = document.body.clientHeight;
                mobsf.style.width = (Number(deviceWidth)-240) + 'px'; //数字是页面布局宽度差值
                mobsf.style.height = (Number(deviceHeight)-64) + 'px'; //数字是页面布局高度差
            }

            changeMobsfIframe()

            window.onresize = function(){

                //console.log('1=====1111111111111111111111=====================')
                changeMobsfIframe()
            }


    this.timer = window.setInterval(() => {
                setTimeout(() => {
                    //this.getList() //调用接口的方法
                    this.getPayStatus(platformId)
                    console.log('查询订单状态'+platformId)
                }, 1)
            }, 3000);

        },
        handleMessage(Event){
            debugger
            const data = event.data
            switch(data.cmd){
                case 'returnFormJson':

                    break
                case 'returnHeight':
                    break
            }
        },
        destroyed(){

         console.log("清除定时器")
         clearInterval(this.timer);

        }
       
        
        
    }
</script>

<style  scoped>
.iframe{
position:absolute;
    top:64px;
    left: 240px;
    right:0px;
    bottom:100px;
}
.goback{
    color: blue;
    align-items: center;
    align-self: center;

}

.pay-content{
   position: relative;
   align-items: center;
   color: red;
}

.info{
    background: rosybrown;
    align-items: center;
    align-content: center;
    align-self: center;
    margin-left: 0px;
}
</style>
