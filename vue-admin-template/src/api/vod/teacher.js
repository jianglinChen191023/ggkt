import request from '@/utils/request'

const api_name = '/admin/vod/teacher';
export default {
  // current 当前页, limit 每页记录数, searchObj 条件对象
  getList(current, limit, teacherQueryVo) {
    return request({
      url: `${api_name}/${current}/${limit}`,
      method: 'get',
      params: teacherQueryVo
    })
  }
}
