<template>
  <div>
    <div v-for="project in projects">
      <el-link type="primary" :href="project.path">{{ project.name }}</el-link>
      <br/>
    </div>
  </div>
</template>

<script>
export default {
  name: "index",
  created() {
    this.projects = [
      {
        name: '尚筹网会员系统',
        path: this.basePath
      },
      {
        name: '尚筹网后台管理系统',
        path: `${this.basePath}:8080/atcrowdfunding02-admin-webui-1.0-SNAPSHOT/admin/to/login/page.html`
      },
      {
        name: '电商后台管理系统',
        path: `${this.basePath}:81/#/login`
      }
    ]
  },
  data() {
    return {
      // 服务器地址
      basePath: 'http://175.178.174.83',
      // 项目
      projects: []
    }
  }
}
</script>

<style scoped>

</style>
