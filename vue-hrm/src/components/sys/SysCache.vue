<template>
  <div style="margin-top: 10px">
    <span>菜单缓存清理</span>
    <el-switch
      v-model="menuCache"
      @change="clean('menu',menuCache)"
      active-color="#13ce66"
      inactive-color="#ff4949">
    </el-switch>
    <span>所有缓存清理</span>
    <el-switch
      v-model="flushAll"
      @change="clean('all',flushAll)"
      active-color="#13ce66"
      inactive-color="#ff4949">
    </el-switch>
    <span>操作日志清理</span>
    <el-switch
      v-model="accessLog"
      @change="clean('accessLog',accessLog)"
      active-color="#13ce66"
      inactive-color="#ff4949">
    </el-switch>
  </div>
</template>

<script>
  import {deleteRequest, getRequest} from "../../utils/api";

  export default {
    name: "SysCache",
    data() {
      return {
        //按钮默认值 关闭状态
        menuCache: false,
        flushAll: false,
        accessLog: false
      }
    },
    methods: {
      clean(type, bool) {
        if (bool) {
          bool = !bool;
          if ('menu' === type) {
            getRequest('/system/evictCache/menuWithRole')
          }
          if ('all' === type) {
            getRequest('/system/evictCache/all')
          }
          if ('accessLog' === type) {
            deleteRequest('/sys/access/')
          }
        }

      }
    }

  }
</script>

<style scoped>

</style>
