import axios from 'axios'
import {Message} from 'element-ui'
import router from '../router'

axios.interceptors.response.use(success => {
  if (success.status && success.status === 200 && success.data.status === 500) {
    Message.error({message: success.data.msg})
    return
  }
  //如果有附带msg则前端提示
  if (success.data.msg) {
    Message.success({message: success.data.msg})
  }
  return success.data
}, error => {
  // 有响应返回 并且HTTP状态码为200 或者500
  if (error.response.status === 504 || error.response.status === 404) {
    Message.error({message: '服务器被吃了( ╯□╰ )'})
  } else if (error.response.status === 403) {
    Message.error({message: '权限不足，请联系管理员'})
  } else if (error.response.status === 401) {
    Message.error({message: '尚未登录，请登录'})
    //清除用户信息
    window.sessionStorage.removeItem('user')
    window.sessionStorage.removeItem('politicsstatus')
    window.sessionStorage.removeItem('nations')
    window.sessionStorage.removeItem('deps')
    window.sessionStorage.removeItem('joblevels')
    window.sessionStorage.removeItem('depList')
    window.sessionStorage.removeItem('positions')
    router.replace('/')
  } else {
    if (error.response.data.msg) {
      Message.error({message: error.response.data.msg})
    } else {
      Message.error({message: '未知错误!'})
    }
  }
})

let base = ''

export const postKeyValueRequest = (url, params) => {
  return axios({
    method: 'post',
    url: `${base}${url}`,
    data: params,
    transformRequest: [function (data) {
      let ret = ''
      for (let i in data) {
        ret += encodeURIComponent(i) + '=' + encodeURIComponent(data[i]) + '&'
      }
      return ret
    }],
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
    }
  })
}
export const postRequest = (url, params) => {
  return axios({
    method: 'post',
    url: `${base}${url}`,
    data: params
  })
}
export const putRequest = (url, params) => {
  return axios({
    method: 'put',
    url: `${base}${url}`,
    data: params
  })
}
export const getRequest = (url, params) => {
  return axios({
    method: 'get',
    url: `${base}${url}`,
    data: params
  })
}
export const deleteRequest = (url, params) => {
  return axios({
    method: 'delete',
    url: `${base}${url}`,
    data: params
  })
}
export const patchRequest = (url, params) => {
  return axios({
    method: 'patch',
    url: `${base}${url}`,
    data: params
  })
}
export const headRequest = (url, params) => {
  return axios({
    method: 'head',
    url: `${base}${url}`,
    data: params
  })
}
export const optionsRequest = (url, params) => {
  return axios({
    method: 'options',
    url: `${base}${url}`,
    data: params
  })
}
