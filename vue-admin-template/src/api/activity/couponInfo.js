import request from '@/utils/request'

const api_name = '/admin/activity/couponInfo'

export default {

  getPageList(page, limit) {
    return request({
      url: `${api_name}/${page}/${limit}`,
      method: 'get'
    })
  },
  getById(id) {
    return request({
      url: `${api_name}/get/${id}`,
      method: 'get'
    })
  },

  save(data) {
    return request({
      url: `${api_name}/save`,
      method: 'post',
      data
    })
  },

  updateById(role) {
    return request({
      url: `${api_name}/update`,
      method: 'put',
      data: role
    })
  },
  removeById(id) {
    return request({
      url: `${api_name}/remove/${id}`,
      method: 'delete'
    })
  },
  removeRows(data) {
    return request({
      url: `${api_name}/batchRemove`,
      method: 'delete',
      data
    })
  },

  getPageCouponUseList(page, limit, params) {
    return request({
      url: `${api_name}/couponUse/${page}/${limit}`,
      method: 'get',
      params
    })
  }
}
