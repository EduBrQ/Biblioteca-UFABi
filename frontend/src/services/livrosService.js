import http from './http'

const LivrosService = {
  getAll: () => {
    return http.get('/livros')
  },
  getById: id => {
    return http.get(`/livros/${id}`)
  },
  edit: item => {
    return http.put(`/livros/${item.id}`, item)
  },
  create: item => {
    return http.post(`/livros`, item)
  },
  delete: id => {
    return http.delete(`/livros/${id}`)
  },
}

export default LivrosService