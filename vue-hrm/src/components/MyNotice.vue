<template>
  <div style="margin-top: 10px">
    <span v-if="notices.length===0">暂无通知</span>
    <!--触发已读-->
    <el-collapse v-model="activeNames" @change="handleChange" accordion>
      <el-collapse-item v-bind:key="index" v-for="(notice,index) in notices" :name="notice.id">
        <template slot="title">
          <el-tag v-if="notice.state===0">未读</el-tag>
          <el-tag v-if="notice.state===1" type="success">已读</el-tag>
          {{notice.title}}
        </template>
        <div>{{notice.message}}</div>
        <div>发布日期:{{notice.createDate}}</div>
      </el-collapse-item>
    </el-collapse>
  </div>
</template>

<script>
  export default {
    name: "MyNotice"
    ,
    data() {
      return {
        //默认展开的通知
        activeNames: [],
        notice: {
          title: '',
          message: ''
        },
        posted: false,
        notices: [],
      }
    },
    methods: {
      initNotices() {
        this.getRequest('/system/config/notice').then(resp => {
          if (resp) {
            this.notices = resp.obj.data;
          }
        })
      },
      handleChange(val) {
        //更新通知状态 val是已经展开的项的ID
        this.posted = !this.posted;
        if (this.posted) {
          let url = '/system/config/notice/' + val;
          this.putRequest(url).then(resp => {
            this.initNotices()
          })
        }
      }
    }, mounted() {
      this.initNotices();
    }
  }
</script>

<style scoped>

</style>
