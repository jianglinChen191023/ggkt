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
  }
}
