<template>
  <div class="app-container">
    <!-- 表格 -->
    <el-table
      :data="list"
      border
      stripe
    >
      <el-table-column type="selection"/>
      <el-table-column
        label="#"
        width="50">
        <template slot-scope="scope">
          {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
      </el-table-column>
      <el-table-column prop="name" label="名称" width="80"/>
      <el-table-column label="头衔" width="90">
        <template slot-scope="scope">
          <el-tag v-if="scope.row.level === 1" type="success" size="mini">高级讲师</el-tag>
          <el-tag v-if="scope.row.level === 0" size="mini">首席讲师</el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="intro" label="简介"/>
      <el-table-column prop="sort" label="排序" width="60"/>
      <el-table-column prop="joinDate" label="入驻时间" width="160"/>
      <el-table-column label="操作" width="200" align="center">
        <template slot-scope="scope">
          <el-button type="text" size="mini" @click="removeById(scope.row.id)">删除</el-button>
          <router-link :to="'/vod/teacher/edit/'+scope.row.id">
            <el-button type="text" size="mini">修改</el-button>
          </router-link>
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页区域 -->
    <el-pagination
      :current-page="page"
      :total="total"
      :page-size="limit"
      :page-sizes="[5, 10, 20, 30, 40, 50, 100]"
      style="padding: 30px 0; text-align: center;"
      layout="total, sizes, prev, pager, next, jumper"
      @size-change="changePageSize"
      @current-change="changeCurrentPage">
    </el-pagination>
  </div>
</template>

<script>
import teacherApi from '@/api/vod/teacher'

export default {
  name: "list",
  created() {
    this.getTeacherList()
  },
  data() {
    return {
      // 列表数据
      list: [],
      // 总记录数
      total: 0,
      // 当前页码
      page: 1,
      // 每页记录数
      limit: 10,
      // 查询条件
      searchObj: {},
      // 批量删除选中的记录列表
      multipleSelection: []
    }
  },
  methods: {
    getTeacherList() {
      teacherApi.getList(this.page, this.limit, this.searchObj).then(res => {
        this.list = res.data.records
        this.total = res.data.total
      })
    },
    // 改变每页显示记录数
    changePageSize(size) {
      this.limit = size
      this.getTeacherList()
    },
    // 改变页码数
    changeCurrentPage(page) {
      this.page = page
      this.getTeacherList()
    },
    removeById(id) {

    }

  }
}
</script>

<style scoped>

</style>
