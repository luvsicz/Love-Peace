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
    <div>
      <!-- container -->
      <el-container class="main-container">
        <!-- main -->
        <el-main class="app-main">
          <el-card>
            <iframe src="/druid/index.html" width="100%" height="100%" style="height: 100vh;"
                    name="iframe" frameborder="0"></iframe>
          </el-card>
        </el-main>
      </el-container>
    </div>
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
            getRequest('/sys/cache/menuWithRole')
          }
          if ('all' === type) {
            getRequest('/sys/cache/all')
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
