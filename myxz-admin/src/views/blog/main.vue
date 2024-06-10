<template>
    <el-main>
      <router-view :key="key" />
    </el-main>
</template>

<script>
  export default {
    name: 'blogMain',
    computed: {
      key() {
        return this.$route.path
      }
    }
  }
</script>

<style scoped>
  .el-main {
    min-height: 800px;
  }
</style>