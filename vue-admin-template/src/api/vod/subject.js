import request from '@/utils/request'

const api_name = '/admin/vod/subject';
export default {
  // current 当前页, limit 每页记录数, searchObj 条件对象
  getList(id) {
    return request({
      url: `${api_name}/getChildSubject/${id}`,
      method: 'get'
    })
  }
}
