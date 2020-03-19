<template>
<!-- 页面渲染的模板-->
  <div style="display:flex;justify-content:center">
    <el-card style="width: 400px;margin-top: 150px">
      <div slot="header" class="clearfix">
        <span>登录</span>
      </div>
      <div v-for="o in 4" :key="o" class="text item">
        {{'列表内容 ' + o }}
      </div>
    </el-card>
  </div>
</template>

<script>
//把自己导出为Login 组件
  export default {
    name: "Login"
  }
</script>

<style scoped>

</style>
