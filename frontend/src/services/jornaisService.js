import http from './http'

const JornaisService = {
  getAll: () => {
    return http.get('/jornais')
  },
  getById: id => {
    return http.get(`/jornais/${id}`)
  },
  edit: item => {
    return http.put(`/jornais/${item.id}`, item)
  },
  create: item => {
    return http.post(`/jornais`, item)
  },
  delete: id => {
    return http.delete(`/jornais/${id}`)
  },
}

export default JornaisService