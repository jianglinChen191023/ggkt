import request from '@/utils/request'

const api_name = '/admin/wechat/menu'

export default {
  // 查询所有菜单
  findMenuInfo() {
    return request({
      url: `${api_name}/findMenuInfo`,
      method: `get`
    })
  },
  // 查询一级菜单
  findOneMenuInfo() {
    return request({
      url: `${api_name}/findOneMenuInfo`,
      method: `get`
    })
  },

  save(menu) {
    return request({
      url: `${api_name}/save`,
      method: `post`,
      data: menu
    })
  },

  getById(id) {
    return request({
      url: `${api_name}/get/${id}`,
      method: `get`
    })
  },

  updateById(data) {
    return request({
      url: `${api_name}/update`,
      method: `put`,
      data
    })
  },
  // 公众号菜单同步
  syncMenu() {
    return request({
      url: `${api_name}/syncMenu`,
      method: `get`
    })
  },

  removeById(id) {
    return request({
      url: `${api_name}/remove/${id}`,
      method: 'delete'
    })
  },
  // 公众号菜单删除
  removeMenu() {
    return request({
      url: `${api_name}/removeMenu`,
      method: `delete`
    })
  }
}
