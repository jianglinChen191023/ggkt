import axios from 'axios'
import store from '../store'

export function request(config) {
  // 1. 创建 axios 的实例
  const instance = axios.create({
    baseURL: 'http://175.178.174.83',
    // 请求超时时间
    timeout: 30000
  });

  // 2. axios 的拦截器
  // 配置请求和响应拦截
  instance.interceptors.request.use(config => {
    // 1. 比如 config 中一些信息不符合服务器的要求
    // 2. 比如每次发送网络请求时, 都希望在界面中显示一个请求的图标
    console.log('来到了 request 拦截 success 中')

    //获取 localStorage 里面的 token 值
    let token = window.localStorage.getItem('token') || '';
    if (token !== '') {
      //把 token 值放到 header 里面
      config.headers['token'] = token; // 'eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJSCjAK0A0Ndg1S0lFKrShQsjI0MzY3MTQxMTbWUSotTi3yTAGKQZh-ibmpQB1KtQARkjypPAAAAA.B6dziXWxcc2mIYYaDQnXB1t0IHwQK-GwWNFsAQ0Z7CbCBVb11uoNjojWYotC8YEdlVW9Ahtq99LWtz1_Wbhhlw';//cookie.get('guli_token');
    }

    return config;
  }, err => {
    console.log('来到了 request 拦截 failure 中')
    return Promise.reject(err);
  })

  // 响应拦截
  instance.interceptors.response.use(res => {
    console.log('来到了 response 拦截 success 中')

    if (res.data.code === 208) {
      // 微信状态码
      // 替换# 后台获取不到#后面的参数
      let url = window.location.href.replace('#', 'guiguketan')
      window.location = store.getters.wechatPath + url;
    } else {
      if (res.data.code === 20000) {
        // 成功
        return res.data
      } else {
        // 错误
        console.log("response.data:" + JSON.stringify(res.data))
        alert(res.data.message || 'error')
        return Promise.reject(res)
      }
    }
  }, err => {
    console.log('来到了 response 拦截 failure 中')
    return Promise.reject(err);
  })

  // 3. 发送真正的网络请求
  return instance(config);
}
