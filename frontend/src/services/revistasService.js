import http from './http'

const RevistasService = {
  getAll: () => {
    return http.get('/revistas')
  },
  getById: id => {
    return http.get(`/revistas/${id}`)
  },
  edit: item => {
    return http.put(`/revistas/${item.id}`, item)
  },
  create: item => {
    return http.post(`/revistas`, item)
  },
  delete: id => {
    return http.delete(`/revistas/${id}`)
  },
}

export default RevistasService