import request from '@/utils/request'

const api_name = '/admin/vod'

export default {
  // 根据文件 id 删除
  removeByFileId(fileId) {
    return request({
      url: `${api_name}/remove/${fileId}`,
      method: 'delete'
    })
  }
}
