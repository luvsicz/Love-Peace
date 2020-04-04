<template>
  <div style="margin-top: 10px">
    <el-collapse v-model="activeNames" accordion>
      <el-collapse-item v-bind:key="index" v-for="(notice,index) in notices" :title="notice.title"
                        :name="notice.id">
        <div>{{notice.message}}</div>
        <div>
          <el-tag>发布日期</el-tag>
          {{ notice.createDate}}
        </div>
        <div>
          <el-popconfirm
            confirmButtonText='好的'
            cancelButtonText='不确定'
            @onConfirm="deleteNotice(notice.id)"
            icon="el-icon-info"
            iconColor="red"
            title="确定删除吗？"
          >
            <el-button type="danger" size="mini"
                       slot="reference">删除
            </el-button>
          </el-popconfirm>
        </div>
      </el-collapse-item>
    </el-collapse>
    <el-button icon="el-icon-search" size="mini" type="primary" @click="publishNotice">发布通知
    </el-button>
    <el-dialog
      :before-close="handleClose"

      :visible.sync="showPublishNotice"
      title="发布通知"
      width="30%">
      <div>
        <el-form :model="notice" :rules="rules" class="demo-ruleForm" label-width="100px"
                 ref="notice"
                 status-icon>
          <el-form-item label="请输入标题" prop="title">
            <el-input autocomplete="off" type="text" v-model="notice.title"></el-input>
          </el-form-item>
          <el-form-item label="请输入内容" prop="message">
            <el-input autocomplete="off" type="text" v-model="notice.message"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button @click="submitForm('notice')" type="primary">发布</el-button>
            <el-button @click="resetForm('notice')">重置</el-button>
          </el-form-item>
        </el-form>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  export default {
    name: "SysNotice"
    ,
    data() {
      return {
        //默认展开的通知
        activeNames: [],
        showPublishNotice: false,
        notice: {
          title: '',
          message: ''
        },
        posted: false,
        notices: [],
        rules: {
          title: [
            {required: true, message: '请输入标题', trigger: 'blur'},
            {min: 0, max: 64, message: '长度在 0 到 64 个字符', trigger: 'blur'}
          ],
          message: [
            {required: true, message: '请输入内容', trigger: 'blur'}
          ]
        }
      }
    },
    methods: {
      initNotices() {
        this.getRequest('/sys/nf/').then(resp => {
          if (resp) {
            this.notices = resp.obj.data;
          }
        })
      }, deleteNotice(id) {
        this.deleteRequest('/sys/nf/?mid=' + id).then(resp => {
          if (resp) {
            this.initNotices()
          }

        })
      },
      handleClose(done) {
        this.$confirm('确定取消发送通知吗？')
        .then(_ => {
          done();
        })
        .catch(_ => {
        });
      },
      publishNotice() {
        this.showPublishNotice = true
      }
      ,
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
      ,
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            //发送websocket消息
            let msgObj = {};
            msgObj.title = this.notice.title;
            msgObj.message = this.notice.message;
            this.$store.state.stomp.send('/im/send', {}, JSON.stringify(msgObj));
            this.showPublishNotice = false;
          } else {
            return false;
          }
        })
        //等待一秒再刷新
        setTimeout(this.initNotices
          , 1000);
        // this.postRequest("/sys/nf/", this.notice).then(resp => {
        //   if (resp && resp.status === 200) {
        //     this.showPublishNotice = false;
        //     this.initNotices()
        //   }
        // })
      }

    },
    mounted() {
      this.initNotices();
    }
  }
</script>

<style scoped>

</style>
