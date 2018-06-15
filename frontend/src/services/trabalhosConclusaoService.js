import http from './http'

const TrabalhosDeConclusaoService = {
  getAll: () => {
    return http.get('/trabalhosDeConclusao')
  },
  getById: id => {
    return http.get(`/trabalhosDeConclusao/${id}`)
  },
  edit: item => {
    return http.put(`/trabalhosDeConclusao/${item.id}`, item)
  },
  create: item => {
    return http.post(`/trabalhosDeConclusao`, item)
  },
  delete: id => {
    return http.delete(`/trabalhosDeConclusao/${id}`)
  },
}

export default TrabalhosDeConclusaoService