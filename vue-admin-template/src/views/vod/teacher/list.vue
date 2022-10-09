<template>
  <div class="app-container">
    <!--查询表单-->
    <el-card class="operate-container" shadow="never">
      <el-form :inline="true" class="demo-form-inline">
        <el-form-item label="名称">
          <el-input v-model="searchObj.name" placeholder="讲师名"/>
        </el-form-item>

        <el-form-item label="头衔">
          <el-select v-model="searchObj.level" clearable placeholder="头衔">
            <el-option value="1" label="高级讲师"/>
            <el-option value="0" label="首席讲师"/>
          </el-select>
        </el-form-item>

        <el-form-item label="入驻时间">
          <el-date-picker
            v-model="searchObj.joinDateBegin"
            placeholder="开始时间"
            value-format="yyyy-MM-dd"/>
        </el-form-item>

        <el-form-item label="-">
          <el-date-picker
            v-model="searchObj.joinDateEnd"
            placeholder="结束时间"
            value-format="yyyy-MM-dd"/>
        </el-form-item>

        <el-button type="primary" icon="el-icon-search" @click="getTeacherList()">查询</el-button>
        <el-button type="default" @click="resetData()">清空</el-button>
      </el-form>
    </el-card>

    <!-- 工具按钮 -->
    <el-card class="operate-container" shadow="never">
      <i class="el-icon-tickets" style="margin-top: 5px"></i>
      <span style="margin-top: 5px">数据列表</span>
      <el-button class="btn-add" @click="add()" style="margin-left: 10px;">添加</el-button>
      <el-button class="btn-add" @click="batchRemove()">批量删除</el-button>
    </el-card>

    <!-- 表格 -->
    <el-table
      :data="list"
      border
      stripe
      @selection-change="handleSelectionChange"
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
          <!-- 修改按钮 -->
          <router-link :to="'/vod/teacher/edit/'+scope.row.id">
            <el-button type="primary" icon="el-icon-edit" size="mini" @click="showEditDialog(scope.row.id)"></el-button>
          </router-link>
          <!-- 删除按钮 -->
          <el-button style="margin-left: 10px;" type="danger" icon="el-icon-delete" size="mini"
                     @click="removeById(scope.row.id)"></el-button>
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
    // 清空表单
    resetData() {
      this.searchObj = {};
      this.getTeacherList()
    },
    // 根据 id 删除数据
    removeById(id) {
      this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        return teacherApi.removeById(id)
      }).then((response) => {
        this.getTeacherList()
        this.$message.success("删除成功")
      })
    },
    // 复选框触发事件
    handleSelectionChange(selection) {
      this.multipleSelection = selection
    },
    add() {
      // 跳转到添加页面
      this.$router.push({path: "/vod/teacher/create"})
    },
    // 批量删除
    batchRemove() {
      if (this.multipleSelection.length === 0) {
        this.$message.warning('请选择要删除的记录!')
        return
      }

      this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        const idList = []
        // 遍历数组将 id 取出并存储到 idList 中
        this.multipleSelection.forEach(teacher => idList.push(teacher.id))
        // 批量删除
        return teacherApi.batchRemove(idList)
      }).then((response) => {
        this.getTeacherList()
        this.$message.success("批量删除成功")
      })
    }
  }
}
</script>

<style scoped>

</style>
