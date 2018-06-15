import http from './http'

const CursosService = {
  getAll: () => {
    return http.get('/cursos')
  },
  getById: id => {
    return http.get(`/cursos/${id}`)
  },
  edit: item => {
    return http.put(`/cursos/${item.id}`, item)
  },
  create: item => {
    return http.post(`/cursos`, item)
  },
  delete: id => {
    return http.delete(`/cursos/${id}`)
  },
}

export default CursosService