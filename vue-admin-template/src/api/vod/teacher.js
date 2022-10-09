import request from '@/utils/request'

const api_name = '/admin/vod/teacher';
export default {
  // current 当前页, limit 每页记录数, searchObj 条件对象
  getList(current, limit, params) {
    return request({
      url: `${api_name}/findQueryPage/${current}/${limit}`,
      method: 'get',
      params
    })
  },
  removeById(id) {
    return request({
      url: `${api_name}/remove/${id}`,
      method: 'delete'
    })
  },
  // 讲师添加
  saveTeacher(data) {
    return request({
      url: `${api_name}/save`,
      method: 'post',
      data
    })
  },
  // 讲师修改
  updateTeacher(data) {
    return request({
      url: `${api_name}/update`,
      method: 'put',
      data
    })
  },
  // 根据 id 获取讲师信息
  getTeacherById(id) {
    return request({
      url: `${api_name}/get/${id}`,
      method: 'get'
    })
  },
  // 批量删除
  batchRemove(data) {
    return request({
      url: `${api_name}/batch/remove`,
      method: 'delete',
      data
    })
  }
}
