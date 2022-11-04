import {request} from '@/utils/request'

const api_name = '/api/wechat/share'

export default {
  // 获取
  getSignature(url) {
    return request({
      url: `${api_name}/getSignature`,
      method: 'get',
      params: {
        url
      }
    })
  }
}
