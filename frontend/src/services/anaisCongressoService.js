import http from './http'

const AnaisCongressoService = {
  getAll: () => {
    return http.get('/anaisDeCongresso')
  },
  getById: id => {
    return http.get(`/anaisDeCongresso/${id}`)
  },
  edit: item => {
    return http.put(`/anaisDeCongresso/${item.id}`, item)
  },
  create: item => {
    return http.post(`/anaisDeCongresso`, item)
  },
  delete: id => {
    return http.delete(`/anaisDeCongresso/${id}`)
  },
}

export default AnaisCongressoService