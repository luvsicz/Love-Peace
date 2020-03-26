<template>
  <div>
    <el-container>
      <el-header style="text-align: left;padding-left: 0px;margin-top: 10px">
        <el-tag size="medium">请选择部门:</el-tag>
        <el-select placeholder="请选择" size="mini" v-model="depId">
          <el-option
            :key="item.id"
            :label="item.name"
            :value="item.id"
            v-for="item in deps">
          </el-option>
        </el-select>
      </el-header>
      <el-main>Main</el-main>
    </el-container>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        depId: 1,
        deps: []
      }
    },
    methods: {
      loadDeps() {
        var _this = this;
        this.getRequest("/salary/table/deps").then(resp => {
          if (resp && resp.status == 200) {
            _this.deps = resp.data;
          }
        })
      }
    },
    mounted: function () {
      this.loadDeps();
    }
  }
</script>
