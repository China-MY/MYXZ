<template>
  <div class="app">
    <!-- 介绍 -->
    <div class="Introduction">
      <h1 class="title">你好，欢迎来到明裕学长博客</h1>
      <div class="content">
        <span>
          小骚话:
        </span>
        <p>{{ content }}</p>
      </div>
      <!-- 主视图  flex布局横向-->
      <div class="main-views">
        <!-- 左边的文章列表部分 flex布局竖向-->
        <div class="left-box">
          <!-- 分类 -->
          <div class="classification">
            <el-card>
              <el-link href="https://element.eleme.io" target="_blank">默认链接</el-link>
              <el-link href="https://element.eleme.io" target="_blank">默认链接</el-link>
              <el-link href="https://element.eleme.io" target="_blank">默认链接</el-link>
            </el-card>
          </div>
          <!-- 文章列表做分页 -->
          <div class="articlelist">
            <!-- 列表 -->
            <div class="list">
              <el-card class="box-card">
                <div v-for="o in 4" :key="o" class="text item">
                  {{ '列表内容 ' + o }}
                </div>
              </el-card>
            </div>
            <!-- 分页 -->
            <div class="page">
              <el-pagination background layout="prev, pager, next" :total="1000">
              </el-pagination>
            </div>
          </div>
        </div>
        <!-- 右侧的卡片视图 flex布局竖向-->
        <div class="right-box">
          <!-- 个人说明及联系方式 -->
          <div class="abme">
            <el-card>
              个人说明
            </el-card>
          </div>
          <!-- 时间日历 -->
          <div class="calendar">
            <el-card>
              时间日历
            </el-card>

          </div>
          <!-- 热门标签 -->
          <div class="tag">
            <el-card>
              热门标签
            </el-card>
          </div>
          <!-- 站点数据 -->
          <div class="sitedata">
            <el-card>
              站点数据
            </el-card>
          </div>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
import axios from 'axios'
export default {
  data() {
    return {
      content: ''
    }
  },
  created() {
    this.getContent()
  },
  methods: {
    async getContent() {
      const response = await axios.get('https://api.vvhan.com/api/text/sexy?type=json');
      this.content = response.data.data.content;
    }
  }
}

</script>


<style>
.app {
  height: 100%;
  width: 100%;
}

.Introduction {
  text-align: center;
}

.title {
  font-size: 50px;
  font-weight: 600;
  margin-top: 50px;
}

.content {
  font-size: 20px;
  margin-top: 50px;
  font-weight: 600;
}

.main-views {

  height: 100%;
  width: 100%;
  display: flex;
}

.left-box {

  height: 100%;
  width: 80%;
  display: flex;
  flex-direction: column;

}

.classification {
  height: 100%;
  width: 100%;

}

.articlelist {

  height: 100%;
  width: 100%;
}

.list {

  height: 100%;
  width: 100%;
}

.text {
  font-size: 14px;
}

.item {
  padding: 18px 0;
}

.box-card {
  width: 100%;
}

.page {

  height: 100%;
  width: 100%;
}

.right-box {

  height: 100%;
  width: 20%;
  display: flex;
  flex-direction: column;
}

.abme {

  height: 100%;
  width: 100%;
}

.calendar {

  height: 100%;
  width: 100%;
}

.tag {

  height: 100%;
  width: 100%;
}

.sitedata {

  height: 100%;
  width: 100%;
}
</style>