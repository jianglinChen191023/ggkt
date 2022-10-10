<template>
  <div class="app-container">
    <div class="el-toolbar">
      <div class="el-toolbar-body" style="justify-content: flex-start;">
        <el-button type="text" @click="exportData"><i class="fa fa-plus"/> 导出</el-button>
        <el-button type="text" @click="importData"><i class="fa fa-plus"/> 导入</el-button>
      </div>
    </div>

    <el-table
      :data="list"
      style="width: 100%"
      row-key="id"
      border
      lazy
      :load="load"
      :tree-props="{children: 'children', hasChildren: 'hasChildren'}">
      <el-table-column
        prop="title"
        label="名称"
        width="180">
      </el-table-column>
      <el-table-column
        prop="createTime"
        label="创建时间"
        width="180">
      </el-table-column>
    </el-table>

    <!-- 弹出框 -->
    <el-dialog title="导入" :visible.sync="dialogImportVisible" width="480px">
      <el-form label-position="right" label-width="170px">
        <el-form-item label="文件">
          <el-upload
            ref="upload"
            :multiple="false"
            :on-error="handleError"
            :before-upload="beforeUpload"
            :on-success="onUploadSuccess"
            :action="basePath + '/admin/vod/subject/importData'"
            class="upload-demo">
            <el-button size="small" type="primary">点击上传</el-button>
            <div slot="tip" class="el-upload__tip">只能上传xls文件，且不超过500kb</div>
          </el-upload>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogImportVisible = false">取消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import subjectApi from '@/api/vod/subject'

export default {
  name: 'list',
  data() {
    return {
      //数据字典列表数组
      list: [],
      basePath: process.env.VUE_APP_BASE_API,
      dialogImportVisible: false
    }
  },
  created() {
    this.getSubList(0)
  },
  methods: {
    //数据字典列表
    getSubList(id) {
      subjectApi.getList(id)
        .then(response => {
          this.list = response.data
        })
    },
    // 懒加载
    load(tree, treeNode, resolve) {
      subjectApi.getList(tree.id).then(response => {
        resolve(response.data)
      })
    },
    // 导出数据为 Excel 文件
    exportData() {
      window.open(this.basePath + "/admin/vod/subject/exportData")
    },
    // 导入数据
    importData() {
      this.dialogImportVisible = true
    },
    // 上传文件
    onUploadSuccess(response) {
      // 清空上传列表
      this.$refs.upload.clearFiles();
      if (response.code === 20000) {
        this.$message.success('导入成功')
        this.dialogImportVisible = false
        this.getSubList(0)
      } else {
        this.$message.error('导入失败')
      }
    },
    handleError() {
      this.$message.error('上传失败')
    },
    // 上传之前触发
    beforeUpload(file) {
      const isJPG = file.type === 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet';
      const isLt2M = file.size / 1024 < 500;
      if (!isJPG) {
        this.$message.error('上传文件只能是 xls 格式!');
      }

      if (!isLt2M) {
        this.$message.error('上传文件大小不能超过 500KB!');
      }

      return isJPG && isLt2M;
    }
  }
}
</script>

<style scoped>

</style>
