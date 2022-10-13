import request from '@/utils/request'

const api_name = '/admin/order/orderInfo'

export default {

  getPageList(page, limit, params) {
    return request({
      url: `${api_name}/${page}/${limit}`,
      method: 'get',
      params
    })
  }
}
