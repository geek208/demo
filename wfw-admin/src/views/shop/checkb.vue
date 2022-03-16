<div id="app22">
        <input type="checkbox" v-model='checked' v-on:click='checkedAll'> 全选{{checked}}
        <template v-for="(list,index) in checkboxList">
            <input type="checkbox" v-model='checkList' :value="list.id"> {{list.product_inf}}
        </template>
        {{checkList}}
</div>
<script>
    
</script>