import request from '@/utils/request'

const api_name = '/admin/vod/course'

export default {
  //课程列表
  getPageList(page, limit, params) {
    return request({
      url: `${api_name}/${page}/${limit}`,
      method: 'get',
      params
    })
  },
  //添加课程基本信息
  saveCourseInfo(data) {
    return request({
      url: `${api_name}/save`,
      method: 'post',
      data
    })
  },
  // 根据 id 获取课程信息
  getCourseInfoById(id) {
    return request({
      url: `${api_name}/get/${id}`,
      method: 'get'
    })
  },
  // 根据 id 修改课程信息
  updateCourseInfoById(data) {
    return request({
      url: `${api_name}/update`,
      method: 'put',
      data
    })
  },
  //获取发布课程信息
  getCoursePublishById(id) {
    return request({
      url: `${api_name}/getCoursePublishVo/${id}`,
      method: 'get'
    })
  },
  //发布课程
  publishCourseById(id) {
    return request({
      url: `${api_name}/publishCourse/${id}`,
      method: 'put'
    })
  },
  // 根据 id 删除数据
  removeById(id) {
    return request({
      url: `${api_name}/remove/${id}`,
      method: 'delete'
    })
  },
  findAll() {
    return request({
      url: `${api_name}/findAll`,
      method: 'get'
    })
  }
}
