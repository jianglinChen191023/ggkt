<template>
  <div class="app-container">
    <!-- 输入表单 -->
    <el-form label-width="120px">
      <el-form-item label="讲师名称">
        <el-input v-model="teacher.name"/>
      </el-form-item>
      <el-form-item label="入驻时间">
        <el-date-picker v-model="teacher.joinDate" value-format="yyyy-MM-dd"/>
      </el-form-item>
      <el-form-item label="讲师排序">
        <el-input-number v-model="teacher.sort" :min="0"/>
      </el-form-item>
      <el-form-item label="讲师头衔">
        <el-select v-model="teacher.level">
          <!--
            数据类型一定要和取出的json中的一致，否则没法回填
            因此，这里value使用动态绑定的值，保证其数据类型是number
            -->
          <el-option :value="1" label="高级讲师"/>
          <el-option :value="2" label="首席讲师"/>
        </el-select>
      </el-form-item>
      <el-form-item label="讲师简介">
        <el-input v-model="teacher.intro"/>
      </el-form-item>
      <el-form-item label="讲师资历">
        <el-input v-model="teacher.career" :rows="10" type="textarea"/>
      </el-form-item>

      <!-- 讲师头像 -->
      <el-form-item label="讲师头像">
        <el-upload
          class="avatar-uploader"
          :action="BASE_API + '/admin/vod/file/upload'"
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :on-error="handleAvatarError"
          :before-upload="beforeAvatarUpload">
          <img v-if="teacher.avatar" :src="teacher.avatar" class="avatar">
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="saveOrUpdate()">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import teacherApi from '@/api/vod/teacher'

export default {
  name: "form",
  created() {
    // 获取路径 id 值, 根据 id 查询数据
    const id = this.$route.params.id
    if (id) {
      teacherApi.getTeacherById(id)
        .then(response => {
          this.teacher = response.data
        })
    }
  },
  data() {
    return {
      teacher: {
        sort: 0,
        level: 1
      },
      BASE_API: process.env.VUE_APP_BASE_API
    }
  },
  methods: {
    // 添加
    save() {
      teacherApi.saveTeacher(this.teacher)
        .then(response => {
          // 提示
          this.$message.success("添加成功!");
          // 跳转列表页面
          this.$router.push({path: "/vod/teacher/list"});
        })
    },
    // 修改
    update() {
      teacherApi.updateTeacher(this.teacher)
        .then(response => {
          // 提示
          this.$message.success("修改成功!");
          // 跳转列表页面
          this.$router.push({path: "/vod/teacher/list"});
        })
    },
    // 保存或修改
    saveOrUpdate() {
      if (this.teacher.id) {
        this.update()
      } else {
        this.save()
      }
    },
    // 上传成功触发
    handleAvatarSuccess(res, file) {
      if (res.code === 20000) {
        this.teacher.avatar = res.data
        // 强制重新渲染
        this.$forceUpdate()
      } else {
        this.$message.error('上传失败（非0）')
      }
    },
    handleAvatarError() {
      this.$message.error('上传失败（http 失败）')
    },
    // 上传之前触发, 用于校验
    beforeAvatarUpload(file) {
      const isJPG = file.type === 'image/jpeg';
      const isLt2M = file.size / 1024 / 1024 < 2;
      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!');
      }

      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!');
      }

      return isJPG && isLt2M;
    }
  }
}

</script>

<style scoped>
>>> .avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

>>> .avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}

.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}

.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>
