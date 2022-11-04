import {request} from '@/utils/request'

const api_name = '/api/live/liveCourse'

export default {
  // 获取 access_token
  getPlayAuth(liveCourseId) {
    return request({
      url: `${api_name}/getPlayAuth/${liveCourseId}`,
      method: 'get'
    })
  },

  // 直播详情
  getInfo(liveCourseId) {
    return request({
      url: `${api_name}/getInfo/${liveCourseId}`,
      method: 'get'
    })
  }
}
