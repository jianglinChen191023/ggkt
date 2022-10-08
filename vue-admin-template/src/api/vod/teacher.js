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
  }
}
