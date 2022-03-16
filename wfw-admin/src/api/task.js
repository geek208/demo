import request from '@/utils/request'

export function addMessage(data) {
  return request({
    url: '/wfwactivity/postFormFields',
    method: 'post',
    data
  })
}
/**
 * 更新
 * @param {} data
 */
export function updateMessage(data) {
  return request({
    url: 'message',
    method: 'put',
    data
  })
}

/**
 * 获取一个server
 * @param {} id
 */
export function getMessage(id) {
  return request({
    url: `message/${id}`,
    method: 'get'
  })
}

/**
 * list
 * @param {int}} page
 * @param {int} pageSize
 */
export function listTodoTask(page) {
  return request({
    url: `/wfwactivity/getMyTaskTodoList`,
    method: 'get',
    params: page
  })
}


/**
 * list
 * @param {int}} page
 * @param {int} pageSize
 */
 export function listDoneTask(page) {
  return request({
    url: `/wfwactivity/getMyTaskDoneList`,
    method: 'get',
    params: page
  })
}

/**
 * 删除
 * @param {*} id
 */
export function deleteMessage(id) {
  return request({
    url: `message/${id}`,
    method: 'DELETE'
  })
}

/**
 * 删除
 * @param {*} id
 */
 export function dotask(id) {
  return request({
    url: `/wfwactivity/dotask/${id}`,
    method: 'get',
   })
}
