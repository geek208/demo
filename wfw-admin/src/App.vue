<template>
  <div id="app">
    <router-view />

  </div>
</template>

<script>
import data from './views/pdf/content';
export default {
  name: "App",
  data(){
     return{
     //url: this.$route.query.url,
     }
  },
  created(){
    console.log('app=============================='+this.$route.params.url)
    //window.addEventListener("message", this.receiveMessageFromIframePage, false);
  },
  methods:{

//      receiveMessageFromIframePage(event){

//           if (event.data && event.data.data && event.data.data.type) {

//                    // do somthing, you want to do

//                 }

//     }


  }



};
</script>
