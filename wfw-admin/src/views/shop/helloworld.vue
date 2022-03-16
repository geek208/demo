<template>
  <div class="taocan">
      <div class="header">
      <p>入门套餐</p>
      </div>
      <div class="price">
          <div class="fee">9.9月</div>
      </div>
  </div>
  
</template>

<script>
export default {

}
</script>

<style>
.taocan{
  padding-top: 0px;
  padding-left: 50px;
  padding-right: 50px;
  background-color:#ccc;
  display: flex;
  border: darkblue;
  position: relative;
}

.header{
  margin: 20px;
  border: crimson;
  display: flex;
  background: blue;
  
}

.price .fee{
  margin: 20px;
  border:#9999;
  display: flex;
  background: blue;
  position: absolute;
  justify-content: center;
}

.header p{
  font-size: 24;
  font-weight: bold;
  align-content: center;
}

</style>