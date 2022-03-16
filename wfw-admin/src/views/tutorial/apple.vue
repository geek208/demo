<template>
          <!-- Main Content -->
      <div class="main-content" style="min-height: 517px;">
        <section class="section">
          <div class="section-header">
            <div class="section-header-back">
              <a href="https://suying555.net/user/tutorial" class="btn btn-icon"><i class="fas fa-arrow-left"></i></a>
            </div>
            <h1>IOS   使用教程</h1>
                      </div>
          <div class="section-body">
            <div class="row mt-sm-4">
              <div class="col-12">
                                <div class="card">
                  <div class="card-body">
                    <ul class="steps">
                      <!-- <li>
                        <div class="row">
					     <div class="left-text col-xs-12 col-md-6 col-lg-6">
                            <label class="step-no">SSR客户端：</label>
                            <br><br>
							<a href="https://wws.lanzous.com/iPZrfipd20d" class="btn btn-icon icon-left btn-primary btn-app btn-lg btn-round" target="blank"><i class="fas fa-download"></i> 下载客户端</a>

                           <a href="https://down.suying666.org/suying-sr-win.zip" target="_blank" class="btn btn-icon icon-left btn-primary btn-win btn-lg btn-round"><i class="fas fa-download"></i> 备用下载地址</a>
							<a href="https://down.suying666.org/s/Win-ssr.mp4" class="btn btn-icon icon-left btn-primary btn-app btn-lg btn-round" target="blank"><i class="fas fa-download"></i> 查看视频教程</a>
                          </div>					  					  
                          <div class="right-pic col-xs-12 col-md-6 col-lg-6">
                            <div class="tutorial-pic">
                            </div>					  		
                          </div>
                        </div>
                      </li> -->
					  <li>
					    <!-- <hr> -->
                        <div class="row">
                            <h3  class="step-no">V2ray客户端：</h3>
                          <!-- <label class="step-no">V2ray客户端：</label> -->
                          <div class="left-text col-xs-12 col-md-6 col-lg-6">
                      
                            <br><br>
							<a href="https://wws.lanzous.com/i1jNxffhisd" class="btn btn-icon icon-left btn-primary btn-app btn-lg btn-round" target="blank"><i class="fas fa-download"></i> 下载客户端</a>
                            <!-- <a href="https://down.suying666.org/v2.zip" target="_blank" class="btn btn-icon icon-left btn-primary btn-win btn-lg btn-round"><i class="fas fa-download"></i> 备用下载地址</a>
                            <a href="https://down.suying666.org/s/Win-V2Ray.mp4" class="btn btn-icon icon-left btn-primary btn-app btn-lg btn-round" target="blank"><i class="fas fa-download"></i> 查看视频教程</a> -->
                          </div>

                            <!-- <div class="left-text col-xs-12 col-md-6 col-lg-6">
                           
                            <br><br>
							 <a href="https://wws.lanzous.com/icv7Idzymkj" class="btn btn-icon icon-left btn-primary btn-app btn-lg btn-round" target="blank"><i class="fas fa-download"></i> 下载客户端</a>
                            <a href="https://down.suying666.org/v2.zip" target="_blank" class="btn btn-icon icon-left btn-primary btn-win btn-lg btn-round"><i class="fas fa-download"></i> 备用下载地址</a> -->
                            <!-- <a href="https://down.suying666.org/s/Win-V2Ray.mp4" class="btn btn-icon icon-left btn-primary btn-app btn-lg btn-round" target="blank"><i class="fas fa-download"></i> 查看视频教程</a>
                     
                          </div>  -->
                          
                          										  
                          <!-- <div class="right-pic col-xs-12 col-md-6 col-lg-6">
                             <div class="tutorial-pic">
                            </div>					  		
                          </div> -->
						</div>  
                      </li>
                      <!-- <li>
                        <hr>
                        <div class="row">
                          <div class="left-text col-xs-12 col-md-6 col-lg-6">
                            <label class="step-no">订阅链接：</label>
                            <br><br>
							<a href="https://suying555.net/user/tutorial?os=windows&amp;client=ssr##" class="btn btn-icon icon-left btn-primary btn-app copy-text btn-lg btn-round" data-clipboard-text="https://dingyue.suying666.info/link/kcMlqtGhI5PFg94L?sub=1"><i class="malio-ssr"></i> 复制 SSR 订阅链接</a>
							<a href="https://suying555.net/user/tutorial?os=windows&amp;client=ssr##" class="btn btn-icon icon-left btn-primary btn-app btn-lg btn-round copy-text" data-clipboard-text="https://dingyue.suying666.info/link/kcMlqtGhI5PFg94L?sub=3"><i class="malio-v2rayng"></i> 复制 V2Ray 订阅链接</a>
                          </div>
                          <div class="right-pic col-xs-12 col-md-6 col-lg-6">
                            <div class="tutorial-pic">
                            </div>
                          </div>
                        </div>
                      </li> -->
                    
                          
                          </ul></div>
                        </div>
                      
                    
                  </div>
                </div>
              </div>
            </section></div>
</template>
<script>
  export default {
    name: "window",
   data(){
        return {
            count: 0
        }
    },
    methods:{
            toOsPage(id){
                this.$router.push({ path: 'window', query: { id: id}})
            }
        }
  }
</script>
<style scoped>
 /* @import "all.min.css"; */
 /* @import "bootstrap.min.css"; */
 /* @import "components.css"; */
 /* @import "malio.css";
 @import "style-purple.css"; */

 .card-body{
     display: flex;
     flex-direction: row ;
     justify-content: flex-start;
     flex-wrap: wrap;
     color: cornsilk;
     /* flex: 1; */
     margin: 20px;
     padding: 20px;
 }


    .step-no{
        font-size: 20px;
        color: black;
    }

   .col-lg-6{
  
    padding: 20px;
    margin: 20px;
    font-size: 18px;
    width: 200px;
    height: 100px;
    color: cornsilk;
    border: 1px solid #cccc;
    background-color:     #343a40;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
    border-bottom-left-radius: 10px;
    border-bottom-right-radius: 10px;

 
    }

   .windows-card{
      background-color:     #007bff;
    }
    .android-card{
      background-color:     #20c997;
    }

     .apple-card{
      background-color:    #343a40;
    }

     .mac-card{
      background-color:     #6c757d;
    }

     .linux-card{
      background-color:     #fd7e14;
    }
</style>